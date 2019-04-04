package presentationL;

import java.awt.BorderLayout;
import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.JPasswordField;
import javax.swing.border.EmptyBorder;

import business.Entities.StudentBLL;
import business.Entities.TeacherBLL;
import data.Entities.StudentEntity;
import data.Entities.TeacherEntity;

import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JButton;
import javax.swing.JTextField;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;

public class LoginUI extends JFrame {

	private JPanel contentPane;
	private JTextField textField_username;
	private JTextField textField_password;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					LoginUI frame = new LoginUI();
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
	
	StudentBLL studentBLL=new StudentBLL();
	TeacherBLL teacherBLL = new TeacherBLL();
	
	public LoginUI() {
		setTitle("Login");
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 450, 300);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		JLabel lblUsername = new JLabel("Username: ");
		lblUsername.setBounds(43, 76, 76, 14);
		contentPane.add(lblUsername);
		
		JLabel lblPassword = new JLabel("Password: ");
		lblPassword.setBounds(43, 124, 76, 14);
		contentPane.add(lblPassword);
		
		JButton btnLogin = new JButton("Login");
		btnLogin.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				String username = textField_username.getText();
				String password = textField_password.getText();
				
				StudentEntity student = studentBLL.getByName(username);
				if(student!=null)
				{
					if(student.getPassword().equals(password))
					{
						JOptionPane.showMessageDialog(null, "Welcome!");
						StudentUI studentprofile = new StudentUI(student);
						setVisible(false);
						studentprofile.setVisible(true);
					}
					else
					{
						JOptionPane.showMessageDialog(null, "Incorect password!");
					}
				}
				else
				{
					TeacherEntity teacherentity = teacherBLL.getByName(username);
					if(teacherentity!=null)
					{
						if(teacherentity.getPassword().equals(password))
						{
							JOptionPane.showMessageDialog(null, "Welcome!");
							TeacherUI teacher = new TeacherUI(teacherentity);
							setVisible(false);
							teacher.setVisible(true);
						}
						else
						{
							JOptionPane.showMessageDialog(null, "Incorect password!");
						}
					}
					else
					{
						JOptionPane.showMessageDialog(null, "User inexistent!!!");
					}
				}
			}
		});
		btnLogin.setBounds(168, 174, 89, 23);
		contentPane.add(btnLogin);
		
		textField_username = new JTextField("");
		textField_username.setBounds(129, 73, 117, 20);
		contentPane.add(textField_username);
		textField_username.setColumns(10);
		
		textField_password = new JPasswordField("");
		textField_password.setColumns(10);
		textField_password.setBounds(129, 121, 117, 20);
		contentPane.add(textField_password);
	}
}
