/*
 * @author: lxw
 * 2017年8月10日
 * problem：字符串的左旋操作是吧字符串前面额若干个字符转移到字符串的尾部。
 *          请定义一个函数实现字符串左旋操作的功能。
 * example：例如输入"abcdfeg"和2 则输出返回左旋转2位的操作结果："cdefgab"*/
package chapter6;

public class pro42_2 {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		String str1="abcdefg";
		
		pro42_2 d=new pro42_2();
		d.myMethod(str1, 2);
	}
	
	//time:3min
	public void myMethod(String str,int k)
	{
		if(str==null || k>str.length())
			return;
		
		char[] ss=str.toCharArray();
		String result="";
		
		for(int i=k; i<ss.length; i++)
			result+=ss[i];
		
		for(int i=0; i<k; i++)
			result+=ss[i];
		
		System.out.println(result);
	}
	
	//是C++不能变数组么，，书中的方法很麻烦，不再写入

}
