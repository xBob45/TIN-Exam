package cv10_1;



public class Seznam {
	private Prvek first;

	// Metoda přidávající na záčátek jednosměrně vázaného lineárního seznamu
	public void vloz(String s) { 
		Prvek e = new Prvek(s);
		
		// V případě, že seznam je prázdný tak nově vytvořený prvek bude ten první -> bude počátkem
		if (first == null) {
			first = e;
		
		// Případ, že seznam není prázdný a něco už v něm je
		} else {
			e.setNext(first); //tak následujíc prvek toho nového bude ten, který je v součansné době JEŠTĚ první
			first = e; // a nový prvek je tímto nastaven na první
		}
		}
	
	//Vypsat data všech uzlů jednosměrně vázaného seznamu
	public void print() {
		Prvek tmp = first;
		while(tmp != null) {
			System.out.println(tmp.getData());
			tmp = tmp.getNext();
		}
	}
	

	public void odstranPredposledni() {
		/*o co jde je reálně to, že já potřebuju mít dva ukazatele s tím, že ten jeden se bude dívat vždy dopředu a
		 * a ten druhý, který bude držet referenci na toho před ním a až ten "první" nemá, žádně další hodnoty tak ví, že je poslední,
		 * tudíž, ten druhý ukazuje na toho před ním a ten je předposlední. 
		 */
	    Prvek predpred = null; //Toto bude ukazovat na předposlední prvek
	    Prvek pred = first; //Toto bude ukazovat na poslední prvek
	    
	    while (pred.getNext() != null) {
	    	/*Pokud se "pred" nerovná poslednímu, tedy pokud 
	    	 * má před sebou nějaké další tak se na ně posuneme a v proměnné "prepred" mám referenci na toho minulého
	    	 * */
	        predpred = pred; 
	        pred = pred.getNext();
	    }
	    predpred.setNext(pred.getNext()); //Tímto je předposlední prvek nastaven na "null" a tím zaniká.
	}
	
	
	//Metoda odstraňující první prvek ze seznamu
	public void odstranPrvni() {
		// Kontrola zda seznam není prázdný
	    if (first == null) { 
	        return;
	    }
	    //Jeslti ne, tak, první prvek se přenastaví na druhý a tím první prvek zaniká
	    first = first.getNext(); // nový první prvek je nyní druhý prvek
	}

	

	public Prvek najdiProstredni() {
	    //Kontrola zda seznam není prázdný
		if (first == null) {
	        return null;
	    }
		//Ze začátku obě proměnné ukazují na začátek
	    Prvek slow = first; //Bude ukzovat na aktuální prvek
	    Prvek fast = first; //Bude ukazovat na prvek o dva kroky dále
	    
	    //Dokud nedojdeme na koned seznamu
	    while (fast != null && fast.getNext() != null) {
	    	/*"slow" bude ukazovat na prost5edek seznamu, jelikož se posunul o polovinu cesty co "fast"*/
	        slow = slow.getNext();
	        fast = fast.getNext().getNext();
	    }
	    //return slow.getNext()
	    return slow;
	}
}
