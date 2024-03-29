package io.stream;

import java.io.BufferedReader;
import java.io.DataInputStream;
import java.io.DataOutputStream;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.InputStreamReader;

public class Test {
	public static void main(String args[]) throws IOException {

		DataInputStream in = new DataInputStream(new FileInputStream("test.txt"));
		DataOutputStream out = new DataOutputStream(new FileOutputStream("test1.txt"));
		BufferedReader d = new BufferedReader(new InputStreamReader(in));

		String count;
		while ((count = d.readLine()) != null) {
			String u = count.toUpperCase();
			System.out.println(u);
			out.writeBytes(u + ";\r\n");
		}
		d.close();
		out.close();
	}
}
