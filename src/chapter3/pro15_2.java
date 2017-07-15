/*
 * problem:链表的中间节点。如果链表中节点的总数是奇数，返回中间节点；如果为偶数，则返回中间两个节点的
 *         任意一个。*/
package chapter3;

public class pro15_2 {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		pro15_2 d=new pro15_2();
		ListNode use=d.getListNode(8);
		d.printListNode(use);
		ListNode med=d.bookMehod_getMediumNode(use);
		System.out.println(med.Vaule);
	}
	
	class ListNode{
		int Vaule;
		ListNode Next;
	}
	
	//目前能想出来的就是先遍历一遍，看看有多少个节点，然后再找到中间节点，时间复杂度为O(N)
	
	//书中的：定义2个指针，同时从链表的头节点出发，一个指针一次走一步，一个指针一次走2步。
	        //当走的快的指针走到链表末尾时，走的慢的指针正好在链表中间~~~~面试官你好聪明啊~~撒花~~~
	public ListNode bookMehod_getMediumNode(ListNode pHeadNode)
	{
		if(pHeadNode==null)
		{
			System.out.println("the input list is null");
			return null;
		}
		ListNode fast=pHeadNode;
		ListNode slow=pHeadNode;
		while(fast.Next!=null)
		{
			slow=slow.Next;
			for(int i=0;i<2 && fast.Next!=null;i++)
				fast=fast.Next;
		}
		return slow;
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
