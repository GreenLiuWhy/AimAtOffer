/*
 * author:lxw
 * data:6/29/2017
 * problem:实现一个函数，将字符串中的每一个空格替换为%20*/
package chapter2;

public class pro4 {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		String ss="the big big liu";
		pro4 demon=new pro4();
		System.out.println(demon.violenceMehtod(ss));

	}
	
	//method1:iterate the String,if find a blank, then change it
	//the time complexity is O(n)
	public String violenceMehtod(String ss)
	{
		String result="";
		for(int i=0;i<ss.length();i++)
		{
			char s=ss.charAt(i);
			if(s==' ')
				result=result+"%20";
			else
				result=result+s;
		}
		return result;
	}

}
