package reflect;

import java.io.FileInputStream;
import java.io.IOException;
import java.io.InputStream;
import java.util.Properties;

import org.junit.jupiter.api.Test;

public class ClassLoaderTest {
	
	@Test
	void test1() throws Exception {
		FileInputStream fis = new FileInputStream("src\\test.properties");
		Properties p1 = new Properties();
		p1.load(fis);
		
		String name = p1.getProperty("user");
		String time = p1.getProperty("year");
		System.out.println("name: " + name + " ;time: " + time);
	}
	
	@Test
	void test2() throws IOException {
		ClassLoader classloader = ClassLoaderTest.class.getClassLoader();
		InputStream is = classloader.getResourceAsStream("test.properties");
		
		Properties p = new Properties();
		p.load(is);
		
		String name = p.getProperty("user");
		String time = p.getProperty("year");
		System.out.println("name: " + name + " ;time: " + time);
	}
}
