/**
 * Class to test List.java
 * 
 * @author Nhan Ha
 * @author Gerardo R Padilla Jr
 */
public class ListTest {

	public static void main(String args[]) {
		List<Integer> L = new List<>();

		List<Integer> L69 = new List<>();
		System.out.println("Print empty List: " + L69);

		System.out.println("Adding 4 numbers to List 1");
		L.addFirst(69); // list is now 69;
		L.addLast(14); // list is now 69,14;
		L.addFirst(15); // list is now 15,69,14;
		L.addLast(55); // list is now 15,69,14,55;
		L.printNumberedList(); // now prints 15,69,14, 55 in that order, but numbered;

		List<Integer> L2 = new List<>(L); // L2 is now equal to L
		System.out.println("List 2 is now equal to List 1 ");
		System.out.println();
		System.out.println("Printing list 2");
		L2.printNumberedList(); // should print no numbers
		System.out.println("Deleting the 4 nodes on the list, starting with last 2 ");
		L2.removeLast(); // list is now 15,69,14;
		System.out.print(L2);
		L2.removeLast(); // list is now 15,69
		System.out.print(L2);
		L2.removeFirst(); // List is now 69
		System.out.println(L2);
		L2.removeFirst(); // List should be empty
		L2.printNumberedList(); // should print no numbers
		System.out.println("Is list 2 empty? " + L2.isEmpty());

		L.placeIterator();
		L.addIterator(100); // should ad to second spot; //list is now 15,100 69,14,55;
		L.printNumberedList();
		L.advanceIterator(); // iterator is now second node. aka 100
		L.advanceIterator(); // iterator is now third node aka 69
		L.addIterator(100); // add a 100 after the 69 /list is now 15,100, 69, 100,14,55;
		L.reverseIterator(); // iterator is now first 100
		L.printNumberedList();

		System.out.println(" Copying List 1 to List 3");
		List<Integer> L3 = new List<>(L);
		System.out.println("Is the copied list empty? " + L3.isEmpty());

		L.placeIterator();
		L.advanceIterator(); // iterator is now second node
		L.reverseIterator(); // iterator is now first node again
		System.out.println("List 1: " + L);
		System.out.println("List 3: " + L3);
		System.out.println("Are they equal? " + L.equals(L3)); // prints true because they are equal
		System.out.println();
		System.out.println("Here a node is removed from list 1");
		L.removeIterator(); // removes first from the list 1

		System.out.println("List 1: " + L);
		System.out.println("List 3: " + L3);
		System.out.println("Are they equal? " + L.equals(L3) + "\n"); // prints false, because node is not equals

		System.out.println("List 1: " + L);
		System.out.println("List 3: " + L3);
		System.out.println();
		System.out.println("List 1 First Value: " + L.getFirst()); // gets 100 from list
		System.out.println("List 3 First Value: " + L3.getFirst() + "\n"); // gets 15 from list

		System.out.println("List 1 Last Value: " + L.getLast()); // prints 55
		System.out.println("List 3 Last Value: " + L3.getLast()); // prints 55
		System.out.println();

		System.out.println("List 1 length: " + L.getLength()); //
		System.out.println("List 3 length: " + L3.getLength()); //
		System.out.println();

		System.out.println("Is iterator null in List 1? " + L.offEnd());
		L3.placeIterator(); // iterator equal to first node
		L.placeIterator(); // iterator equal to first node
		System.out.println("Iterators have been placed on Lists 1 and 3");
		System.out.println("Print iterator List 1: " + L3.getIterator()); // returns iterator (first node)
		System.out.println("Print iterator List 2: " + L.getIterator() + " \n"); // returns iterator (first node)

		System.out.println("Is iterator null in List 1? " + L.offEnd() + "\n");
		L.removeIterator(); // removed first node from list 1
		System.out.println("Iterator has been removed on List 1, as with the first node");
		System.out.println("Is iterator null in List 1? " + L.offEnd() + "\n");

	}

}
