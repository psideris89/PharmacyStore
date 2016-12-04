package pharmacyCode;

import java.util.Scanner;

public class Menu {
	
	private static final int maxNumber = 1000;
	private static Drugs[] drugAr = new Drugs[maxNumber];
	private static People[] patientAr = new Patient[maxNumber];
	private static People[] doctorAr = new Doctor[maxNumber];
	private static Prescription[] prescriptionAr = new Prescription[maxNumber];
	
	public static void main(String[] args) {
		
		int choice = 0;
		boolean cont = true;
		int numOfDrugs = 0, numOfPatients = 0, numOfDoctors = 0, numOfPres = 0;
		
		Scanner reader = new Scanner(System.in);
		
		printMenu.login(reader);	// Calling Login method
		
		while(cont) {
			boolean cont_funct = true;
			
			choice = printMenu.mainMenu(reader);
			System.out.println();
			
			switch(choice) {
			case 1:
				if(Drugs.getDrugsTotal() < maxNumber) {
					System.out.print("\t\tInsert Medicine's Name: ");
					String drugName = reader.next();
					System.out.print("\t\tInsert Price: ");
					double drugPrice = reader.nextDouble();
					
					if (!CheckArray.booleanCheckList(drugAr, drugName)) {
						drugAr[numOfDrugs] = new Drugs(drugName, drugPrice);
						numOfDrugs++;
						
						System.out.println("\n\t\tMedicine Added");
					}
				}else {
					System.out.println("\n\t\tWARNING\n\t\tThe list of Medicines is Full --- Delete to proceed\n");
				}
				break;
				
			case 2:
				if(Patient.getPatientsTotal() < maxNumber) {
					System.out.print("\t\tInsert Patient's First Name: ");
					String patFname = reader.next();
					System.out.print("\t\tInsert Patient's Last Name: ");
					String patLname = reader.next();
					
					if(!CheckArray.booleanCheckListPat(patientAr, patFname, patLname)) {
						patientAr[numOfPatients] = new Patient(patFname, patLname);
						((Patient)patientAr[numOfPatients]).setCodeID();
						numOfPatients++;
						
						System.out.println("\n\t\tPatient Added");
					}
				}else {
					System.out.println("\n\t\tWARNING\n\t\tThe list of Patients is Full --- Delete to proceed\n");
				}
				break;
				
			case 3:
				if(Doctor.getDoctorsTotal() < maxNumber) {
					System.out.print("\t\tInsert Doctor's First Name: ");
					String docFname = reader.next();
					System.out.print("\t\tInsert Doctor's Last Name: ");
					String docLname = reader.next();
					
					if(!CheckArray.booleanCheckListDoc(doctorAr, docFname, docLname)) {
						doctorAr[numOfDoctors] = new Doctor(docFname, docLname);
						((Doctor)doctorAr[numOfDoctors]).setCodeID();
						numOfDoctors++;
						
						System.out.println("\n\t\tDoctor Added");
					}					
				}else {
					System.out.println("\n\t\tWARNING\n\t\tThe list of Doctors is Full --- Delete to proceed\n");
				}
				break;
				
			case 4:
				if(Prescription.getPrescriptionsTotal() < maxNumber) {
					String presDocFname, presDocLname, presPatFname, presPatLname;
					String addDrug = new String("yes");
					
					String[] presDrugName = new String[6];
					int [] presDrugQuantity = new int[6];
					int numOfPresDrugs = 0;
					int indexDoc = -1;
					int indexPat = -1;
					boolean foundDoc = false;
					boolean foundPat = false;
					boolean foundDrug = false;
					
					System.out.print("\t\tInsert Prescription's Doctor First Name: ");
					presDocFname = reader.next();
					System.out.print("\t\tInsert Prescription's Doctor Last Name: ");
					presDocLname = reader.next();
					
					for(int i = 0; i < Doctor.getDoctorsTotal(); i++ ) {
						if((presDocFname.equalsIgnoreCase(doctorAr[i].getFname())) && (presDocLname.equalsIgnoreCase(doctorAr[i].getLname()))) {
							indexDoc = i;
							foundDoc = true;
						}
					}
					if(!foundDoc){
							System.out.println("\n\t\tError --- Doctor not Found!");
							System.out.println("\t\tRedirecting to Main Menu.");
							break;
					}
					
					System.out.print("\n\t\tInsert Prescription's Patient First Name: ");
					presPatFname = reader.next();
					System.out.print("\t\tInsert Prescription's Patient Last Name: ");
					presPatLname = reader.next();
					
					for(int i = 0; i < Patient.getPatientsTotal(); i++ ) {
						if((presPatFname.equalsIgnoreCase(patientAr[i].getFname())) && (presPatLname.equalsIgnoreCase(patientAr[i].getLname()))) {
							indexPat = i;
							foundPat = true;
						}
					}
					if(!foundPat) {
							System.out.println("\n\t\tError --- Patient not Found!");
							System.out.println("\t\tRedirecting to Main Menu.");
							break;
					}
	
					if(foundDoc && foundPat) {
						prescriptionAr[numOfPres] = new Prescription( ((Doctor)doctorAr[indexDoc]), 
								((Patient)patientAr[indexPat]));
						prescriptionAr[numOfPres].setPresID();
						prescriptionAr[numOfPres].setPresCurrentDate();
					
					
						double totalPrice = 0;
						while(numOfPresDrugs < 6 && (addDrug.equalsIgnoreCase("yes") || addDrug.equalsIgnoreCase("y") )) {
							System.out.println();
							System.out.print("\t\tInsert Prescription's Medicine: ");
							presDrugName[numOfPresDrugs] = reader.next();
							System.out.print("\t\tInsert Quantity: ");
							presDrugQuantity[numOfPresDrugs] = reader.nextInt();
							
							for(int i = 0; i < Drugs.getDrugsTotal(); i++) {
								if(presDrugName[numOfPresDrugs].equalsIgnoreCase(drugAr[i].getDrugName())) {
									
									prescriptionAr[numOfPres].setPresDrug(presDrugName[numOfPresDrugs], 
											presDrugQuantity[numOfPresDrugs]);
									
									totalPrice += drugAr[i].getDrugPrice() * presDrugQuantity[numOfPresDrugs];
									
									foundDrug = true;
								}
							}
							if(foundDrug) 
								numOfPresDrugs++;
							else
								System.out.println("\n\t\tMedicine not Found");
								
							foundDrug = false;
							
							if(numOfPresDrugs < 6) {
								do {
									System.out.print("\t\tInsert New Medicine? (yes/no) : ");
									addDrug = reader.next();
								}while((!addDrug.equalsIgnoreCase("yes")) && (!addDrug.equalsIgnoreCase("y")) && (!addDrug.equalsIgnoreCase("no")) 
										&& (!addDrug.equalsIgnoreCase("n")));
							}
							
						}
						
						prescriptionAr[numOfPres].setTotalMoney(totalPrice);
					}
					numOfPres++;
					System.out.println("\n\n\t\tPrescription Added\n");
				}
				else {
					System.out.println("\n\t\tWARNING\n\t\tList of Prescriptions is Full --- Delete to proceed\n");
				}
				
				break;
				
			case 5:
				while(cont_funct) {
					
					int indexDrugDelete = -1, indexPatientDelete = -1, indexDoctorDelete = -1, indexPresDelete = -1;
					boolean foundDrugDelete = false, foundPatientDelete = false, foundDoctorDelete = false, foundPresDelete = false;
					
					printMenu.deleteMenu();
					
					int choice3 = reader.nextInt();
					
					switch(choice3) {
					case 1:
						System.out.print("\t\tInsert Medicine's name to delete: ");
						String drugNameDelete = reader.next();
						
						for(int i = 0; i < Drugs.getDrugsTotal(); i++) {
							if(drugNameDelete.equalsIgnoreCase(drugAr[i].getDrugName())) {
								indexDrugDelete = i;
								foundDrugDelete = true;
							}
						}
						if(foundDrugDelete) {
							for(int i = indexDrugDelete; i < Drugs.getDrugsTotal()-1 ; i++) {
								drugAr[i].setDrugID(drugAr[i+1].getDrugID());
								drugAr[i].setDrugName(drugAr[i+1].getDrugName());
								drugAr[i].setDrugPrice(drugAr[i+1].getDrugPrice());
							}
							numOfDrugs--;
							Drugs.setDrugsTotal();
							System.out.println("\n\t\tMedicine Deleted");
						}
						else {
							System.out.println("\n\t\tError --- Medicine not Found");
						}
							
						break;
						
					case 2:
						System.out.print("\t\tEnter Patient's first name: ");
						String patientFnameDelete = reader.next();
						System.out.print("\t\tEnter Patient's last name: ");
						String patientLnameDelete = reader.next();
						
						for(int i = 0; i < Patient.getPatientsTotal(); i++) {
							if((patientFnameDelete.equalsIgnoreCase(patientAr[i].getFname())) && (patientLnameDelete.equalsIgnoreCase(patientAr[i].getLname()))) {
								indexPatientDelete = i;
								foundPatientDelete = true;
							}
						}
						if(foundPatientDelete) {
							for(int i = indexPatientDelete; i < (Patient.getPatientsTotal()-1); i++) {
								patientAr[i].setFname(patientAr[i+1].getFname());
								patientAr[i].setLname(patientAr[i+1].getLname());
								((Patient)patientAr[i]).setCodeID(((Patient)patientAr[i+1]).getAMKA());
							}
							numOfPatients--;
							Patient.setPatientsTotal();
							System.out.println("\n\t\tPatient Deleted");
						}
						else {
							System.out.println("\n\t\tError --- Patient not Found");
						}
						
						break;
						
					case 3:
						System.out.print("\t\tEnter Doctor's first name: ");
						String doctorFnameDelete = reader.next();
						System.out.print("\t\tEnter Doctor's last name: ");
						String doctorLnameDelete = reader.next();
						
						for(int i = 0; i < Doctor.getDoctorsTotal(); i++) {
							if((doctorFnameDelete.equalsIgnoreCase(doctorAr[i].getFname())) && (doctorLnameDelete.equalsIgnoreCase(doctorAr[i].getLname()))) {
								indexDoctorDelete = i;
								foundDoctorDelete = true;
							}
						}
						if(foundDoctorDelete) {
							for(int i = indexDoctorDelete; i < Doctor.getDoctorsTotal()-1; i++) {
								doctorAr[i].setFname(doctorAr[i+1].getFname());
								doctorAr[i].setLname(doctorAr[i+1].getLname());
								((Doctor)doctorAr[i]).setCodeID(((Doctor)doctorAr[i+1]).getDocCode());
							}
							numOfDoctors--;
							Doctor.setDoctorsTotal();
							System.out.println("\n\t\tDoctor Deleted");
						}
						else {
							System.out.println("\n\t\tError --- Doctor not Found!");
						}
						
						break;
						
					case 4:
						System.out.print("\t\tEnter the Presciption's ID to delete: ");
						int presDelete = reader.nextInt();
						for(int i = 0; i < Prescription.getPrescriptionsTotal(); i++) {
							if(presDelete == prescriptionAr[i].getPresID()) {
								indexPresDelete = i;
								foundPresDelete = true;
							}
						}
						if(foundPresDelete) {
							for(int i = indexPresDelete; i < Prescription.getPrescriptionsTotal()-1; i++) {
								prescriptionAr[i].setPresID(prescriptionAr[i+1].getPresID());
								prescriptionAr[i].setPresDoctor(prescriptionAr[i+1].getPresDoctor());
								prescriptionAr[i].setPresPatient(prescriptionAr[i+1].getPresPatient());
								prescriptionAr[i].setPresDate(prescriptionAr[i+1].getPresDate());
								for(int j = 0; j < 6; j++) {
									prescriptionAr[i].setPresDrug(prescriptionAr[i+1].getPresDrugName(j), prescriptionAr[i+1].getPresDrugQuantity(j), j);
								}
							}
							numOfPres--;
							Prescription.setPrescriptionsTotal();
							System.out.println("\n\t\tPrescription Deleted");
						}
						else {
							System.out.println("\t\tError --- Prescription not Found");
						}
						
						break;
						
					case 5:
						cont_funct = false;
						break;
						
					default:
						System.out.println("Error --- Wrong Input");
						break;
					}
				}
				
				break;
			case 6:
				while(cont_funct) {
					
					boolean foundSearch = false;
					
					printMenu.searchMenu();
					
					int choice4 = reader.nextInt();
					
					switch(choice4) {
					case 1:
						System.out.print("\t\tInsert Doctor's first name: ");
						String searchDoctorFname = reader.next();
						System.out.print("\t\tInsert Doctor's Last Name: ");
						String searchDoctorLname = reader.next();
						
						for(int i = 0; i < Prescription.getPrescriptionsTotal(); i++) {
							if( (searchDoctorFname.equalsIgnoreCase(prescriptionAr[i].getPresDoctorFname())) && 
									(searchDoctorLname.equalsIgnoreCase(prescriptionAr[i].getPresDoctorLname())) ) {
								System.out.println("\t\t==============================");
								prescriptionAr[i].printAllPrescriptions();
								foundSearch = true;
							}
						}
						if(!foundSearch) {
							System.out.println("\t\t==============================");
							System.out.println("\n\t\tNo Prescription with this Doctor's Name.\n");
							System.out.println("\t\t==============================");
						}
						
						break;
						
					case 2:
						System.out.print("\t\tInsert Patient's ID: ");
						int searchPatientAMKA = reader.nextInt();
						
						for(int i = 0; i < Prescription.getPrescriptionsTotal(); i++) {
							if( searchPatientAMKA == prescriptionAr[i].getPresPatientAMKA()) {
								System.out.println("\t\t==============================");
								prescriptionAr[i].printAllPrescriptions();
								foundSearch = true;
							}
						}
						if(!foundSearch) {
							System.out.println("\t\t==============================");
							System.out.println("\n\t\tNo Prescription with this Patient's ID.\n");
							System.out.println("\t\t==============================");
						}
						
						break;
						
					case 3:
						System.out.println("\t\tStill in Progress!!");
						break;
						
					case 4:
						cont_funct = false;
						break;
						
					default:
						System.out.println("Error --- Wrong Input");
						break;
					}
				}
				
				break;
			case 7:
				while(cont_funct) {
					printMenu.printMenuAll();
					
					int choice2 = reader.nextInt();
					switch(choice2) {
					case 1:
						printMenu.printMedicines(drugAr);
						break;
					case 2:
						printMenu.printPatients(patientAr);
						break;
					case 3:
						printMenu.printDoctors(doctorAr);
						break;
					case 4:
						printMenu.printPrescriptions(prescriptionAr);
						break;
					case 5:
						cont_funct = false;
						break;
					default:
						System.out.println("Error --- Wrong Input");
						break;
					}
				}
				break;
				
			case 8:
				System.out.println("\n\n-------- System Terminated --------");
				cont = false;
				break;
			}
		}
		reader.close();
	}	
}
