package io.stream2;

import java.io.*;
import java.util.ArrayList;

import org.junit.jupiter.api.Test;

public class SerializeTest {
	
	@Test
	void test1() {
		serialization();
		deserialization();
	}
	
	public void serialization() {
		ObjectOutputStream oos = null;

		try {
			FileOutputStream fos = new FileOutputStream("serial.ser");
			oos = new ObjectOutputStream(fos);
			
			Person p1 = new Person("Sarah", "China", 22, 281933);
			Person p2 = new Person("Taka", "Japan", 18, 6283);
			Person p3 = new Person("Billie", "USA", 20, 47928);
			ArrayList<Person> arr = new ArrayList<Person>();
			arr.add(p1);
			arr.add(p2);
			arr.add(p3);
			
			oos.writeObject(arr);
			oos.writeObject(new String("搞不懂啊"));
		} catch (FileNotFoundException e) {
			e.printStackTrace();
		} catch (IOException e) {
			e.printStackTrace();
		} finally {
			if(oos != null) {
				try {
					oos.close();
				} catch (IOException e) {
					e.printStackTrace();
				}
			}
		}
	}
	
	public void deserialization() {
		ObjectInputStream ois = null;
		
		try {
			FileInputStream fis = new FileInputStream("serial.ser");
			ois = new ObjectInputStream(fis);
			
			ArrayList<Person> arr = (ArrayList<Person>)ois.readObject();
			for(Person obj : arr) {
				System.out.println(obj);
				System.out.println(Person.gender);
			}
			
		} catch (FileNotFoundException e) {
			e.printStackTrace();
		} catch (ClassNotFoundException e) {
			e.printStackTrace();
		} catch (IOException e) {
			e.printStackTrace();
		} finally {
			if(ois != null) {
				try {
					ois.close();
				} catch (IOException e) {
					e.printStackTrace();
				}
			}
		}
	}
}
