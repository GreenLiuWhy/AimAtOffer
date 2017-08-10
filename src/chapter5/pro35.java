/*
 * @author: lxw
 * 2017年7月26日
 * 
 * 题目描述：在字符串中找到第一个只出现一次的字符。例如输入“abaccdeft”，则输出b*/
package chapter5;

import java.util.HashMap;

public class pro35 {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		String str="abaccdeft";
		
		pro35 d=new pro35();
		System.out.println(d.myMethod(str));
		
	}
	
	/*
	 * time:6min*/
	public char myMethod(String str)
	{
		char[] ss=str.toCharArray();
		HashMap<Character,Integer> hm=new HashMap<Character,Integer>();
		for(int i=0; i<ss.length; i++)
		{
			if(hm.get(ss[i])==null) //也就是没有自动初始化为0
				hm.put(ss[i], 1);
			else
				hm.replace(ss[i], hm.get(ss[i])+1);
		}
		
		for(int i=0 ;i<ss.length; i++)
		{
			if(hm.get(ss[i])==1)
				return ss[i];
		}
		
		
		return 'w';
	}
	
	//bookMethod:因为C++没有hashmap结构，所以书中方法人工实现hashMap结构，用了256length的数组，因为
	//char有8位，256个取值

}
