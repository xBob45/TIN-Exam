package doubly_list;

public class Node {
	

	//Parametrický konstruktor, který slouží k inicializaci proměnné "data"	
	public Node(int data) {
		super();
		this.data = data;
	}

	//Proměnné třídy tj. "class variables"
	private int data;
	private Node previous;
	private Node next;
	
	
	//Gettery & Settery
	public Node getPrevious() {
		return previous;
	}
	public void setPrevious(Node previous) {
		this.previous = previous;
	}
	public Node getNext() {
		return next;
	}
	public void setNext(Node next) {
		this.next = next;
	}
	public int getData() {
		return data;
	}
	public void setData(int data) {
		this.data = data;
	}
	
	
	

}
