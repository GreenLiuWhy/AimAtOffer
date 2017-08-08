/*
 * problem：输入两个整数序列，第一个序列表示栈的压入顺序，请判断第二个序列是否为该栈的弹出序列。
 *          假设压入栈的所有数字均不相等。例如，序列1,2,3,4,5是某栈的压入顺序，
 *          序列4,5,3,2,1是该栈压栈序列对应的一个弹出序列。
 *          但4,3,5,1,2就不可能是该压栈序列的弹出序列*/
package chapter4;

import java.util.ArrayList;

public class pro22 {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		pro22 d=new pro22();
		ArrayList<Integer> in=d.getInList();
		ArrayList<Integer> outReal=d.getRealList();
		ArrayList<Integer> outWrong=d.getWrongList();
		
		d.myMethod_chuZhanQuDong(in, outReal);
		d.myMethod_chuZhanQuDong(in, outWrong);
		
	}
	
	//得到测试压入序列
	public ArrayList<Integer> getInList()
	{
		ArrayList<Integer> aa=new ArrayList<Integer>();
		for(int i=1;i<6;i++)
			aa.add(i);
		return aa;
	}
	
	//得到测试用正确弹出序列
	public ArrayList<Integer> getRealList()
	{
		ArrayList<Integer> aa=new ArrayList<Integer>();
		aa.add(4);aa.add(5);aa.add(3);aa.add(2);aa.add(1);
		return aa;
	}
	
	//得到测试用错误弹出序列
	public ArrayList<Integer> getWrongList()
	{
		ArrayList<Integer> aa=new ArrayList<Integer>();
		aa.add(4);aa.add(3);aa.add(5);aa.add(1);aa.add(2);
		return aa;
	}
	//通过
	public void myMethod_chuZhanQuDong(ArrayList<Integer> in, ArrayList<Integer> out)
	{
		int inDex=0;
		int outDex=0;
		ArrayList<Integer> stack=new ArrayList<Integer>();
		
		while(inDex<in.size())
		{
			stack.add(in.get(inDex));
			inDex++;
			while(!stack.isEmpty() && stack.get(stack.size()-1)==out.get(outDex))
			{
				outDex++;
				stack.remove(stack.size()-1);
			}
		}
		if(outDex>out.size()-1) //没有等号！
			System.out.println("yes");
		else
			System.out.println("no");
	}

}
