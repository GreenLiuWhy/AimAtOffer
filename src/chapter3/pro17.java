/*
 * problem：输入两个递增排序的链表，合并这两个链表并使新链表中的节点依然是按照递增顺序排列的。
 *          注意，和并得到新链表*/
package chapter3;


public class pro17 {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		pro17 d=new pro17();
		ListNode use1=d.getListNode(1, 12, 2);
		d.printListNode(use1);
		ListNode use2=d.getListNode(2, 5, 2);
		d.printListNode(use2);
		ListNode mer=d.myMethod_newList(use1, use2);
		d.printListNode(mer);
		ListNode bo=d.myMethod_orgList(use1, use2);
		d.printListNode(bo);
	}
	
	class ListNode{
		int Vaule;
		ListNode Next;
	}
	
	//原2个链表保留，生成新链表,其实就是一个一个来的
	/*出现的问题：
	 * 1.如果result只是new了一个空间，什么内容也没有的话，直接令 tail=result 会导致result随着tail变化
	 *   解决的方案就是，先使tail=null，等result有值以后再使tail等于他
	 * 2.括号的问题
	 * */
	public ListNode myMethod_newList(ListNode one,ListNode two)
	{
		ListNode result=new ListNode();
		ListNode tail=null;
		if(one==null && two==null)
			return null;
		
		ListNode p1=one;
		ListNode p2=two;
		
		while(p1!=null && p2!=null)
		{
			//System.out.print(p1.Vaule +"  "+p2.Vaule+"  ");
			if(p1.Vaule<=p2.Vaule)
			{
				if(tail==null)
				{
					result.Vaule=p1.Vaule;
					result.Next=null;
					tail=result;
				}else{
					ListNode tt=new ListNode();
					tt.Vaule=p1.Vaule;
					tt.Next=null;
					tail.Next=tt;
					tail=tt;
				}
				p1=p1.Next;
			}else{
				if(tail==null){
					result.Vaule=p2.Vaule;
					result.Next=null;
					tail=result;
				}else{
					ListNode tt=new ListNode();
					tt.Vaule=p2.Vaule;
					tt.Next=null;
					tail.Next=tt;
					tail=tt;
				}
				p2=p2.Next;
		      
			}
        }
		
		//不用使用while从句！！！！！
		if(p1!=null)
			tail.Next=p1;
		if(p2!=null)
			tail.Next=p2;
		/*
		while(p1!=null)
		{
			if(tail==null)
			{
				result.Vaule=p1.Vaule;
				result.Next=null;
				tail=result;
			}else{
				ListNode tt=new ListNode();
				tt.Vaule=p1.Vaule;
				tt.Next=null;
				tail.Next=tt;
				tail=tt;
			}
			p1=p1.Next;
		
		}
		
		while(p2!=null)
		{
			if(tail==null)
			{
				result.Vaule=p2.Vaule;
				result.Next=null;
				tail=result;
			}else{
				ListNode tt=new ListNode();
				tt.Vaule=p2.Vaule;
				tt.Next=null;
				tail.Next=tt;
				tail=tt;
			}
			p2=p2.Next;
		}	
		*/
		
		return result;
	}
	
	//原来链表合并成一个新链表
	//其实这也是book中给出的手段，也就是书中认为“新链表”是和原来不同的，而不是重新生成内存空间而生成的
	//注意空指针问题
	public ListNode myMethod_orgList(ListNode one,ListNode two)
	{
		//特殊值处理
		if(one==null && two==null)
			return null;		
		if(one==null)
			return two;
		if(two==null)
			return one;
		
		//正式
		ListNode head=new ListNode();
		ListNode tail=null;
		ListNode p1=one;
		ListNode p2=two;
		if(one.Vaule<two.Vaule)
		{
			head=one;
			p1=p1.Next;
		}
		else
		{
			head=two;
			p2=p2.Next;
		}
		tail=head;
		while(p1!=null && p2!=null)
		{
			if(p1.Vaule<=p2.Vaule)
			{
				tail.Next=p1;
				tail=tail.Next;
				p1=p1.Next;
			}else{
				tail.Next=p2;
				tail=tail.Next;
				p2=p2.Next;
			}
		}
		
		///下面的地方不用使用while语句！！！！！！！
		if(p1!=null)
			tail.Next=p1;
		if(p2!=null)
			tail.Next=p2;
		
		return head;
	}

	//生成一个Listnode
	public ListNode getListNode(int begain,int num,int diff)
	{
		ListNode head=new ListNode();
		ListNode tail=null;
		ListNode hh=null;
		 int nn=0;
		for(int i=1;i<=num;i++)
		{
			if(i==1)
			{
				nn=nn+begain;
				head.Vaule=nn;
				head.Next=null;
				tail=head;
			}else{
				nn=nn+diff;
				ListNode tt=new ListNode();
				tt.Vaule=nn;
				tt.Next=null;
				tail.Next=tt;
				tail=tt;
			}
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
