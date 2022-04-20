package collection.set;

import java.util.Comparator;
import java.util.Iterator;
import java.util.TreeSet;

public class TreeSetTest2 {

	public static void main(String[] args) {
		Comparator<Employee> comp = new Comparator<Employee>() {
			public int compare(Employee em1, Employee em2) {
				int gapYear = em1.getBirthday().getYear() - em2.getBirthday().getYear();
				if (gapYear != 0) {
					return gapYear;
				}

				int gapMonth = em1.getBirthday().getMonth() - em2.getBirthday().getMonth();
				if (gapMonth != 0) {
					return gapMonth;
				}

				int gapDay = em1.getBirthday().getDay() - em2.getBirthday().getDay();
				return gapDay;
			}
		};
		
		TreeSet<Employee> treeSet = new TreeSet<Employee>(comp);

		Employee emp1 = new Employee("Jack", 21, new MyDate(2000, 12, 21));
		Employee emp2 = new Employee("Mary", 50, new MyDate(1971, 7, 23));
		Employee emp3 = new Employee("Rose", 21, new MyDate(1971, 5, 21));
		Employee emp4 = new Employee("Teayeon", 30, new MyDate(1991, 3, 22));
		Employee emp5 = new Employee("Billie", 20, new MyDate(2001, 1, 11));

		treeSet.add(emp1);
		treeSet.add(emp2);
		treeSet.add(emp3);
		treeSet.add(emp4);
		treeSet.add(emp5);

		Iterator<Employee> it = treeSet.iterator();
		while (it.hasNext()) {
			System.out.println(it.next());
		}
	}

}
