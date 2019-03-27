package presentationpackage;
import java.awt.BorderLayout;
import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;

import com.mysql.jdbc.Connection;
import com.mysql.jdbc.PreparedStatement;

import dataaccesspackage.MyConnection;

import java.awt.Label;
import java.awt.TextField;
import java.awt.Button;
import java.awt.event.ActionListener;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.awt.event.ActionEvent;

public class LoginForm extends JFrame {

	private JPanel contentPane;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					LoginForm frame = new LoginForm();
					frame.setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}

	/**
	 * Create the frame.
	 */
	public LoginForm() {
		
		
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 450, 300);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		Label loginForm = new Label("Login Form");
		loginForm.setBounds(150, 21, 94, 49);
		contentPane.add(loginForm);
		
		Label username = new Label("Username: ");
		username.setBounds(32, 94, 62, 22);
		contentPane.add(username);
		
		
		Label password = new Label("Password:");
		password.setBounds(32, 145, 62, 22);
		contentPane.add(password);
		
		
		TextField textUsername = new TextField();
		textUsername.setBounds(123, 94, 121, 22);
		contentPane.add(textUsername);
		
		TextField testPassword = new TextField();
		testPassword.setBounds(123, 145, 121, 22);
		contentPane.add(testPassword);
		
		Button buttonLogin = new Button("Login");
		buttonLogin.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent evt) {
			
				Connection con =MyConnection.getConnection();
				PreparedStatement ps;
				try {
					ps=(PreparedStatement) con.prepareStatement("SELECT * FROM user WHERE username = ? AND password = ?");
					ps.setString(1, textUsername.getText());
					ps.setString(2, String.valueOf(testPassword.getText()));
					
					ResultSet rs=ps.executeQuery();
					
					if(rs.next())
						
					{
						AddForm af = new AddForm();
						af.setVisible(true);
						af.pack();
						af.setLocationRelativeTo(null);
						
					}
					else
					{
						System.out.println("NO");
					}
				
				} catch (SQLException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}		}
		
		});
		buttonLogin.setBounds(174, 186, 70, 22);
		contentPane.add(buttonLogin);
	}
}
