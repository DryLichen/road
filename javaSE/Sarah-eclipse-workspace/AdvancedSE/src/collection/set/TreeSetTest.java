package collection.set;

import java.util.Iterator;
import java.util.TreeSet;

public class TreeSetTest {

	public static void main(String[] args) {
		Employee emp1 =  new Employee("Jack", 21, new MyDate(2000, 12, 21));
		Employee emp2 =  new Employee("Mary", 50, new MyDate(1971, 7, 23));
		Employee emp3 =  new Employee("Rose", 21, new MyDate(1997, 5, 21));
		Employee emp4 =  new Employee("Teayeon", 30, new MyDate(1991, 3, 22));
		Employee emp5 =  new Employee("Billie", 20, new MyDate(2001, 1, 11));
		
		TreeSet<Employee> treeSet = new TreeSet();
		treeSet.add(emp1);
		treeSet.add(emp2);
		treeSet.add(emp3);
		treeSet.add(emp4);
		treeSet.add(emp5);
		
		Iterator<Employee> it = treeSet.iterator(); 
		while(it.hasNext()) {
			System.out.println(it.next());
		}
	}
}
