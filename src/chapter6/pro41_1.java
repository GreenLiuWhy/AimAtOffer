/*
 * @author: lxw
 * 2017年8月10日
 * 
 * problem：和为s的两个数字 VS 和为s的连续正数序列
 * describe：输入一个递增排序的数组和一个数字s,在数组中查找两个数，使得它们的和正好等于s，
 *          如果有多对数字的和为s，则输出任意一对即可
 * example：输入{1,2,4,7,11,15},15 输出 4,11*/
package chapter6;

public class pro41_1 {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		int[] arr1={1,2,4,7,11,15};
		
		pro41_1 d=new pro41_1();
		d.myMethod(arr1, 6);
		d.bookMethod(arr1, 6);
	}
	
	//time:5min
	/*
	 * 思路： 固定最大的数，然后指针从小数向大数方向移动，如果小于指定的和，则再将小数往大数方向移动，
	 *     如果大于指定的和，则跳出第二层循环，将大数改变，再重复小数过程
	 * 时间复杂度：O(N^2)*/
	public void myMethod(int[] arr, int num)
	{
		for(int tail=arr.length-1; tail>=0; tail--)
		{
			for(int head=0; head<tail; head++)
			{
				if(arr[head]+arr[tail]==num)
				{
					System.out.println(arr[head]+", "+arr[tail]);
					return;
				}
				else
				{
					if(arr[head]+arr[tail]>num)
						break;			
				}
			}
		}
		
		System.out.println("have no result");
	}
	
	//book
	/*
	 * 思路： 大数和小数一起移动，先使在两头，如果和超出了指定值，则大数移动，如果小于指定的值，则小数向大数方向移动
	 * 时间复杂度：O(N)
	 * time:2min*/
	public void bookMethod(int[] arr, int num)
	{
		int head=0;
		int tail=arr.length-1;
		int sum=0;
		while(tail>head)
		{
			sum=arr[head]+arr[tail];
			if(sum==num)
			{
				System.out.println(arr[head]+",  "+arr[tail]);
				return;
			}else{
				if(sum>num)
					tail--;
				else
					head++;
			}
		}
		
		System.out.println("have something wrong");
	}
	

}
