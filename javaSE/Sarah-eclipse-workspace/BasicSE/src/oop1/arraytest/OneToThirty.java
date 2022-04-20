package oop1.arraytest;

//数组的赋值
//创建一个长度为6的int型数组,1-30随机赋不同值；
/*public class OneToThirty {

	public static void main(String[] args) {
		
		int[] arr = new int[6];
		int value = 0;
		boolean isFlag = false;
		
		for(int i = 0; i < arr.length; i++) {
			
			while(true) {
				value = (int) (Math.random() * 30 + 1);
				for(int j = 0; j < i; j++) {
					if(value == arr[j] ) {
						isFlag = true;
						break;
					}
				}
				if(isFlag == false) {
					break;
				}		
			}
			
			arr[i] = value;
			System.out.println( "第" + (i + 1) + "个数为：" + arr[i]);
		}

	}

}
*/


//advanced
public class OneToThirty {

	public static void main(String[] args) {
		
		int[] arr = new int[6];
		int value = 0;
		
		for(int i = 0; i < arr.length; i++) {
			value = (int) (Math.random() * 30 + 1);
			arr[i] = value;
			
			for(int j = 0; j < i; j++) {
				if(value == arr[j]) {
					i--;
					break;
				}
			}
		}
		
		for(int i = 0; i < arr.length; i++) {
			System.out.println( "第" + (i + 1) + "个数为：" + arr[i]);
		}
			
	}

}
