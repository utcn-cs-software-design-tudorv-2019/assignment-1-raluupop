package data.DAO;

import java.sql.Connection;
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


public class CourseDao {
	protected static final Logger LOGGER = Logger.getLogger(StudentDao.class.getName());
	private static final String getAllStatementString = "Select * from course";
	private static final String getByidAdminStatementString = "Select * from course where idTeacher=?";
	private static final String insertStatementString = "INSERT INTO course (idTeacher,name,points)" + " VALUES (?,?,?)";
	
	public int insert(CourseEntity course)
	{
		Connection dbConnection = ConnectionDB.getConnection();
		PreparedStatement insertStatement = null;
		int new_id=-1;
		try {
			insertStatement = dbConnection.prepareStatement(insertStatementString, Statement.RETURN_GENERATED_KEYS);
			
			insertStatement.setInt(1,course.getIdTeacher());
			insertStatement.setString(2,course.getName());
			insertStatement.setInt(3,course.getPoints());
			
			insertStatement.executeUpdate();
			
			ResultSet rs = insertStatement.getGeneratedKeys();
			if (rs.next()) {
				new_id = rs.getInt(1);
			}
		} catch (SQLException e) {
			LOGGER.log(Level.WARNING, "CourseDAO:insert " + e.getMessage());
		} finally {
			ConnectionDB.close(insertStatement);
			ConnectionDB.close(dbConnection);
		}
		return new_id;
	}
	
	public List<CourseEntity> getAll()
	{		
		Connection dbConnection = ConnectionDB.getConnection();
		PreparedStatement findAllStatement = null;
        ResultSet rs = null;
        
        List<CourseEntity> courses = new ArrayList<CourseEntity>();
		
		try {
			findAllStatement = dbConnection.prepareStatement(getAllStatementString);
			rs = findAllStatement.executeQuery();
			
			while(rs.next())
			{   
				CourseEntity course = new CourseEntity(rs.getInt("idCourse"),rs.getString("name"),rs.getInt("points"),rs.getInt("idTeacher"));
			    courses.add(course);
			}		
		} catch (SQLException e) {
			LOGGER.log(Level.WARNING,"CourseDao:findAll " + e.getMessage());
		} finally {
			ConnectionDB.close(rs);
			ConnectionDB.close(findAllStatement);
			ConnectionDB.close(dbConnection);
		}
     
		return courses;
	}
	
	public List<CourseEntity> getByidAdmin(int id){
		Connection dbConnection = ConnectionDB.getConnection();
		PreparedStatement getByidStatement=null;
		ResultSet rs = null;
		
		List<CourseEntity> courses = new ArrayList<CourseEntity>();
		
		try {
			getByidStatement = dbConnection.prepareStatement(getByidAdminStatementString);
			getByidStatement.setInt(1, id);
			rs = getByidStatement.executeQuery();
			
			while(rs.next())
			{   
				CourseEntity course = new CourseEntity(rs.getInt("idCourse"),rs.getString("name"),rs.getInt("points"),rs.getInt("idTeacher"));
			    courses.add(course);
			}		
		} catch (SQLException e) {
			LOGGER.log(Level.WARNING,"CourseDao:findAll " + e.getMessage());
		} finally {
			ConnectionDB.close(rs);
			ConnectionDB.close(getByidStatement);
			ConnectionDB.close(dbConnection);
		}
		
		return courses;
	}
}
