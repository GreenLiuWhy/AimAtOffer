/*
 * problem：输入一个矩阵，按照从外向里以顺时针的顺序依次打印出每一个数字，如输入矩阵：
 *          1   2   3    4
 *          5   6   7    8
 *          9   10  11   12
 *          13  14  15   16
 *          输出：1,2,3,4,8,12,16,15,14,13,9,5,6,7,11,10*/

//自己的问题：题目所说的是矩阵，而不是方阵，这就会使得，最后可能不知是一个环，甚至，不是从[i][i]开始的
package chapter4;

public class pro20 {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		pro20 d=new pro20();
		for(int i=2;i<10;i++)
		{
			int[][] use=d.getMatrix(i);
			System.out.println("----------rule-----------");
			d.myMethod_GuiLv(use);
			System.out.println();
			System.out.println("----------book rule-----------");
			d.bookMethod(use, use.length, use.length);
			System.out.println();
			System.out.println("----------progress---------");
			d.myMethod_progress(use);
			System.out.println();
			System.out.println("------------------------------------");
		}
	}
	
	//生成矩阵，并打印出来
	public int[][] getMatrix(int row)
	{
		int[][] result=new int[row][row];
		int shu=1;
		for(int i=0;i<row;i++)
		{
			for(int j=0;j<row;j++)
			{
				result[i][j]=shu;
				shu++;
			}
		}
		
		for(int i=0;i<row;i++)
		{
			for(int j=0;j<row;j++)
				System.out.print(result[i][j]+"  ");
			System.out.println();
		}
		
		return result;
	}
	//原来王的思路（貌似他就是看的解析。。）：找规律，每次从 mat[i][i] 开始，扫描一个环，扫描的过程分为 右下左上
	public void myMethod_GuiLv(int[][] mat)
	{
		for(int i=0; i*2<=mat.length ;i++)
		{
			//右
			for(int j=i;j<mat.length-i; j++)
				System.out.print(mat[i][j]+", ");
			//下
			for(int j=i+1; j<mat.length-i; j++)
				System.out.print(mat[j][mat.length-i-1]+", ");
			//左
			for(int j=mat.length-i-2;j>=i;j--)
				System.out.print(mat[mat.length-i-1][j]+", ");
			//上
			for(int j=mat.length-i-2;j>i;j--)
				System.out.print(mat[j][i]+", ");
		}
	}
	
	//书中的方法，也就是不再从[i][i]开始了，而是自己定义star位置开始
	public void bookMethod(int[][] mat,int cols,int rows)
	{
		int start=0;
		for(;start*2<=cols && start*2<=rows;start++)
			this.bookMethod_circle(mat, cols, rows, start);
	}
	public void bookMethod_circle(int[][] mat,int cols,int rows,int start)
	{
		int endX=cols-1-start;
		int endY=rows-1-start;
		
		//左
		for(int i=start;i<=endX;i++)
			System.out.print(mat[start][i]+", ");
		//下
		if(start<endY)
		{
			for(int i=start+1;i<=endY;i++)
				System.out.print(mat[i][endX]+", ");
		}	
		//右
		if(start<endX && start<endY)
		{
			for(int i=endX-1;i>=start;i--)
				System.out.print(mat[endY][i]+", ");
		}
		//上
		if(start<endX && start<endY-1)
		{
			for(int i=endY-1;i>start;i--) //书中这个地方有错误！！应该是没有 = 号的
				System.out.print(mat[i][start]+", ");
		}
	}
	
	//原来自己的思路：基于过程的，设置访问矩阵，在碰见访问的就转弯,也能够实现，时间复杂度相同，但边界条件比较
	                //难于处理
	public void myMethod_progress(int[][] mat)
	{
		if(mat.length ==1)
		{
			System.out.print(mat[0][0]);
			return;
		}
		
		//访问记录矩阵
		boolean[][] flag=new boolean[mat.length][mat.length];
		for(int i=0;i<mat.length;i++)
			for(int j=0;j<mat.length;j++)
				flag[i][j]=false;
		
		//当右边被访问的时候算法终止
		int row=0;
		int col=0;
		while(flag[row][col]==false)
		{
			//右
			for(; col<mat.length && !flag[row][col];col++)
			{
				System.out.print(mat[row][col]+", ");
				flag[row][col]=true;
			}
			//下
			col--;
			row++;
			for(; row<mat.length && !flag[row][col];row++)
			{
				System.out.print(mat[row][col]+", ");
				flag[row][col]=true;
			}
			//左
			//if(row!=mat.length-1)
				row--;
			col--;
			for(; col>=0 && !flag[row][col];col--)
			{
				System.out.print(mat[row][col]+", ");
				flag[row][col]=true;
			}
			//上
			//if(col!=0)
				col++;
			row--;
			for(; row>=0 && !flag[row][col];row--)
			{
				System.out.print(mat[row][col]+", ");
				flag[row][col]=true;
			}
			//下一轮
			//System.out.println(row+"---"+col);
			//if(flag[row][col])
				row++;
			col++;
			//System.out.println(row+"---"+col);
		}
	}

}
