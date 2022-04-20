package objecttestone;


//对象数组题目
//定义类Student,创建20个学生对象，打印三年级信息；冒泡排序成绩
public class Students {

	public static void main(String[] args) {
		defStu[] stu = new defStu[20]; 
		
		for(int i = 0;i < 20;i++) {
			stu[i] = new defStu();
			stu[i].number = i + 1;
			stu[i].state = (int)Math.round(Math.random() * 6 + 1);
			stu[i].score = (int)Math.round(Math.random() * 101);
		}
		
		Students test = new Students();
		
		test.print(stu);
		System.out.println("**********************************************");
		
		test.searchStu(stu, 3);
		System.out.println("**********************************************");
		
		test.sort(stu);
		test.print(stu);
		
	}
	
	public void print(defStu[] stu) {
		for(int i = 0;i < 20;i++) {
			System.out.println(stu[i].info());
		}
	}
	
	/**
	 * @Description 查找指定年级信息
	 * @author Sarah Cheung
	 * @param stu
	 */
	public void searchStu(defStu[] stu, int state) {
		for(int i = 0;i < 20;i++) {
			if(state == stu[i].state) {
				System.out.println(stu[i].info());
			}
		}
	}
	
	/**
	 * @Description 给数组冒泡排序
	 * @author Sarah Cheung
	 * @param stu
	 */
	public void sort(defStu[] stu) {
		defStu temp = new defStu();
		
		for(int i = 0;i < stu.length - 1;i++) {
			for(int j = 0;j < stu.length - 1 - i;j++) {
				if(stu[j].score > stu[j+ 1].score) {
					temp = stu[j];
					stu[j] = stu[j + 1];
					stu[j + 1] = temp;
				}
			}
		}
	}
	
}

class defStu{
	int number;
	int state;
	int score;
	
	public String info() {
			return "number: " + number + " ; state: " + state+ " ; score: " + score;
	}
	
}

