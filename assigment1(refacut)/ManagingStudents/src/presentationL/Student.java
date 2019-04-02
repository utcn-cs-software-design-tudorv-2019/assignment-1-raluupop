package presentationL;

import java.awt.BorderLayout;
import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.JPasswordField;
import javax.swing.border.EmptyBorder;

import business.Entities.CourseBLL;
import business.Entities.EnrolmentBLL;
import business.Entities.StudentBLL;
import data.Entities.StudentEntity;
import javax.swing.JLabel;
import javax.swing.SwingConstants;
import javax.swing.JTextField;
import javax.swing.JButton;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;
import javax.swing.JOptionPane;
import java.util.List;

import javax.swing.JScrollPane;
import javax.swing.JTable;
import data.Entities.CourseEntity;
import business.Entities.*;
import java.text.SimpleDateFormat;
import java.sql.Date;
import data.Entities.*;
public class Student extends JFrame {

	private JPanel contentPane;
	StudentBLL studentBLL = new StudentBLL();
	CourseBLL courseBLL = new CourseBLL();
	EnrolmentBLL enrolmentBLL = new EnrolmentBLL();
	private JTextField textField_id;
	private JTextField textField_username;
	private JTextField textField_adress;
	private JTextField textField_pnc;
	private JTextField textField_email;
	private JTextField textField_course;

	
	public Student(StudentEntity student) {
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 499, 381);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		JPanel panel = new JPanel();
		panel.setLayout(null);
		panel.setBorder(new EmptyBorder(5, 5, 5, 5));
		panel.setBounds(25, 11, 437, 329);
		contentPane.add(panel);
		
		JLabel labelID = new JLabel("ID:");
		labelID.setBounds(21, 67, 46, 14);
		panel.add(labelID);
		
		JLabel label_username = new JLabel("Username:");
		label_username.setBounds(21, 117, 54, 14);
		panel.add(label_username);
		
		JLabel label_address = new JLabel("Address:");
		label_address.setHorizontalAlignment(SwingConstants.TRAILING);
		label_address.setBounds(21, 165, 46, 14);
		panel.add(label_address);
		
		JLabel label_pnc = new JLabel("PNC:");
		label_pnc.setBounds(250, 67, 46, 14);
		panel.add(label_pnc);
		
		JLabel label_email = new JLabel("E-mail:");
		label_email.setBounds(250, 117, 46, 14);
		panel.add(label_email);
		
		JLabel label_course = new JLabel("Course:");
		label_course.setBounds(250, 165, 46, 14);
		panel.add(label_course);
		
		textField_username = new JTextField();
		textField_username.setColumns(10);
		textField_username.setBounds(85, 114, 86, 20);
		panel.add(textField_username);
		
		textField_adress = new JTextField();
		textField_adress.setColumns(10);
		textField_adress.setBounds(85, 162, 86, 20);
		panel.add(textField_adress);
		
		textField_pnc = new JTextField();
		textField_pnc.setColumns(10);
		textField_pnc.setBounds(297, 64, 86, 20);
		panel.add(textField_pnc);
		
		textField_email = new JTextField();
		textField_email.setColumns(10);
		textField_email.setBounds(297, 114, 86, 20);
		panel.add(textField_email);
		
		textField_course = new JTextField();
		textField_course.setColumns(10);
		textField_course.setBounds(297, 162, 86, 20);
		panel.add(textField_course);
		
		
		JButton button_delete = new JButton("Delete");
		button_delete.setBounds(310, 213, 89, 23);
		panel.add(button_delete);
		
		JButton button_course = new JButton("Course");
		button_course.setBounds(85, 275, 89, 23);
		panel.add(button_course);
		
		JButton button_logout = new JButton("Logout");
		button_logout.setBounds(193, 275, 89, 23);
		panel.add(button_logout);
		
		textField_id = new JTextField();
		textField_id.setBounds(85, 64, 86, 20);
		panel.add(textField_id);
		textField_id.setColumns(10);
		
		JButton button_view = new JButton("View Profile");
		button_view.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				
				JLabel label_username = new JLabel("Username: "+student.getUsername());
				contentPane.add( label_username);
				
