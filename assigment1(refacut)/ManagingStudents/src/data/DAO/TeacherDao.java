package data.DAO;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.logging.Logger;

import connectionDB.ConnectionDB;
import data.Entities.TeacherEntity;

public class TeacherDao {
	protected static final Logger LOGGER = Logger.getLogger(StudentDao.class.getName());
	private static final String insertStatementString = "INSERT INTO administrator (firstname,lastname,username,password,pnc,address,email,course)" + " VALUES (?,?,?,?,?,?,?,?)";
	private final static String updateStatementString = "UPDATE administrator SET firstname=?,lastname=?,username=?,password=?,pnc=?,address=?,email=?,course=?" + " WHERE idAdministrator=?";
	private final static String selectStatementString = "SELECT * From administrator where username=?";
	private final static String deleteStatementString = "DELETE from administrator where idTeacher=?";
	
	public int insert(TeacherEntity teacher) {
		Connection dbConnection = ConnectionDB.getConnection();
		PreparedStatement insertStatement = null;
		int new_id=-1;
		try {
			insertStatement = dbConnection.prepareStatement(insertStatementString, Statement.RETURN_GENERATED_KEYS);
			
			insertStatement.setString(1,teacher.getFirstname());
			insertStatement.setString(2, teacher.getLastname());
			insertStatement.setString(3, teacher.getUsername());
			insertStatement.setString(4, teacher.getPassword());
			insertStatement.setString(5, teacher.getPnc());
			insertStatement.setString(6, teacher.getAddress());
			insertStatement.setString(7, teacher.getEmail());
			insertStatement.setString(8, teacher.getCourse());
			
			insertStatement.executeUpdate();
			
			ResultSet rs = insertStatement.getGeneratedKeys();
			if (rs.next()) {
				new_id = rs.getInt(1);
			}
		} catch (SQLException e) {
		
			e.printStackTrace();
		} finally {
			ConnectionDB.close(insertStatement);
			ConnectionDB.close(dbConnection);
		}
		return new_id;
	}
	
	public TeacherEntity getByName(String name)
	{
		TeacherEntity rezultat=null;
		Connection dbConnection = ConnectionDB.getConnection();
		PreparedStatement finderStatement = null;
		try {
			ResultSet rs = null;
			finderStatement = dbConnection.prepareStatement(selectStatementString, Statement.RETURN_GENERATED_KEYS);
			
			finderStatement.setString(1,name);
			
			rs = finderStatement.executeQuery();
			rs.next();
			
			rezultat = new TeacherEntity(rs.getString("firstname"),rs.getString("lastname"),rs.getString("username"),rs.getString("password"),rs.getString("pnc"),rs.getString("address"),rs.getString("email"),rs.getString("course"),rs.getInt("idTeacher"));
			
		} catch (SQLException e) {
			
		} finally {
			
			ConnectionDB.close(finderStatement);
			ConnectionDB.close(dbConnection);
		}
		return rezultat;
	}
	
	public boolean update(TeacherEntity teacher)
	{
		Connection dbConnection = ConnectionDB.getConnection();
		PreparedStatement updateStatement = null;	
		int ID = teacher.getID();

		try {			
			updateStatement = dbConnection.prepareStatement(updateStatementString, Statement.RETURN_GENERATED_KEYS);		
			updateStatement.setString(1,teacher.getFirstname());
			updateStatement.setString(2,teacher.getLastname());
			updateStatement.setString(3,teacher.getUsername());
			updateStatement.setString(4,teacher.getPassword());
			updateStatement.setString(5,teacher.getPnc());
			updateStatement.setString(6,teacher.getAddress());
			updateStatement.setString(7,teacher.getEmail());
			updateStatement.setString(8,teacher.getCourse());
			updateStatement.setInt(9,ID);		
			updateStatement.executeUpdate();
			return true;
		}
		catch(SQLException e)
		{
			
			e.printStackTrace();
			return false;
	    } finally {
		 ConnectionDB.close(updateStatement);
		 ConnectionDB.close(dbConnection);
	    }
	}
	
	public boolean delete(int adminID){
		Connection dbConnection = ConnectionDB.getConnection();
		PreparedStatement deleteStatement = null;
		
		try {
			deleteStatement = dbConnection.prepareStatement(deleteStatementString);
			deleteStatement.setInt(1, adminID);
			deleteStatement.executeUpdate();
			return true;
		}
		catch(SQLException e)
		 {
			
			e.printStackTrace();
			 return false;
	     } finally {
		  ConnectionDB.close(deleteStatement);
		  ConnectionDB.close(dbConnection);
	    }
	}
}
