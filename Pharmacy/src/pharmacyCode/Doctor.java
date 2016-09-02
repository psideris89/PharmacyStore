package pharmacyCode;

public final class Doctor extends People{

	private static int doc_code = 1;
	private static int doctorsTotal = 0;
	private int docID;
	
	public Doctor(String fname, String lname) {
		super(fname, lname);
		doctorsTotal++;
	}
	
	public static int getDoctorsTotal() {
		return doctorsTotal;
	}
	
	public static void setDoctorsTotal() {
		doctorsTotal--;
	}
	
	public void setCodeID() {
		docID = doc_code;
		doc_code++;
	}
	
	public void setCodeID(int newDocCode) {
		docID = newDocCode;
	}
	
	public int getDocCode() {
		return this.docID;
	}
	
	public void printPerson() {
		super.printPerson();
		System.out.println("\t\tID: " + this.docID);
	}
	
}
