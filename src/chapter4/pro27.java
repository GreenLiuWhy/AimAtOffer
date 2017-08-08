/*
 * problem：输入一颗二叉搜素树，将该二叉搜素树转化成一个排序的双向链表。
 *          要求不能创建任何新的节点，只能调整树中节点指针的指向。*/
package chapter4;

import java.util.ArrayList;
import java.util.Stack;

public class pro27 {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		pro27 d=new pro27();
		BTNode root=d.getTree();
		BTNode result=d.myMethod(root);
		BTNode tail=result;
		while(tail!=null)
		{
			System.out.print(tail.Value+",");
			tail=tail.Right;
		}
		System.out.println();

	}

	//二叉树节点
	class BTNode{
		int Value;
		BTNode Left;
		BTNode Right;
		public BTNode(int v, BTNode l, BTNode r)
		{
			this.Value=v;
			this.Left=l;
			this.Right=r;
		}
	}
	
	//生成测试用二叉树
	public BTNode getTree()
	{
		BTNode node4=new BTNode(4,null,null);
		BTNode node8=new BTNode(8,null,null);
		BTNode node12=new BTNode(12,null,null);
		BTNode node16=new BTNode(16,null,null);
		BTNode node6=new BTNode(6,node4,node8);
		BTNode node14=new BTNode(14,node12,node16);
		BTNode node10=new BTNode(10,node6,node14);
		
		return node10;
	}
	
	//
	public BTNode myMethod(BTNode root)
	{
		ArrayList<BTNode> tt=new ArrayList<BTNode>();
        //采用非递归实现
        if(root==null)
            return null;
        
        boolean ll=true;//左子树是否遍历过
        Stack<BTNode> sta=new Stack<BTNode>();
        //Stack<TreeNode> line=new Stack<TreeNode>();
        sta.push(root);
        BTNode tail=root.Left;
        while(!sta.isEmpty())
            {
            while(ll && tail!=null)
            {
            	//System.out.println("the stack add:"+tail.Value);
                sta.push(tail);
                tail=tail.Left;
            }
            ll=false;
            BTNode s=sta.pop();
            tt.add(s);
            if(s.Right!=null)
                {
                tail=s.Right;
                sta.push(tail); //这个地方错了，因为如果在上面的话，10出栈的时候循环就终止了
                tail=tail.Left;
                ll=true;
            }
        }
        
        
        for(int i=0;i<tt.size()-1;i++)
            {
            tt.get(i).Right=tt.get(i+1);
            tt.get(i+1).Left=tt.get(i);
        }
        
        return tt.get(0);
	}
}

	
