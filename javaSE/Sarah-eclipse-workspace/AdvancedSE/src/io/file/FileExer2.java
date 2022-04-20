package io.file;

import java.io.*;
import java.util.Scanner;

public class FileExer2 {
	boolean flag;
	String fileName;
	long size;

	public static void main(String[] args) {
		FileExer2 fileExer2 = new FileExer2();
		
		try {
			fileExer2.creation();
		} catch (IOException e) {
			e.printStackTrace();
		}

		Scanner scan = new Scanner(System.in);
		System.out.println("Please input name: ");
		String str = scan.nextLine();

		System.out.println(fileExer2.search(str));

		scan.close();
	}

	// 建立测试文件夹
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

	// 查找是否有jpg文件
	public String search(String dir) {
		File file = new File(dir);

		if (file.isFile()) {
			String str = file.getAbsolutePath();
			if (str.endsWith(".jpg")) {
				flag = true;
				fileName = file.getName();
			}
		}

		else if (file.isDirectory()) {
			File[] f1 = file.listFiles();
			for (int i = 0; i < f1.length; i++) {
				search(f1[i].getAbsolutePath());
			}
		}

		else {
			throw new RuntimeException("错误的类型");
		}

		if (flag) {
			return "存在jpg文件，名字为：" + fileName;
		}
		return "不存在jpg文件。";
	}

	// 计算文件大小
	public long fileSize(String str) {
		File file = new File(str);

		if (file.isFile()) {
			size += file.length();
		}

		else if (file.isDirectory()) {
			File[] f1 = file.listFiles();
			for (int i = 0; i < f1.length; i++) {
				fileSize(f1[i].getAbsolutePath());
			}
		}

		else {
			throw new RuntimeException("错误的类型");
		}

		return size;
	}
}
