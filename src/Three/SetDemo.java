package Three;

import java.util.HashSet;
import java.util.Set;

public class SetDemo {
	public static void main(String[] args) {
		Set mySet = new HashSet();
		String fruit1 = "pear";
		String fruit2 = "banana";
		String fruit3 = "tangerine";
		String fruit4 = "strawberry";
		String fruit5 = "blackberry";
		mySet.add(fruit1);
		mySet.add(fruit2);
		mySet.add(fruit3);
		mySet.add(fruit4);
		mySet.add(fruit5);
		
		System.out.println("mySet contains: ");
		System.out.println(mySet);
		
		System.out.println("Cardinality: " +mySet.size());
		
		mySet.remove(fruit4);
		mySet.remove(fruit5);
		System.out.println("mySet now is ");
		System.out.println(mySet);
		mySet.removeAll(mySet);
		System.out.println("mySet now is ");
		System.out.println(mySet);
		
		System.out.println("Is the set now empty? " + mySet.isEmpty());
		
		
		
	}
}
