package ifelse;
import java.util.Scanner;

public class Lotto {

	public static void main(String[] args) {
		Scanner scan = new Scanner(System.in);
		System.out.println("请输入一个两位数：");
		int num = scan.nextInt();
		int lotto = (int)(Math.random() * 90 + 10);
		System.out.println("乐透号码为：" + lotto);
		int award = 0;
		
		//取出个位及十位数字
		int num1 = num % 10;
		int num10 = num / 10;
		int lotto1 = lotto % 10;
		int lotto10 = lotto / 10;
		
		//判断奖金
		if(num == lotto) {
			award = 10000;
		}
		else if(num1 == lotto10 && num10 == lotto1) {
			award = 3000;
		}
		else if((num1 == lotto1)^(num10 ==lotto10)) {
			award = 1000;
		}
		else if((num1 == lotto10)^(num10 == lotto1)) {
			award = 500;
		}
		else {
			System.out.println("未中奖");
		}
		
		System.out.println("奖金为：" + award);
	}

}
