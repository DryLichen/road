package oop1.arraytest;

// 冒泡排序 
public class BubbleSort {

	public static void main(String[] args) {
		
		int[] arr = new int[] {-98,-34,-23,0,1,12,25,44,45,54,65};
		int temp = 0;
		
		for(int i = 0; i < arr.length - 1; i++) {
			
			for(int j = 0; j < arr.length - 1 - i; j++) {
				if(arr[j] < arr[j + 1]) {
					temp = arr[j];
					arr[j] = arr[j + 1];
					arr[j + 1] = temp; 
				}
			}
			
		}
		
		for(int i = 0; i < arr.length; i++) {
			System.out.print(arr[i] + "\t");
		}
		
	}

}
