package ifelse;
import java.util.Scanner;

public class DogAge {
	public static void main(String[] args) {
		Scanner scan = new Scanner(System.in);
		System.out.println("请输入狗的年龄： ");
		int age = scan.nextInt();
		double humanAge = 0;
	
		if(age <= 2 && age >= 0) {
			humanAge = 10.5 * age;
		}
		else if(age > 2){
			humanAge = (age - 2) * 4 + 21;
		}
		else {
			System.out.println("错误的年龄！");
		}
		System.out.println("等价人类年龄为：" + humanAge);
	}
}
