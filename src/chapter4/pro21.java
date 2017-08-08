/*
 * problem：定义栈的数据结构，请在该类型中实现一个能够得到栈的最小元素的min函数，
 *          在该栈中，调用min、push\pop的时间复杂度都是O(1)*/
package chapter4;

import java.util.ArrayList;
import java.util.Stack;

public class pro21 {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		pro21 dd=new pro21();
        myStack mm=dd.new myStack(); //这个地方应该这样定义
        int[] shu={10,3,6,4,1,7,5};
        for(int i=0;i<shu.length;i++)
        {
        	mm.push(shu[i]);
        	System.out.print(mm.getMin()+", ");
        }
        System.out.println();
        for(int i=0;i<shu.length;i++)
        	System.out.print(mm.pop()+",");
	}
	
	//好像没有看明白题目意思的我。。。思路：用ArrayList实现一个栈的基本结果，然后定义一个索引值，指向min的位置
	//这个没有考虑到如果当前最小元素被弹出栈了，那如何找到下一个最小元素
	class myStack{
		private ArrayList<Integer> inner=new ArrayList<Integer>();
		private int minDex=-1;
		private int minNum;
		
		public void push(int num)
		{
			inner.add(num);
			
			//定位最小值
			if(inner.size()==1)
			{
				minNum=num;
				minDex=0;
			}else{
				if(num<minNum)
				{
					minNum=num;
					minDex=inner.size()-1;
				}
			}
		}
		
		public int pop()
		{
			return inner.remove(inner.size()-1);
		}
		
		public int getMin()
		{
			if(inner.isEmpty())
			{
				System.out.println("the stack is enmpy");
				return -001;
			}
			return inner.get(minDex);
		}
	}
	
	//根据书中例子，这个可以记录最小值的栈，可以通过栈来实现
	class bookStack{
		private Stack<Integer> m_data=new Stack<Integer>();
		private Stack<Integer> m_min=new Stack<Integer>();
		
		public void push(int em)
		{
			if(m_data.isEmpty())
			{
				m_min.push(em);
			}else{
				if(em<m_min.get(m_min.size()-1))
					m_min.push(em);
				else
					m_min.push(m_min.get(m_min.size()-1));
			}
			m_data.push(em);
		}
		
		public int pop()
		{
			m_min.pop();//这一步要在这里加上
			return m_data.pop();
		}
		
		public int getMin()
		{
			return m_min.get(m_min.size()-1);
		}
	}

}
