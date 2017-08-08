/*
 * problem：输入一个整数数组，判断该数组是不是某二叉树搜索数的后序遍历结果。
 *          如果是则返回true，如果不是返回false
 *          建设属兔的数组的任意两个数字都不相同
 *          注意是二叉搜素数（左小右大），而不是二叉树*/
package chapter4;

public class pro24 {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		pro24 d=new pro24();
		int[] real=d.getRealtest();
		int[] wrong=d.getWrongtest();
		
		d.myMethod(real);
		d.myMethod(wrong);

	}
	
	//得到正确测试样例
	public int[] getRealtest()
	{
		int[] aa={5,7,6,9,11,10,8};
		return aa;
	}
	
	//得到错误测试样例
	public int[] getWrongtest()
	{
		int[] aa={7,4,6,5};
		return aa;
	}
	
	//思路：后序遍历，最后是根节点，且是二叉搜素树，所以，大于根节点的是右子树，小于根节点的是左子树
	      //那么，针对每一个子树，应该有一个 小于根  到  大于根  的过程，如果开始出现大于后又出现小于，则不能构成
	public boolean myMethod(int[] test)
	{
	     
        if(test==null || test.length==0)
            return false;
        
        int root=test[test.length-1];//根节点
        
        int ll=0;
        for(;ll<test.length-1 && test[ll]<root;ll++);
        int[] left=new int[ll];
        for(int j=0;j<ll;j++)
            left[j]=test[j];
        
        int[] right=new int[test.length-ll-1];
        for(int i=ll;i<test.length-1;i++)
            {
            if(test[i]<root)
                return false;
            right[i-ll]=test[i];
        }
        
        boolean lis=true;
        if(ll>0)
        	lis=myMethod(left);
        boolean ris=true;
        if(ll<test.length-1)	
        	ris=myMethod(right);
        
       if(lis==true && ris==true)
           return true;
        else
            return false;
	}

}
