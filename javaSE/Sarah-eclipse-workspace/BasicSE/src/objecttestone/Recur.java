package objecttestone;
//递归的实现

public class Recur {

	public static void main(String[] args) {
		Recur re = new Recur();
		System.out.println(re.fibonacci(10));
	}
	
	//求和
	public int getSum(int n) {
		if(n == 1) {
			return 1;
		}else {
			return n + getSum(n - 1);
		}
	}

	//已知有一个数列：f(0) = 1,f(1) = 4,f(n+2) = 2*f(n+1) + f(n),n >= 1,求f(10)
	public int getNum(int n) {
		if(n == 0) {
			return 1;
		}else if(n == 1) {
			return 4;
		}else {
			return 2 * getNum(n-1) + getNum(n-2);
		}
	}
	
	//斐波拉契数列
	public int fibonacci(int n) {
		if(n == 1) {
			return 1;
		}else if(n == 2) {
			return 1;
		}else {
			return fibonacci(n-1) + fibonacci(n-2);
		}
	}
	
	//汉诺塔问题
	
	//快排
	
	
}
