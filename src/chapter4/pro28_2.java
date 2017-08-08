/*
 * @author: lxw
 * 2017年7月13日
 * problem：输入一个字符串，打印出该字符串中字符的所有组合。例如输入字符串abc，则打印出：
 *          a,b,c,ab,ac,bc,abc*/
package chapter4;

import java.util.ArrayList;


public class pro28_2 {
	

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		pro28_2 d=new pro28_2();
		d.printResult(d.myMethod("abcd"));
	}
	
	//这个应该也可以看成一个递归，但是这个递归是从后向前的，也就是说，先看后面的字符组合，然后前面一个字符加入已经得到的所有字符
	//组合
	/*
	 * 例如：abcd, 第一步：d； 第二步：c,c+{d}=cd， 第三步b+{空，d,c,cd}=b,bd,bc,bcd
	 * 第四步：a+{null,d,c,cd,b,bd,bc,bcd} =a,ad,ac,acd,ab,abd,abc,abcd
	 * 则排列组合就是上面4步得到的组合
	 */
	public ArrayList<String> myMethod(String str)
	{
		ArrayList<String> result=new ArrayList<String>();
		
		if(str==null)
			return result;
		
		int begain=str.length()-1;
		
		while(begain>=0)
		{
			int relen=result.size();
			String only=str.substring(begain, begain+1);
			//System.out.println(only);
			result.add(only);				
			for(int i=0; i<relen; i++)
				result.add(only+result.get(i));
			begain--;
		}
		
		return result;
		
	}
	
	
	public void printResult(ArrayList<String> res)
	{
		for(int i=0;i<res.size();i++)
			System.out.print(res.get(i)+", ");
		System.out.println();
		
	}


}
