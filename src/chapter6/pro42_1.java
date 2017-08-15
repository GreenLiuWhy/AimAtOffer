/*
 * @author: lxw
 * 2017年8月10日
 * 
 * problem：反转单词顺序 VS 左旋转字符串
 * describe：输入一个英文句子，旋转句子中单词的顺序，但单词内字符的顺序不便，
 *          简单起见，标点符号和普通字母一样处理
 * example：输入"I am a student" 则输出 "student. a am I" */
package chapter6;

public class pro42_1 {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		String str1="I am a student";
		
		pro42_1 d= new pro42_1();
		d.myMethod(str1);
	}
	
	//time:11min
	public void myMethod(String str)
	{
		if(str==null)
			return;
		
		char[] ss=str.toCharArray();
		String result="";
		for(int head=ss.length-1,tail=head; head>=0;)
		{
			while(head>=0 && ss[head]!=' ')
				head--;
			if(head>=0)
			{
				for(int i=head+1; i<=tail; i++)
				{
					result+=ss[i];
				}
				result+=" ";
				tail=head-1;
				head=tail;
			}else{
				if(head==-1)//=======================
				{
					for(int i=head+1; i<=tail; i++)//===========
						result+=ss[i];
				}
			}
		}
		System.out.println(result);
	}
	
	//书中的方法是先反转整个句子，后反转每个单词，自感不如我这个方法，所以不写书中的方法了！

}
