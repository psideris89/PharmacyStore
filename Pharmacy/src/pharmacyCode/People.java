package pharmacyCode;

public abstract class People {
	
	private String fname, lname;
	
	public People(String fname, String lname) {
		this.fname = fname;
		this.lname = lname;
	}
	
	public abstract void setCodeID();
	
	public void setFname(String fname) {
		this.fname = fname;
	}
	
	public String getFname() {
		return this.fname;
	}
	
	public void setLname(String lname) {
		this.lname = lname;
	}
	
	public String getLname() {
		return this.lname;
	}
	
	public void printPerson() {
		System.out.println("\t\tName: " + this.fname + " " + this.lname);
	}
}
