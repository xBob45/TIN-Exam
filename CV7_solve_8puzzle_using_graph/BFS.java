package eight_puzzle_solution;

import java.util.HashSet;
import java.util.LinkedList;

/*BFS je prohledávání do šířky pomocí fronty.
 * Na jedné straně přidávám (začátek) a na druhé odstraňuji (konec)*/

public class BFS { 
	public void vypisTahy(HraciPole zadani) {
		
		LinkedList<HraciPole> open = new LinkedList<HraciPole>();	
		
		HashSet<HraciPole> closed = new HashSet<HraciPole>();
		// TreeSet<HraciPole> closed = new TreeSet<HraciPole>();
		// LinkedList<HraciPole> closed = new LinkedList<HraciPole>();
		open.addLast(zadani);
		
		while (!open.isEmpty()) {
			//Případ, že fronta "open" není prázdná
			HraciPole tmp = open.removeFirst(); //Ostraňuji ze začátku
			closed.add(tmp); //Přidávám na konec
			if(tmp.jeReseni()) { /*A teď je otázka zda do "tmp" odstraněné z "open" 
				a přidané do "closed" je řešení*/
				
				//Jestli se jedná o řešení tak spončím a vypíšu řešení.
				System.out.println("Konec. Řešení nalezeno");
				System.out.println(tmp);
				return; //"return" pro skončení výpočtu"
			}else {
				/*Jestli se nejedná o řešení je nutné rozgenerovat všechny možnosti
				 * pře cyklus FOR si rozgeneruji všechny 4 tahy (proto 1 - 4) */
				for (int i = 1; i <= 4; i++) {
					HraciPole nove = tmp.klonujAPohni(i); //Rozgenerovávám to řešení na kterém teď "stojím" tedy "tmp" a vytvářím nová hrací pole pro každý směr
					if(nove == null) { //Metoda "klonujAPohni v případě, že tah není možný vrací 'null' "
						continue; // a pak takový tah neuvažujeme, pomocí 'continue' ho přeskočíme a 
					}
					if(!closed.contains(nove)){ //V opačné případě ten pohyb je možný a neni-li zároveň v množine takový objekt už obsažen
						open.addLast(nove); //přidávám ho na konec
					}
				}
			}
			
		}
		
		//Případ, že fron "open" je prázdná, tak řešení neexistuje
		System.out.println("Konec. Řešení neexistuje");
		
	}
}
