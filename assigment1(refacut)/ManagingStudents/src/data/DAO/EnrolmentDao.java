package data.DAO;

import java.sql.Connection;
import java.sql.Date;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;

import connectionDB.ConnectionDB;
import data.Entities.CourseEntity;
import data.Entities.EnrolmentEntity;


public class EnrolmentDao {
	protected static final Logger LOGGER = Logger.getLogger(StudentDao.class.getName());
	private static final String insertStatementString = "INSERT INTO enrollment (idStudent, idCourse, startDate, nota)" + " VALUES (?,?,?,?)";
	private static final String getByIdStudentStatementString = "SELECT * from enrollment where idStudent=?";
	private static final String getByIdCourseStatementString = "SELECT * from enrollment where idCourse=?";
	private final static String updateStatementString = "UPDATE enrollment SET grade=?" + " WHERE idEnrollment=?";
	
	public int insert(int idStudent,int idCourse, Date startDate, int grade) {
		Connection dbConnection = ConnectionDB.getConnection();
		PreparedStatement insertStatement = null;
		int new_id=-1;
		try {
			insertStatement = dbConnection.prepareStatement(insertStatementString, Statement.RETURN_GENERATED_KEYS);
			
			insertStatement.setInt(1, idStudent);
			insertStatement.setInt(2,idCourse);
			insertStatement.setDate(3, startDate);
			insertStatement.setInt(4, grade);
			
			insertStatement.executeUpdate();
			
			ResultSet rs = insertStatement.getGeneratedKeys();
			if (rs.next()) {
				new_id = rs.getInt(1);
			}
		} catch (SQLException e) {
			LOGGER.log(Level.WARNING, "StudentDao:insert " + e.getMessage());
		} finally {
			ConnectionDB.close(insertStatement);
			ConnectionDB.close(dbConnection);
		}
		return new_id;
	}
	
	public List<EnrolmentEntity> getById(int id)
	{
		List<EnrolmentEntity> rez = new ArrayList<EnrolmentEntity>();

		Connection dbConnection = ConnectionDB.getConnection();
		PreparedStatement finderStatement = null;
		PreparedStatement finderStatement2 = null;
		try {
			ResultSet rs = null;
			ResultSet rs2 = null;
			finderStatement = dbConnection.prepareStatement(getByIdStudentStatementString, Statement.RETURN_GENERATED_KEYS);
			finderStatement.setInt(1,id);
			rs = finderStatement.executeQuery();
			
			while (rs.next())
			{
				finderStatement2 = dbConnection.prepareStatement("select * from course where idCourse="+rs.getInt("idCourse"),Statement.RETURN_GENERATED_KEYS);
				rs2 = finderStatement2.executeQuery();
				rs2.next();
				CourseEntity course = new CourseEntity(rs2.getInt("idCourse"),rs2.getString("name"),rs2.getInt("points"),rs2.getInt("idTeacher"));
				EnrolmentEntity rezultat = new EnrolmentEntity(course,rs.getDate("startDate"),rs.getInt("grade"),rs.getInt("idStudent"));
				rez.add(rezultat);
			}
			
		} catch (SQLException e) {
			LOGGER.log(Level.WARNING, "StudentDao:insert " + e.getMessage());
		} finally {
			
			ConnectionDB.close(finderStatement);
			ConnectionDB.close(finderStatement2);
			ConnectionDB.close(dbConnection);
		}
		
		return rez;
	}
	
	public List<EnrolmentEntity> getByIdCourse(int id)
	{
		List<EnrolmentEntity> rez = new ArrayList<EnrolmentEntity>();

		Connection dbConnection = ConnectionDB.getConnection();
		PreparedStatement finderStatement = null;
		PreparedStatement finderStatement2 = null;
		try {
			ResultSet rs = null;
			ResultSet rs2 = null;
			finderStatement = dbConnection.prepareStatement(getByIdCourseStatementString, Statement.RETURN_GENERATED_KEYS);
			finderStatement.setInt(1,id);
			rs = finderStatement.executeQuery();
			
			while (rs.next())
			{
				finderStatement2 = dbConnection.prepareStatement("select * from course where idCourse="+rs.getInt("idCourse"),Statement.RETURN_GENERATED_KEYS);
				rs2 = finderStatement2.executeQuery();
				rs2.next();
				CourseEntity course = new CourseEntity(rs2.getInt("idCourse"),rs2.getString("name"),rs2.getInt("points"),rs2.getInt("idTeacher"));
				EnrolmentEntity rezultat = new EnrolmentEntity(course,rs.getDate("startDate"),rs.getInt("grade"),rs.getInt("idStudent"),rs.getInt("idEnrollment"));
				rez.add(rezultat);
			}
			
		} catch (SQLException e) {
			LOGGER.log(Level.WARNING, "StudentDao:insert " + e.getMessage());
		} finally {
			
			ConnectionDB.close(finderStatement);
			ConnectionDB.close(finderStatement2);
			ConnectionDB.close(dbConnection);
		}
		
		return rez;
	}
	
	public void update (int id, int grade) {
		Connection dbConnection = ConnectionDB.getConnection();
		PreparedStatement updateStatement = null;	

		try {			
			updateStatement = dbConnection.prepareStatement(updateStatementString, Statement.RETURN_GENERATED_KEYS);		
			updateStatement.setInt(1,grade);
			updateStatement.setInt(2, id);
			updateStatement.executeUpdate();
		}
		catch(SQLException e)
		{
			LOGGER.log(Level.WARNING, "StudentDao:update " + e.getMessage());
		
	    } finally {
		 ConnectionDB.close(updateStatement);
		 ConnectionDB.close(dbConnection);
	    }	
	}
}
