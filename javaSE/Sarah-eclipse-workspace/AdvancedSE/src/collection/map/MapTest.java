package collection.map;

import java.util.ArrayList;
import java.util.Collection;
import java.util.HashMap;
import java.util.Iterator;
import java.util.Map;
import java.util.Set;

import org.junit.jupiter.api.Test;

public class MapTest {
	
	//测试使用泛型遍历map
	@Test
	void test1() {
		HashMap<String, Integer> map1 = new HashMap<String, Integer>();
		map1.put("Jana", 23222);
		map1.put("FSalf", 427);
		map1.put("aJF", 49779);
		map1.put("akfh", 9976);
		map1.put("Jfas", 678);
		
		for(String st : map1.keySet()) {
			System.out.println("key: " + st);
		}
		System.out.println("********************************************");
		
		for(Integer i : map1.values()) {
			System.out.println("value: " + i);
		}
		System.out.println("********************************************");
		
		Set<Map.Entry<String, Integer>> entrySet1 = map1.entrySet();
		Iterator<Map.Entry<String, Integer>> it = entrySet1.iterator();
		while(it.hasNext()) {
			System.out.println("Entry: " + it.next());
		}
	}
	
	//遍历获取HashMap<String, String>中所有value，并放在List中返回
	@Test
	void test2(){
		HashMap<String, String> hashMap = new HashMap<String, String>();
		hashMap.put("Jana", "一");
		hashMap.put("FSalf", "二");
		hashMap.put("aJF", "三");
		hashMap.put("akfh", "四");
		hashMap.put("Jfas", "五");
		
		/*
		 * 错误写法：返回就是父类对象，无法强转为子类，只有用父类接收new的子类后，才可以强转
		 * Collection(String) cl = hashMap.values;
		 * ArrayList(String) arr = (ArrayList)cl;
		 */
		
		Collection<String> cl = hashMap.values();
		ArrayList<String> arr = new ArrayList<String>(cl.size());
		for(Object obj : cl) {
			arr.add((String)obj);
		}
		System.out.println("List: " + arr);
	}
	
	
}
