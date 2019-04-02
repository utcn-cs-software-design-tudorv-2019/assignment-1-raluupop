package business.Entities;

import data.DAO.TeacherDao;
import data.Entities.TeacherEntity;

public class TeacherBLL {
	private TeacherDao teacherDAO;
	
	public TeacherBLL() {
		teacherDAO = new TeacherDao();
	}
	
	public int insert(TeacherEntity teacher){
		return teacherDAO.insert(teacher);
	}
	
	public TeacherEntity  getByName(String name)
	{
		return teacherDAO.getByName(name);
	}
	
	public  boolean update(TeacherEntity  teacher)
	{
		return teacherDAO.update(teacher);
	}
	
	public boolean delete(int teacherID) {
		return teacherDAO.delete(teacherID);
	}
}
