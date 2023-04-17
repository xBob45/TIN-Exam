package eight_puzzle;

import java.util.Arrays;

public class HraciPole {
	
	private static final int UP = 1;
	private static final int DOWN = 2;
	private static final int LEFT = 3;
	private static final int RIGHT = 4;
	
	private int[][] board = {{7,2,4},{5,0,6},{8,3,1}}; // Vytvoření a inicializace "two-dimensional array", který reprezentuje hrací plochu.
	
	// Souřadnice 0-vého elementu
	private int x = 1; // Reprezntuje řádek
	private int y = 1; // Reprezentuje sloupec
	
	
	//Metoda pro výpis součásného stavu hracího pole
	public void printTheBoard() {
		
		StringBuilder game_board = new StringBuilder(); // Objekt, do kterého se iterováním přidávají řádky hracího pole
		for (int row = 0; row<board.length; row++) { //Tento cyklus prochází "řádky" tj. jednotlivé pod-pole "board" 
			for (int column = 0; column<board.length; column++) { //Tento cyklus iteruje přes "sloupce" tj. jednotlivé elementy každého pod-pole.
				game_board.append(board[row][column]); //Každý element je tímto přidán do objektu "game_board"
				game_board.append(" "); //Za každým elementem se tímto udělá mezera
			}
			game_board.append("\n"); //Na konci každého řádku tj. pod-pole je udělán nový řádek a celý proces se opakuje dokud se neprojde celé pole "board"
		}
		
		System.out.println(game_board);
	}
	
	public void makeMove(int direction) {
		
		switch (direction) {
		
		case UP:
			if(x>=0) {
				//První pozice [x] vybírá sub-pole druhá pozice [y] vybírá element v tom sub-poli.
				board[x][y] = board[x-1][y]; // {{7,2,4},{5,2,6},{8,3,1}}; ||| na to [x-1]je potřeba se dívat tak jakože jdu na pole o index níže --> {{7,2,4}[x-1],{5,0,6}[x],{8,3,1}[x+1]}; 
				board[x-1][y] = 0; // {{7,0,4},{5,2,6},{8,3,1}};
				x--; // Update hranic tak abych y pole nepřetekl. Ale je lepší si to představovat ne jako kolik se jeětě mohu posunout, ale jake se zvětši/zmenšil index.
			}
			break;
		case DOWN:
			if(x<=2) {
				board[x][y] = board[x+1][y];
				board[x+1][y] = 0;
				x++;
			}
			break;
		case LEFT:
			if(y>=0) {
				board[x][y] = board[x][y-1];
				board[x][y-1] = 0;
				y--;
			}
			break;
		case RIGHT:
			if(y<=2) {
				board[x][y] = board[x][y+1];
				board[x][y+1] = 0;
				y++;
			}
			break;
		
		}
			
	}
	
	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass()) //Porovnání zda jsou objekty potomci stejné třídy
			return false;
		HraciPole other = (HraciPole) obj;
		if (!Arrays.deepEquals(board, other.board)) //deepEquals slouží k porovnání "multi-dimenzional" polí. Jsou li pole stejné dimenze a obsahují stejné prvky na stejných pozicích metoda vrací True jinak False. 
			return false;
		if (x != other.x)
			return false;
		if (y != other.y)
			return false;
		return true;
	
	
		
	}
}
	
	
	


