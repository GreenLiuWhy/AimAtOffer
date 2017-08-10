/*
 * @author: lxw
 * 2017年7月26日
 * 
 * 题目描述：输入一个整数n，求从1到n这n个整数的十进制表示中1出现的次数。例如输入12，从1到12这些证书中包含1的数字
 *        有1,10,11,12；则1一共出现了5次
 * 要      求：时间复杂度为O(logN)*/
package chapter5;

public class pro32 {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		pro32 d=new pro32();
		System.out.println(d.methodNet(12));
		System.out.println(d.methodNet(5));
		System.out.println(d.methodNet(534));
		System.out.println(d.methodNet(530));
		System.out.println(d.methodNet(504));
		System.out.println(d.methodNet(514));
		System.out.println(d.methodNet(0));
		System.out.println(d.methodNet(1));
	}
	
	//the net method
	/*
	 * time:11min
	 * 思路：http://blog.csdn.net/yi_afly/article/details/52012593*/
	public int methodNet(int num)
	{
		int weishu=1;
		for(int ch=10; num%ch!=num; weishu++, ch*=10);
		//System.out.println(weishu);
		int chu=10;
		int result=0;
		while(weishu-->0)
		{
			int yu=(num%chu)/(chu/10);
			if(yu==0)
				result+=(num/chu)*chu/10;
			if(yu==1)
				result+=(num/chu)*chu/10+num%(chu/10)+1;
			if(yu>1)
				result+=(num/chu+1)*chu/10;
			//System.out.println("result="+result);
			chu*=10;
		}
		return result;
	}
	//the book method
	//递归做法，太复杂了，没自信看
	

}
