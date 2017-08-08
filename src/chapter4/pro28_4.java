/*
 * @author: lxw
 * 2017年7月13日
 * problem：在8*8的国际象棋上摆放8个皇后，使其不能相互攻击，即任意两个皇后不能再同一行、同一列或者是
 *          同一对角线上。请问总共有多少种符合条件的摆法。*/
package chapter4;

public class pro28_4 {
	
	public static void main(String[] args)
	{
		
	}
	
	//bookMethod:很长
	/*
	 * 由于8个皇后的任意两个不能处在同一行，那么肯定是每一个皇后占据一行。于是我们一可以定义一个col[8]的数组，
	 * 数组中第i个数字表示位于第i行的皇后的列号。先把数组col的8个数字分别用0~7初始化，接下来对其数字进行全排列。
	 * 因为我们是用不同的数字初始化的数组，所以任意两个皇后坑顶不同列。我们只需拍段每一个排列对应的8个皇后是不是在同一对角线上，
	 * 也就是对于数组的两个下标i和j，是不是有i-i=col[i]-col[j]或者j-i=col[j]-col[i]
	 * */
	public int bookMethod()
	{
		return 0;
	}
}
