/*
 * @author: lxw
 * 2017年8月10日
 * problem：圆圈中最后剩下的数字
 * describe：0,1，...,n-1这n个数字排成一个圆圈，从数字0开始每次从这个圆圈里删除第m个数字，
 *           求出这个圆圈里剩下的最后一个数字*/
package chapter6;

import java.util.LinkedList;

public class pro45 {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		pro45 d=new pro45();
		d.myMethod(9, 3);
		d.bookMethod(9, 3);
	}
	
	//time:7min
	/*
	 * 思路：用一个链表来模拟删除过程，直到求出最后一个
	 * 时间复杂度：O(N)
	 * 空间复杂度：O(1)*/
	public void myMethod(int n, int m)
	{
		LinkedList<Integer> ll=new LinkedList<Integer>();
		
		for(int i=0; i<n; i++)
			ll.add(i);
		
		int del=0;
		while(ll.size()!=1)
		{
			del=del+m-1;
			if(del<ll.size())
			{
				System.out.println(ll.get(del));
				ll.remove(del);
			}
			else{
				del=del%(ll.size());//======
				System.out.println(ll.get(del));
				ll.remove(del);
			}
		}
		
		System.out.println(ll.get(0));
	}

	//book
	/*
	 * 思路：好难想到啊。。。
	 *     首先定义方程f(n,m)
	 *     假设n个数字，删除了第一个数字（假设为k）以后，下一次删除要从k+1开始计数，相当于在剩下的序列中k+1排在了前面，
	 *     从而形成k+1,...,n-1,0,..,k-1。则f(n,m)=f'(n-1,m
	 *     通过映射，找到递归关系
	 *            0,   n=1
	 *     f(n,m)=
	 *            [f(n-1,m)+m]%n,       n>1*/
	public void bookMethod(int n, int m)
	{
		if(n<1 || m<1)
			return;
		
		int last=0;
		for(int i=2; i<=n; i++)
			last=(last+m)%i;
		
		System.out.println(last);
			
	}
}
