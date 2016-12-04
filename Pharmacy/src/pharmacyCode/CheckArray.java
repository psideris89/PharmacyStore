package pharmacyCode;

public class CheckArray {

	public static boolean booleanCheckList(Drugs[] inputArray, String name) {
		if(Drugs.getDrugsTotal() > 0 ) {
			for(int i = 0; i < Drugs.getDrugsTotal(); i++) {
				if(inputArray[i].getDrugName().equalsIgnoreCase(name)) {
					System.out.println("\n\t\tError --- An entry already exists with the same name");
					return true;
				}
			}
		}
		return false;
	}
	
	public static boolean booleanCheckListPat(People[] inputArray, String fname, String lname) {
		if(Patient.getPatientsTotal() > 0 ) {
			for(int i = 0; i < Patient.getPatientsTotal(); i++) {
				if(inputArray[i].getFname().equalsIgnoreCase(fname) && inputArray[i].getLname().equalsIgnoreCase(lname)) {
					System.out.println("\n\t\tError --- An entry already exists with the same name");
					return true;
				}
			}
		}
		return false;
	}
	
	public static boolean booleanCheckListDoc(People[] inputArray, String fname, String lname) {
		if(Doctor.getDoctorsTotal() > 0 ) {
			for(int i = 0; i < Doctor.getDoctorsTotal(); i++) {
				if(inputArray[i].getFname().equalsIgnoreCase(fname) && inputArray[i].getLname().equalsIgnoreCase(lname)) {
					System.out.println("\n\t\tError --- An entry already exists with the same name");
					return true;
				}
			}
		}
		return false;
	}
}
