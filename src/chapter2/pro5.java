/*author:lxw
 * data:6/29/2017
 * problem:输入一个链表的头节点，从尾到头反过来打印每个节点的值
 *         链表节点的定义如下：
 *         class ListNode
 *         {
 *             int Key;
 *             ListNode Next;
 *         }*/
package chapter2;

import java.util.ArrayList;

public class pro5 {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		int[] arr={1,5,2,7,4};
		
		pro5 demon=new pro5();
		pro5.ListNode linknode=demon.generateLinklist(arr);
		demon.printLinkList(linknode);
		demon.violentMethod(linknode);
		

	}
	
	//inner class
	class ListNode
	{
		int Key;
		ListNode Next;
		
		public ListNode(int Keys)
		{
			this.Key=Keys;
		}
	}
	
	//input an array to generate an Linklist
	public ListNode generateLinklist(int[] arr)
	{
		if(arr==null || arr.length==0)
		{
			System.out.println("the array is wrong");
			return null;
		}
		
		ListNode headNode=null;
		ListNode tempNode=null;
		ListNode tailNode=null;
		
		for(int i=0;i<arr.length;i++)
		{
			tempNode=new ListNode(arr[i]);
			tempNode.Next=null;
			
			if(i==0)
			{
				headNode=tempNode;
				tailNode=headNode;
			}else{
				//System.out.print(tailNode.Key); System.out.print(tempNode.Key);
				
				tailNode.Next=tempNode;
				tailNode=tailNode.Next;
			}
			
		}
		
		return headNode;
	}
	
	//print the node num
	public void printLinkList(ListNode head)
	{
		if(head==null)
		{
			System.out.println("the Linklist is null");
			return;
		}
		while(head.Next!=null)
		{
			System.out.print(head.Key);
			head=head.Next;
		}
		System.out.println(head.Key);
		System.out.println();
	}
	
	//violent method
	//put the stack/array and output it by negative sequence
	public void violentMethod(ListNode head)
	{
		ArrayList<Integer> aa=new ArrayList<Integer>();
		if(head==null)
		{
			System.out.println("the Linklist is null");
			return;
		}
		while(head.Next!=null)
		{
			aa.add(head.Key);
			head=head.Next;
		}
		aa.add(head.Key);
		for(int i=aa.size()-1;i>=0;i--)
			System.out.print(aa.get(i));
		System.out.println();
	}

}
