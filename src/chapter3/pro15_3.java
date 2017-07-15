/*
 * problem：判断单向链表时候形成了环形结构。*/
package chapter3;

public class pro15_3 {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		pro15_3 d=new pro15_3();
		ListNode no_huan=d.getListNode(8, 0, false);
		ListNode have_huan=d.getListNode(12, 5, true);
		d.printListNode(no_huan);
		d.myMethod_2point(no_huan);
		d.myMethod_2point(have_huan);
		
	}
	
	//数据结构
	class ListNode{
		int Value;
		ListNode Next;
	}
	
	//思路：通过两个指针完成，同时从头节点出发，一个每次走两步，一个每次走一步，如果相遇则说明有环，如果最终快的那个
	      //走到了终点，则说明无环。
	public void myMethod_2point(ListNode head)
	{
		if(head==null)
		{
			System.out.println("the input is wrong");
			return;
		}
		
		ListNode fast=head;
		ListNode slow=head;
		while(true)
		{
			slow=slow.Next;
			for(int i=0;i<2 && fast!=null;i++)
				fast=fast.Next;
			if(fast==null)
			{
				System.out.println("no it hasn't");
				return;
			}
			if(slow.equals(fast))
			{
				System.out.println("yes it has");
				return;
			}
		}
	}
	
	//生成一个Listnode
	public ListNode getListNode(int num, int huan,boolean havehuan)
	{
		ListNode head=new ListNode();
		ListNode tail=null;
		ListNode hh=null;
		
		for(int i=1;i<=num;i++)
		{
			if(i==1)
			{
				head.Value=1;
				head.Next=null;
				tail=head;
			}else{
				ListNode tt=new ListNode();
				tt.Value=i;
				tt.Next=null;
				tail.Next=tt;
				tail=tt;
			}
			if(havehuan && i==huan)
				hh=tail;
		}
		tail.Next=hh;
		return head;
	}
	
	//打印其中的数
	public void printListNode(ListNode node)
	{
		while(node!=null)
		{
			System.out.print(node.Value+"-->");
			node=node.Next;
		}
		System.out.println();
	}

}