				JLabel label_address = new JLabel("Address: "+student.getAddress());
				contentPane.add(label_address);
				
				JLabel label_email = new JLabel("Email: "+student.getEmail());
				contentPane.add(label_email);
				
				JLabel label_group = new JLabel("Course: "+student.getGroup());
				contentPane.add(label_group);
				
				JLabel label_pnc = new JLabel("PNC: "+student.getPnc());
				contentPane.add(label_pnc);
				
				JLabel labelID = new JLabel("ID: "+student.getID());
				contentPane.add(labelID);
			}
		});
		button_view.setBounds(82, 213, 89, 23);
		panel.add(button_view);
		
		JButton button_updateprofile = new JButton("Update profile");
		button_updateprofile.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				JLabel lblUsername = new JLabel("Username: ");
				contentPane.add(lblUsername);
				
				JTextField textField_username = new JTextField(student.getUsername());
				contentPane.add(textField_username);
				textField_username.setColumns(20);
				textField_username.setEditable(false);
				
				JLabel label_address = new JLabel("Address: ");
				contentPane.add(label_address);
				
				JTextField textField_address = new JTextField(student.getAddress());
				contentPane.add(textField_address);
				textField_address.setColumns(20);
				
				JLabel label_email = new JLabel("Email: ");
				contentPane.add(label_email);
				
				JTextField textField_email = new JTextField(student.getEmail());
				contentPane.add(textField_email);
				textField_email.setColumns(20);
				
				JLabel label_group = new JLabel("Course: ");
				contentPane.add(label_group);
				
				JTextField textField_group = new JTextField(student.getGroup());
				contentPane.add(textField_group);
				textField_group.setColumns(20);
				
				JLabel label_pnc = new JLabel("PNC: ");
				contentPane.add(label_pnc);
				
				JTextField textField_pnc = new JTextField(student.getPnc());
				contentPane.add(textField_pnc);
				textField_pnc.setColumns(20);
				
				JLabel label_firstname = new JLabel("Firstname:");
				
				JTextField textField_firstname = new JTextField(student.getFirstname());
				contentPane.add(textField_firstname);
				textField_firstname.setColumns(20);
				
				JLabel label_lastname=new JLabel("Lastname:");
				contentPane.add(label_lastname);	
				JTextField textField_lastname = new JTextField(student.getLastname());
				contentPane.add(textField_lastname);
				textField_lastname.setColumns(20);
				
				JLabel label_password = new JLabel("Password:");
				contentPane.add(label_password);
				
				JTextField textField_password = new JPasswordField();
				contentPane.add(textField_password);
				textField_password.setColumns(20);
				
				JLabel label_ID = new JLabel("ID: ");
				contentPane.add(label_ID);
				
				JTextField textField_id = new JTextField(Integer.toString(student.getID()));
				contentPane.add(textField_id);
				textField_id.setColumns(20);
				textField_id.setEditable(false);
				button_updateprofile.setBounds(193, 213, 89, 23);
				panel.add(button_updateprofile);
				
				JButton update = new JButton("Update");
				contentPane.add(update);
				
				update.addActionListener(new ActionListener() {
					public void actionPerformed(ActionEvent e)
					{
						student.setAddress(textField_address.getText());
						student.setEmail(textField_email.getText());
						student.setGroup(textField_group.getText());
						student.setPnc(textField_pnc.getText());
						student.setFirstname(textField_firstname.getText());
						student.setLastname(textField_lastname.getText());
						student.setPassword(textField_password.getText());
						
						if(studentBLL.update(student))
						{
							JOptionPane.showMessageDialog(null, "Updated!");
						}
						else
						{
							JOptionPane.showMessageDialog(null, "ERROR!");
						}
						
					}
			
		});
			}
		});
		
				JButton buton_delete = new JButton("Delete");
				buton_delete.addActionListener(new ActionListener() {
					public void actionPerformed(ActionEvent e) {
						if(studentBLL.delete(student.getID()))
						{
							JOptionPane.showMessageDialog(null, "Student deleted!");
							Login login = new Login();
							setVisible(false);
							login.setVisible(true);
						}
						else
						{
							JOptionPane.showMessageDialog(null, "ERROR!");
						}
						
					}
				});
				contentPane.add(buton_delete);
		
				JButton button_enrolments = new JButton("Enrolments");
				button_enrolments.addActionListener(new ActionListener() {
					public void actionPerformed(ActionEvent e) {
					
						
						JLabel info = new JLabel("Select course:");
						contentPane.add(info);
						
						List<CourseEntity> courses = courseBLL.getAll();
						
						String[] columnNames = {"ID","IdTeacher","Name","Points"};
						
						String[][] data = new String[courses.size()][4];
						
						for (int i=0;i<courses.size();i++)
						{
							data[i][0]=Integer.toString(courses.get(i).getID());
							data[i][1]=Integer.toString(courses.get(i).getIdTeacher());
							data[i][2]=courses.get(i).getName();
							data[i][3]=Integer.toString(courses.get(i).getPoints());
						}
						
						JTable table = new JTable(data,columnNames);
						
						JScrollPane sp = new JScrollPane(table);
						table.setVisible(true);
						
						table.setAutoResizeMode(JTable.AUTO_RESIZE_OFF);
						table.getColumnModel().getColumn(0).setPreferredWidth(30);
						table.getColumnModel().getColumn(2).setPreferredWidth(200);
						
						contentPane.add(sp);
						
						JLabel lbldatestart = new JLabel("Start date(dd-mm-yyyy): ");
						contentPane.add(lbldatestart);
						
						JTextField textField_start = new JTextField();
						contentPane.add(textField_start);
						textField_start.setColumns(20);
						
						
				
						
						JButton add = new JButton("Enrolment");
						contentPane.add(add);
						
						add.addActionListener(new ActionListener() {
							@Override
							public void actionPerformed(ActionEvent e) {
								int row = table.getSelectedRow();
								
								SimpleDateFormat sdf1 = new SimpleDateFormat("dd-MM-yyyy");
								java.util.Date date;
								try {
									date = sdf1.parse(textField_start.getText());
									
									Date startDate=new java.sql.Date(date.getTime());
			
									
									enrolmentBLL.insert(student.getID(), Integer.parseInt((String)table.getValueAt(row, 0)), startDate, -1);				
								} catch (Exception e1) {
									// TODO Auto-generated catch block
									e1.printStackTrace();
								}
							}
						});
						
					}
				});
				contentPane.add(button_enrolments);
		
				JButton grades = new JButton("Grades");
				grades.addActionListener(new ActionListener() {
					@Override
					public void actionPerformed(ActionEvent e) {
					
						List<EnrolmentEntity> enrolments = enrolmentBLL.getById(student.getID());
						
						String[] columnNames = {"Name","Points","Start Date","Grade"};
						
						String[][] data = new String[enrolments.size()][5];
						
						for (int i=0;i<enrolments.size();i++)
						{
							data[i][0]=(enrolments.get(i).getCourse().getName());
							data[i][1]=Integer.toString(enrolments.get(i).getCourse().getPoints());
							data[i][2]=enrolments.get(i).getStartDate().toString();
							int grade = enrolments.get(i).getGrade();
							if(grade==-1)
							{
								data[i][4]="ERROR!";
							}
							else
							{
								data[i][4]=Integer.toString(grade);
							}
							
						}
						
						JTable table = new JTable(data,columnNames);
						
						JScrollPane sp = new JScrollPane(table);
						table.setVisible(true);
						
						table.setAutoResizeMode(JTable.AUTO_RESIZE_OFF);
						table.getColumnModel().getColumn(0).setPreferredWidth(180);
						table.getColumnModel().getColumn(1).setPreferredWidth(40);
						
						contentPane.add(sp);
					}
					
				});
				contentPane.add(grades);
				
				JButton logout = new JButton("Logout");
				logout.addActionListener(new ActionListener() {
					public void actionPerformed(ActionEvent e) {
						setVisible(false);
						Login login = new Login();
						login.setVisible(true);
					}
				});
				contentPane.add(logout);
	}
}