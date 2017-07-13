/*author:lxw
 * data:6/29/2017
 * problem:
 * max_two函数：一直青蛙一次可以跳上1级台阶，也可以跳上2级
 *         求该青蛙跳上一个n级台阶总共有多少种跳法
 * no_max函数：该青蛙可以一次跳上1级，也可以2级，。。。，也可以n级，
 *         此时该青蛙跳上一个n级台阶的化有多少种跳法*/
package chapter2;

public class pro9_2 {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		pro9_2 dd=new pro9_2();
		for(int i=1;i<10;i++)
			System.out.println("the num is: "+i+" then the result: "+dd.myMehod_no_max(i));

	}
	
	//我的方法，在纸上画画，可以知道，当青蛙想要跳到第n级台阶时，可以从n-2级跳一下2个，或者n-1级跳一个
	//所以类似 那个数列 也就是 f(n)=f(n-2)+f(n-1)，其中f(1)=1,f(2)=2
	public int myMethod_max_two(int n)
	{
		int result=0;
		if(n<1)
		{
			System.out.println("the taijie is wrong");
			return 0;
		}
		
		return result;
	}
	
	//可以在第1级跳一下n，第2级跳一下n-1
	//f(n)=f(1)+f(2)+....+f(n-1), where f(1)=1,f(2)=2
	//等价于 f(n)=2*f(n-1)
	//这个地方本来错误分析，f(3)=3,实际上f(3)=4
	public int myMehod_no_max(int n)
	{
		int result=0;
		if(n<1)
		{
			System.out.println("the taijie is wrong");
			return 0;
		}
		
		for(int i=1;i<=n;i++)
		{
			if(i==1)
				result=1;
			else{
				result=2*result;
			}
				
		}
		return result;
	}

}
