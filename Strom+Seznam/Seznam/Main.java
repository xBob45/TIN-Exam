package cv10_1;

public class Main {
	public static void main(String[] args) {
		Seznam s = new Seznam();
		s.vloz("E");
		s.vloz("D");
		s.vloz("C");
		s.vloz("B");
		s.vloz("A");

		//s.odstranPredposledni(); 	// A
		
		
		System.out.println(s.najdiProstredni().getData());
		
		
		s.print();
		s.odstranPredposledni();
		System.out.println("");
		s.print();
		
		System.out.println("");
		
		s.vloz("G");
		s.print();
		System.out.println("");
		
	}

}
