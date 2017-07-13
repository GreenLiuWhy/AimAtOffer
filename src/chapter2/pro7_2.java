/*author:lxw
 * data:6/29/2017
 * problem: 用两个队列实现一个栈*/
package chapter2;

import java.util.*;

public class pro7_2 {
	Queue<Integer> A;
	Queue<Integer> B;

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		pro7_2 dd=new pro7_2();
		for(int i=1;i<=5;i++)
		{
			dd.myMethod_violent_append(i);
			dd.printA();
		}
		for(int i=0;i<=5;i++)
		{
			System.out.println("dele num is: "+dd.Mymethod_violent_dele());
			dd.printA();
		}

	}
	
	public pro7_2()
	{
		A=new LinkedList<Integer>();
		B=new LinkedList<Integer>();
	}
	
	public void printA(){
		if(A.isEmpty())
		{
			System.out.println("the Stack is enmpty");
			return;
		}
		for(int i=0;i<A.size();i++)
			System.out.print(A.toString());
		System.out.println();
	}
	//暴力发，还是用A为主，B为辅助，时间复杂度，插入O(1)，删除O(2N)
	public void myMethod_violent_append(int num){
		A.add(num);
	}
	
	public int Mymethod_violent_dele(){
		int result=0;
		if(A.isEmpty())
		{
			System.out.println("the stack is empty");
			return 0;
		}
		int len=A.size()-1;
		for(int i=0;i<len;i++)
			B.add(A.poll());
		result=A.poll();
		for(int i=0;i<len;i++)
			A.add(B.poll());
		return result;
	}

}
