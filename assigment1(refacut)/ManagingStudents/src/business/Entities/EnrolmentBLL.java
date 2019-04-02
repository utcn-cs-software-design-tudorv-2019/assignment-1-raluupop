package business.Entities;

import java.sql.Date;
import java.util.List;

import data.DAO.EnrolmentDao;
import data.Entities.EnrolmentEntity;
public class EnrolmentBLL {
	
private EnrolmentDao enrolmentDAO;
	
	public EnrolmentBLL()
	{
		enrolmentDAO = new EnrolmentDao();
	}
	
	public int insert(int idStudent,int idCourse, Date startDate, int grade)
	{
		return enrolmentDAO.insert(idStudent, idCourse,startDate,grade);
	}
	
	public List<EnrolmentEntity> getById(int id)
	{
		return enrolmentDAO.getById(id);
	}
	
	public List<EnrolmentEntity> getByIdCourse(int id)
	{
		return enrolmentDAO.getByIdCourse(id);
	}
	
	public void update (int id, int grade) {
		enrolmentDAO.update(id, grade);
	}
}
