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

//import data.entities.Course;
//import data.entities.Enrolment;

import connectionDB.ConnectionDB;
import data.Entities.StudentEntity;

public class StudentDao {
	protected static final Logger LOGGER = Logger.getLogger(StudentDao.class.getName());
	private static final String insertStatementString = "INSERT INTO student (firstname,lastname,username,password,pnc,address,email,group)" + " VALUES (?,?,?,?,?,?,?,?)";
	private final static String updateStatementString = "UPDATE student SET firstname=?,lastname=?,username=?,password=?,pnc=?,address=?,email=?,group=?" + " WHERE idStudent=?";
	private final static String selectStatementString = "SELECT * From student where username=?";
	private final static String deleteStatementString = "DELETE from student where idStudent=?";
	private final static String selectByID = "SELECT * from student where idStudent=?";
	private final static String getAll = "SELECT * from student";
	
	public int insert(StudentEntity student) {
		Connection dbConnection = ConnectionDB.getConnection();
		PreparedStatement insertStatement = null;
		int new_id=-1;
		try {
			insertStatement = dbConnection.prepareStatement(insertStatementString, Statement.RETURN_GENERATED_KEYS);
			
			insertStatement.setString(1,student.getFirstname());
			insertStatement.setString(2, student.getLastname());
			insertStatement.setString(3, student.getUsername());
			insertStatement.setString(4, student.getPassword());
			insertStatement.setString(5, student.getPnc());
			insertStatement.setString(6, student.getAddress());
			insertStatement.setString(7, student.getEmail());
			insertStatement.setString(8, student.getGroup());
			
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
	
	public StudentEntity getByName(String name)
	{
		StudentEntity rezultat=null;
		Connection dbConnection = ConnectionDB.getConnection();
		PreparedStatement finderStatement = null;
		try {
			ResultSet rs = null;
			finderStatement = dbConnection.prepareStatement(selectStatementString, Statement.RETURN_GENERATED_KEYS);
			
			finderStatement.setString(1,name);
			rs = finderStatement.executeQuery();
			rs.next();
			
			rezultat = new StudentEntity(rs.getString("firstname"),rs.getString("lastname"),rs.getString("username"),rs.getString("password"),rs.getString("pnc"),rs.getString("address"),rs.getString("email"),rs.getString("group"),rs.getInt("idStudent"));
			
		} catch (SQLException e) {
			
		} finally {
			
			ConnectionDB.close(finderStatement);
			ConnectionDB.close(dbConnection);
		}
		return rezultat;
	}
	
	public StudentEntity getByID(int id)
	{
		StudentEntity rezultat=null;
		Connection dbConnection = ConnectionDB.getConnection();
		PreparedStatement finderStatement = null;
		try {
			ResultSet rs = null;
			finderStatement = dbConnection.prepareStatement(selectByID, Statement.RETURN_GENERATED_KEYS);
			
			finderStatement.setInt(1,id);
			rs = finderStatement.executeQuery();
			rs.next();
			
			rezultat = new StudentEntity(rs.getString("firstname"),rs.getString("lastname"),rs.getString("username"),rs.getString("password"),rs.getString("pnc"),rs.getString("address"),rs.getString("email"),rs.getString("group"),rs.getInt("idStudent"));
			
		} catch (SQLException e) {
			LOGGER.log(Level.WARNING, "StudentDao:insert " + e.getMessage());
		} finally {
			
			ConnectionDB.close(finderStatement);
			ConnectionDB.close(dbConnection);
		}
		return rezultat;
	}
	
	public boolean update(StudentEntity student)
	{
		Connection dbConnection = ConnectionDB.getConnection();
		PreparedStatement updateStatement = null;	
		int ID = student.getID();

		try {			
			updateStatement = dbConnection.prepareStatement(updateStatementString, Statement.RETURN_GENERATED_KEYS);		
			updateStatement.setString(1,student.getFirstname());
			updateStatement.setString(2,student.getLastname());
			updateStatement.setString(3,student.getUsername());
			updateStatement.setString(4,student.getPassword());
			updateStatement.setString(5,student.getPnc());
			updateStatement.setString(6,student.getAddress());
			updateStatement.setString(7,student.getEmail());
			updateStatement.setString(8, student.getGroup());
			updateStatement.setInt(9,ID);		
			updateStatement.executeUpdate();
			return true;
		}
		catch(SQLException e)
		{
			LOGGER.log(Level.WARNING, "StudentDao:update " + e.getMessage());
			return false;
	    } finally {
		 ConnectionDB.close(updateStatement);
		 ConnectionDB.close(dbConnection);
	    }	
	}
	
	public boolean delete(int ID){
		Connection dbConnection = ConnectionDB.getConnection();
		PreparedStatement deleteStatement = null;
		
		try {
			deleteStatement = dbConnection.prepareStatement(deleteStatementString);
			deleteStatement.setInt(1, ID);
			deleteStatement.executeUpdate();
			return true;
		}
		catch(SQLException e)
		 {
			 LOGGER.log(Level.WARNING, "StudentDao:delete " + e.getMessage());
			 return false;
	     } finally {
		  ConnectionDB.close(deleteStatement);
		  ConnectionDB.close(dbConnection);
	    }
	}
	
	public List<StudentEntity> getAll()
	{
		List<StudentEntity> rez = new ArrayList<StudentEntity>();

		Connection dbConnection = ConnectionDB.getConnection();
		PreparedStatement finderStatement = null;
		try {
			ResultSet rs = null;
			finderStatement = dbConnection.prepareStatement(getAll, Statement.RETURN_GENERATED_KEYS);
			
			rs = finderStatement.executeQuery();
			
			while (rs.next())
			{
			
				StudentEntity student = new StudentEntity(rs.getString("firstname"),rs.getString("lastname"),rs.getString("username"),rs.getString("password"),rs.getString("pnc"),rs.getString("address"),rs.getString("email"),rs.getString("group"),rs.getInt("idStudent"));
				rez.add(student);
			}
			
		} catch (SQLException e) {
			LOGGER.log(Level.WARNING, "StudentDao:getAll " + e.getMessage());
		} finally {
			
			ConnectionDB.close(finderStatement);
			ConnectionDB.close(dbConnection);
		}
		
		return rez;
	}
}
