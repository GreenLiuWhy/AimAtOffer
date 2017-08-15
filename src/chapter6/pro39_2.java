/*
 * @author: lxw
 * 2017年8月11日
 * problem:输入一个二叉树的根节点，判断该树是不是平衡二叉树。
 *         如果某二叉树中任意节点的左右子树的深度相差不超过1，那么它就是一棵平衡二叉树*/
package chapter6;


public class pro39_2 {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		pro39_2 d=new pro39_2();
		BTNode noBalance=d.generateBTree_noBalance();
		BTNode balance=d.generateBTree_Balance();
		
		System.out.println(d.bookMethod1(balance));
		System.out.println(d.bookMethod1(noBalance));
		
		System.out.println("---------方法二有问题-----------");
		
		System.out.println(d.bookMethod2(balance));
		System.out.println(d.bookMethod2(noBalance));

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
	
	/*
	 * book1: 用深度优先的递归算法
	 *        在遍历树的每个节点的时候，调用函数TreeDepth得到它的左右子树深度，如果每个节点的左右子树的
	 *        深度相差都不超过1，按照定义它就是一棵平衡二叉树。
	 * 缺点：一个节点会被重复遍历多次，所以这种思路的时间效率并不高*/
	public boolean bookMethod1(BTNode root)
	{
		if(root==null)
			return true;
		
		int left=this.treeDepth(root.left);
		int right=this.treeDepth(root.right);
		int diff=left-right;
		if(diff>1 || diff<-1)
			return false;
		
		return this.bookMethod1(root.left)&&this.bookMethod1(root.right);
	}
	
	public int treeDepth(BTNode root)
	{
		if(root==null)
			return 0;
		
		int nLeft=this.treeDepth(root.left);
		int nRight=this.treeDepth(root.right);
		
		if(nLeft>nRight)
			return nLeft+1;
		else
			return nRight+1;
	}
	
	/*
	 * book2:用后序遍历方式遍历二叉树的每一个节点，在遍历一个节点之前，我们就已经遍历了它的左右子树。
	 *       只要在遍历每个节点的时候记录它的深度，我们就一遍遍历一遍判断每个节点是不是平衡的
	 *       */
	public boolean bookMethod2(BTNode root)
	{
		int depth=0;
		return this.isBalanced(root, depth);
	}
	
	public boolean isBalanced(BTNode root, int depth)
	{
		if(root==null)
		{
			depth=0;
			return true;
		}
		
		int left=0, right=0;//问题出在这里
		if(this.isBalanced(root.left, left) && this.isBalanced(root.right, right))
		{
			int diff=left-right;
			if(diff<=1 && diff>=-1)
			{
				depth=1+(left>right ? left: right);
				return true;
			}
		}
		return false;
		
	}
	
	
	/*
	 * 自己的方法*/
	public boolean myMethod(BTNode root)
	{
		return true;
	}
	//生成一棵非平衡二叉树，树的形态如下
	/*
	 *                      1
	 *              2                  3
	 *         4         5          6
	 *      7
	 *         8
	 * 也就是树的深度为5*/
	public BTNode generateBTree_noBalance()
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
	
	//生成一棵平衡二叉树，树的形态如下
	/*
	 *                     1
	 *             2              3
	 *        4        5       6
	 *        */
	public BTNode generateBTree_Balance()
	{
		BTNode node6=new BTNode(6, null, null);
		BTNode node5=new BTNode(5, null, null);
		BTNode node4=new BTNode(4, null, null);
		BTNode node3=new BTNode(3, node6, null);
		BTNode node2=new BTNode(2, node4, node5);
		BTNode node1=new BTNode(1, node2, node3);
		
		return node1;
	}

}
