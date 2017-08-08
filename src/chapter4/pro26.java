/*
 * problem：请实现函数 ComplexListNode myClone(ComplexListNode head) 复制一个复杂链表。
 *          在复杂链表中，每个节点除了一个Next指针指向下一个节点外，
 *          Sibling指针指向链表的任意节点或者NULL*/
package chapter4;
import java.util.HashMap;

public class pro26 {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		pro26 d=new pro26();
		RandomListNode root=d.getComplexListNode();
		d.printComplexListNode(root);
		RandomListNode myResult=d.myClone(root);
		d.printComplexListNode(myResult);
		RandomListNode bookResult=d.bookMethod(root);
		d.printComplexListNode(bookResult);
	}
	
	//复杂链表数据结构
	public class RandomListNode {
	    int label;
	    RandomListNode next = null;
	    RandomListNode random = null;

	    RandomListNode(int label,RandomListNode next,RandomListNode random) {
	        this.label = label;
	        this.next=next;
	        this.random=random;
	    }
	}
	
	public RandomListNode getComplexListNode()
	{
		//生成的链表为为1(3),2(5),3,4(2),5
		//其中括号里指的是随机指针的指向
		RandomListNode node5=new RandomListNode(5,null,null);
		RandomListNode node3=new RandomListNode(3,null,null);
		RandomListNode node2=new RandomListNode(2,node3,node5);
		RandomListNode node4=new RandomListNode(4,node5,node2);
		node3.next=node4;
		RandomListNode node1=new RandomListNode(1,node2,node3);
		return node1;
		
	}
	
	//打印复杂链表
	public void printComplexListNode(RandomListNode root)
	{
		RandomListNode tail=root;
		while(tail!=null)
		{
			if(tail.random!=null)
				System.out.print(tail.label+"("+tail.random.label+"),");
			else
				System.out.print(tail.label+",");
			tail=tail.next;
		}
		System.out.println();
	}
	
	//书中的第三种方法：将新链表的每个节点放在对应旧链表节点的后面，然后找随机指向节点的时候，只需要将
	                  //随机指向的下一个，然后将一个链表拆分为两个链表
	public RandomListNode bookMethod(RandomListNode pHead)
	{
		if(pHead==null)
			return null;
		
		//第一回合：合成一个链表
		RandomListNode result=new RandomListNode(pHead.label,pHead.next,null);
		RandomListNode tail=pHead;
		tail.next=result;
		tail=result.next;
		while(tail!=null)
		{
			RandomListNode tt=new RandomListNode(tail.label,tail.next,null);
			tail.next=tt;
			tail=tt.next;
		}
		//this.printComplexListNode(pHead);
		//第二回合：找到随机节点位置
		tail=pHead;
		while(tail!=null)
		{
			if(tail.random!=null)
			{
				tail.next.random=tail.random.next;			
			}
			tail=tail.next.next;
		}
		//第三回合：拆分链表
		boolean org=true;
		tail=pHead.next.next;
		RandomListNode ntail=result;
		ntail.next=null;
		RandomListNode otail=pHead;
		otail.next=null;
		while(tail!=null)
		{
			if(org)
			{
				org=false;
				otail.next=tail;
				otail=otail.next;
				tail=tail.next;//这行代码和下行代码的顺序不能颠倒！！
				otail.next=null;				
			}else{
				org=true;
				ntail.next=tail;
				ntail=ntail.next;
				tail=tail.next;
				ntail.next=null;
				
			}
		}
		
		return result;
	}
	//思路：遍历两遍得到，因为第一遍有些节点还没有建成，可能导致指针为空，因为是完全建立了一个新表
	       //并不是通过引用，所以必须建立一个映射，完成随机指针的工作，其实映射的作用相当于建立了
	       //原链表到新链表对应节点的指针。
	//与书中用空间换时间的方法思路（第二种方法）相同
	public RandomListNode myClone(RandomListNode pHead)
	{
        //首先可以用比较暴力的方法，遍历两遍，第一遍得到后继节点，第二遍得到任意节点
        if(pHead==null)
            return null;
        
        HashMap<RandomListNode,RandomListNode> hash=new HashMap<RandomListNode,RandomListNode>();
        RandomListNode result=new RandomListNode(pHead.label,null,null);
        hash.put(pHead,result);//用来旧表到新表的映射
        RandomListNode tail=result;
        RandomListNode or_tail=pHead.next;
        //得到后续节点
        while(or_tail!=null)
            {
            RandomListNode temp=new RandomListNode(or_tail.label,null,null);
            hash.put(or_tail,temp);
            tail.next=temp;
            tail=temp;
            or_tail=or_tail.next;
        }
        //得到任意节点
        or_tail=pHead;
        while(or_tail!=null)
            {
            if(or_tail.random!=null)
                {
                hash.get(or_tail).random=hash.get(or_tail.random);
            }
            or_tail=or_tail.next;
        }
        
        return result;
	}

}
