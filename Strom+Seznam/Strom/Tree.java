package cv10;

import java.util.Stack;


// Vsechno o stromech je zde: https://www.baeldung.com/java-binary-tree#2-finding-an-element
public class Tree {
	private Uzel koren;

	public Tree() {
	}

	//Getter 
	public Uzel getKoren() {
		return koren;
	}
	
	//Setter
	public void setKoren(Uzel koren) {
		this.koren = koren;
	}

	
	//Metoda, která sečte data všech uzlů
	public int sectiVsechny() {

		//Jestli je strom prázdný tak "root" = "null" a tedy součet je 0.
		if (koren == null) {
			return 0;
		}
		//Jinak (else), vezmi data, roota (vrcholu stromu)
		int sum = koren.getData();
		sum += sumChild(koren); //Přičítej data, která obsahují potomci. sumChild
		return sum;

	}
	
	
	//Metoda, která sčítá "data" potomků
	private static int sumChild(Uzel u) { //Jako parametr, který vstupu je do funkce máme "rodiče".
		int sum = 0;
		if (u.getLevy() != null) {// Kontrola, jestli "u" má na levo potomka.
			//Jestli ANO
			//Data, "levého" se přičtou, k "sum" a rekurzivně se zavolá "sumChild" na toho "levého" jelikož od se teď stává rodičem svých potomků a takto se pokračuje dále dokud nějaký levý existuje u toho výchozího "u" existuje.
			sum += u.getLevy().getData() + sumChild(u.getLevy()); 
		}
		//Stejně jako u levého
		if (u.getPravy() != null) {// Kontrola, jestli "u" má na pravo potomka.
			sum += u.getPravy().getData() + sumChild(u.getPravy()); //
		}

		return sum; //A toto se potom přište k "sum" v metodě "sectiVsechny"
	}
	
	//Listy jsou uzly, které už nemají potomky
	public int sectiListy() {

		if (koren == null) { //Jestli je binární strom prázdný tj. vrchol stromu je roven "null" tak je soucet 0
			return 0;
		}
		//Jestli ve stromu něco je tak zavolej "sumListy"
		int sum = sumListy(koren);
		return sum;

	}
	
	//Listy jsou uzly, které už dále nemají žádné potomky
	private static int sumListy(Uzel u) { //Jako vstup je vždy kořen, který je rodič.
		int sum = 0;
		//Test jestli jde o uzel, který už nemá potomky, jestli ano jde o list a přišteme hodnotu proměnné "data" k "sum"
		if (u.getLevy() == null && u.getPravy() == null) {
			sum = u.getData();
		//Jinak na levého i pravého zavoláme rekurzivně "sumListy" a tam pro ně proběhne stejná kontrola jako výše
		} else {
			if (u.getLevy() != null) {
				sum += sumListy(u.getLevy());
			}
			if (u.getPravy() != null) {
				sum += sumListy(u.getPravy());
			}
		}
		return sum; //a tento "sum" se přičte k "sum" v metodě "sectiListy"

	}

	public int sectiVnitrni() {
		// TODO Auto-generated method stub
		if (koren == null) {
			return 0;
		}
		int sum = sumVnitrnich(koren);
		return sum;
	}
	
	//Vnitrni jsou ty uzly, kterými strom "nekončí" tedy mají alespoň jednoho potomka
	private int sumVnitrnich(Uzel u) {
		int sum = 0;
		//Kontrola jestli má uzel, alespoň jednoho potomka tj. -> zdali je "vnitřním"
		if (u.getLevy() != null || u.getPravy() != null) {
			sum = u.getData();
		}
		if (u.getLevy() != null) {
			sum += sumVnitrnich(u.getLevy());
		}
		if (u.getPravy() != null) {
			sum += sumVnitrnich(u.getPravy());
		}
		return sum; //Tento "sum" se potom přičte k "sum" v metodě "sectiVnitrni"
	}

	public String uzlyVhloubce() {
		if (koren == null) {
			return "";
		}
		int depth = 3;
		int tmpdepth = 1;
		String s = depth(koren, tmpdepth, depth);
		return s;
	}

	private String depth(Uzel u, int tmpdepth, int depth) {
		String s = "";
		//Test jestli už jsme dosáhli dané hloubky
		if (tmpdepth == depth) {
			s = u.getData() + " "; //V tu chvíli kdy dojedem ke uzlu, který bude v hlobce rovné "tmpdepth" tak uloží do proměnné "s" obsah proměnné "data"
		//Jestli ne, tak metodu "depth" rekurzivně aplikujeme na potomky a takto jdeme tím stromem dokud nedosáhneme hloubky "thmdepth"
		} else {
			if (u.getLevy() != null) {
				s += depth(u.getLevy(), tmpdepth+1, depth);
			}
			if (u.getPravy() != null) {
				s += depth(u.getPravy(), tmpdepth+1, depth);
			}		
		}
		return s; // Toto "s" se ulož do proměnné "s" metody "uzlyVhloubce"
	}

	
	//Převedení na lineární seznam (in-order)
	public void Seznam() {
		if(koren == null) {
			return; //Pokud je strom prázdný nic metoda končí
		}
		Uzel tmp = koren; 
		while(tmp != null) {
			Uzel exPrav = tmp.getPravy(); //Pravý potomek
			tmp.setPravy(tmp.getLevy()); //Pravý potomek se nastavý na levého
			
			tmp.setLevy(null);//Levý potomek tímto zaniká
			
			Uzel end = tmp; 
			//Cyklus, který hledá poslední uzel
			while(true) {
				if(end.getPravy() == null) {
					end.setPravy(exPrav); //Poslední uzle, je pravý potomek aktuálního listu tj, "end"
					break;
				}
				end = end.getPravy(); //Skutečný konec seznamu
			}
			tmp = tmp.getPravy();
		}
	}
	
	
	//Převod stromu na jednosměrně vázaný lineární seznam
	public void flatten(Uzel kořen) {
        if (kořen == null) { //Pokud je strom prázdný metoda skončí
            return;
        }
        flatten(kořen.getLevy()); //Rekurze na pravého potomka
        flatten(kořen.getPravy()); // Rekurze na levého potomka
        Uzel tmp = kořen.getPravy();
        kořen.setPravy(kořen.getLevy()); //Levý potomek se nastavý pravého
        kořen.setLevy(null); //Levý potomek se nastavý "null" a tak zanikne
        while (kořen.getPravy() != null) { //Cyklus "doskáče" na poslední uzel
            kořen = kořen.getPravy();
        }
        kořen.setPravy(tmp); //z něhož se nastavý reference na původního pravého potomka a to je konec seznamu
    }
	
	
	//In-order
	public void inorderTraversal(Uzel kořen) {
	    if (kořen == null) {
	        return;
	    }
	    inorderTraversal(kořen.getLevy());
	    System.out.print(kořen.getData() + " ");
	    inorderTraversal(kořen.getPravy());
	}
	
	//Pre-order
	public void preorderTraversal(Uzel kořen) {
	    if (kořen == null) {
	        return;
	    }
	    System.out.print(kořen.getData() + " ");
	    preorderTraversal(kořen.getLevy());
	    preorderTraversal(kořen.getPravy());
	}

	
	//Post-order
	public void postorderTraversal(Uzel kořen) {
	    if (kořen == null) {
	        return;
	    }
	    postorderTraversal(kořen.getLevy());
	    postorderTraversal(kořen.getPravy());
	    System.out.print(kořen.getData() + " ");
	}
}
