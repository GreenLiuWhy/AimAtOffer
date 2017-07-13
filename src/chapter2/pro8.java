/*author:lxw
 * data:6/29/2017
 * problem:旋转数组的最小数字
 *         把一个数组最开始的若干元素搬到数组的末尾，我们称之为数组的旋转
 *         输入一个递增排序的数组的一个旋转，输出旋转数组的最小元素
 *         如，输入数组{3,4,5,1,2},输出最小元素1
 * 错误：
 *      原来数组本身有序的时候，会造成死循环
 *      */
package chapter2;

import java.util.ArrayList;

public class pro8 {
	ArrayList<Integer> aa;

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		pro8 dd=new pro8();
		dd.printaa();
		dd.myMehod_Zheban();

	}
	
	//构造函数
	public pro8(){
		aa=new ArrayList<Integer>();
		for(int i=0;i<=3;i++)
		{
			aa.add(i);
//			aa.add(i);
//			aa.add(i);
		}
//		aa.add(0);
//		for(int i=3;i<=3;i++)
//		{
//			aa.add(i);
//			aa.add(i);
//		}
	}
	//打印
	public void printaa()
	{
		if(aa.isEmpty())
		{
			System.out.println("ArrayList is empty");
			return;
		}
		for(int i=0;i<aa.size();i++)
			System.out.print(aa.get(i));
		System.out.println();
	}
	//暴力法，遍历直到后一个数字比前一个数字小，时间复杂度为O(N)
	//类似于折半查找法，时间复杂度为LOG(N)，考虑有相同元素的存在
	public int myMehod_Zheban()
	{
		if(aa.isEmpty())
		{
			System.out.println("the List is empty");
			return 0;
		}
		
		int head=0;
		int tail=aa.size()-1;
		int med=(head+tail)/2;
		
		//当本身就是顺序的话
		if(aa.get(head)<=aa.get(tail))
		{
			System.out.println(aa.get(head));
			return 0;
		}
		
		while(!(aa.get(med)<aa.get(med-1) || aa.get(med)>aa.get(med+1)))
		{
			if(aa.get(head)>aa.get(med))
				tail=med;
			else
				head=med;
			med=(head+tail)/2;
		}
		System.out.println(head+"  "+med+" "+tail);
		if(aa.get(med)<=aa.get(med-1) && aa.get(med)<aa.get(med+1))
			System.out.println(aa.get(med));
		else
		{
			if(aa.get(med+1)<=aa.get(med-1) && aa.get(med+1)<aa.get(med))
				System.out.println(aa.get(med+1));
			else
				System.out.println(aa.get(med)-1);
		}
		return 0;
	}

}
