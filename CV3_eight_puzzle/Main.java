package eight_puzzle;

public class Main {
	
	 public static final int UP = 1;
	 public static final int DOWN = 2;
	 public static final int LEFT = 3;
	 public static final int RIGHT = 4;

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		HraciPole hraciPole = new HraciPole();
		
		hraciPole.printTheBoard();
		hraciPole.makeMove(UP);
		hraciPole.printTheBoard();
		hraciPole.makeMove(RIGHT);
		hraciPole.printTheBoard();

	}

}
