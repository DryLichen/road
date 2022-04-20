package io.stream;

import java.io.BufferedReader;
import java.io.DataInputStream;
import java.io.DataOutputStream;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.PrintStream;

import org.junit.jupiter.api.Test;

public class OtherStreamTest {
	
	@Test
	void testData() throws IOException {
		DataOutputStream dos = new DataOutputStream(new FileOutputStream("data.txt"));
		
		dos.writeUTF("发空间地方");
		dos.flush();
		dos.writeBoolean(true);
		dos.flush();
		dos.writeInt(2493);
		dos.flush();
		
		dos.close();
		
		DataInputStream dis = new DataInputStream(new FileInputStream("data.txt"));
		
		System.out.println("String: " + dis.readUTF());
		System.out.println("Boolean: " + dis.readBoolean());
		System.out.println("Int: " + dis.readInt());
		
		dis.close();
	}
	
	@Test
	void testPrint() {
		PrintStream ps = null;
		
		try {
			FileOutputStream fos = new FileOutputStream("print.txt");
			ps = new PrintStream(fos, true);
			System.setOut(ps);
			for(int i = 0; i < 128;i++) {
				System.out.println((char)i);
			}
		} catch (FileNotFoundException e) {
			e.printStackTrace();
		} finally {
			if(ps != null) {
				ps.close();
			}
		}
	}
	
	@Test
	void testMyInput() {
		System.out.println("请输入：");
		int a = MyInput.IntIn();
		System.out.println(a);
	}
	
	@Test
	void testUpperCase() {
		BufferKey();
	}
	
	//使用标准流实现从键盘输入文字转化为大写
	public void BufferKey() {
		BufferedReader br = null;
		
		try {
			InputStreamReader isr = new InputStreamReader(System.in);
			br = new BufferedReader(isr);
			
			while(true) {
				System.out.println("Please input:");
				String data = br.readLine();
				if("e".equalsIgnoreCase(data) || "exit".equalsIgnoreCase(data)) {
					System.out.println("end");
					break;
				}
				
				System.out.println(data.toUpperCase());
			}
		} catch (IOException e) {
			e.printStackTrace();
		} finally {
			if(br != null) {
				try {
					br.close();
				} catch (IOException e) {
					e.printStackTrace();
				}
			}
		}
	}
}
