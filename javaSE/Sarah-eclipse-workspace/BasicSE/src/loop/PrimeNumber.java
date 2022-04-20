package loop;

public class PrimeNumber {

	public static void main(String[] args) {
		
		System.out.println("prime number: " + 2);
		boolean isFlag = true;
		int count = 0;
		
		//获取当前时间距离1970-01-01 00：00：00的毫秒数
		long start = System.currentTimeMillis();
		
		for(int i = 2; i <= 100000; i++) {
			
			for(int j = 2; j <= Math.sqrt(i); j++) {
				if(i % j == 0) {
					isFlag = false;
					break;
				}
			}
			
			if(isFlag) {
				System.out.println("prime number: " + i);
				count++;
			}
			isFlag = true;
			
		}
		
		long end = System.currentTimeMillis();
		System.out.println("花费时间为：" + (end - start));
		System.out.println("质数总数为：" + count);
	}

}

/*优化
加break
开平方
*/