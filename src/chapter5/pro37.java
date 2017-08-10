/*
 * @author: lxw
 * 2017年7月26日
 * 
 * 题目描述：输入两个链表，找出他们的第一个公共节点。其中链表结构已经定义。*/
package chapter5;

import java.util.ArrayList;
import java.util.HashMap;

public class pro37 {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		pro37 d=new pro37();
		ArrayList<ListNode> list=d.generateList();
		d.myMethod(list.get(0), list.get(1));
		d.bookMethod1(list.get(0), list.get(1));
	}
	
	class ListNode{
		int val;
		ListNode next;
		
		public ListNode(int val, ListNode next)
		{
			this.val=val;
			this.next=next;
		}
	}
	
	//当时看的书上的，印象深刻的方法
	/*
	 * 思路：可以先遍历一次得到两个链表的长度，
	 * 然后令长的链表先出发 long-short 步，然后一起出发，直到达到第一个它们相同的节点。
	 * time:10min*/
	public void bookMethod1(ListNode head1, ListNode head2)
	{
		if(head1==null && head2==null)
			return;
		
		int len1=0;
		int len2=0;
		for(ListNode dex=head1; dex!=null; dex=dex.next, len1++);
		for(ListNode dex=head2; dex!=null; dex=dex.next, len2++);
		
		ListNode ho=head1;
		ListNode ht=head2;
		if(len1>=len2)
		{
			int cha=len1-len2;
			for(; cha>0; cha--, ho=ho.next );
		}
		else
		{
			int cha=len2-len1;
			for(; cha>0; cha--, ht=ht.next );
		}
		
		while(ho!=null && ht!=null && ho!=ht)
		{
			ho=ho.next;
			ht=ht.next;
		}
		if(ho==ht)
			System.out.println(ho.val);
		return;
		
	}
	
	//自己测验hashMap能不能实现
	/*可以，耶耶耶！
	 * time:6min*/
	public void myMethod(ListNode head1, ListNode head2)
	{
		if(head1==null || head2==null)
			return;
		
		HashMap<ListNode,Boolean> hm=new HashMap<ListNode,Boolean>();
		
		for(ListNode dex=head1; dex!=null; dex=dex.next)
		{
			if(hm.get(dex)==null)
				hm.put(dex, true);
		}
		
		ListNode dex2;
		for(dex2=head2; dex2!=null && hm.get(dex2)==null; dex2=dex2.next);
		
		System.out.println(dex2.val);
		
	}
	
	/* 构造两个链表，形如：
	 * 1--->2-->3--->6--->7
	 *              ^
	 *              | 
	 *      4-->5----
	 * */
	public ArrayList<ListNode> generateList()
	{
		ArrayList<ListNode> list=new ArrayList<ListNode>();
		ListNode node7=new ListNode(7,null);
		ListNode node6=new ListNode(6,node7);
		ListNode node5=new ListNode(5,node6);
		ListNode node4=new ListNode(4,node5);
		ListNode node3=new ListNode(3,node6);
		ListNode node2=new ListNode(2,node3);
		ListNode node1=new ListNode(1,node2);
		
		list.add(node1);
		list.add(node4);
		return list;
	}

}
