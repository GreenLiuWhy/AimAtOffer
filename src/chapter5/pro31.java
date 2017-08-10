/*
 * @author: lxw
 * 2017年7月26日
 * 
 * 题目描述：输入一个整数数组，数组里有正数也有负数。数组中一个或连续的多个整数组成一个子数组。求所有子数组的和的最大值。
 * 要       求：时间复杂度为O(N)*/
package chapter5;

public class pro31 {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		int[] arr1={1,-2,3,10,-4,7,2,-5};
		
		pro31 d=new pro31();
		System.out.println(d.theMethod(arr1));
	}
	
	//
	/*
	 * time:4min
	 * */
	public int theMethod(int[] arr)
	{
		int max=arr[0];
		int count=0;
		for(int i=0; i<arr.length; i++)
		{
			if(arr[i]<0 && count>max)
				max=count;		
			count+=arr[i];
			if(count<=0)
				count=0;
			//System.out.println("count:"+count+"  max:"+max);
		}
		if(count>max)//这一个一定不要忘记，也就是后面没有负数
			max=count;
		return max;
	}

}
