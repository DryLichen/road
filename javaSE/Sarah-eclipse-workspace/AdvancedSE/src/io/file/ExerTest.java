package io.file;

import java.io.File;
import java.io.IOException;

import org.junit.jupiter.api.Test;

public class ExerTest {
	
	//课后练习三
	@Test
	void test1() throws IOException{
		FileExer2 f = new FileExer2();
		f.creation();
		System.out.println(f.fileSize("D:\\java\\code\\javaSE"));
	}
	
	//创造一个和2.txt文件同目录下的另一个文件b.txt
	@Test
	void test2() {
		File f1 = new File("D:\\java\\code\\javaSE\\IO\\2.txt");
		File f2 = new File(f1.getParent(), "b.txt");
		
		try {
			f2.createNewFile();
		} catch (IOException e) {
			e.printStackTrace();
		}
	}
}
