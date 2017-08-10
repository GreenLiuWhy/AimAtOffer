/*
 * @author: lxw
 * 2017年7月26日
 * 
 * 题目描述：输入n个整数，找出其中最小的k个数。例如输入4,5,1,6,2,7,3,8这8个数字，则最小的4个数字是1,2,3,4
 * 要        求：在O(NlogK)的时间复杂度下*/
package chapter5;

public class pro30 {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		int[] arr1={4,5,1,6,2,7,3,8};
		
		pro30 d=new pro30();
		d.methodQuickSort(arr1, 4);
		d.methodBaseHeap(arr1, 4);
	}
	
	//思路1:结合快速排序
	/*
	 * time:7min
	 * 缺点：改变了数组
	 * 优点：时间复杂度为O(N)
	 * 思路：借助开速排序思想
	 * */
	public void methodQuickSort(int[] arr, int k)
	{
		if(arr==null || k>arr.length)
			return;
		
		int[] result=new int[k];
		int mid=this.paration(arr, 0, arr.length-1);
		while(mid!=k)
		{
			if(mid>k)
				mid=this.paration(arr, 0, mid-1);
			else
				mid=this.paration(arr, mid+1, arr.length-1);
		}
		
		//print
		for(int i=0;i<result.length; i++)
			System.out.print(arr[i]+",");
		System.out.println();
	}
	
	public int paration(int[] arr, int low, int high)
	{
		int pri=arr[low];
		while(low<high)
		{
			while(low<high && pri<=arr[high])
				high--;
			if(low>=high)
				break;
			arr[low]=arr[high];
			while(low<high && pri>=arr[low])
				low++;
			if(low>=high)
				break;
			arr[high]=arr[low];
		}
		arr[low]=pri;
		return low;
	}
	
	//思路2：
	/*
	 * time:20min
	 * 思路：先创建一个大小为k的数据容器来存储最小的k个数字，接着每次从输入的n个整数中读取一个数。
	 * 如果容器中的已有数字少于k个，则直接把这次读入的整数放到容器之中；
	 * 如果容器中的已有k个数字，则找出这k个数据的最大值，然后拿这次待插入的整数和最大的值进行比较
	 * 如果带插入小，则替换
	 * 则在容器已满的情况下我们应该：
	 * step 1：在k个整数中找到最大的数
	 * step 2：在容器中删除最大的数
	 * step 3：插入新的数字
	 * NOTE：为了在logK的时间复杂度内实现插入和删除该节点的操作，可以用二叉树来做这个容器（或者大根堆）
	 * 优点：
	 * 缺点：*/
	public void methodBaseHeap(int[] arr, int k)
	{
		if(arr==null || k>arr.length)
			return;
		
		int[] result=new int[k];
		for(int i=0; i<k; i++)
			result[i]=arr[i];
		
		//建立大根堆
		this.BuildMaxHeap(result);
		
		for(int i=k; i<arr.length; i++)
		{
			if(result[0]>arr[i])
			{
				result[0]=result[0]+arr[i];
				arr[i]=result[0]-arr[i];
				result[0]=result[0]-arr[i];
				this.BuildMaxHeap(result);
			}
		}
		
		//print
		for(int i=0; i<result.length; i++)
			System.out.print(result[i]+", ");
		System.out.println();
		
	}
	
	public void BuildMaxHeap(int[] arr)
	{
		int dex=arr.length/2-1;
		while(dex>=0)//这个地方可以是>=0，因为adjust程序里，有一个dex--，会使之变成-1，也就是不需要后面的东西了
			dex=this.AdjustHeap(arr, dex);
		/*
		//System.out.println("first");
		dex=this.AdjustHeap(arr, 0);
		while(dex>0)
			dex=this.AdjustHeap(arr, 0);
		//System.out.print("second");
		 * *
		 */
	}
	
	public int AdjustHeap(int[] arr, int dex)
	{
		
		if(dex*2+1<arr.length)//左右孩子节点的最大的
		{
			int son=dex*2+1;
			if(son+1<arr.length)
			{
				if(arr[son+1]>arr[son])
					son++;
			}
			//System.out.println("dex:"+arr[dex]+", son:"+arr[son]);
			if(arr[dex]<arr[son])
			{
				//交换
				arr[dex]=arr[dex]+arr[son];
				arr[son]=arr[dex]-arr[son];
				arr[dex]=arr[dex]-arr[son];
				//dex=son;
				return son;//这个一定不可以在if外面！！！
			}
			
		}
		dex--;
		return dex;
	}
	


}
