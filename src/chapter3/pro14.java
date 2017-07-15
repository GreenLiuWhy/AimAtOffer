/*
 * problem：输入一个整数数组，实现一个函数来调整该数组中数字的顺序，使得所有奇数位于数组的前半部分，
 *          所有偶数位于数组的后半部分*/
package chapter3;

public class pro14 {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		int num=11;
		int[] arr=new int[num];
		for(int i=1;i<=num;i++)
			arr[i-1]=i;
		
		pro14 d=new pro14();
		int[] result=d.myMethod(arr);
		
		for(int i=0;i<result.length;i++)
			System.out.print(result[i]+",");
		
			

	}
	
	//自己的方法：从前面选偶数后移，后面选奇数前移，知道前后指针相遇则不在移动，时间复杂度为O(N)
	//考虑负数应该也是一样的
	public int[] myMethod(int[] arr)
	{
		int head=0;
		int tail=arr.length-1;
		int temp=0;
		while(head<tail)
		{
			//找前面的偶数
			while(head<arr.length && arr[head]%2!=0)
				head++;
			//找后面的奇数
			while(tail>=0 && arr[tail]%2==0)
				tail--;
			if(head<tail)
			{
				temp=arr[head];
				arr[head]=arr[tail];
				arr[tail]=temp;
			}
		}
		return arr;
	}
	
	//

}
