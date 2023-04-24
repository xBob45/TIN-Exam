package registr_kradenych_aut;

public class Nakladni extends Auto{
	
	//Class variables
	private boolean prives;
	private String VIN_prives;
	
	
	
	//Getters & Setters
	public boolean getPrives() {
		return prives;
	}
	public void setPrives(boolean prives) {
		this.prives = prives;
	}
	public String getVIN_prives() {
		return VIN_prives;
	}
	public void setVIN_prives(String VIN_prives) {
		/*V případě, že Nákaldní auto nemá přívěs, 
		 * nemá smysl VIN číslo uvažovat
		 */
		if (getPrives() == false) {
			this.VIN_prives = null;
		}
		else {
			this.VIN_prives = VIN_prives;
		}
		
	}
	@Override
	public String toString() {
		return "\n" +"Název: "+getNazev() +"\n" + "VIN: "+getVIN() +"\n"+ "Barva: "+getBarva() +"\n"+ "Prives: "+getPrives()+"\n"+"VIN privesu: "+getVIN_prives();
	}
	
	
	
	
	
	

}
