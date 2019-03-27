package operationpackage;
import java.sql.ResultSet;
import java.sql.SQLException;

import javax.swing.JOptionPane;
import javax.swing.JTable;
import javax.swing.table.DefaultTableModel;

import com.mysql.jdbc.Connection;
import com.mysql.jdbc.PreparedStatement;

import dataaccesspackage.MyConnection;

public class Course {
	public void insertUpdateDeleteStudent(char operation, Integer id, String label)
{
Connection con = MyConnection.getConnection();
PreparedStatement ps;

//i for insert
if (operation == 'i')
{
try {
ps=(PreparedStatement) con.prepareStatement("INSERT INTO `course` (`lable`) VALUES (?)");
ps.setString(1, label);


if(ps.executeUpdate() > 0)
{
JOptionPane.showMessageDialog(null,"New Course Added!");
}

} catch (SQLException e) {
// TODO Auto-generated catch block
e.printStackTrace();
}

}

//u for update
if (operation == 'u')
{
try {
ps=(PreparedStatement) con.prepareStatement("UPDATE `course` SET `lable` = ? WHERE `id` = ?" );
ps.setString(1, label);
ps.setInt(2, id);

if(ps.executeUpdate() > 0)
{
JOptionPane.showMessageDialog(null,"Course Data Updated!");
}

} catch (SQLException e) {
// TODO Auto-generated catch block
e.printStackTrace();
}

}

//d for delete
if (operation == 'd')
{
try {
ps=(PreparedStatement) con.prepareStatement("DELETE FROM `course` WHERE `id` = ?");

ps.setInt(1, id);

if(ps.executeUpdate() > 0)
{
JOptionPane.showMessageDialog(null, "Course Deleted!");
}

} catch (SQLException e) {
// TODO Auto-generated catch block
e.printStackTrace();
}

}
}
	public boolean isCourseExist(String courseName)
	{
		boolean isExist=false;
		Connection con = MyConnection.getConnection();
		PreparedStatement ps;
		
		try {
			
		ps=(PreparedStatement) con.prepareStatement("SELECT * FROM `course` WHERE `lable` = ?");
		ps.setString(1, courseName);
		
		ResultSet rs= ps.executeQuery();
		
		if(rs.next())
		{
			
			isExist= true;
			
		}
		
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		return isExist;
	}
	public void fillCourseJTABLE(JTable table)
	{
		Connection con = MyConnection.getConnection();
		PreparedStatement ps;
		
		try {
			
		ps=(PreparedStatement) con.prepareStatement("SELECT * FROM `course`");
		
		
		ResultSet rs= ps.executeQuery();
		DefaultTableModel model=(DefaultTableModel) table.getModel();
		
		Object[] row;
		while(rs.next())
		{
			row = new Object[2];
			row[0]=rs.getInt(1);
			row[1]=rs.getString(2);
			
			
			model.addRow(row);
		}
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
}
