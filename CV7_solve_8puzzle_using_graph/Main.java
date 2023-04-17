package eight_puzzle_solution;

import java.util.Random;



public class Main {

	public static void main(String[] args) {
		HraciPole h = new HraciPole();
		int pocitadlo = 0; 
		for (int i = 0; i < 100000; i++) {//Random.nextInt(4) vrací čísla z rozsahu 0-3, ale máme 4 pohyby, proto se přičítá ta 1		
			if(h.pohni(new Random().nextInt(4)+ 1)) { //Tady testujeme, jestli metoda "pohni" třídy "HracíPole" vrací "true" tedy tah byl úspěšný, nebo "false" tah nebyl úspěšný
				pocitadlo++;
			}
			
		}
		
		System.out.println(h);
		BFS bfs = new BFS();
		bfs.vypisTahy(h);
		System.out.println("Počet úspěšných tahů: " + pocitadlo);
		
	}

}
