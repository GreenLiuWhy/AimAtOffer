/*
 * problem: 实现函数 double Power(double base,int ex) 实现base的 ex次方，
 *          不得使用库函数，同时不需要考虑最大数问题*/
package chapter3;

import java.util.ArrayList;

public class pro11 {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		pro11 dd=new pro11();
		for(int i=-2;i<=2;i++)
		{
			System.out.println("the pow(2,"+i+")="+dd.myMethod_Power(2, i));
			System.out.println("the pow(2,"+i+")="+dd.bookMethod_shulie(2, i));
		}

	}
	
	//自己的实现，也就是循环暴力方法，时间复杂度为O(N)，只是考虑到ex<0的情况
	//自己的方法没有考虑到base是0的情况！！！！！！！
	public double myMethod_Power(double base, int ex)
	{
		//------------------加上掉了的 base=0 的情况-----------------
		if(base==0)
			return 0;
		//----------------------------------------------------------
		boolean pos=true;
		if(ex<0)
		{
			pos=false;
			ex=-ex;
		}
		double result=1;
		while(ex!=0)
		{
			result=result*base;
			ex--;
		}
		
		if(!pos)
			return 1/result;
		
		return result;
	}
	
	//书上的方法，类似于考虑斐波那契数列、
	//f(a,n)=f(a,n/2)^2  , if n 是偶数
	//f(a,n)=f(a,(n-1)/2)^2*a , if n 是奇数
	//书中其实是用了烦人的递归，但是递归其实是一种没有效率的实现，此处是不用递归的书中方法的实现
	public double bookMethod_shulie(double base, int ex)
	{
		if(base==0)
			return 0;
		ArrayList<Double> aa=new ArrayList<Double>();
		aa.add(1.0);//当ex=0时
		
		double result=1;
		boolean pos=true;
		if(ex<0)
		{
			ex=-ex;
			pos=false;
		}
		
		//开始实现原来递归的功能
		while(2*(aa.size()-1)!=ex && 2*(aa.size()-1)+1!=ex)
		{
			int len=aa.size();//这个地方不应该有-1
			if(len%2!=0){//如果是奇数
				aa.add( aa.get((len-1)/2)*aa.get((len-1)/2)*base);
			}else{
				aa.add(aa.get(len/2)*aa.get(len/2));
			}
		}
		
		if(ex%2!=0)
			result=aa.get(aa.size()-1)*aa.get(aa.size()-1)*base;
		else
			result=aa.get(aa.size()-1)*aa.get(aa.size()-1);
		
		if(!pos)
			return 1/result;
		return result;
	}

}
