/*
 * @author: lxw
 * 2017年8月10日
 * 
 * problem：n个骰子的点数
 * describe：把n个骰子仍在地上，所有骰子朝上一面的点数之和为s。输入n，打印出s的所有可能值出现的概率*/
package chapter6;
import java.util.ArrayList;

public class pro43 {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		pro43 d=new pro43();
		
		d.IwriteMethod2(3);
	}
	
	/*
	 * 思路：基于循环求骰子点数，时间性能好
	 * 方案：用两个数组来存储筛子点数的每一个总数出现的次数。
	 *     在每一次循环中，第一个数组中的第n个数字表示骰子和为n的出现次数。
	 *     在下一次循环中，我们加上一个新的骰子，此时和为n的骰子出现的次数应该等于上一次循环中骰子何为
	 *     n-1,n-2,n-3,n-3,n-5和n-6的次数的总和，所以我们把另一个数组的第n个数字设为前一个数组对应的第
	 *     n-1,n-2,n-3,n-4,n-5和n-6之和
	 * http://blog.csdn.net/whuqin/article/details/6639187*/
	public void IwriteMethod2(int num)
	{
		if(num<1)
			return;
		
		ArrayList<Integer> N_=new ArrayList<Integer>();//记录N-1个骰子的点数为n出现的次数
		ArrayList<Integer> N=new ArrayList<Integer>();//记录N个骰子时的情况
		
		for(int i=0; i<6; i++)
			N_.add(1);//递归的初始
		
		for(int digui=2; digui<=num; digui++)
		{
			for(int nd=0; nd<digui*5+1; nd++)
			{
				int temp=0;
				int head=0;
				if(nd-5>0)
					head=nd-5;
				for(int i=head; i<N_.size() && i<=nd; i++)
					temp+=N_.get(i);
				N.add(temp);
			}
			
			N_.clear();
			N_=(ArrayList<Integer>)N.clone();
			N.clear();
		}
		N=N_;
		double sum=0.0;
		for(int i=0; i<N.size(); i++)
			sum+=N.get(i);
		
		for(int i=0; i<N.size(); i++)
			System.out.println((i+num)+"'s problity:"+N.get(i)/sum);
	}

}
