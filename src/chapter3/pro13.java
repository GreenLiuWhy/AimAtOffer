/*problem：在给定单向链表的头指针和一个节点指针，定义一个函数在O(1)的时间删除该节点，
 *          链表节点和函数定义如下：
 *          struct ListNode
 *          {
 *          	int Value;
 *          	ListNode Next;
 *          }
 *          void DeleNode(ListNode pListHead,ListNode pToBeDeleted)*/
package chapter3;

public class pro13 {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		pro13 d=new pro13();
		ListNode use=d.getListNode(9);
		d.printListNode(use);
		ListNode del=d.willDele(use, 3);
		//d.myMethod_DeleNode(use, del);
		d.bookMehod_DeleNode(use, del);
		d.printListNode(use);
	}
	
	//单向链表节点结构
	class ListNode{
		int Value;
		ListNode Next;
	}
	
	//貌似无法做到O(1)，那么只能O(N)了，其中时间主要花费到找到被删除节点的前一个节点那里
	public void myMethod_DeleNode(ListNode pListHead,ListNode pToBeDeleted)
	{
		ListNode p=pListHead;
		for(;p.Next!=pToBeDeleted && p.Next!=null;p=p.Next);
		p.Next=pToBeDeleted.Next;
		pToBeDeleted.Next=null;
		
	}
	
	//书中的做法：
	/*
	 * 1.如果要删除的不是最后一个节点：则用覆盖（其后面的节点覆盖要被删除的）来代替删除，时间复杂度为O(1)
	 * 2.是最后一个节点（也就是其.Next=null）：则还是要遍历，时间复杂度为O(N)
	 * 此时的平局时间复杂度还是O(1)
	 * 特别注意：当该链表只有一个节点的时候：要将链表的头指针置为NULL
	 * 注意二： 1 有一个前提就是该删除的节点一定在节点里，但事实上不一定在，如果不在，最好出现错误提示，但是
	 *         本题要求时间复杂度为O(1)，所以就忽略了不在的情况*/
	public void bookMehod_DeleNode(ListNode pHeadNode,ListNode pToBeDeleted)
	{
		//输入如果不和规范的时候
		if(pHeadNode==null || pToBeDeleted==null)
		{
			System.out.println("the node is null");
			return;
		}
		//如果该链表只有一个节点,一般来说要加 pHeadNode==pToBeDeleted
		if(pHeadNode.Next==null)
		{
			pHeadNode=null;
			return;
		}else{
			//如果不是最后一个节点则覆盖
			if(pToBeDeleted.Next!=null)
			{
				pToBeDeleted.Value=pToBeDeleted.Next.Value;
				pToBeDeleted.Next=pToBeDeleted.Next.Next;//要这样，不能 p=p.next 因为这时候只是引用，不包含具体内容
			}else{//如果是最后一个节点则仍需遍历
				ListNode p=pHeadNode;
				while(p.Next!=pToBeDeleted)
					p=pHeadNode.Next;
				System.out.println(p.Next.Value);
				p.Next=null;
			}
		}
		
	}
	
	//打印其中的数
	public void printListNode(ListNode node)
	{
		while(node.Next!=null)
		{
			System.out.print(node.Value+"-->");
			node=node.Next;
		}
		System.out.println();
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
		}
		
		return head;
	}
	
	//选择一个要删除的节点
	public ListNode willDele(ListNode head,int num)
	{
		ListNode p=head;
		for(int i=0;i<num;i++)
			p=p.Next;
		return p;
		
	}

}
