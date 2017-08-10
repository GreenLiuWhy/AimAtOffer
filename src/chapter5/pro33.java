/*
 * @author: lxw
 * 2017年7月26日
 * 
 * 题目描述：输入一个正整数数组，把数组里所有的数字拼接起来排成一个数，打印能拼接出的所有数字中最小的一个。
 *        例如，输入数组{3,32,321}，则输出321323
 * 时间复杂度：O(NlogN)*/
package chapter5;

import java.util.ArrayList;

public class pro33 {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		
		int[] arr1={3,32,321};
		pro33 d=new pro33();
		
		System.out.println(d.myMethod(arr1));
		System.out.println(d.PrintMinNumber(arr1));

	}
	
	//book method
	/*
	 * time:30min*/
	public String myMethod(int[] arr)
	{
		ArrayList<char[]> list=new ArrayList<char[]>();
		for(int i=0; i<arr.length; i++)
			list.add(this.intToChar(arr[i]));
		int[] paixu=new int[arr.length];
		
		//赋值
		paixu[0]=arr.length;
		int big=paixu[0];
		int small=paixu[0];
		for(int i=0; i<arr.length-1; i++)
			for(int j=i+1; j<arr.length; j++)
			{
				if(i==0)//赋值
				{
					if(this.compareBigSmall(list.get(i), list.get(j)))
						paixu[j]=++big;
					else
						paixu[j]=--small;
				}else{//交换值
					if(this.check(this.compareBigSmall(list.get(i), list.get(j)), paixu[i], paixu[j]))
					{
						int tt=paixu[i];
						paixu[i]=paixu[j];
						paixu[j]=tt;
					}
				}
			}
		
		//print
		String re="";
		int max=2*paixu.length;
		int min=max;
		int minDex=0;
		for(int i=0;i<paixu.length; i++)
		{
			for(int j=0; j<paixu.length;j++)
			{
				if(paixu[j]<min)
				{
					min=paixu[j];
					minDex=j;
				}
			}
			paixu[minDex]=max;
			min=max;
			
			char[] ttt=list.get(minDex);
			for(int m=0;m<ttt.length;m++)
				re+=ttt[m];
			
		}
		
		return re;
	}
	
	//真则c1小，应该为小的数
	public boolean compareBigSmall(char[] c1, char[] c2)
	{
		String s1=c1.toString();
		String s2=c2.toString();
		char[] head=(s1+s2).toCharArray();
		char[] tail=(s2+s1).toCharArray();
		
		for(int i=0; i<head.length; i++)
		{
			if(head[i]>tail[i])
				return false;
		}
		
		return true;
		
	}
	
	public boolean check(boolean head, int ii, int jj)
	{
		if(head && ii>jj)
			return true;
		if(!head && ii<jj)
			return true;
		return false;
	}
	
	public char[] intToChar(int num)
	{
		//System.out.print(String.valueOf(num));
		return String.valueOf(num).toCharArray();
	}
	
	
	//bookMehod:通过compare函数接口实现
	/*
	 * 对Java中的compareto方法和compare方法的说明：
	 * ------------------compareto方法--------------------
	 * 参考：http://www.blogjava.net/hgc-ghc/archive/2013/03/28/397084.html
	 * 简介：返回参与比较的前后两个字符串的ASCII码差值
	 * 1.如果两个字符串首字母不同，则该方法返回首字母的ASCII码差值
	 * 2.如果首字母相同，则比较下一个字符，直到有不同的为止，返回该不同的ASCII码差值
	 * 3.如果两个字符串不一样长，可以参与比较的字符又完全一样，则返回两个字符串的长度差值
	 * NOTE：差值=str1.compareto.b=a-b
	 * 
	 * -------------------compare方法------------------------
	 * 实际上用的是待比较对象的compareTo方法
	 * 
	 * */
	
    public String PrintMinNumber(int [] numbers) {
    	//其实这两个for循环做了一个类似于冒泡排序的工作，每次都将我们定义的小值放在前面。
        for(int i=0;i<numbers.length;i++)
        {
            for(int j=numbers.length-1;j>i;j--)
            {
                if(compare(numbers[j-1],numbers[j])>0) //前面的ASCII减后面的ASCII，大于0表示，前面的大
                {
                    int temp=numbers[j-1]; //也就是互换位置，将后面的放在数组的前面
                    numbers[j-1]=numbers[j]; //这样的话，最后省去了排序操作
                    numbers[j]=temp; 
                }
            }
        }
        String ans="";
        for(int i=0;i<numbers.length;i++){
            ans+=numbers[i];
        }
        return ans;
    }
    
    public int compare(int int1,int int2){
        String str1=int1+""+int2;
        String str2=int2+""+int1;
        return str1.compareTo(str2);
    }

}
