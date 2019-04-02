package data.Entities;

import java.util.ArrayList;
import java.util.List;

public class StudentEntity extends UserEntity {
	private int ID;
	private String group;
	
	public StudentEntity()
	{
		super();
	}
	
	public StudentEntity(String firstname, String lastname, String username, String password, String pnc, String address, String email, String group) {
		super(firstname, lastname, username, password, pnc, address, email);
		this.group=group;
	}
	
	public StudentEntity(String firstname, String lastname, String username, String password, String pnc, String address, String email, String group,int ID) {
		super(firstname, lastname, username, password, pnc, address, email);
		this.group=group;
		this.ID=ID;
	}

	public int getID() {
		return ID;
	}

	public void setID(int ID) {
		this.ID = ID;
	}

	public String getGroup() {
		return group;
	}

	public void setGroup(String group) {
		this.group = group;
	}

	@Override
	public String toString() {
		return "Student [ID=" + ID + ", group=" + group 
				+ ", getFirstname()=" + getFirstname() + ", getLastname()=" + getLastname() + ", getUsername()=" + getUsername()
				+ ", getPassword()=" + getPassword() + ", getPnc()=" + getPnc() + ", getAddress()=" + getAddress()
				+ ", getEmail()=" + getEmail() + ", getClass()=" + getClass() + ", hashCode()=" + hashCode()
				+ ", toString()=" + super.toString() + "]";
	}
	
	

}
