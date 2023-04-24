package registr_kradenych_aut;

public class Main {

	public static void main(String[] args) {
		
		Mapa registr = new Mapa();
		
		
		
		
		Osobni BMW = new Osobni();
		BMW.setNazev("BMW X6(2023)");
		BMW.setBarva("Modrá");
		BMW.setVIN("4Y1SL65848Z411439");
		
		Nakladni Iveco = new Nakladni();
		Iveco.setNazev("EuroCargo");
		Iveco.setBarva("Bílá");
		Iveco.setVIN("4Y1SL65848Z411440");
		Iveco.toString();
		
		
		registr.pridej(BMW);
		registr.pridej(Iveco);
		
		
		registr.hledej("4Y1SL65848Z411439");
		
		
		

	}

}
