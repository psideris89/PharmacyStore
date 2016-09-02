package pharmacyCode;

public final class Patient extends People{

	private static int AMKA_code = 1;
	private static int patientsTotal = 0;
	private int AMKA;
	
	public Patient(String fname, String lname) {
		super(fname, lname);
		patientsTotal++;
	}
	
	public static int getPatientsTotal() {
		return patientsTotal;
	}
	
	public static void setPatientsTotal() {
		patientsTotal--;
	}
	
	public void setCodeID() {
		AMKA = AMKA_code;
		AMKA_code++;
	}
	
	public void setCodeID(int Amka) {
		AMKA = Amka;
	}
	
	public int getAMKA() {
		return this.AMKA;
	}
	
	public void printPerson() {
		super.printPerson();
		System.out.println("\t\tNiNO: " + this.AMKA);
	}
}
