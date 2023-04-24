package registr_kradenych_aut;

public abstract class Auto {
	
	//Class variables
	private String VIN;
	private String nazev;
	private String barva;
	
	
	//Getters & Setters
	public String getVIN() {
		return VIN;
	}
	public void setVIN(String VIN) {
		this.VIN = VIN;
	}
	public String getNazev() {
		return nazev;
	}
	public void setNazev(String nazev) {
		this.nazev = nazev;
	}
	public String getBarva() {
		return barva;
	}
	public void setBarva(String barva) {
		this.barva = barva;
	}
	
	
	

}
