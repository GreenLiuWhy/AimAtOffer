/*
 * author:lxw
 * data:6/29/2017
 * problem:在一个二维数组中，每一行从左到右递增，每一列从上到下递增。
 *         完成一个函数，输入这样一个二维数组和一个整数，判断该数组中是否有该整数
 * place:剑指offer第2章面试题3
 * */
package chapter2;

public class pro3 {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		int[][] arr={{1,3,5},{4,9,15},{7,17,21}};
		int theNum=21;
		
		pro3 demon=new pro3();
		System.out.println(demon.halfMethod(arr,theNum));
		System.out.println(demon.theBookMethod(arr, theNum));
	}
	
	//暴力法实现：遍历数组，如果搜索到该整数，则输出“有”；如果遍历结束还找不到，就输出“无”
	//暴力法的时间复杂度为：O(n^2)
	public String violenceMthod(int[][] arr,int theNum)
	{
		return "The array don't have the number";
	}
	
	//遍历第一行，然后进行类似折半查找方式进行查找
	//此时时间复杂度为 O(N*logN)
	public String halfMethod(int[][] arr, int theNum)
	{
		int len=arr.length;
		//if theNum is samller than the min of arr or bigger than the biggst of arr
		if(theNum<arr[0][0]||theNum>arr[len-1][len-1])
			return "The array don't have the number";
		//iterate through the first row and bisearch every cow
		for(int i=0;i<len && arr[0][i]<=theNum;i++)//probel1:i<len need in front of condition2
		{
			//bisearch the cow
			int head=0;
			int tail=len-1;
			while(head<=tail)//the condition is right?
			{
				int middle=(int)(head+tail)/2;
				if (arr[head][i]==theNum || arr[tail][i]==theNum || arr[middle][i]==theNum)
					return "the number is in the array";
				if(middle==head || middle==tail)  //problem2: it's the better delete it?
					break;
				if(arr[middle][i]>theNum)
					tail=middle;
				else
					head=middle;
			}
			
		}
		return "The array don't have the number";
	}
	
	//the method of book, based on the property of the array, we can shrink the range on right or bottom
	//so in that way, the time complexity is O(m+n)
	public String theBookMethod(int[][] arr,int theNum)
	{
		int theRow=arr.length;
		int theCol=theRow;
		if(arr!=null && theRow>0 && theCol>0)
		{
			int row=0;
			int column=theCol-1;
			while(row<theRow && column>=0)
			{
				if(arr[row][column]==theNum)
					return "the num in the ["+(row+1)+"]["+(column+1)+"]";
				else{
					if(arr[row][column]<theNum)
						row++;
					else
						column--;
				}
			}
		}
		return" the array don't have the number";
	}
	

}
