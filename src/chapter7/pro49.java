/*
 * @author: lxw
 * 2017年8月10日
 * 
 * problem：实现atoi函数*/
package chapter7;
import java.util.Stack;

public class pro49 {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		String str1="-12345";
		String str2="+12345";
		String str3="12345";
		
		pro49 d=new pro49();
		System.out.println(d.myAtoI_simple(str1));
		System.out.println(d.myAtoI_simple(str2));
		System.out.println(d.myAtoI_simple(str3));
		
		String str4="(1+3*5+2)*2-5/2+5";
		System.out.println(d.myAtoI_ver2(str4));
	}
	
	//time:10min
	/*
	 * 存在的问题是没有考虑到输入中含有加减乘除括号的情况
	 * 其实书上就是这种，只不过，在防止异常的时候有一个全局标志位*/
	public int myAtoI_simple(String str)
	{
		if(str==null)
			return 0;
		
		char[] ss=str.toCharArray();
		boolean neg=false;
		int dex=0;
		
		//判断正负号的首位
		if(ss[0]=='+')
			dex++;
		else{
			if(ss[0]=='-')
			{
				neg=true;
				dex++;
			}
		}
		
		//得出结果
		int result=0;
		for(;dex<ss.length;dex++)
		{
			if(ss[dex]<'0' || ss[dex]>'9')
			{
				System.out.println("the wrong input");
				return 0;
			}
			
			result=result+(ss[dex]-'0')*(int)Math.pow(10, ss.length-dex-1);
		}
		
		if(neg==true)
			return -result;
		else
			return result;		
	}
	
	/*
	 * time:54-
	 * 考虑到输入中有加减乘除、括号的情况，其实类似与认识加法如：
	 * 这个时候一般就不是字符串到整数的转化了，更多情况下可能是double型，因为有伴随到乘除的转化，所以一般不属于atio函数内容
	 * 但写程序实现这样一个四则运算未必不是一个好的过程，数据结构上也学过
	 * 所以实现一番！用双栈实现
	 * (1+3*5+2)*2-5/2+5=38.5*/
	public double myAtoI_ver2(String str) 
	{
		if(str==null)
			return 0;
		
		int head=0;
		char[] ss=str.toCharArray();
		boolean neg=false;
		
		//判断正负
		if(ss[0]=='-')
		{
			neg=true;
			head++;
		}else{
			if(ss[0]=='+')
				head++;
		}
		
		//用栈来分别存储信息数字和符号位
		double result=0.0;		
		double temp=0;
		Stack<Double> num=new Stack<Double>();
		Stack<Character> opter=new Stack<Character>();
		if(ss[head]=='(')
			opter.add(ss[head++]);
		int tail=head;
		
		for(int i=head; tail<ss.length;)
		{
			if(ss[tail]>='0' && ss[tail]<='9')
			{
				for(;tail<ss.length && ss[tail]>='0' && ss[tail]<='9'; tail++);
				temp=this.getNum(ss, head, tail);
				//System.out.println("temp="+temp);
				num.push(temp);
			}
			
			if(tail>=ss.length)
				break;
			else
			{
				if(!this.ellnum(ss[tail]))
				{
					System.out.println("wrong input");
					return 0;
				}else
				{
					//对比符号栈中的元素
					if(ss[tail]==')')
					{
						if(opter.size()==1)
							return -1;//说明错误
						
						char op=opter.pop();
						while(op!='(')
						{
							double a=num.pop();
							double b=num.pop();
							double r=this.calculate(a, b, op);
							//System.out.println("num push 1: "+a+" "+op+" "+b+" = "+r);
							num.push(r);
							//num.push(this.calculate(num.pop(), num.pop(), op));
							op=opter.pop();
						}
						tail++;
					}else{
						//System.out.println("tail="+tail+", ss[tail]="+ss[tail]+", opter="+opter.lastElement());
						if(opter.size()==0 || this.bigger(ss[tail], opter.lastElement()))
						{
							opter.add(ss[tail++]);
						}else{
							double a=num.pop();
							double b=num.pop();
							char op=opter.pop();
							double r=this.calculate(a, b, op);
							//System.out.println("num push 2: "+a+" "+op+" "+b+" = "+r);
							num.push(r);
							//num.push(this.calculate(num.pop(), num.pop(), opter.pop()));
							opter.add(ss[tail++]);
						}
					}
				}
			}
			head=tail;
		}
		
//		System.out.println("opter.size="+opter.size());
//		System.out.println("num's size="+num.size());
//		
//		while(!num.isEmpty())
//			System.out.print(num.pop()+",  ");
//		System.out.println();
//		
//		while(!opter.isEmpty())
//			System.out.print(opter.pop()+",  ");
//		System.out.println();
		
//		while(!opter.isEmpty())
//		{
//			double n1=num.pop();
//			double n2=num.pop();
//			char opt=opter.pop();
//			double r=this.calculate(n2, n1, opt);
//			System.out.println("num push3: "+n2+" "+opt+" "+n1+" = "+r);
//			num.push(r);
//		}
		
		//说明在最后的时候要从前向后
		double[] tnum=new double[num.size()]; int dt=0;
		char[] top=new char[opter.size()]; int ot=0;
		while(!opter.isEmpty())
		{
			top[top.length-1-ot]=opter.pop();
			ot++;
		}
		while(!num.isEmpty())
		{
			tnum[tnum.length-1-dt]=num.pop();
			dt++;
		}
		result=tnum[0];
		dt=1;
		ot=0;
		while(dt<tnum.length)
		{
			//System.out.println("num push3: "+result+" "+top[ot]+" "+tnum[dt]);
			result=this.calculate(tnum[dt++], result, top[ot++]);
			
		}
			
		return result;
	}
	
	public double getNum(char[] arr, int head, int tail)
	{
		double result=0.0;
		for(int i=head; i<tail; i++)
			result+=(arr[i]-'0')*(int)Math.pow(10, tail-head-1);
		return result;
	}
	
	public boolean ellnum(char c)
	{
		if(c=='+' || c=='-' || c=='*' || c=='/' || c=='(' || c==')')
			return true;
		else
			return false;
	}
	
	//也就说返回为true的时候，不用做出栈操作；
	//不用做出栈操作，就是说将要入栈的符号大于原栈顶符号
	//也就说true的情况，代表big>small
	public boolean bigger(char big, char small)
	{
		if((big=='*' || big=='/') && (small=='+' || small=='-'))
			return true;
		if((big=='+' || big=='-' || big=='*' || big=='/') && small=='(')
			return true;
		return false;
	}
	
	public double calculate(double qian, double hou, char op)
	{
		if(op=='+')
			return qian+hou;
		if(op=='-')
			return hou-qian;
		if(op=='*')
			return qian*hou;
		if(op=='/')
			return hou/qian;
		return 0.0;
	}

}
