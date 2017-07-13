/*author:lxw
 * data:6/29/2017
 * problem:请实现一个函数、，输入一个整数，输出该数2进制表示中1的个数*/
package chapter2;

public class pro10 {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		pro10 dd=new pro10();
		for(int i=-3;i<=10;i++)
			//System.out.println("the num: "+i+" 's shumu is: "+dd.myMethod_zhuanhua(i));
			System.out.println("the num: "+i+" 's shumu is: "+dd.bookMethod1(i));

	}
	
	//类似于求10进制转2进制的方法，但是不做记录，只统计1的个数，这样占内存小
	//时间复杂度为O(2*logN)
	public int myMethod_zhuanhua(int num)
	{
		int result=0;
		
		if(num<0)
			num=-num;
		
		//找出最高位
		int high=0;
		int shu=1;
		while(num>=shu)
		{
			shu=shu*2;
			high++;
		}
		
		//找1的个数
		for(int i=high;i>=0;i--)
		{
			//System.out.println(i);
			if(num>=Math.pow(2, i))//!!!这个地方本来忘记等号了！！！
			{
				result++;
				num=(int)(num-(int)Math.pow(2, i));
				//System.out.println(num);
			}
		}
		return result;
		
	}
	
	//book中的解法1：转化为与1的与计算，结合左移位来实现
	//book中的解法2：把一个整数减去1，在和原整数做 与 运算，会把该整数最右边的一个1变为0，难么
	               //关于一个整数的2进制有多少个1，就可以进行多少次这样的操作
	public int bookMethod1(int n)
	{
		int count=0;
		while(n!=0)
		{
			count++;
			n=(n-1) & n;
		}
		return count;
	}

}
