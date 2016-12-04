package pharmacyCode;

import java.util.Scanner;

public abstract class printMenu {
	
	public static void login(Scanner reader) {
		int login_attempts = 0;
		String userName, userCode;
		
		do {
			if (login_attempts > 0) {
				System.out.println("\nWrong name/password");
				System.out.println((3 - login_attempts) + " remaining attempts \n");
			}
			System.out.println("==============================");
			System.out.println("\tLogin");
			System.out.print("Name: ");
			userName = reader.next();
			System.out.print("Password: ");
			userCode = reader.next();
			login_attempts++;
		
			if(login_attempts == 3) {
				System.out.println("3 Wrong Attempts --- System is terminating");
				System.exit(0);
			}
		}while(!(userName.equals("testUser")) || !(userCode.equals("12345")));
		System.out.println("\n\tWelcome " + userName + "\n");
	}
	
	public static int mainMenu(Scanner reader) {
		int choice;
		
		System.out.println("==============================");
		System.out.println("\tMENU");
		System.out.println();
		System.out.println("1 -- Add Medicine");
		System.out.println("2 -- Add Patient");
		System.out.println("3 -- Add Doctor");
		System.out.println("4 -- Create Prescription");
		System.out.println("5 -- Delete Menu");
		System.out.println("6 -- Search Prescription Menu");
		System.out.println("7 -- Print Menu");
		System.out.println("8 -- Exit");
		System.out.println();
		System.out.println("==============================");
		
		do {
			System.out.print("Enter your choice (1-8): ");
			choice = reader.nextInt();
		}while((choice < 1) || (choice > 8));
		
		return choice;
	}
	
	public static void deleteMenu() {
		System.out.println("==============================");
		System.out.println("\tDELETE MENU");
		System.out.println();
		System.out.println("1 -- Delete Medicine");
		System.out.println("2 -- Delete Patient");
		System.out.println("3 -- Delete Doctor");
		System.out.println("4 -- Delete Prescription");
		System.out.println("5 -- Return to Main Menu");
		System.out.println("\nEnter your choice (1-5): ");
	}
	
	public static void searchMenu() {
		System.out.println("==============================");
		System.out.println("\tPRESCRIPTION SEARCH MENU");
		System.out.println();
		System.out.println("1 -- Search by Doctor Name");
		System.out.println("2 -- Search by Patient's ID");
		System.out.println("3 -- Search by Date");
		System.out.println("4 -- Return to Main Menu");
		System.out.print("\nEnter your choice (1-4): ");
	}
	
	public static void printMenuAll() {
		System.out.println("==============================");
		System.out.println("\tPRINT MENU");
		System.out.println();
		System.out.println("1 -- Print Medicines");
		System.out.println("2 -- Print Patients");
		System.out.println("3 -- Print Doctors");
		System.out.println("4 -- Print Prescriptions");
		System.out.println("5 -- Return to Main Menu");
		System.out.print("\nEnter your choice (1-5): ");
	}
	
	public static void printMedicines(Drugs[] inputArray) {
		System.out.println("\t\t==============================");
		System.out.println("\t\t\tMEDICINES LIST");
		if(Drugs.getDrugsTotal() == 0) {
			System.out.println("\n\t\tEmpty List\n");
		}
		else {
			for(int i = 0; i < Drugs.getDrugsTotal(); i++) {
				System.out.println();
				inputArray[i].printDrug();
			}
		}
	}
	
	public static void printPatients(People[] inputArray) {
		System.out.println("\t\t==============================");
		System.out.println("\t\t\tPATIENTS LIST");
		if(Patient.getPatientsTotal() == 0) {
			System.out.println("\n\t\tEmpty List\n");
		}
		else {
			for(int i = 0; i < Patient.getPatientsTotal(); i++) {
				System.out.println();
				inputArray[i].printPerson();
			}
		}
	}
	
	public static void printDoctors(People[] inputArray) {
		System.out.println("\t\t==============================");
		System.out.println("\t\t\tDOCTORS LIST");
		if(Doctor.getDoctorsTotal() == 0) {
			System.out.println("\n\t\tEmpty List\n");
		}
		else {
			for(int i = 0; i < Doctor.getDoctorsTotal(); i++) {
				System.out.println();
				inputArray[i].printPerson();
			}
		}
	}
	
	public static void printPrescriptions(Prescription[] inputArray) {
		System.out.println("\t\t==============================");
		System.out.println("\t\t\tPRESCRIPTIONS LIST");
		if(Prescription.getPrescriptionsTotal() == 0) {
			System.out.println("\n\t\tEmpty List\n");
		}
		else {
			for(int i = 0; i < Prescription.getPrescriptionsTotal(); i++) {
				System.out.println();
				inputArray[i].printAllPrescriptions();
			}
		}
	}
}
