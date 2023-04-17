package doubly_list;



public class Main {

	public static void main(String[] args) {
		
		DoublyLinkedList list = new DoublyLinkedList();
		
		
//		list.addFirst(1);
//		list.addFirst(2);
//		list.addFirst(3);
//		list.addFirst(4);
//		list.addFirst(5);
	
		list.addLast(1);
		list.addLast(2);
		list.addLast(3);
		list.addLast(4);
		list.addLast(5);
		
		list.printList();
		list.printList_Reverse();
		
		
		list.removeFirst();
		list.printList();
		
		list.removeFirst();
		list.printList();
		
		list.removeFirst();
		list.printList();
		
		
		System.out.println(list.contains(1));
		System.out.println(list.contains(5));

	}

}
