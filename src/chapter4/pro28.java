/*
 * author:lxw
 * problem：输入一个字符串，打印出该字符串中字符的所有排列。例如输入字符串abc，则打印出：
 *          abc,acb,bac,aca,cab,cba
 *          其实就是全排列*/
package chapter4;
import java.util.ArrayList;

public class pro28 {

	private ArrayList<String> result=new ArrayList<String>();
	
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		pro28 d=new pro28();
		//d.printResult(d.bookMethod("aa"));
		
		d.printResult(d.bookMethod("abc"));
		//d.printResult(d.myMethod("abc"));

	}
	
	//自己的问题是本来没有考虑到字符串中有重复的字符,错了~~~~我的方法~~~
	public ArrayList<String> myMethod(String str)
	{
		ArrayList<String> re=new ArrayList<String>();
		re.add(str);
		for(int su=0;su<str.length();su++)
		{
			String head=str.substring(0, su);
			//System.out.println("head="+head);
			String tail=str.substring(su);
			//System.out.println("tail="+tail);
			for(int i=0;i<tail.length()-1;i++)
				for(int j=i+1;j<tail.length();j++)
				{
					System.out.println(this.replacePosition(tail, i, j));
					re.add(head+this.replacePosition(tail, i, j));
				}
		}
		return re;
		
	}
	
	//书中的方法：将第一个字符和后面的所有字符分别看为2个整体,然后用递归的方式进行求出
	//好像这种方式也没有考虑到右重复字符的情况
	public ArrayList<String> bookMethod(String str)
	{
		if(str==null)
			return null;
		
		result.clear();
		
		this.bookMethodDigui(str, 0);
		
		return result;
	}
	
	public void bookMethodDigui(String str,int begain)
	{
		if(begain==str.length())
		{
			if(!result.contains(str))
			{
				result.add(str);
				//System.out.println("add the num:"+str);
			}
			
		}
		else
		{
			for(int i=begain; i<str.length() ;i++)
			{
				//step 1：求出所有可能出现在第一个位置的字符，即将第一个字符与后面所有的字符交换
				str=this.replacePosition(str, begain, i);
				//step 2：固定第一个字符，求后面所有字符的全排列
				this.bookMethodDigui(str, begain+1);
				//下面这一句好像是可有可无的
				//str=this.replacePosition(str, begain, i);
				
			}
		}

	}
	
	public String replacePosition(String str,int head,int tail)
	{
		char[] sch=str.toCharArray();
		char temp=sch[head];
		sch[head]=sch[tail];
		sch[tail]=temp;
		/*
		for(int i=0;i<sch.length;i++)
			System.out.print(sch[i]);
			*/
		String ss=new String(sch);
		return ss;
	}
	
	public void printResult(ArrayList<String> res)
	{
		for(int i=0;i<res.size();i++)
			System.out.print(res.get(i)+", ");
		System.out.println();
		
	}

}
