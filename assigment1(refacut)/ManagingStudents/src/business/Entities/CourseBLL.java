package business.Entities;

import java.util.List;

import data.DAO.CourseDao;
import data.Entities.CourseEntity;

public class CourseBLL {
	
private CourseDao courseDAO;
	
	public CourseBLL()
	{
		courseDAO = new CourseDao();
	}
	
	public int insert(CourseEntity course)
	{
		return courseDAO.insert(course);
	}
	
	public List<CourseEntity> getAll()
	{
		return courseDAO.getAll();
	}
	
	public List<CourseEntity> getByidAdmin(int id)
	{
		return courseDAO.getByidAdmin(id);
	}
}
