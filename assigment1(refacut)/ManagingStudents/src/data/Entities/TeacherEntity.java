package data.Entities;

import java.util.ArrayList;
import java.util.List;

public class TeacherEntity extends UserEntity{
	
	private int ID;
	private String course;
	
	public TeacherEntity(String firstname, String lastname, String username, String password, String pnc, String address,
			String email, String course) {
		super(firstname, lastname, username, password, pnc, address, email);
		this.course = course;
	}
	
	public TeacherEntity(String firstname, String lastname, String username, String password, String pnc, String address,
			String email, String course, int ID) {
		super(firstname, lastname, username, password, pnc, address, email);
		this.course = course;
		this.ID=ID;
	}

	public int getID() {
		return ID;
	}

	public void setID(int ID) {
		this.ID = ID;
	}

	public String getCourse() {
		return course;
	}

	public void setCourse(String course) {
		this.course = course;
	}
	
}
