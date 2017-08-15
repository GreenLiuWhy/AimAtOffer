/*
 * @author: lxw
 * 2017年7月26日
 * 
 * 题目描述：统计一个数字在排序数组中出现的次数。
 *        例如输入排序数组{1,2,3,3,3,3,4,5}和数字3，犹豫3在数组中出现了4次，所以输出4*/
package chapter6;

public class pro38 {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		int[] arr1={1,2,3,3,3,3,4,5};
		
		pro38 d=new pro38();
		d.method1(arr1, 3);
		d.methodHalf(arr1, 3);
	}
	
	//time:5min
	//method 1：一个指针head，一个指针tail，分别找数字，再用tail-head+1得到
	public void method1(int[] arr, int num)
	{
		if(arr==null)
			return;
		
		int head=0;
		int tail=arr.length-1;
		while(head<arr.length && arr[head]!=num)
			head++;
		while(tail>=0 && arr[tail]!=num)
			tail--;
		
		if(head>tail)
		{
			System.out.println("can't find the num");
			return;
		}else
		{
			System.out.println(tail-head+1);
		}
	}
	
	//time: 50-
	/*
	 * 折半查找
	 * 思想：类似与书中的方法，但是书中用了递归。。。但我好像是一看递归就会晕倒的体质。。。
	 * 主要思想是先通过二分查找的方式，找到第一个k，也就是该位置是k，但是其左边的元素不是k
	 * 然后通过二分查找的方式找到最后一个k，也就是该位置是k,但是其右边的元素不是k
	 * 好了，既然我们找了左右两边的k了，
	 * 接下来就让我们愉快的相减吧！
	 * 
	 * 注意：
	 * 1，等号的位置
	 * 2，判断条件*/
	public void methodHalf(int[] arr, int num)
	{
		int low=0;
		int high=arr.length-1;
		int mid=(high+low)/2;
		
		int right,left;
		
		//find the left flag
		while(arr[mid]!=num || this.checkLeft(arr, mid, num) )
		{			
			if(arr[mid]>=num)//-----------等号在上面------
				high=mid-1;
			else
				low=mid+1;
			mid=(high+low)/2;
			if(low>high)
				break;
		}
		//System.out.println("low="+low+",  mid="+mid+",  high"+high);
		if(low>high)
			return;
		left=mid;
		
		//find the right flag
		low=mid;
		high=arr.length-1;
		mid=(high+low)/2;
		while(arr[mid]!=num || this.checkRight(arr, mid, num))
		{
			if(arr[mid]>num)//----------等号在面----------
				high=mid-1;
			else
				low=mid+1;
			mid=(high+low)/2;
			if(low>high)
				break;
		}
		//System.out.println("low="+low+",  mid="+mid+",  high="+high);
		if(low>high)
			return;
		right=mid;
		
		System.out.println(right-left+1);

	}
	
	public boolean checkLeft(int[] arr, int mid, int k)
	{
		if(arr[mid]==k && mid==0)
			return false;
		if(arr[mid]==k && mid!=0 && arr[mid-1]!=k)
			return false;
		return true;
	}
	
	public boolean checkRight(int[] arr, int mid, int k)
	{
		if(arr[mid]==k && mid==arr.length-1)
			return false;
		if(arr[mid]==k && mid!=arr.length-1 && arr[mid+1]!=k)
			return false;
		return true;
	}

}
