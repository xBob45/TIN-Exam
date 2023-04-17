package cv10_1;

public class Prvek {
	private String data;
	private Prvek next;

	public Prvek(String data) {
		super();
		this.data = data;
	}
	
	
	public Prvek getNext() {
		return next;
	}

	public void setNext(Prvek next) {
		this.next = next;
	}

	
	public String getData() {
		return data;
	}

	public void setData(String data) {
		this.data = data;
	}

	
	
	
	
}
