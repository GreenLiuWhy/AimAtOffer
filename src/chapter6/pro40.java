/*
 * @author: lxw
 * 2017年8月10日
 * 
 * problem：数组中只出现一次的数字
 * describe：一个整型数组里除了两个数字之外，其他的数字都出现了两次。请写程序找出这两个只出现一次的数字。
 * require：时间复杂度为O(n)，空间复杂度为O(1)
 * example：输入数组{2,4,3,6,3,2,5,5}，输出4,6*/
package chapter6;

import java.util.HashMap;

public class pro40 {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		int[] arr={2,4,3,6,3,2,5,5};
		
		pro40 d=new pro40();
		d.myMethod(arr);
		d.myMethod(arr);
	}
	
	//time:4min
	/*
	 * 思路，借用hashmap来实现，好处是无论有多少个数字为1次，都可以在时间复杂度为O(N)下得到结果，
	 * 坏处是占用了空间复杂度，空间复杂度为O(N)*/
	public void myMethod(int[] arr)
	{
		HashMap<Integer, Integer> hm=new HashMap<Integer, Integer>();
		for(int i=0; i<arr.length; i++)
		{
			if(hm.get(arr[i])==null)
				hm.put(arr[i], 1);
			else
				hm.replace(arr[i], 1+hm.get(arr[i]));
		}
		
		for(int i=0; i<arr.length; i++)
			if(hm.get(arr[i])==1)
				System.out.print(arr[i]+", ");
				
		System.out.println();
	}
	
	//异或方法
	/*
	 * 思路:异或运算的性质--任何一个数字异或它自己都等于0，也就是说，如果我们从头到尾一次异或数组中的每一个数字，
	 *     那么最终的结果刚好是那个只出现一次的数字，因为那些成对出现两次的数字全部在异或操作中抵消了。
	 *     那问题的解决可以是，首先试着把原数组分成两个子数组，使得每个数字只包含一个只出现一次的数组，而其他数字都成对出现
	 *     两次。然后再在这两个子数组中找出数字。
	 *     
	 *     step 1： 我们还是从头到尾一次异或数组中的每一个数字，那么最终得到的结果就是两个只出现一次的数字的异或结果。
	 *     由于这两个数字肯定不一样，那么异或的结果肯定不为0，也就是说在这个数字的二进制表示中至少有一位是1.
	 *     step 2：我们再结果数字中找到第一个为1的位置，记为第n位。现在我们以第n位是不是1为标准把原数组分成两个子数组，
	 *     第一个子数组中每个卒子的第n位都是1，而第二个数组中的每个数字的第n位都是0.
	 *     step 3：在两个子数组中找数字
	 *     
	 *     
	 * 实现的优点：全部采用移位来实现*/
	public void bookMethod(int[] arr)
	{
		if(arr==null || arr.length<2)
		{
			System.out.println("the wrong input");
			return;
		}
		
		//find the first different
		int ResultOR=0;
		for(int i=0; i<arr.length; i++)
			ResultOR^=arr[i];
		
		int theFirstDiff=this.getFirstDiff(ResultOR);
		
		//divide two part in virtually
		int result1=0;
		int result2=0;
		for(int i=0; i<arr.length; i++)
		{
			if(this.divideTwoPart(arr[i],theFirstDiff))
				result1^=arr[i];
			else
				result2^=arr[i];
		}
		
		System.out.println("the num1:"+result1+",  the num2:"+result2);
	}
	
	public int getFirstDiff(int num)
	{
		int result=0;
		while((num&1)!=0) //因为是求最高位是1的情况，所以在1位的前面全部是0，所以满足这个条件
		{
			num=num>>1;
			result++;
		}
		return result;
	}
	
	public boolean divideTwoPart(int num, int dex)
	{
		for(int i=0; i<dex; i++)
			num=num>>dex;
		if(num%2==1)
			return true;
		else
			return false;
	}
	
	

}
