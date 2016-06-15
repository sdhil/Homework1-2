package four;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import java.util.ListIterator;

public class ListDemo {
	public static void main(String[] args) {
		List myList = new ArrayList();
		String fruit1 = "pear";
		String fruit2 = "banana";
		String fruit3 = "tangerine";
		String fruit4 = "strawberry";
		String fruit5 = "blackberry";
		myList.add(fruit1);
		myList.add(fruit2);
		myList.add(fruit3);
		myList.add(fruit4);
		myList.add(fruit5);
		System.out.println("Original list: ");
		System.out.println(myList);
		
		Iterator it = myList.iterator();
		System.out.println("Using Iterator: ");
		while(it.hasNext()) {
			System.out.println(it.next());
		}
		
		ListIterator li = myList.listIterator(myList.size());
		System.out.println("Traversing the list in reverse order");
		while(li.hasPrevious()) {
			System.out.println(li.previous());
		}
		
		System.out.println("Adding another banana");
		
		myList.add(myList.indexOf(fruit3) +1, "banana");
		System.out.println("Now the list is ");
		System.out.println(myList);
		
	}
}
