/*
 * @author: lxw
 * 2017年7月26日
 * 
 * 题目描述：输入一颗二叉树的根节点，求该树的深度。从根节点到叶节点依次经过的节点（含根、叶节点）形成数的一条路径，
 *        求最长路径的长度即为树的深度。其中二叉树结构定义如下*/
package chapter6;

import java.util.LinkedList;
import java.util.Queue;

public class pro39_1 {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		pro39_1 d=new pro39_1();
		BTNode test=d.generateBTree();
		System.out.println(d.myMethod(test));
	}
	
	class BTNode{
		int val;
		BTNode left;
		BTNode right;
		
		public BTNode(int val, BTNode left, BTNode right)
		{
			this.val=val;
			this.left=left;
			this.right=right;
		}
	}
	
	//time:35-43=8min
	/*
	 * 思路，还是用我熟悉的广度优先搜索的队列实现，
	 * 用两个队列，一个记录节点，一个记录层数，也就是说某一节点的左右孩子应该在同一层上
	 * 
	 * 书中的方法还是用来一个递归，对于这个，我真的是。。。*/
	public int myMethod(BTNode root)
	{
		if(root==null)
			return 0;
		
		Queue<BTNode> gList=new LinkedList<BTNode>();
		Queue<Integer> dList=new LinkedList<Integer>();
		
		int dep=0;
		gList.add(root);
		dList.add(1);
		while(!gList.isEmpty())
		{
			BTNode s=gList.poll();
			dep=dList.poll();
			
			if(s.left!=null)
			{
				gList.add(s.left);
				dList.add(dep+1);
			}
			
			if(s.right!=null)
			{
				gList.add(s.right);
				dList.add(dep+1);
			}
		}
		
		return dep;
	}
	
	
	//生成一棵树，树的形态如下
	/*
	 *                      1
	 *              2                  3
	 *         4         5          6
	 *      7
	 *         8
	 * 也就是树的深度为5*/
	public BTNode generateBTree()
	{
		BTNode node8=new BTNode(8, null, null);
		BTNode node7=new BTNode(7, null, node8);
		BTNode node6=new BTNode(6, null, null);
		BTNode node5=new BTNode(5, null, null);
		BTNode node4=new BTNode(4, node7, null);
		BTNode node3=new BTNode(3, node6, null);
		BTNode node2=new BTNode(2, node4, node5);
		BTNode node1=new BTNode(1, node2, node3);
		
		return node1;
	}

}
