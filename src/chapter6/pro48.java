/*
 * @author: lxw
 * 2017年8月10日
 * problem： 不能被继承的类
 * describe：设计一个不能被继承的类。
*/
package chapter6;

public class pro48 {

	public static void main(String[] args) {
		// TODO Auto-generated method stub

	}
	

}

/*
 * 这个题应该不会在JAVA中问，问了也比较尴尬！因为JAVA有final啊！
 * final修饰的类就是不可继承的*/
final class father{
	int val;
	int val2;
}

/* 下面如果这样写就会报错！
class son extends father{ 
	
}
*/
