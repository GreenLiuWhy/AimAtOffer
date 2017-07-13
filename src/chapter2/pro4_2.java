/*author:lxw
 * data:6/29/2017
 * problem:有2个排序的数组A1和A2，内存在A1末尾有足够多的空余空间容纳A2.
 *          实现一个函数，将A2中的所有数字插入到A1中，并且使所有数据有序的*/
package chapter2;

public class pro4_2 {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		int[] A1={1,3,5};
		int[] A2={2,7,9};
		int[] A3=new int[A1.length+A2.length];
		for(int i=0;i<A1.length;i++)
			A3[i]=A1[i];
		
		pro4_2 demon=new pro4_2();
		int[] result=demon.newArrayMethod(A1, A2);
		demon.printArray(result);
		demon.printArray(demon.theBookMethod(A3, A2));

	}
	
	//violent method
	//iterate every A2 to insert A1. The time complex is O(n)
	//read the problem carefully, it need insert to A1,so the num's removing time need to be considered
	//so the time complexity is O(n*n)
	public int[] violentMethod(int[] A1,int A2)
	{
		int[] result=null;
		return result;
	}
	
	//a new array to place the result,then copy the result to A1
	//the time complex is O(m+n)
	public int[] newArrayMethod(int[] A1,int[] A2)
	{
		int[] result=new int[A1.length+A2.length];
		int dex1=0;
		int dex2=0;
		int dex=0;
		while(dex1<A1.length && dex2<A2.length)
		{
			if(A1[dex1]<=A2[dex2])
			{
				result[dex]=A1[dex1];
				dex1++;
			}else{
				result[dex]=A2[dex2];
				dex2++;
			}
			dex++;
		}
		
		while(dex1<A1.length)
		{
			result[dex++]=A1[dex1++];
		}
		
		while(dex2<A2.length)
			result[dex++]=A2[dex2++];
		
		return result;
	}

	//print array
	public void printArray(int[] aa)
	{
		for(int i=0;i<aa.length;i++)
			System.out.print(aa[i]);
		System.out.println();
	}
	
	//the book's method:
	//tail to head, the time complexity is O(n)
	public int[] theBookMethod(int[] aa,int bb[])
	{
		int dex1=aa.length-bb.length-1;
		//System.out.println(dex1);
		int dex2=bb.length-1;
		int dex=aa.length-1;
		while(dex1>=0 && dex2>=0)
		{
			if(aa[dex1]>=bb[dex2])
			{
				aa[dex]=aa[dex1];
				dex1--;
			}else{
				aa[dex]=bb[dex2];
				dex2--;
			}
			dex--;
		}
		
		while(dex1>=0)
		{
			aa[dex--]=aa[dex1--];
		}
		
		while(dex2>=0)
			aa[dex--]=bb[dex2--];
		return aa;
	}
}
