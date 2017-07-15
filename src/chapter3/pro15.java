/*
 * problem:输入一个链表，输出该链表中倒数第k个节点。为了符合大多数人的习惯，本题从 1 开始计数，
 *         即链表的尾节点是倒数第一个节点。例如一个链表有6个节点，从头节点开始它们的值依次为：
 *         1,2,3,4,5,6 这个链表的倒数第 3 个节点是值为 4 的节点
 *         链表的节点定义如下：
 *         struct ListNode
 *         {
 *         	  int  Value;
 *            ListNode Next; 
 *         }*/
package chapter3;


public class pro15 {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		pro15 d=new pro15();
		ListNode use=d.getListNode(8);
		d.printListNode(use);
		System.out.println(d.myMehod_twopoint(use, 3));

	}
	
	class ListNode{
		int Vaule;
		ListNode Next;
	}
	
	//两个指针，一前一后
	/*
	 * 需要注意的问题（自己全部注意到了好欢喜~~）：
	 * 1.输入的node=null的情况
	 * 2.输入的diff>size(list)的情况
	 * 3.输入的diff<1的情况*/
	public int myMehod_twopoint(ListNode node, int diff)
	{
		//根据题目，应该是倒数第0个，第负数个是不存在的
		if(diff<1)
		{
			System.out.println("the diff must big than 0");
			return -1;
		}
		
		int result=0;
		ListNode head=node;
		ListNode tail=node;
		int i=1;
		
		//前后岔开k个
		for(;tail!=null && i<diff;i++,tail=tail.Next);
		
		//用户输入的k值不能大于总的节点数
		if(tail==null)
		{
			System.out.println("the list just have "+(i-1)+" elems");
			return -1;
		}
		//找寻倒数第k个
		for(;tail.Next!=null;head=head.Next,tail=tail.Next);
		result=head.Vaule;
		
		return result;
	}
	
	//生成一个Listnode
	public ListNode getListNode(int num)
	{
		ListNode head=new ListNode();
		ListNode tail=null;
		
		for(int i=1;i<=num;i++)
		{
			if(i==1)
			{
				head.Vaule=1;
				head.Next=null;
				tail=head;
			}else{
				ListNode tt=new ListNode();
				tt.Vaule=i;
				tt.Next=null;
				tail.Next=tt;
				tail=tt;
			}
		}
		
		return head;
	}
	
	//打印其中的数
	public void printListNode(ListNode node)
	{
		while(node!=null)
		{
			System.out.print(node.Vaule+"-->");
			node=node.Next;
		}
		System.out.println();
	}

}
