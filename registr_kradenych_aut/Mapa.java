package registr_kradenych_aut;

import java.util.HashMap;

public class Mapa{
	
	//Realizce asociace "VIN:Auto" 
	private HashMap<String, Auto> registr = new HashMap<String, Auto>();
	
	public void pridej(Auto auto) {
		registr.put(auto.getVIN(), auto);
	}
	
	public void hledej(String VIN) {
		Auto vysledek = registr.get(VIN);
		System.out.println(vysledek.toString());
		
		
		
	}

}
