package io.file;

import java.io.File;
import java.io.IOException;
import java.util.Scanner;

public class FileExer1 {
	public static void main(String[] args) {
		FileExer1 fileExer1 = new FileExer1();
		
		try {
			fileExer1.creation();
		} catch (IOException e) {
			e.printStackTrace();
		}

		Scanner scan = new Scanner(System.in);
		System.out.println("Please input file name: ");
		String str = scan.nextLine();

		try {
			Boolean b = fileExer1.deleteFile(str);
			if (b) {
				System.out.println("Successfully delete");
			} else {
				System.out.println("Unsuccessfully delete");
			}

		} catch (Exception e) {
			e.printStackTrace();
		}

		scan.close();
	}

	//建立测试文件夹
	public void creation() throws IOException {
		File f1 = new File("D:\\java\\code\\javaSE\\IO\\file1");
		f1.mkdirs();

		File f2 = new File("D:\\java\\code\\javaSE\\IO\\file1\\1.txt");
		f2.createNewFile();

		File f3 = new File("D:\\java\\code\\javaSE\\IO\\2.txt");
		f3.createNewFile();

		File f4 = new File("D:\\java\\code\\javaSE\\IO\\3.jpg");
		f4.createNewFile();
	}

	//删除指定文件
	public boolean deleteFile(String name) {
		File file = new File(name);
		
		if (file.exists()) {
			if (file.isFile()) {
				System.out.println("Deleting... " + file.getAbsolutePath());
				file.delete();
				return true;
			}
			if (file.isDirectory()) {
				File[] f1 = file.listFiles();
				for (int i = 0; i < f1.length; i++) {
					deleteFile(f1[i].getAbsolutePath());
				}
				System.out.println("Deleting... " + file.getAbsolutePath());
				file.delete();
				return true;
			}
		}
		
		return false;
	}
}
