package presentationL;

import java.awt.BorderLayout;
import java.awt.EventQueue;
import java.util.List;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.JPasswordField;
import javax.swing.JScrollPane;
import javax.swing.JTable;
import javax.swing.border.EmptyBorder;
import data.Entities.*;

import business.Entities.*;
import business.Entities.CourseBLL;
import business.Entities.TeacherBLL;
import data.Entities.CourseEntity;
import data.Entities.TeacherEntity;
import data.DAO.TeacherDao;

import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.SwingConstants;
import javax.swing.JTextField;
import javax.swing.JButton;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;

public class TeacherUI extends JFrame {

	private JPanel contentPane;
	private JTextField textField_id;
	private JTextField textField_username;
	private JTextField textField_address;
	private JTextField textField_pnc;
	private JTextField textField_email;
	private JTextField textField_course;
	private JButton btnUpdateProfile;
	private JButton btnDelete;
	private JButton btnUpdate;
	private JButton buttonCourse;


	TeacherBLL teacherBLL = new TeacherBLL();
	CourseBLL courseBLL = new CourseBLL();
	StudentBLL studentBLL = new StudentBLL();
	EnrolmentBLL enrolmentBLL = new EnrolmentBLL();
	protected JPasswordField textField_firstname;
	protected JPasswordField textField_lastname;
	protected JPasswordField textField_password;
	public TeacherUI(TeacherEntity teacherentity) {
		setTitle("TeacherProfile");
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 450, 401);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		JLabel lblID = new JLabel("ID:");
		lblID.setBounds(21, 67, 46, 14);
		contentPane.add(lblID);
		
		JLabel lblUsername = new JLabel("Username:");
		lblUsername.setBounds(21, 117, 54, 14);
		contentPane.add(lblUsername);
		
		JLabel lblAddress = new JLabel("Address:");
		lblAddress.setHorizontalAlignment(SwingConstants.TRAILING);
		lblAddress.setBounds(21, 165, 46, 14);
		contentPane.add(lblAddress);
		
		JLabel lblPNC = new JLabel("PNC:");
		lblPNC.setBounds(250, 67, 46, 14);
		contentPane.add(lblPNC);
		
		JLabel lblEmail = new JLabel("E-mail:");
		lblEmail.setBounds(250, 117, 46, 14);
		contentPane.add(lblEmail);
		
		JLabel lblCourse = new JLabel("Course:");
		lblCourse.setBounds(250, 165, 46, 14);
		contentPane.add(lblCourse);
		
		textField_id = new JTextField();
		textField_id.setBounds(85, 64, 86, 20);
		contentPane.add(textField_id);
		textField_id.setColumns(10);
		
		textField_username = new JTextField();
		textField_username.setColumns(10);
		textField_username.setBounds(85, 114, 86, 20);
		contentPane.add(textField_username);
		
		textField_address = new JTextField();
		textField_address.setColumns(10);
		textField_address.setBounds(85, 162, 86, 20);
		contentPane.add(textField_address);
		
		textField_pnc = new JTextField();
		textField_pnc.setColumns(10);
		textField_pnc.setBounds(297, 64, 86, 20);
		contentPane.add(textField_pnc);
		
		textField_email = new JTextField();
		textField_email.setColumns(10);
		textField_email.setBounds(297, 114, 86, 20);
		contentPane.add(textField_email);
		
		textField_course = new JTextField();
		textField_course.setColumns(10);
		textField_course.setBounds(297, 162, 86, 20);
		contentPane.add(textField_course);
		
		JButton btnviewprofile = new JButton("View Profile");
		btnviewprofile.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				
				JLabel lblUsername = new JLabel("Username: "+teacherentity.getUsername());
				contentPane.add(lblUsername);
				
				JLabel lblAddress = new JLabel("Address: "+teacherentity.getAddress());
				contentPane.add(lblAddress);
				
				JLabel lblEmail = new JLabel("Email: "+teacherentity.getEmail());
				contentPane.add(lblEmail);
				
				JLabel lblCourse = new JLabel("Course: "+teacherentity.getCourse());
				contentPane.add(lblCourse);
				
				JLabel lblPNC = new JLabel("PNC: "+teacherentity.getPnc());
				contentPane.add(lblPNC);
				
