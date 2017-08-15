/*
 * @author: lxw
 * 2017年8月10日
 * 
 * problem：输入一个正数s，打印出所有和为s的连续正数序列（至少含有两个数）
 * example：输入15，输出3个连续数列：1~5， 4~6， 7~8*/
package chapter6;

public class pro41_2 {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		pro41_2 d=new pro41_2();
		d.myMethod(15);
		System.out.println("---------------");
		d.bookMethod(15);
	}
	
	//time:10min
	/*
	 * 思路：本想着可不可以根据d=1的等差数列和的公式直接求，但发现涉及二次函数求解，于是放弃了。
	 *     最终还是用的笨方法，也就是，固定小数，遍历的去找大数*/
	public void myMethod(int num)
	{
		for(int i=1; i<=num/2; i++)
		{
			if(this.getBig(num, i)>0)
			{
				for(int pr=i; pr<=this.getBig(num, i); pr++)
					System.out.print(pr+", ");
				System.out.println();
			}
		}
	}
	
	public int getBig(int num, int begain)
	{
		int sum=0;
		int i=begain;
		for(; sum<num; i++)
			sum+=i;
		if(sum==num)
			return i-1;
		else 
			return 0;
	}
	
	//book
	/*time:3min
	 * 思路：也是两个指针，其中一个是small，一个是big。
	 *     先将small初始化为1，big初始化为2，序列和为3，如果我们要求等于9的所有连续数列。
	 *     那我们要big++，{1,2,3},还是小于，所以big++，{1,2,3,4}
	 *     此时大于9，所以我们small++，
	 *     {2,3,4}=9,打印，然后big++ 
	 *     if(small<=num/2) repeat上述过程*/
	public void bookMethod(int num)
	{
		int small=1;
		int big=2;
		int sum=small+big;
		while(small<=num/2)
		{
			if(sum==num)
			{
				for(int i=small; i<=big; i++)
					System.out.print(i+", ");
				System.out.println();
				sum=sum+big+1-small;
				big++;
				small++;				
			}else{
				if(sum>num)
				{
					sum=sum-small;
					small++;				
				}
				else
				{
					big++;
					sum=sum+big;
				}
			}
		}
	}

}
