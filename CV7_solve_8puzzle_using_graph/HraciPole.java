package eight_puzzle_solution;

import java.util.ArrayList;

public class HraciPole implements Comparable<HraciPole> { //Comparable aby bylo možné porovnávat dvě pole
	private int[][] data = { { 1, 4, 7 }, { 2, 5, 8 }, { 3, 6, -1 } }; //Vyvoření hracího pole
	private int x = 2; //X-óvá souřadnice prázdného políčka
	private int y = 2; //Y-óvá souřadnice prázdného políčka
	private ArrayList<Integer> pohyby = new ArrayList<Integer>();
	
	
	//Pohyby
	public static final int UP = 1;
	public static final int DOWN = 2;
	public static final int LEFT = 3;
	public static final int RIGHT = 4;
	
	
	/*Metoda vytváří NOVÉ místo v paměti, nový objekt se, 
	 * kterým se poté provadí, operace a to proto aby ten výchozí objetk, ten 
	 * rodič zůstal netknutý*/
	
	public HraciPole klonujAPohni(int smer) {
		HraciPole nove = new HraciPole(); //Vytvoření nové paměti
		
		//----------------Zkopírování obsahu "staré" paměti do nové---------------------------
		
		//Nakopírování pozice "-1" tedy (X,Y) a další pohyby
		nove.x = this.x;
		nove.y = this.y;
		nove.pohyby.addAll(this.pohyby);
		nove.pohyby.add(smer);

		//Překopírování dvojrozměrného pole
		for (int x = 0; x < 3; x++) {
			for (int y = 0; y < 3; y++) {
				nove.data[x][y] = this.data[x][y];
			}
		}
		//-------------------------------------------

		
		//Procedení samotného pohybu nad novým objektem (novou pamětí)
		boolean jeMozny = nove.pohni(smer);
		if (jeMozny) {
			return nove;
		} else {
			return null;
		}
	}

	public boolean pohni(int smer) {
		//Ta políčka se vypsují to co je v syso řádek jako {} v System.out.println řádek tak se do konzole vypíše jako sloupec 
		switch (smer) {
		case UP:
			// nahoru
			if (y < 1) {
				return false; //V případě, že operaci nelze provést
			}
			data[x][y] = data[x][y - 1];
			data[x][y - 1] = -1;
			y = y - 1; // y--;
			return true; //V případě, že operace je proveedena úspěšně
		case DOWN:
			// nahoru
			if (y > 1) {
				return false;
			}
			data[x][y] = data[x][y + 1];
			data[x][y + 1] = -1;
			y++; // y = y + 1;
			return true;
		case LEFT:
			// nahoru
			if (x < 1) {
				return false;
			}
			data[x][y] = data[x - 1][y];
			data[x - 1][y] = -1;
			x = x - 1; // y--;
			return true;
		case RIGHT:
			if (x > 1) {
				return false;
			}
			data[x][y] = data[x + 1][y];
			data[x + 1][y] = -1;
			x++; // y = y + 1;
			return true;// TODO
		}
		return false;
	}

	@Override
	public String toString() {
		String res = "pohyby:" + pohyby + "\n";
		for (int iy = 0; iy < 3; iy++) {
			for (int ix = 0; ix < 3; ix++) {
				res += data[ix][iy] + ",";
			}
			res += "\n";
		}
		return res;
	}

	public boolean jeReseni() {
		
		/*Pole, které odpovídá, řešení a vůči kterému se jednotlivá pole (objekty) 
		 *po každém pohybu porovnávají a zjišťuje se zda jde o řešení 4i nikoliv*/
		
		/*Cykly jedou přes všechna X a Y a porovnávají se jednotlivé hodnoty 
		 *současného pole vůči jednotlivým hodnotám řešení*/
		int[][] reseni = { { 1, 4, 7 }, { 2, 5, 8 }, { 3, 6, -1 } }; 
		for (int x = 0; x < reseni.length; x++) {
			for (int y = 0; y < reseni[0].length; y++) {
				if (data[x][y] != reseni[x][y]) {
					return false; //V případě, že je nalezena odlišnost tak vrací "false"
				}
			}
		}
		return true; //jinak "true"
	}

	public int hashCode() {
		String result = "";
		for (int x = 0; x < this.data.length; x++) {
			for (int y = 0; y < this.data[0].length; y++) {
				if (this.data[x][y] == -1) {
					result += 9;
				} else {
					result += this.data[x][y];
				}
			}
		}
		return Integer.parseInt(result);
	}

	public boolean equals(Object obj) {
		HraciPole hp = (HraciPole) obj;
		for (int x = 0; x < 3; x++) {
			for (int y = 0; y < 3; y++) {
				if (data[x][y] != hp.data[x][y]) {
					return false;
				}
			}
		}
		return true;
	}

	
	@Override
	public int compareTo(HraciPole o) {
		// TODO Auto-generated method stub
		int hash1 = this.hashCode();
		int hash2 = o.hashCode();
		if (hash1 == hash2) { //Když jsou dvě pole stejné vrací 0
			return 0;
		} else if (hash1 > hash2) { //Je-li někde nějaké odlišnost vrací 1 nebo -1
			return 1; 
		} else {
			return -1; 
		}

	}
	
}
