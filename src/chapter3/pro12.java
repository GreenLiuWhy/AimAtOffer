/*problem：输入数字n，按顺序打印出从1到最大n位的十进制数，
 *         比如输入3，则打印输出1,2,3,...,999*/
package chapter3;

import java.util.ArrayList;

public class pro12 {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		pro12 d=new pro12();
		for(int num=1;num<=3;num++)
		{
			d.myMethod_printNum(num);
			System.out.println();
		}

	}
	
	//自己的方法，为了防止数字溢出，所以用数组实现，比较麻烦的地方是临界值处理
	public void myMethod_printNum(int num)
	{
		ArrayList<Integer> aa=new ArrayList<Integer>();
		
		if(num<1)
		{
			System.out.println("the input should be big than 0");
			return;
		}
		
		for(int i=1;i<=num;i++)
		{
			aa.add(0);
		}
		
		int song=0;
		
		while(song!=Math.pow(10, num))
		{
			while(aa.get(aa.size()-1)<10)
			{
				aa.set(aa.size()-1, aa.get(aa.size()-1)+1);
				song++;
				if(aa.get(aa.size()-1)<10)
				{
					this.printarray(aa);
					System.out.print(",");
				}
			}
			//修改进位
			int jian=1;
			for(;aa.get(aa.size()-jian)>=10 && jian<num;jian++)
			{
				aa.set(aa.size()-jian, 0);
				aa.set(aa.size()-jian-1, aa.get(aa.size()-jian-1)+1);
			}
			
			//打印10
			if(jian<=num && song!=Math.pow(10, num))//加了这个判断
			{
				this.printarray(aa);
				System.out.print(",");
			}
				
		}
	}
	
	public void printarray(ArrayList<Integer> ss)
	{
		int i=0;
		for(;ss.get(i)==0;)
		{
			i++;
		}
		for(;i<ss.size();i++)
		{
			System.out.print(ss.get(i));
		}
			
	}

}
