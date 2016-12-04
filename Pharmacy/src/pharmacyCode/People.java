package pharmacyCode;

import lombok.AccessLevel;
import lombok.Getter;
import lombok.Setter;

public abstract class People {
	
	@Getter @Setter private String fname, lname;
	
	public People(String fname, String lname) {
		this.fname = fname;
		this.lname = lname;
	}
	
	public abstract void setCodeID();
	
	public void printPerson() {
		System.out.println("\t\tName: " + this.fname + " " + this.lname);
	}
}
