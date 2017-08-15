/*
 * @author: lxw
 * 2017年8月10日
 * 
 * problem：书中两个节点的最低公共祖先*/
package chapter7;

import java.util.ArrayList;

public class pro50 {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		pro50 d=new pro50();
		
		ArrayList<BTNode> list=d.generateTree();
		
		for(int i=0; i<list.size(); i++)
		{
			System.out.print("node"+list.get(6).Val+"  and node"+list.get(i).Val+" 's father is:");
			d.myMethod(list.get(0), list.get(6), list.get(i));
		}
	}
	
	class BTNode
	{
		int Val;
		BTNode Left;
		BTNode Right;
		
		public BTNode(int val, BTNode left, BTNode right)
		{
			this.Val=val;
			this.Left=left;
			this.Right=right;
		}
	}
	
	/*
	 * time:30min
	 * 思路：用ArrayList模拟栈，来实现深度遍历一个树。为了记录其右孩子有没有被遍历，要维护另一个boolean型的list来
	 * 记录右孩子的遍历情况。
	 *     如果该节点有左孩子就一直将其左孩子存入list中，同时将boolList记为false
	 *     直到没有左孩子，此时看 这个节点是否有右孩子，同时右孩子是否被遍历过，如果满足条件，则加入右孩子
	 *     如果不满足条件，则删除list中的尾节点，看其父节点的右节点情况
	 *     在树种找到node1和node2以后，要将其路径存起来，然后找寻共同祖先*/
	public void myMethod(BTNode root, BTNode node1, BTNode node2)
	{
		if(root==null || node1==null || node2==null)
			return;
		
		ArrayList<BTNode> list=new ArrayList<BTNode>();
		ArrayList<Boolean> Pright=new ArrayList<Boolean>();
		ArrayList<BTNode> pathNode1=new ArrayList<BTNode>();
		ArrayList<BTNode> pathNode2=new ArrayList<BTNode>();
		
		list.add(root);
		Pright.add(false);
		BTNode s=list.get(list.size()-1);
		boolean n1=false;
		boolean n2=false;
		
		//important
		if(this.getPath(list, root, node1, pathNode1)) 
			n1=true;
		if(this.getPath(list, root, node2, pathNode2))
			n2=true;
		
		while(!list.isEmpty() && (n1==false || n2==false))
		{
			
			while(s.Left!=null)
			{
				if(this.getPath(list, s.Left, node1, pathNode1))
					n1=true;
				if(this.getPath(list, s.Left, node2, pathNode2))
					n2=true;
				list.add(s.Left);
				Pright.add(false);
				s=s.Left;
			}
			
			//System.out.println(n1+"  "+n2);
			
			if(s.Right!=null && Pright.get(Pright.size()-1)==false)
			{
				if(this.getPath(list, s.Right, node1, pathNode1))
					n1=true;
				if(this.getPath(list, s.Right, node2, pathNode2))
					n2=true;
				
				Pright.set(Pright.size()-1, true);
				list.add(s.Right);
				Pright.add(false);
				s=s.Right;
			}else{
				//important
				while(s.Right==null || Pright.get(Pright.size()-1)==true)
				{				
					list.remove(list.size()-1);
					Pright.remove(Pright.size()-1);
					if(list.isEmpty())
						break;
					s=list.get(list.size()-1);
				}
				
				//take care
				if(!list.isEmpty())
				{
					if(this.getPath(list, s.Right, node1, pathNode1))
						n1=true;
					if(this.getPath(list, s.Right, node2, pathNode2))
						n2=true;
					
					Pright.set(Pright.size()-1, true);
					list.add(s.Right);
					Pright.add(false);
					
					s=s.Right;

					//System.out.println(list.get(list.size()-1).Val);
				}
				
			}
			
			//System.out.println("list's size:"+list.size());
		}
		
		for(int i=0; i<pathNode1.size() && i<pathNode2.size(); i++)
		{
			if(pathNode1.get(i)!=pathNode2.get(i))
			{
				System.out.println(pathNode1.get(i-1).Val);
				return;
			}
		}
		
		if(pathNode1.size()<pathNode2.size())
			System.out.println(pathNode1.get(pathNode1.size()-1).Val);
		else
			System.out.println(pathNode2.get(pathNode2.size()-1).Val);
	}
	
	//判断从该节点是否为node1或node2，如果是的话，存储路径
	//我好像偶然探索到了一种JAVA函数传出多个值得新方法。。
	public boolean getPath(ArrayList<BTNode> list, BTNode s, BTNode node, ArrayList<BTNode> path)
	{
		if(s==node)
		{
			for(int i=0; i<list.size(); i++)
				path.add(list.get(i));
			path.add(node);
			return true;
		}
		
		return false;
	}
	
	//书上的。。没看。。
	
	//-------------------生成树------------------------------------
	/*
	 *                            1
	 *                2                          3
	 *           4           5              6
	 *     7              8      9
	 *        10    
	 *      11          */
	
	public ArrayList<BTNode> generateTree()
	{
		BTNode node11=new BTNode(11, null, null);
		BTNode node10=new BTNode(10, node11, null);
		BTNode node9=new BTNode(9, null, null);
		BTNode node8=new BTNode(8, null, null);
		BTNode node7=new BTNode(7, null, node10);
		BTNode node6=new BTNode(6, null, null);
		BTNode node5=new BTNode(5, node8, node9);
		BTNode node4=new BTNode(4, node7, null);
		BTNode node3=new BTNode(3, node6, null);
		BTNode node2=new BTNode(2, node4, node5);
		BTNode node1=new BTNode(1, node2, node3);
		
		ArrayList<BTNode> list=new ArrayList<BTNode>();
		list.add(node1); list.add(node2); list.add(node3); list.add(node4);
		list.add(node5); list.add(node6); list.add(node7); list.add(node8);
		list.add(node9); list.add(node10); list.add(node11); 
		
		return list;
	}
	
}
