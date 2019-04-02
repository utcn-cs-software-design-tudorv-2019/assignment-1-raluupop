package data.Entities;

public class CourseEntity {
	private int ID;
	private String name;
	private int points;
	private int idTeacher;
	
	public CourseEntity(int ID, String name, int points, int idTeacher) {
		super();
		this.ID = ID;
		this.name = name;
		this.points = points;
		this.idTeacher=idTeacher;
	}
	
	public CourseEntity(String name, int points, int idTeacher) {
		super();
		this.name = name;
		this.points = points;
		this.idTeacher=idTeacher;
	}

	public int getID() {
		return ID;
	}

	public void setID(int iD) {
		ID = iD;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public int getPoints() {
		return points;
	}

	public void setPoints(int points) {
		this.points = points;
	}

	public int getIdTeacher() {
		return idTeacher;
	}

	public void setIdTeacher(int idTeacher) {
		this.idTeacher = idTeacher;
	}

	
	
	
}
