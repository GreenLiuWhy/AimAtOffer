/*
 * @author: lxw
 * 2017年8月10日
 * problem：求1+2+...+n
 * describe：求1+2+...+n，要求不能使用除法，for，while，if，else，switch，case等关键字及
 *          条件判断语句(A?B:C)*/
package chapter6;

import java.util.ArrayList;

//这个！其实有错误！
public class pro46 {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		pro46 d=new pro46();
		
		d.method1(10);
	}
	
	//实在想不出，下面的做法全部来自于书上
	
	/*
	 * 思路一： 利用构造函数来求解
	 * 方案：还是围绕循环来做文章，不利用for,while来让相同的代码重复n遍，
	 *     则可以定义一个类型，然后构造n个实例。也就是说，我们可以将与累加相关的代码放在构造函数里*/
	
	//这个方法好像对Java无效。。因为JAVA并没有对数组中的每个Temp元素进行初始化
	public void method1(int n)
	{
		Temp.Reset();
		
		Temp[] ll=new Temp[n];
		ll=null;
		
		System.out.println("the method1:"+Temp.GetSum());
	}
	
	
	/*
	 * 思路二：利用虚函数求解
	 * 方案：围绕递归做文章。既然不能在一个函数里判断是不是应该终止递归，那么我们可以利用两个函数
	 *     一个函数充当递归的角色，另一个函数处理递归终止的情况，我们要做的就是在这两个函数里二选一；
	 *     那么问题变为，如何将数值变量n变为布尔值===>!!n*/

}

//也就是说，如果是内部类的话，不能用static方法，用外部类的时候是可以的
//------------------------方法一-------------------------------
class Temp
{
	private static int N;
	private static int sum;
	
	public Temp()
	{
		N++;
		sum+=N;
		System.out.println("generate a new one");
	}
	
	public static void Reset()
	{
		N=0;
		sum=0;
	}
	
	public static int GetSum()
	{
		return sum;
	}
	
}

//-----------------------------方法二---------------------------------
