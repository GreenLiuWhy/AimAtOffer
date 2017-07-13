/*author:lxw
 * data:6/29/2017
 * problem1:用一条语句判断一个整数是不是2的整数次方。
 * problem2：输入两个整数m和n，计算需要改变m的二进制表示中的多少位才能得到n
 * */
package chapter2;

import java.util.ArrayList;

public class pro10_2 {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		pro10_2 dd=new pro10_2();
		for(int i=0;i<=10;i++)
			System.out.println("-- "+i+" --: "+dd.myMethod_problem2(10, i));

	}
	
	//针对problem1：实在不知道咋用一句话判断，取log？。。。
	//见书
	//针对problem2：暴力法，也就是先转换为2进制，然后从后往前遍历m和n的二进制位，时间复杂度为O(max(m,n))
	public int myMethod_problem2(int m,int n)
	{
		int result=0;
		
		ArrayList<Integer> mm=this.change_to_2(m);
		ArrayList<Integer> nn=this.change_to_2(n);
		
		int lenmm=mm.size();
		int lennn=nn.size();
		int i=1;
		for(;i<=lenmm && i<=lennn;i++)
		{
			if(mm.get(lenmm-i)!=nn.get(lennn-i))
				result++;
		}
		
		for(;i<=lenmm;i++)
		{
			if(mm.get(lenmm-i)==1)
				result++;
		}
		
		for(;i<=lennn;i++)
		{
			if(nn.get(lennn-i)==1)
				result++;
		}
		
		//for(int i=len)
		return result;
	}
	
	//转化为2进制的函数
	public ArrayList<Integer> change_to_2(int m)
	{
		ArrayList<Integer> result=new ArrayList<Integer>();
		//先得到位数
		int high=0;
		int shu=1;
		while(m>shu)
		{
			shu=shu*2;
			high++;
		}
		//转化为2进制
		for(int i=high;i>=0;i--)
		{
			if(m>=Math.pow(2, i))
			{
				result.add(1);
				m=(int)(m-(int)Math.pow(2, i));
			}else
				result.add(0);
		}
		if(result.get(0)==0)
			result.remove(0);
		this.printArrayList(result);
		return result;
	}
	
	//打印
	public void printArrayList(ArrayList<Integer> aa)
	{
		for(int i=0;i<aa.size();i++)
			System.out.print(aa.get(i));
		System.out.println();
	}

}
