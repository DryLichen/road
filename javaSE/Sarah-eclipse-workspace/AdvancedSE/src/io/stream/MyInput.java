package io.stream;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

//模拟Scanner的MyInput类
public class MyInput {
	public static String StringIn() {
		BufferedReader br = null;
		String str = null;
		
		try {
			br = new BufferedReader(new InputStreamReader(System.in));
			str = br.readLine();
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
		
		return str;
	}
	
	public static short ShortIn() {
		return Short.parseShort(StringIn());
	}
	
	public static long LongIn() {
		return Long.parseLong(StringIn());
	}
	
	public static int IntIn() {
		return Integer.parseInt(StringIn());
	}
	
	public static float FloatIn() {
		return Float.parseFloat(StringIn());
	}
	
	public static double DoubleIn() {
		return Double.parseDouble(StringIn());
	}
	
	public static boolean BooleanIn() {
		return Boolean.parseBoolean(StringIn());
	}
	
	public static char CharIn() {
		return StringIn().charAt(0);
	}
	
	public static byte ByteIn() {
		return Byte.parseByte(StringIn());
	}
}
