package registr_kradenych_aut;

public class Osobni extends Auto {
	
	public String toString() {
		return "\n" +"Název: "+getNazev()  +"\n" + "VIN: "+getVIN() +"\n"+ "Barva: "+getBarva();
	}

}
