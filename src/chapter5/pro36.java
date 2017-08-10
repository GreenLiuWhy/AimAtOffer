/*
 * @author: lxw
 * 2017年7月26日
 * 
 * 题目描述：在数组中的两个数字，如果前面的一个数字大于后面的数字，则这两个数字就组成了一个逆序对。
 *        输入一个数组，求出这个数组中逆序对的总数。*/
package chapter5;

public class pro36 {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		int[] arr1={7,5,6,4};
		int[] arr2={1,2,3,4};
		int[] arr3={4,3,2,1};
		
		pro36 d=new pro36();
		System.out.println(d.myMethod(arr1));
		System.out.println(d.myMethod(arr2));
		System.out.println(d.myMethod(arr3));
	}
	
	/* 
	 * 借助归并排序思想
	 * time:22min*/
	public int myMethod(int[] arr)
	{
		int count=0;
		int path=1;
		int low=0;
		int high;
		while(path<=arr.length/2)
		{
			low=0;
			high=low+path*2-1;
			while(high<arr.length)
			{
				count+=this.merge(arr, low, high, path);
				low=low+2*path;
				high=low+path*2-1;
			}
			if(high>=arr.length && low<arr.length)
				count+=this.merge(arr, low, arr.length-1, path);
			path*=2;
		}
		
//		for(int i=0; i<arr.length; i++)
//			System.out.print(arr[i]+", ");
//		System.out.println();
		
		return count;
	}
	
	public int merge(int[] arr, int low, int high, int path)
	{
		int rlow=low;
		int headtail=low+path-1;
		if(headtail>=arr.length)
			headtail=arr.length-1;
		int tailhead=headtail+1;
		if(tailhead>=arr.length)
			tailhead=headtail;
		int count=0;
		
		int[] temp=new int[high-low+1];
		int dt=0;
		while(low<=headtail && tailhead<=high)
		{
			if(arr[low]<arr[tailhead])
				temp[dt++]=arr[low++];
			else
			{
				temp[dt++]=arr[tailhead++];
				count+=(headtail-low+1);//注意这个地方不应该是加1！！！
			}
		}
		while(low<=headtail)
		{
			temp[dt++]=arr[low++];
			//count++; //这个地方不应该有
		}
		while(tailhead<=high)
			temp[dt++]=arr[tailhead++];

		for(int i=0; i<temp.length; i++)
			arr[rlow+i]=temp[i];

		
		return count;
	}

}
