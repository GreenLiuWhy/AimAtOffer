/*author:lxw
 * data:6/29/2017
 * problem:输入某个二叉树的前序遍历和中序遍历的结果，重建该二叉树；
 *         假设输入的前序遍历和中序遍历的结果都不含有重复的数字。
 *         例如输入前序遍历顺序{1,2,4,7,3,5,6,8}和中序遍历序列{4,7,2,1,5,3,8,6}
 *         则重建下图的二叉树并输出其头节点
 *                                     1
 *                                   -----
 *                                   2    3
 *                                  ---  ----
 *                                  4    5  6
 *                                  --      --
 *                                  7         8
 *          二叉树节点定义如下：
 *          class BinaryTreeNode
 *          {
 *              int Value;
 *              BinaryTreeNode Left;
 *              BinaryTreeNode Right;
 *          } 
 *          */
package chapter2;

public class pro6 {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		int[] first={1,2,3,4,5,6,7,8};
		int[] middle={4,7,2,1,5,3,8,6};
		

	}
	
	//inner class
	class BTreeNode
	{
		int Value;
		BTreeNode Left;
		BTreeNode Right;
	}

}
