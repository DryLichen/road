package io.stream;

import java.io.BufferedInputStream;
import java.io.BufferedOutputStream;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;

import org.junit.jupiter.api.Test;

public class BufferExer1 {

	// 分别使用节点流和缓冲流复制文件，比较效率
	@Test
	void test1() {
		long start = System.currentTimeMillis();
		copyFast("南三环东路.wav", "南三环备份.wav");//1232 vs 418
		long end = System.currentTimeMillis();
		System.out.println("花费时间为：" + (end - start));
	}

	public void copySlow(String src, String dst) {
		FileInputStream fis = null;
		FileOutputStream fos = null;

		try {
			File f1 = new File(src);
			File f2 = new File(dst);

			fis = new FileInputStream(f1);
		    fos = new FileOutputStream(f2);

			byte[] buffer = new byte[1024];
			int len = 0;
			while ((len = fis.read(buffer)) != -1) {
				fos.write(buffer, 0, len);
			}
		} catch (IOException e) {
			e.printStackTrace();
		} finally {
			if(fis != null) {
				try {
					fis.close();
				} catch (IOException e) {
					e.printStackTrace();
				}
			}
			
			if(fos != null) {
				try {
					fos.close();
				} catch (IOException e) {
					e.printStackTrace();
				}
			}
		}
	}

	public void copyFast(String src, String dst) {
		BufferedInputStream bis = null;
		BufferedOutputStream bos = null;
		
		try {
			File f1 = new File(src);
			File f2 = new File(dst);

			FileInputStream fis = new FileInputStream(f1);
			FileOutputStream fos = new FileOutputStream(f2);
			bis = new BufferedInputStream(fis);
			bos = new BufferedOutputStream(fos);

			byte[] buffer = new byte[1024];
			int len = 0;
			while((len = bis.read(buffer)) != -1) {
				bos.write(buffer, 0, len);
			}
		} catch (IOException e) {
			e.printStackTrace();
		} finally {
			if(bis != null) {
				try {
					bis.close();
				} catch (IOException e) {
					e.printStackTrace();
				}
			}
			
			if( bos != null) {
				try {
					bos.close();
				} catch (IOException e) {
					e.printStackTrace();
				}
			}
		}
	}
}
