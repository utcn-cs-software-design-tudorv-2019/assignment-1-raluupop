package operationpackage;
import java.sql.ResultSet;
import java.sql.SQLException;

import javax.swing.JOptionPane;
import javax.swing.JTable;
import javax.swing.table.DefaultTableModel;

import com.mysql.jdbc.Connection;
import com.mysql.jdbc.PreparedStatement;

import dataaccesspackage.MyConnection;

public class Student {
	
	public void insertUpdateDeleteStudent(char operation, Integer id, String name, String birthday,
													String pnc, String adress)
	{
		Connection con = MyConnection.getConnection();
		PreparedStatement ps;
		
		//i for insert
		if (operation == 'i')
		{
			try {
				ps=(PreparedStatement) con.prepareStatement("INSERT INTO student(name, birthday, pnc, adress) VALUES (?, ?, ?, ?)");
				ps.setString(1, name);
				ps.setString(2, birthday);
				ps.setString(3, pnc);
				ps.setString(4, adress);
			
				if(ps.executeUpdate() > 0)
				{
					JOptionPane.showMessageDialog(null,"New StudentAdded!");
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
				ps=(PreparedStatement) con.prepareStatement("UPDATE `student` SET `name`= ?, `birthday`= ?, `pnc` = ?, `adress`= ? WHERE `id` = ? " );
				ps.setString(2, name);
				ps.setString(3, birthday);
				ps.setString(4, pnc);
				ps.setString(5, adress);
				ps.setInt(1, id);
			
				if(ps.executeUpdate() > 0)
				{
					JOptionPane.showMessageDialog(null,"Student Data Updated!");
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
						ps=(PreparedStatement) con.prepareStatement("DELETE FROM `student` WHERE `id` = ?" );
						
						ps.setInt(1, id);
					
						if(ps.executeUpdate() > 0)
						{
							JOptionPane.showMessageDialog(null,"Student Deleted!");
						}
						
					} catch (SQLException e) {
						// TODO Auto-generated catch block
						e.printStackTrace();
					}
					
				}
	}
	public void fillStudentJTABLE(JTable table, String valueToSearch)
	{
		Connection con = MyConnection.getConnection();
		PreparedStatement ps;
		
		try {
			
		ps=(PreparedStatement) con.prepareStatement("SELECT * FROM `student` WHERE CONCAT(`name`,`pnc`,`adress`) LIKE ?");
		ps.setString(1, "%"+valueToSearch+"%");
		
		ResultSet rs= ps.executeQuery();
		DefaultTableModel model=(DefaultTableModel) table.getModel();
		
		Object[] row;
		while(rs.next())
		{
			row = new Object[5];
			row[0]=rs.getInt(1);
			row[1]=rs.getString(2);
			row[2]=rs.getString(3);
			row[3]=rs.getString(4);
			row[4]=rs.getString(5);
			
			model.addRow(row);
		}
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
}
