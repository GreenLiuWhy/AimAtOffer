/*
 * problem：定义一个函数，输入一个链表的头节点，反转该链表并输出反转后链表的头节点。
 *          链表节点已经定义到了程序中*/
package chapter3;


public class pro16 {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		pro16 d=new pro16();
		ListNode use=d.getListNode(12, 0, false);
		d.printListNode(use);
		ListNode zhuan=d.myMethod(use);
		d.printListNode(zhuan);

	}
	
	class ListNode{
		int Vaule;
		ListNode Next;
	}
	
	//思路：用3个指针实现，其中f=m+1=t+2是为了防止链表断裂，而存局部头节点的
	      //m是为了存后续，也就是最终转化成 将 t->m 变成 m->t 的问题
	/*
	 * 重点需要注意的问题：（我全注意到了，哈哈）
	 * 1.链表为null或只有一个节点时
	 * 2.翻转后链表不要出现断裂（即需要用f指针）
	 * 3.不要少节点*/
	public ListNode myMethod(ListNode head)
	{
		//输入为空
		if(head==null)
		{
			System.out.println("the input is null");
			return null;
		}
		//只有一个节点
		if(head.Next==null)
			return head;
		
		ListNode h=head;
		ListNode m=head;
		ListNode t=head;
		//前进指针
		for(int i=0;i<2 && h.Next!=null;h=h.Next,i++);
		for(int i=0;i<1 && m.Next!=null;m=m.Next,i++);
		
		while(h!=null)
		{
			if(t==head)
				t.Next=null;
			m.Next=t;
			t=m;
			m=h;
			h=h.Next;
			
		}
		//处理最后
		m.Next=t;
		
		return m;
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
			System.out.print(node.Vaule+"-->");
			node=node.Next;
		}
		System.out.println();
	}

}
