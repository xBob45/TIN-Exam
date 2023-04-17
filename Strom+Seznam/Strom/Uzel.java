package cv10;

public class Uzel {
	
	//Jedná se o binární strom -> každý uzel má data a potomky na levo a na pravo
	private int data;
	private Uzel levy;
	private Uzel pravy;
	
	
	
	//Gettery + Settery
	public Uzel(int data) {
		this.data = data;
	}
	
	public int getData() {
		return data;
	}
	public void setData(int data) {
		this.data = data;
	}
	public Uzel getLevy() {
		return levy;
	}
	public void setLevy(Uzel levy) {
		this.levy = levy;
	}
	public Uzel getPravy() {
		return pravy;
	}
	public void setPravy(Uzel pravy) {
		this.pravy = pravy;
	}

	
}
