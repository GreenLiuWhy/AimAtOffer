/*author:lxw
 * data:6/29/2017
 * problem:用两个栈实现一个队列。队列的声明如下，
 *          template <Typename T> class CQueue
 *          {
 *             public:
 *                CQueue(void);
 *                ~CQueue(void);
 *                
 *                void appendTail(const T& node);
 *                T deleteHead();
 *              private:
 *                 Stack<T> stack1;
 *                 Stack<T> stack2;
 *          }
 *          实现其两个函数appendTail和deletHead，分别完成在队列尾部插入节点和在队列头部删除节点*/
package chapter2;

import java.util.Stack;

public class pro7 {
	Stack<Integer> A;
	Stack<Integer> B;

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		pro7 demon=new pro7();
		for(int i=1;i<=5;i++)
		{
			demon.bookMethod_append(i);
			//demon.myMethod_violent_append(i);
			demon.printA();
		}
		for(int i=0;i<=5;i++)
		{
			System.out.println("dele num is: "+demon.bookMethod_dele());
			//System.out.println("dele num is: "+demon.myMethod_violent_dele());
			demon.printA();
		}
		
		
	}
	
	public pro7(){
		A=new Stack<Integer>();
		B=new Stack<Integer>();
	}
	
	//打印A中的元素
	public void printA()
	{
		if(A.empty() && B.empty())
		{
			System.out.println("the queue is empty");
			return;
		}
		
		if(B.empty())
		{
			for(int i=0;i<A.size();i++)
				System.out.print(A.get(i));
		}else{
			for(int i=0;i<B.size();i++)
				System.out.print(B.get(i));			
		}
		System.out.println();
	}
	
	//暴力方法：用栈A为主栈，B为辅助栈
	//插入时直接将元素插入到A中，删除时，先将除头元素之外的移动到B中，删除头元素后，见B中元素又返回至A中
	//此时插入时间复杂度为O(1)，删除时间复杂度为O(N)
	public void myMethod_violent_append(int num){
		A.push(num);
	}
	
	public int myMethod_violent_dele(){
		int result=0;
		if(A.isEmpty())
		{
			System.out.println("the queue is empty!");
			return 0;
		}
		int len=A.size()-1;//注意一定要有！！！因为A的size会不断减少，引发错误
		for(int i=0;i<len;i++)
			B.push(A.pop());
		result=A.pop();
		for(int i=0;i<len;i++)
			A.push(B.pop());
		return result;
	}
	
	//书上采用的即是类似于不写回的方法，
	public void bookMethod_append(int num)
	{
		if(!B.isEmpty()){
			int len=B.size();
			for(int i=0;i<len;i++)
				A.push(B.pop());		
		}
		A.push(num);
	}
	
	public int bookMethod_dele()
	{
		int result=0;
		if(A.isEmpty() && B.isEmpty())
		{
			System.out.println("the queue is empty");
			return 0;
		}
		//如果A不为空
		if(!A.isEmpty())
		{
			int len=A.size()-1;
			for(int i=0;i<len;i++)
				B.push(A.pop());
			result=A.pop();
		}else{
			result=B.pop();
		}
		return result;
	}

}
