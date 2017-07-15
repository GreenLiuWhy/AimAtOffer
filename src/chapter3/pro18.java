/*
 * problem：输入两颗二叉树 A 和 B，判断 B 是不是 A 的子结构。其中二叉树节点已经定义*/
package chapter3;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.Queue;


public class pro18 {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		pro18 d=new pro18();
		BTNode father=d.getTextTree_father();
		BTNode wrongSon=d.getTextTree_wrongSon();
		BTNode realSon=d.getTextTree_son();
		
//		d.printBTTree(father);
//		d.printBTTree(wrongSon);
//		d.printBTTree(realSon);
		
		d.myMethod(father, wrongSon);
		d.myMethod(father, realSon);
	}
	
	//二叉树节点
	class BTNode{
		int Value;
		BTNode Left;
		BTNode Right;
		
		public BTNode(int v, BTNode l, BTNode r)
		{
			this.Value=v;
			this.Right=r;
			this.Left=l;
		}
	}
	
	//思路：step1.对父树进行广度优先遍历，记录下和待测子树根节点的节点的位置
	      //step2:找出根节点相同的节点，分别进行广度优先搜索的同时，看看是不是子结构
	            //比较的方案就是，左右子树的位置和值
	/*注意点：
	 * 1.子结构不同于左子树、右子树  哪怕父亲还有节点 但只要有相同的结构就可以
	 * 2.空指针的处理
	 * 
	 * 书中采用的是递归实现*/
	public void myMethod(BTNode father,BTNode son)
	{
		if(father==null || son==null)
			return;
					
		ArrayList<BTNode> fatlist=new ArrayList<BTNode>();
		ArrayList<Integer> sameHead=new ArrayList<Integer>();
		
		//找到可能是头节点的
		fatlist.add(father);
		int faDex=0;
		while(faDex<fatlist.size())
		{
			BTNode s=fatlist.get(faDex);
			
			if(s.Value==son.Value)
				sameHead.add(faDex);
			
			if(s.Left!=null)
				fatlist.add(s.Left);
			if(s.Right!=null)
				fatlist.add(s.Right);
			faDex++;
		}
		
		for(int i=0;i<sameHead.size();i++)
		{
			//检查该头节点是否为与son相同
			boolean nono=false;
			Queue<BTNode> fatQue=new LinkedList<BTNode>();
			Queue<BTNode> sonQue=new LinkedList<BTNode>();
			
			fatQue.add(fatlist.get(sameHead.get(i)));
			sonQue.add(son);
			while(!fatQue.isEmpty() && !sonQue.isEmpty())
			{
				BTNode fa=fatQue.poll();
				BTNode ss=sonQue.poll();
				//这个条件主要是为了 子结构 而不是 子树
				boolean ll=this.notall(ss.Right, ss.Left) && !this.myXor(fa.Left==null, ss.Left==null);
				boolean rr=this.notall(ss.Right, ss.Left) && !this.myXor(fa.Right==null, ss.Right==null);
				if(fa.Value!=ss.Value || ll || rr)
				{
					System.out.println("no");
					nono=true;
					break;//此处应该是break！！！！！！
				}
				if(fa.Left!=null)
					fatQue.add(fa.Left);
				if(fa.Right!=null)
					fatQue.add(fa.Right);
				if(ss.Left!=null)
					sonQue.add(ss.Left);
				if(ss.Right!=null)
					sonQue.add(ss.Right);				
			}
			if(!nono)
			{
				System.out.println("yes");
				return;
			}
		}
	}
	
	//实现布尔型的异或操作
	public boolean myXor(boolean one,boolean two)
	{
		if((one==true && two==true) || (one==false && two==false))
			return true;
		else
			return false;
	}
	
	//实现判断左右子树是否全为空
	public boolean notall(BTNode l, BTNode r)
	{
		if(l==null && r==null)
			return false;
		else
			return true;
	}
	//生成测试用二叉树--A
	/*   树的结构为：
	 *        1
	 *    2        3
	 * 4
	 *    5
	 * */
	public BTNode getTextTree_father()
	{
		BTNode node5=new BTNode(5,null,null);
		BTNode node4=new BTNode(4,null,node5);
		BTNode node3=new BTNode(3,null,null);
		BTNode node2=new BTNode(2,node4,null);
		BTNode node1=new BTNode(1,node2,node3);
		
		return node1;
	}
	
	//生成测试用二叉树--B--不是子结构
	/*       数的结构为
	 *           2
	 *               4
	 *                   5*/
	public BTNode getTextTree_wrongSon()
	{
		BTNode node5=new BTNode(5,null,null);
		BTNode node4=new BTNode(4,null,node5);
		BTNode node2=new BTNode(2,null,node4);
		
		return node2;
	}
	
	//生成测试用二叉树 --B--子结构
	/*   树的结构为：
	 *    2        
	 * 4
	 *    5
	 * */
	public BTNode getTextTree_son()
	{
		BTNode node5=new BTNode(5,null,null);
		BTNode node4=new BTNode(4,null,node5);
		BTNode node2=new BTNode(2,node4,null);
		
		return node2;
	}
	
	//广度打印二叉树
	public void printBTTree(BTNode tree)
	{
		Queue<BTNode> qu=new LinkedList<BTNode>();
		
		qu.add(tree);
		System.out.println(tree.Value+"是根节点");
		while(!qu.isEmpty())
		{
			BTNode s=qu.poll();
			if(s.Left!=null)
			{
				System.out.print(s.Left.Value+"是"+s.Value+"的左节点      ");
				qu.add(s.Left);
			}
			if(s.Right!=null)
			{
				System.out.println(s.Right.Value+"是"+s.Value+"的右节点");
				qu.add(s.Right);
			}
		}
		System.out.println();
	}

}
