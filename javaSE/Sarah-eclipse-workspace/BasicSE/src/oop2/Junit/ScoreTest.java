package oop2.Junit;

import java.util.*;

/*
  利用Vector代替数组处理：从键盘读入学生成绩（以负数代表输入结束），找出最高分，并输出所有学生成绩等级。
	提示：数组一旦创建，长度就固定不变，所以在创建数组前就需要知道它的长度。
	而向量类java.util.Vector可以根据需要动态伸缩。
	
	创建Vector对象：Vector v=new Vector();
	给向量添加元素：v.addElement(Object obj);   
	取出向量中的元素：Object obj=v.elementAt(0);
	注意第一个元素的下标是0，返回值是Object类型的。
	计算向量的长度：v.size();
	若与最高分相差10分内：A等；20分内：B等；30分内：C等；其它：D等 
 */

public class ScoreTest {

	public static void main(String[] args) {
		
		Vector v = new Vector();
		Scanner scan = new Scanner(System.in);
		int max = 0;
		
		for(;;) {
			System.out.println("请输入成绩：");
			int a = scan.nextInt();
			if(a < 0) {
				break;
			}
			//自动装箱
			v.addElement(a);
			if(max < a) {
				max = a;
			}
		}
		
		for(int i = 0;i < v.size();i++) {
			Object score = v.elementAt(i);
			Integer intScore = (Integer)score;
			if(max - intScore <= 10) {
				System.out.format("第%d个学生成绩为：%d，等级为：%s\n", i, intScore.intValue(), "A");
			}else if(max -intScore <= 20){
				System.out.format("第%d个学生成绩为：%d，等级为：%s\n", i, intScore.intValue(), "B");
			}else if(max -intScore <= 30) {
				System.out.format("第%d个学生成绩为：%d，等级为：%s\n", i, intScore.intValue(), "C");
			}else {
				System.out.format("第%d个学生成绩为：%d，等级为：%s\n", i, intScore.intValue(), "D");
			}
		}
	
	}

}
