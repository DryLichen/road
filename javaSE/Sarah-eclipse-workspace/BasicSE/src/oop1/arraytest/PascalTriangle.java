package oop1.arraytest;

//使用二维数组打印一个十行的杨辉三角；
public class PascalTriangle {

	public static void main(String[] args) {
		
		int[][] pascal = new int[10][];
		
		for(int i = 0; i < 10; i++) {
			pascal[i] = new int[i + 1];
			for(int j = 0; j <= i; j++) {
				if(j == 0 || j == i) {
					pascal[i][j] = 1;
				}
				else{
					pascal[i][j] = pascal[i - 1][j - 1] + pascal[i - 1][j];
				}
				System.out.print(pascal[i][j] + "\t");
			}
			
			System.out.println();
		}

	}

}
