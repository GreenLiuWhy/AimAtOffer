/*
 * @author: lxw
 * 2017年8月10日
 * 
 * problem：扑克牌的顺序
 * describe：从扑克牌中随机抽5张牌，判断是不是一个顺子，即这5张牌是不是连续的。2~10为数字本身，A为1，J为11，
 *           Q为12，K为13，而且大王小王可以看成任意数字*/
package chapter6;

public class pro44 {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		int[] arr1={1,3,5,4,0};//是
		int[] arr2={0,1,3,6,0};
		
		pro44 d=new pro44();
		d.myMethod(arr1);
		d.myMethod(arr2);
	}
	
	//按照书中的理解，可以传入一个数组，其中0可以看成能代表任意数字的大小王
	//time:8min
	/*
	 * 思路：step 1：排序
	 *     step 2：记录零的数目，然后计算零以后元素的  后面-前面 
	 *             if(后面-前面==0)
	 *                 no;
	 *              if(后面-前面==1)
	 *                 nothing to do;
	 *              if(后面-前面》1)
	 *                 看看0的个数够不够填充；
	 *                 
	 * 书上的和我的做法差不多，至于时间复杂度问题，只有5个数，应该是可以忽略。。
	 * 所以也就不写书上的做法了*/
	public void myMethod(int[] arr)
	{
		if(arr==null)
			return;
		
		this.popSort(arr);
		
		int zeroNum=0;
		while(arr[zeroNum]==0)
			zeroNum++;
		
		for(int i=zeroNum; i<arr.length-1; i++)
		{
			if(arr[i+1]-arr[i]==0)//==============
			{
				System.out.println("no");//说明
				return;
			}
			
			if(arr[i+1]-arr[i]!=1)
			{
				if(zeroNum>0)
				{
					zeroNum=zeroNum-(arr[i+1]-arr[i])+1;//=========
					if(zeroNum<0)
					{
						System.out.println("no");
						return;
					}
				}
				else
				{
					System.out.println("no");//说明
					return;
				}
			}
				
		}
		System.out.println("yes");
	}
	
	public void popSort(int[] arr)
	{
		for(int head=0; head<arr.length; head++)
		{
			for(int tail=arr.length-1; tail>head; tail--)
			{
				if(arr[tail-1]>arr[tail])
				{
					int t=arr[tail-1];
					arr[tail-1]=arr[tail];
					arr[tail]=t;
				}
			}
		}
	}

}
