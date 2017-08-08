/*
 * problem：如何广度优先遍历一个有向图（也就是把树换成了图 ORZ！）
 *           测试图例见 pro23_2.png文件*/
package chapter4;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.Queue;

public class pro23_2 {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		pro23_2 d=new pro23_2();
		ArrayList<GNode> use=d.getGriph();
		d.myMethod(use);

	}
	
	//节点定义
	class GNode
	{
		int Value;
		ArrayList<GNode> Sons; //有向图不一定有几个孩子节点，所以可以用链表实现！！
		boolean FaXian;
		
		public GNode(int v, ArrayList<GNode> ss)
		{
			this.Value=v;
			this.FaXian=false;
			this.Sons=new ArrayList<GNode>();
			if(ss!=null)
			{
				for(int i=0;i<ss.size();i++)
					this.Sons.add(ss.get(i));
			}
		}
	}
	
	//产生一个有向图测试用例，图像表示为pro23_2.png
	public ArrayList<GNode> getGriph()
	{
		GNode node1=new GNode(1,null);
		GNode node2=new GNode(2,null);
		node1.Sons.add(node2);
		GNode node3=new GNode(3,null);
		GNode node4=new GNode(4,null);
		node1.Sons.add(node4);
		node3.Sons.add(node4);
		GNode node5=new GNode(5,null);
		node3.Sons.add(node5);
		GNode node6=new GNode(6,null);
		node2.Sons.add(node6);
		GNode node7=new GNode(7,null);
		node4.Sons.add(node7);
		node3.Sons.add(node7);
		node7.Sons.add(node6);
		node7.Sons.add(node5);
		
		//目的是若有0入度的节点，没遍历到，可以在这里随机选
		ArrayList<GNode> aa=new ArrayList<GNode>();
		aa.add(node1);aa.add(node2);aa.add(node3);aa.add(node4);
		aa.add(node5);aa.add(node6);aa.add(node7);
		return aa;
	}
	
	//有向图的广度优先搜索
	//思路：1.标记位,如果原来数据结构中没有则新建一个数据结构
            //如果队列为空，但是还没有遍历到图，则在未遍历的节点中随机选择一个，重新开始遍历
	public void myMethod(ArrayList<GNode> gList)
	{
		if(gList==null)
		{
			System.out.println("empty!");
			return;
		}
		
		int num=0;
		while(num<gList.size())
		{
			//选择第一个未被标记的节点
			int head=0;
			while(true)
			{
				if(gList.get(head).FaXian==false)
					break;
				head++;
			}
			GNode gg=gList.get(head);
			
			Queue<GNode> qu=new LinkedList<GNode>();
			gg.FaXian=true;
			qu.add(gg);
			num++;
			while(!qu.isEmpty())
			{
				GNode s=qu.poll();
				System.out.print(s.Value+", ");
				for(int i=0; i<s.Sons.size(); i++)
				{
					if(!s.Sons.get(i).FaXian)
					{
						s.Sons.get(i).FaXian=true;
						qu.add(s.Sons.get(i));
						num++;
					}
				}
			}
		}
	}

}
