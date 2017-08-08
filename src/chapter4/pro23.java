/*
 * problem：从上往下打印出二叉树的每个节点，同一层的节点按照从左到右的顺序打印。
 *          其实就是广度优先搜索
 *          二叉树节点已经定义*/
package chapter4;

import java.util.LinkedList;
import java.util.Queue;


public class pro23 {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		pro23 d=new pro23();
		BTNode use=d.getTextTree();
		d.myMethod(use);
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
	
	//其实就是队列实现，在pro19的打印程序更能反映树的结构
	public void myMethod(BTNode tree)
	{
		if(tree==null)
		{
			System.out.println("empty");
			return;
		}
		
		Queue<BTNode> qu=new LinkedList<BTNode>();
		qu.add(tree);
		while(!qu.isEmpty())
		{
			BTNode s=qu.poll();
			System.out.print(s.Value+", ");
			if(s.Left!=null)
				qu.add(s.Left);
			if(s.Right!=null)
				qu.add(s.Right);
		}
	}
	
	//生成测试用二叉树
	/*   树的结构为：
	 *        1
	 *    2        3
	 * 4
	 *    5
	 * */
	public BTNode getTextTree()
	{
		BTNode node5=new BTNode(5,null,null);
		BTNode node4=new BTNode(4,null,node5);
		BTNode node3=new BTNode(3,null,null);
		BTNode node2=new BTNode(2,node4,null);
		BTNode node1=new BTNode(1,node2,node3);
		
		return node1;
	}

}
