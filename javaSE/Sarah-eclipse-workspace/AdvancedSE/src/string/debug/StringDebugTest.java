package string.debug;

import org.junit.jupiter.api.*;

class StringDebugTest {

	@Test
	void testMain() {
		String str = null;
		StringBuffer sb = new StringBuffer();
		sb.append(str);
		
		System.out.println(sb.length());
		
		System.out.println(sb);
		
		StringBuffer sb1 = new StringBuffer(str);
		System.out.println(sb1);
	}
	
	void test2() {
		String str = null;
		StringBuffer sb = new StringBuffer();
		sb.append(str);
		
		System.out.println(sb.length());
		
		System.out.println(sb);
		
		StringBuffer sb1 = new StringBuffer();
		System.out.println(sb1);
	}
	
}
