/*
 * problem：输入一个二叉树和一个整数，打印出二叉树中节点值的 和 为输入整数的所有路径。
 *          从输的根节点开始往下一直到也借点所经过的一条路径（不是根到叶的完整路径不行）*/
package chapter4;
import java.util.Queue;
import java.util.Stack;
import java.util.ArrayList;
import java.util.LinkedList;
public class pro25 {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		
	}
	

	//书上的方法:前序遍历+递归实现
 //思路：其实重建了一个类，记录父节点信息，还是通过广度优先搜索进行遍历，然后在节点加入的时候加的是我自己定义
	//的，可以记录父节点的数据结构
   public ArrayList<ArrayList<Integer>> myMethod(TreeNode root,int num) {
	        ArrayList<ArrayList<Integer>>  reR=new ArrayList<ArrayList<Integer>> ();
	        Stack<ArrayList<Integer>>  result=new Stack<ArrayList<Integer>> ();
	        
	        if(root==null)
	            return reR;
	        
			//还是采用广度优先遍历
	        Queue<toFather> qu=new LinkedList<toFather>();
	        toFather rr=new toFather(root,null);
	        qu.add(rr);
	        while(!qu.isEmpty())
	            {
	            toFather s=qu.poll();
	            if(s.zj.left!=null)
	                {
	                toFather tt=new toFather(s.zj.left,s);
	                qu.add(tt);
	            }
	            if(s.zj.right!=null)
	                {
	                toFather tt=new toFather(s.zj.right,s);
	                qu.add(tt);                
	            }
	            //说明是子节点
	            if(s.zj.right==null && s.zj.left==null)
	                {
	                //看看是否和为所求
	                toFather t=s;
	                int he=0;
	                Stack<Integer> path=new Stack<Integer>();
	                while(t!=null)
	                    {
	                    path.push(t.zj.val);
	                    he+=t.zj.val;
	                    if(he>num)
	                        break;
	                    t=t.fa;
	                }
	                //是符合条件的路径
	                if(he==num)
	                    {
	                    ArrayList<Integer> sub=new ArrayList<Integer>();
	                    while(!path.isEmpty())
	                        {
	                        sub.add(path.pop());
	                    }
	                    result.push(sub);
	                }
	            }
	        }
	        while(!result.isEmpty())
	            reR.add(result.pop());
	        return reR;
	        
	    }
	}


//新建一个类指向父亲节点
class toFather{
	TreeNode zj=null;
    toFather fa=null;
    
    public toFather(TreeNode v,toFather ff)
        {
        zj=v;
        fa=ff;
    }
}
    
//二叉树节点
class TreeNode{
	int val;
	TreeNode left;
	TreeNode right;
}

