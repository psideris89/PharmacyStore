package pharmacyCode;
import java.util.Date;

public class Prescription {
	
	private Doctor presDoctor;
	private Patient presPatient;
	private Date presDate;
	private String[] presDrugs;
	private int presNumDrugs = 0;
	private int[] ammountOfDrug;
	private static int presID = 1;
	private int presCode;
	private static int prescriptionsTotal = 0;
	private double totalMoney;
	private String presDoctorFname2, presDoctorLname2, presPatientFname2, presPatientLname2;
	private int presPatientAMKA2;
	
	public Prescription(Doctor presDoctor, Patient presPatient) {
		this.presDoctor = presDoctor;
		this.presPatient = presPatient;
		this.presDrugs = new String[6];
		this.ammountOfDrug = new int[6];
		this.presNumDrugs = 0;
		this.presCode = 0;
		this.presDate = null;
		this.totalMoney = 0;
		presDoctorFname2 = presDoctor.getFname();
		presDoctorLname2 = presDoctor.getLname();
		presPatientFname2 = presPatient.getFname();
		presPatientLname2 = presPatient.getLname();
		presPatientAMKA2 = presPatient.getAMKA();
		
		prescriptionsTotal++;
	}
	
	public static int getPrescriptionsTotal() {
		return prescriptionsTotal;
	}
	
	public static void setPrescriptionsTotal() {
		prescriptionsTotal--;
	}
	
	public void setPresDoctor(Doctor presDoctor) {
		this.presDoctor = presDoctor;
	}

	public Doctor getPresDoctor() {
		return presDoctor;
	}
	
	public String getPresDoctorFname() {
		return presDoctorFname2;
	}
	
	public String getPresDoctorLname() {
		return presDoctorLname2;
	}
	
	public String getPresPatientFname() {
		return presPatientFname2;
	}
	
	public String getPresPatientLname() {
		return presPatientLname2;
	}
	
	public void setPresPatient(Patient presPatient) {
		this.presPatient = presPatient;
	}
	
	public Patient getPresPatient() {
		return presPatient;
	}
	
	public int getPresPatientAMKA() {
		return presPatientAMKA2;
	}
	
	public void setPresCurrentDate() {
		this.presDate = new Date();
	}
	
	public void setPresDate(Date presDate) {
		this.presDate = presDate;
	}
	
	public Date getPresDate() {
		return presDate;
	}
	
	public void setPresID() {
		presCode = presID;
		presID++;
	}
	
	public void setPresID(int newPresID) {
		presCode = newPresID;
	}
	
	public int getPresID() {
		return presCode;
	}
	
	public void setPresDrug(String presDrug, int quantity) {
		if(presNumDrugs < 6) {
			this.presDrugs[presNumDrugs] = presDrug;
			this.ammountOfDrug[presNumDrugs] = quantity;
			presNumDrugs++;
		}		
	}
	
	public void setPresDrug(String presDrug, int quantity, int position) {
		this.presDrugs[position] = presDrug;
		this.ammountOfDrug[position] = quantity;
	}
	
	public String getPresDrugName(int j) {
		return presDrugs[j];
	}
	
	public int getPresDrugQuantity(int j) {
		return ammountOfDrug[j];
	}
	
	public void printAllPrescriptions() {
		System.out.println();
		System.out.println("\t\tID: " + this.presCode);
		System.out.println("\t\tDoctor: " + this.presDoctorFname2+ " " + this.presDoctorLname2);
		System.out.println("\t\tPatient: " + this.presPatientFname2 + " " + this.presPatientLname2);
		System.out.println("\t\tDate: " + this.presDate);	
		System.out.println();
		System.out.println("\t\tMedicine:");
		
		for(int i = 0; i < presNumDrugs; i++) {
			if(this.presDrugs[i] != null)
				System.out.println("\t\t\t" + this.presDrugs[i] + "\tquantity:" + this.ammountOfDrug[i] );
		}
		
		System.out.println("\n\t\tPrice: " + totalMoney + " £.");
		System.out.println("--------------------------------\n");
	}
	
	public void setTotalMoney(double totalMoney) {
		this.totalMoney = totalMoney;
	}
	
	public double getTotalMoney() {
		return totalMoney;
	}
	/*
	public double calculatePrice() {
		double sum = 0;
		for(int i = 0; i < presNumDrugs; i++) {
			
		}
		return sum;
	}
	*/

}
