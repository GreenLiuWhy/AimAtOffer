/*
 * @author: lxw
 * 2017年7月13日
 * 题目描述：在O(N)复杂度上，找出数组中超过一半的数字*/
package chapter5;

import java.util.HashMap;
import java.util.Iterator;
import java.util.Map;
import java.util.Map.Entry;

public class pro29 {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		int[] arr1={1,2,3,2,2,2,5,4,2};
		int[] arr2={1};
		
		pro29 d=new pro29();
		System.out.println(d.myMethod(arr1));
		System.out.println(d.bookMethod1(arr1));
		System.out.println(d.bookMethod2(arr1));
		
		System.out.println(d.myMethod(arr2));
		System.out.println(d.bookMethod1(arr2));
		System.out.println(d.bookMethod2(arr2));
	}
	
	//思路：通过hashmap实现，先遍历一遍数据，得到每个数据的次数，然后过滤hashmap，查看有没有个数大于一半的
	public int myMethod(int[] array)
	{
		HashMap<Integer,Integer> hash=new HashMap<Integer,Integer>();
        for(int i=0;i<array.length;i++)
        {
            if(hash.get(array[i])==null)
                hash.put(array[i],1);
            else
                hash.replace(array[i],hash.get(array[i])+1);
        }
        
        Iterator<Entry<Integer, Integer>> iter=hash.entrySet().iterator();
        while(iter.hasNext())
        {
        	Map.Entry entry=(Map.Entry)iter.next();
        	int key=(int)entry.getKey();
        	int val=(int)entry.getValue();
        	if(val>array.length/2)
        		return key;
        }
        return 0;
	}
	
	//bookMehod1：基于quickSort的方案
	/*
	 * 一个数字超过了数字上的一半，也就是统计上的中位数，受快速排序的影响，先再数组中任意选择一个数字，
	 * 然后调整数组中数字的顺序，使得比选中的数字大的都排
	 * 问题：需要改变数组内容
	 * */
	public int bookMethod1(int[] arr)
	{
		int result=0;
		int mid=this.paration(arr, 0, arr.length-1);
		while(mid!=arr.length/2)
		{
			if(mid<arr.length/2)
			{
				//System.out.println("small:"+mid);
				mid=this.paration(arr, mid+1, arr.length-1);
				
			}
			else
			{
				//System.out.println("big:"+mid);
				mid=this.paration(arr, 0, mid-1);
				
			}
			//System.out.println("test:"+mid);
		}
		//System.out.println("test out");
		result=arr[mid];
		if(this.check(result, arr))
			return result;
		else 
			return 0;
	}
	
	public boolean check(int result,int[] arr)
	{
		int cout=0;
		for(int i=0; i<arr.length; i++)
			if(arr[i]==result)
				cout++;
		if(cout>arr.length/2)
			return true;
		else
			return false;
	}
	
	public int paration(int arr[], int low, int high)
	{
		int pri=arr[low];
		while(low<high)
		{
			while(low<high && pri<=arr[high])//这个地方一定要包含一个等号，当然在下面包含也可以
				high--;	
			if(low>=high)
				break;
			arr[low]=arr[high];
			while(low<high && pri>arr[low])
				low++;
			if(low>=high)
				break;
			arr[high]=arr[low];
		}
		arr[low]=pri;
		return low;
	}

	//bookMethod2:
	/*
	 * time:5min
	 * 思路：数组中一个数字出现的次数超过数组长度的一半，也就是说它出现的次数比其他数字出现的次数出现的次数的和还要多，
	 * 因此我们考虑数组遍历的时候保存2个值：一个是数组中的一个数字，一个是次数。
	 * 当我们遍历到下一个数字的时候，如果这个数字和我们之前保存的数字相同，则次数加1；
	 * 如果不同，则次数减1；
	 * 如果次数为0，则需要保存下一个数字，并将次数设为1.
	 * */
	public int bookMethod2(int[] arr)
	{
		int count=1;
		int save=arr[0];
		for(int i=1; i<arr.length; i++)
		{
			if(count==0)
			{
				count++;
				save=arr[i];
				continue;
			}
			if(save==arr[i])
				count++;
			else
				count--;
			
		}
		if(count>0)
			return save;
		else
			return 0;
	}
	
}
