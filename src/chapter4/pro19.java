/*problem：请完成一个函数，输入一个二叉树，该函数输出它的镜像（也就是左边边右边，右边到左边）
 *         二叉树的节点已经定义*/
package chapter4;

import java.util.LinkedList;
import java.util.Queue;

public class pro19 {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		pro19 d=new pro19();
		BTNode tree=d.getTextTree();
		d.printBTTree(tree);
		
		System.out.println("--------------------------------");
		BTNode zhuan=d.myMethod_guangdu(tree);
		d.printBTTree(zhuan);

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
	
	//思路：广度优先搜索（队列实现），每次查看孩子要入队列的时候，交换左右孩子位置的重建树
	      //实现时出现的问题：加入一个节点时要new一个节点，貌似new节点的指针，如result就一直代表那个内存
	      //空间了，但是想tail的，原来是null，后来通过tail=others来赋予含义，他就是可以移动的指针
	      //说不定《JAVA虚拟机》之类的书上有说明，以后看看
	/*书中的思路：前序遍历，如果遍历到的节点有子节点，则交换这两个子节点*/
	public BTNode myMethod_guangdu(BTNode tree)
	{
		BTNode result=new BTNode(0,null,null);
		BTNode tail=null;
		
		if(tree==null)
			return null;
		
		result.Value=tree.Value;
		tail=result;
		
		Queue<BTNode> qu=new LinkedList<BTNode>();
		Queue<BTNode> qu_new=new LinkedList<BTNode>();
		qu.add(tree);
		while(!qu.isEmpty()){
			BTNode s=qu.poll();
			//入队和加入节点
			if(s.Left!=null)
			{
				BTNode tt=new BTNode(s.Left.Value,null,null);
				tail.Right=tt;
				qu.add(s.Left);
				qu_new.add(tt);
			}
			if(s.Right!=null)
			{
				BTNode tt=new BTNode(s.Right.Value,null,null);
				tail.Left=tt;
				qu.add(s.Right);
				qu_new.add(tt);
			}
			tail=qu_new.poll();	
		}
		return result;
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
