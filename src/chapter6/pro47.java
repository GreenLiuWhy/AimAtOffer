/*
 * @author: lxw
 * 2017年8月10日
 * 
 * problem：不用加减乘除做加法
 * describe：写一个函数，求两个整数之和，要求在函数体内不得使用四则运算符号。*/
package chapter6;

public class pro47 {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		pro47 d=new pro47();
		
		d.Add(5, 7);
	}
	
	/*
	 * 书上的方法
	 * step 1：将十进制转化为二进制
	 * step 2：用位运算转化为二进制的加法 */
	public void Add(int n, int m)
	{
		int sum,carry;
		do{
			sum=n^m;//如果不考虑任何进位，单纯相加的结果
			carry=(n & m)<<1; //有进位是1，没有进位是0
			
			n=sum;
			m=carry;
		}while(m!=0);
		
		System.out.println(n);
	}

}