				JLabel lblID = new JLabel("ID: "+teacherentity.getID());
				contentPane.add(lblID);
				
			}
		});
		btnviewprofile.setBounds(82, 213, 89, 23);
		contentPane.add(btnviewprofile);
		
		btnUpdateProfile = new JButton("Update profile");
		btnUpdateProfile.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				
				
				JLabel lblUsername = new JLabel("Username: ");
				contentPane.add(lblUsername);
				
				JTextField textField_username = new JTextField(teacherentity.getUsername());
				contentPane.add(textField_username);
				textField_username.setColumns(20);
				textField_username.setEditable(false);
				
				JLabel lblAddress = new JLabel("Address: ");
				contentPane.add(lblAddress);
				
				JTextField textField_address = new JTextField(teacherentity.getAddress());
				contentPane.add(textField_address);
				textField_address.setColumns(20);
				
				JLabel lblEmail = new JLabel("Email: ");
				contentPane.add(lblEmail);
				
				JTextField textField_email = new JTextField(teacherentity.getEmail());
				contentPane.add(textField_email);
				textField_email.setColumns(20);
				
				JLabel lblCourse = new JLabel("Course: ");
				contentPane.add(lblCourse);
				
				JTextField textField_course = new JTextField(teacherentity.getCourse());
				contentPane.add(textField_course);
				textField_course.setColumns(20);
				
				JLabel lblPNC = new JLabel("PNC: ");
				contentPane.add(lblPNC);
				
				JTextField textField_pnc = new JTextField(teacherentity.getPnc());
				contentPane.add(textField_pnc);
				textField_pnc.setColumns(20);
				
				JLabel lblFirstname = new JLabel("Firstname:");
				
				JTextField textField_firstname = new JTextField(teacherentity.getFirstname());
				contentPane.add(textField_firstname);
				textField_firstname.setColumns(20);
				
				JLabel lblLastname = new JLabel("Lastname:");
				contentPane.add(lblLastname);
				
				JTextField textField_lastname = new JTextField(teacherentity.getLastname());
				contentPane.add(textField_lastname);
				textField_lastname.setColumns(20);
				
				JLabel lblPassword = new JLabel("Password:");
				contentPane.add(lblPassword);
				
				JTextField textField_password = new JPasswordField();
				contentPane.add(textField_password);
				textField_password.setColumns(20);
				
				JLabel lblID = new JLabel("ID: ");
				contentPane.add(lblID);
				
				JTextField textField_id = new JTextField(Integer.toString(teacherentity.getID()));
				contentPane.add(textField_id);
				textField_id.setColumns(20);
				textField_id.setEditable(false);
				
			}
		});
		btnUpdateProfile.setBounds(193, 213, 89, 23);
		contentPane.add(btnUpdateProfile);
		
		btnUpdate = new JButton("Update");
		btnUpdate.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				
				teacherentity.setAddress(textField_address.getText());
				teacherentity.setEmail(textField_email.getText());
				teacherentity.setCourse(textField_course.getText());
				teacherentity.setPnc(textField_pnc.getText());
				teacherentity.setFirstname(textField_firstname.getText());
				teacherentity.setLastname(textField_lastname.getText());
				teacherentity.setPassword(textField_password.getText());
				
				if(teacherBLL.update(teacherentity))
				{
					JOptionPane.showMessageDialog(null, "Update done!");
				}
				else
				{
					JOptionPane.showMessageDialog(null, "ERROR!");
				}
			}
		});
		
		contentPane.add(btnUpdateProfile);
		
		btnDelete = new JButton("Delete");
		btnDelete.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				
				if(teacherBLL.delete(teacherentity.getID()))
				{
					JOptionPane.showMessageDialog(null, "Administrator deleted!");
					LoginUI login = new LoginUI();
					setVisible(false);
					login.setVisible(true);
				}
				else
				{
					JOptionPane.showMessageDialog(null, "ERROR!");
				}
			}
		});
		btnDelete.setBounds(310, 213, 89, 23);
		contentPane.add(btnDelete);
		
		buttonCourse = new JButton("Course");
		buttonCourse.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				List<CourseEntity> courses = courseBLL.getByidAdmin(teacherentity.getID());
				
				String[] columnNames = {"ID","Course name","Points"};
				
				String[][] data = new String[courses.size()][3];
				
				for (int i=0;i<courses.size();i++)
				{
					data[i][0]=Integer.toString(courses.get(i).getID());
					data[i][1]=courses.get(i).getName();
					data[i][2]=Integer.toString(courses.get(i).getPoints());
				}
				
				JTable table = new JTable(data,columnNames);
				
				JScrollPane sp = new JScrollPane(table);
				table.setVisible(true);
				
				table.setAutoResizeMode(JTable.AUTO_RESIZE_OFF);
				table.getColumnModel().getColumn(0).setPreferredWidth(30);
				table.getColumnModel().getColumn(1).setPreferredWidth(330);
				
				contentPane.add(sp);
				
				JButton courseInfo = new JButton("Curs info");
				contentPane.add(courseInfo);
				
				courseInfo.addActionListener(new ActionListener() {
					public void actionPerformed(ActionEvent e) {
						int row=table.getSelectedRow();
						CourseEntity course = new CourseEntity(Integer.parseInt((String)table.getValueAt(row, 0)),(String)table.getValueAt(row, 1),Integer.parseInt((String)table.getValueAt(row, 2)),teacherentity.getID());
						CourseUI courseInfo = new CourseUI(course);
						courseInfo.setVisible(true);
					}
				});
				
				JLabel text = new JLabel("Add course:");
				contentPane.add(text);
				
				JLabel lblName = new JLabel("Name: ");
				contentPane.add(lblName);
				
				JTextField textField_Name = new JTextField();
				contentPane.add(textField_Name);
				textField_Name.setColumns(20);
				
				JLabel lblPoints = new JLabel("Points: ");
				contentPane.add(lblPoints);
				
				JTextField textField_Points = new JTextField();
				contentPane.add(textField_Points);
				textField_Points.setColumns(20);
				
				JButton button = new JButton("Add");
				contentPane.add(button);
				
				button.addActionListener(new ActionListener() {
					public void actionPerformed(ActionEvent e) {
						CourseEntity course = new CourseEntity(textField_Name.getText(),Integer.parseInt(textField_Points.getText()),teacherentity.getID());
						int id = courseBLL.insert(course);
						
						if(id==-1)
						{
							JOptionPane.showMessageDialog(null, "ERROR!");
						}
						else
						{
							JOptionPane.showMessageDialog(null, "Succes, id:"+id);
						}
					}
					
				});
			}
		});
		buttonCourse.setBounds(85, 275, 89, 23);
		contentPane.add(buttonCourse);
		
		JButton btnLogout = new JButton("Logout");
		btnLogout.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				setVisible(false);
				LoginUI login = new LoginUI();
				login.setVisible(true);
			}
		});
		btnLogout.setBounds(193, 275, 89, 23);
		contentPane.add(btnLogout);
		
		
	}
}
