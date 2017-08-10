/*
 * @author: lxw
 * 2017年7月26日
 * 
 * 题目描述：我们把只含有因子2,3,5的数称为丑数。求按从小到大的顺序的第1500个丑数。
 *        例如，6、8都是丑数，但14不是。习惯上，我们将1作为第一个丑数*/
package chapter5;
import java.util.ArrayList;

public class pro34 {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		pro34 d=new pro34();
		for(int i=1; i<15; i++)
			System.out.println(d.myMethod(i)+",  "+d.bookMethod(i));
		System.out.println(d.myMethod(1500)+",  "+d.bookMethod(1500));
	}
	
	/*
	 *time:16min 
	 *思路：与书上的不同是
	 *书上是所有数组中的元素乘以2,3,5取其中大于M的最小值，然后在3个值中取最小
	 *我的方法是，在所有数上全部乘以2,3,5，然后在数组.length个数里取最小
	 *不如书中的方法好实现，也不如书中的时间复杂度低 */
	public int myMethod(int k)
	{
		int count=1;
		ArrayList<Integer> list=new ArrayList<Integer>();
		ArrayList<Integer> first=new ArrayList<Integer>();
		list.add(1);
		int[] chou={2,3,5};
		boolean flag=false;
		
		while(count<k)
		{
			flag=false;
			first.clear();
			for(int i=0; i<list.size(); i++ )
			{
				for(int j=0; j<chou.length; j++)
				{
					if(list.get(i)*chou[j]>list.get(list.size()-1))
					{
						first.add(list.get(i)*chou[j]);
						if(list.get(i)*chou[j]==list.get(list.size()-1))
							flag=true;
						break;
					}
				}
				
				if(flag==true)
					break;
			}
			
			//在first里面找最小的
			if(flag==true)
				list.add(first.get(first.size()-1));
			else
			{
				int min=first.get(0);
				for(int i=0; i<first.size(); i++)
					if(min>first.get(i))
						min=first.get(i);
				list.add(min);
			}
			count++;
		}
		
		return list.get(list.size()-1);
		
	}
	
	//bookmethod
	/*
	 * 思路：假设数组中已经有若干丑数排好序的放入的数组中，那么下一个丑数一定是前面某一个丑数*2,3,5后的结果
	 * 即目前数组中的最大值为 M
	 * 如果是按顺序生成的，那么小于或者等于M的肯定已经在数组中了，我们不需要再考虑；
	 * 我们只需要考虑第一个大于M的结果M2
	 * 同理，将数组中的元素按顺序乘以3，得到第一个大于M的元素M3，以同样方式得到M5，
	 * 将min{M2,M3,M5}加入到数组中
	 * time:7min */
	public int bookMethod(int k)
	{
		ArrayList<Integer> list=new ArrayList<Integer>();
		int count=1;
		list.add(1);
		int M;
		int M2=0;
		int M3=0;
		int M5=0;
		while(count<k)
		{
			M=list.get(list.size()-1);
			//System.out.print("M="+M);
			for(int i=0; i<list.size() && M2<=M; i++) //原来少了等号
				M2=list.get(i)*2;
			//System.out.print("  M2="+M2);
			for(int i=0; i<list.size() && M3<=M; i++)
				M3=list.get(i)*3;
			//System.out.print(",  m3="+M3);
			for(int i=0; i<list.size() && M5<=M; i++)
				M5=list.get(i)*5;
			//System.out.print(",  m5="+M5);
			int[] arr={M2, M3, M5};
			//System.out.println(",  add:"+this.theMin3(arr));
			list.add(this.theMin3(arr));
			count++;
		}
		return list.get(list.size()-1);
	}
	
	public int theMin3(int[] arr)
	{
		
		for(int i=1;i<arr.length;i++)
			if(arr[0]>arr[i])
				arr[0]=arr[i];
		return arr[0];
	}
}
