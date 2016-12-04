package pharmacyCode;

public class Drugs {

	private static int drugID = 1;
	private static int drugsTotal = 0;
	private int drugCode;
	private String name;
	private double price;
	
	public Drugs(String name, double price) {
		this.name = name;
		this.price = price;
		setDrugID();
		drugsTotal++;
	}
	
	public static int getDrugsTotal() {
		return drugsTotal;
	}
	
	public static void setDrugsTotal() {
		drugsTotal--;
	}
	
	public void setDrugID() {
		drugCode = drugID;
		drugID++;
	}
	
	public void setDrugID(int drID) {
		drugCode = drID;
	}
	
	public int getDrugID() {
		return this.drugCode;
	}
	
	public void setDrugName(String name) {
		this.name = name;
	}
	
	public String getDrugName() {
		return this.name;
	}
	
	public void setDrugPrice(double price) {
		this.price = price;
	}
	
	public double getDrugPrice() {
		return this.price;
	}
	
	public void printDrug() {
		System.out.println("\t\tName: " + this.name);
		System.out.println("\t\t\tPrice: " + this.price + " pounds");
		System.out.println("\t\t\tID: " + this.drugCode);
	}
}
