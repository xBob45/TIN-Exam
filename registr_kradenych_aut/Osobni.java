package registr_kradenych_aut;

public class Osobni extends Auto {
	
	public String toString() {
		return "\n" + "\033[4m" + "Typ: Osobní auto" + "\033[0m" + "\n" +"Název: "+getNazev()  +"\n" + "VIN: "+getVIN() +"\n"+ "Barva: "+getBarva();
	}

}
