package data.Entities;

import java.sql.Date;

public class EnrolmentEntity {
	private CourseEntity course;
	private Date startDate;
	private int grade;
	private int studentID;
	private int enrolmentID;
	
	public EnrolmentEntity(CourseEntity course, Date startDate, int grade) {
		super();
		this.course = course;
		this.startDate = startDate;
		this.grade = grade;
	}
	
	public EnrolmentEntity(CourseEntity course, Date startDate, int grade, int studentID) {
		super();
		this.course = course;
		this.startDate = startDate;
		this.grade = grade;
		this.studentID=studentID;
	}
	
	public EnrolmentEntity(CourseEntity course, Date startDate, int grade, int studentID, int enrolmentID) {
		super();
		this.course = course;
		this.startDate = startDate;
		this.grade = grade;
		this.studentID=studentID;
		this.enrolmentID=enrolmentID;
	}
	
	
	
	public CourseEntity getCourse() {
		return course;
	}

	public void setCourse(CourseEntity course) {
		this.course = course;
	}

	public int getGrade() {
		return grade;
	}

	public void setGrade(int grade) {
		this.grade = grade;
	}

	
	public Date getStartDate() {
		return startDate;
	}

	public void setStartDate(Date startDate) {
		this.startDate = startDate;
	}


	public int getStudentID() {
		return studentID;
	}

	public void setStudentID(int studentID) {
		this.studentID = studentID;
	}

	public int getEnrolmentID() {
		return enrolmentID;
	}

	public void setEnrolmentID(int enrolmentID) {
		this.enrolmentID = enrolmentID;
	}
	
	
}
