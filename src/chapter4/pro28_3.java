/*
 * @author: lxw
 * 2017年7月13日
 * problem：输入一个含有8个数字的数组，判断有没有可能把这8个数字分别放到正方体的8个顶点上，
 *          使得正方体上三组相对的面的4个顶点的和都相等*/
package chapter4;
import java.util.ArrayList;

public class pro28_3 {

	private ArrayList<int[]> resu=new ArrayList<int[]>();
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		pro28_3 d=new pro28_3();
		//int[] test1={1,2,3,4,5,6,7,8};
		int[] test1={1,2,3};
		int[] test2={1,1,1,1,1,1,1,1};
		d.bookMethod(test1);
		System.out.println("the result:");
		//d.printResult1();
		//d.bookMethod(test2);
		//d.printResult();
	}
	
	//bookMethod:先得到8个数字的排列组合，然后判断有没有一种排列组合符合下列条件
	/*
	 * a1+a2+a3+a4=a5+a5+a7+a8;	a1+a3+a5+a7=a2+a4+a6+a8;	a1+a1+a5+a6=a3+a4+a7+a8;
	 * 算法优点：比较容易想到，
	 * 缺点：时间复杂度有些高，很多无用的操作
	 */
	public boolean bookMethod(int[] arr)
	{
		if(arr==null || arr.length==0)
			return false;
		
		resu.clear();
		this.bookDigui(arr, 0);
		//this.printResult1();

		/*
		for(int i=0;i<result.size();i++)
		{
			int[] sub=result.get(i);
			if(sub[0]+sub[1]+sub[2]+sub[3]!=sub[4]+sub[5]+sub[6]+sub[7])
				continue;
			if(sub[0]+sub[2]+sub[4]+sub[6]!=sub[1]+sub[3]+sub[5]+sub[7])
				continue;
			if(sub[0]+sub[1]+sub[4]+sub[5]!=sub[2]+sub[3]+sub[6]+sub[7])
				continue;
			return true;
		}
		*/
		return false;
		
	}
	
	public void bookDigui(int[] arr, int begain)
	{
		if(begain==arr.length)
		{
			//System.out.println("the add num:");
			this.printIntArray(arr);
			//this.printResult1();
			if(!resu.contains(arr))
				resu.add(arr);
			//System.out.println(resu.size());
			//this.printResult1();
		}else{
			//交换
			for(int i=begain; i<arr.length; i++)
			{
				int temp=arr[i];
				arr[i]=arr[begain];
				arr[begain]=temp;
				
//				System.out.println("-----");
//				this.printIntArray(arr);
//				System.out.println("-----");
				//递归
				this.bookDigui(arr, begain+1);
				
				//换回
				temp=arr[i];
				arr[i]=arr[begain];
				arr[begain]=temp;
				
			}
			
		}
	}
	

	public void printResult1()
	{
		for(int i=0; i<resu.size(); i++)
			this.printIntArray(resu.get(i));
		System.out.println();
	}
	
	public void printIntArray(int[] arr)
	{
		for(int i=0;i<arr.length;i++)
			System.out.print(arr[i]);
		System.out.print(", ");
	}

}
