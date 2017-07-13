/*author:lxw
 * data:6/29/2017
 * problem:斐波那契数列
 *         写一个函数，输入n，求斐波那契数列的第n项。其中数列定义如下
 *                      0    n=0
 *               f(x) = 1    n=1
 *                      f(n-1)+f(n-2) n>1*/
package chapter2;



public class pro9 {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		pro9 dd=new pro9();
		for(int i=0;i<10;i++)
			System.out.println("the num is "+i+" the result is: "+dd.myMethod_on(i));
	}
	
	
	//我的方法，首先只需要保存2个值，动态规划？时间复杂度为O(N)
	public int myMethod_on(int n)
	{
		int result=0;
		int big=0;
		int small=0;
		if(n<0)
		{
			System.out.println("please input the num bigger than zero");
			return 0;
		}
		
		for(int i=0;i<=n;i++)
		{
			//System.out.println(i);
			if(i==0)
			{
				small=0;
			}
			if(i==1)
			{
				big=1;
			}
			result=big+small;
			small=big;
			big=result;
		}
		return result;
	}

}
