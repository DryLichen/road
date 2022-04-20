package io.stream;

import java.io.BufferedInputStream;
import java.io.BufferedOutputStream;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.FileReader;
import java.io.IOException;
import java.util.HashMap;

import org.junit.jupiter.api.Test;

public class BufferExer2 {

	@Test
	void test1() {
		encryption("盈利预测.jpg", "加密图片.jpg");
		decryption("加密图片.jpg", "解密图片.jpg");
	}
	
	@Test
	void test2() {
		count("test.txt");
	}

	// 实现图片加密操作
	public void encryption(String src, String dst) {
		BufferedInputStream bis = null;
		BufferedOutputStream bos = null;

		try {
			File fs = new File(src);
			File fd = new File(dst);

			FileInputStream fis = new FileInputStream(fs);
			FileOutputStream fos = new FileOutputStream(fd);
			bis = new BufferedInputStream(fis);
			bos = new BufferedOutputStream(fos);

			int a = 0;
			while ((a = bis.read()) != -1) {
				bos.write(a ^ 5);
			}
		} catch (IOException e) {
			e.printStackTrace();
		} finally {
			if (bis != null) {
				try {
					bis.close();
				} catch (IOException e) {
					e.printStackTrace();
				}
			}

			if (bos != null) {
				try {
					bos.close();
				} catch (IOException e) {
					e.printStackTrace();
				}
			}
		}
	}

	public void decryption(String src, String dst) {
		BufferedInputStream bis = null;
		BufferedOutputStream bos = null;

		try {
			File fs = new File(src);
			File fd = new File(dst);

			FileInputStream fis = new FileInputStream(fs);
			FileOutputStream fos = new FileOutputStream(fd);
			bis = new BufferedInputStream(fis);
			bos = new BufferedOutputStream(fos);

			int a = 0;
			while ((a = bis.read()) != -1) {
				bos.write(a ^ 5);
			}
		} catch (IOException e) {
			e.printStackTrace();
		} finally {
			if (bis != null) {
				try {
					bis.close();
				} catch (IOException e) {
					e.printStackTrace();
				}
			}

			if (bos != null) {
				try {
					bos.close();
				} catch (IOException e) {
					e.printStackTrace();
				}
			}
		}
	}

	// 获取文本上每个字符出现的次数
	public void count(String str) {
		FileReader fr = null;

		try {
			fr = new FileReader(str);
			HashMap<Character, Integer> hashMap = new HashMap<>();

			char[] c = new char[64];
			int len = 0;
			int v = 0;
			while ((len = fr.read(c)) != -1) {
				for (int i = 0; i < len; i++) {
					if (hashMap.containsKey(c[i])) {
						v = hashMap.get(c[i]) + 1;
						hashMap.replace(c[i], v);
					} else {
						hashMap.put(c[i], 1);
					}
				}
			}

			System.out.println(hashMap);
		} catch (FileNotFoundException e) {
			e.printStackTrace();
		} catch (IOException e) {
			e.printStackTrace();
		} finally {
			if (fr != null) {
				try {
					fr.close();
				} catch (IOException e) {
					e.printStackTrace();
				}
			}
		}
	}
}
