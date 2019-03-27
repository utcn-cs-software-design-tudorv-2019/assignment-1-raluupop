package presentationpackage;
import java.awt.BorderLayout;
import java.awt.EventQueue;

import javax.swing.ButtonGroup;
import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.table.DefaultTableModel;

import operationpackage.Student;

import java.awt.Label;
import java.awt.TextField;
import java.awt.TextArea;
import java.awt.Button;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;
import java.awt.event.KeyAdapter;
import java.awt.event.KeyEvent;
import javax.swing.JButton;

public class AddForm extends JFrame {

	protected static Object textUsername;
	private JPanel contentPane;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					AddForm frame = new AddForm();
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
	
	Student std= new Student();
	public AddForm() {
		setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
		setBounds(100, 100, 460, 301);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		Label label_welcome = new Label("Welcome!");
		label_welcome.setBounds(26, 24, 108, 22);
		contentPane.add(label_welcome);
		
		Label label_addstudent = new Label("Add a student:");
		label_addstudent.setBounds(24, 52, 85, 22);
		contentPane.add(label_addstudent);
		
		Label label_name = new Label("Name:");
		label_name.setBounds(34, 80, 62, 22);
		contentPane.add(label_name);
		
		Label label_bday = new Label("Birthday: ");
		label_bday.setBounds(34, 108, 62, 22);
		contentPane.add(label_bday);
		
		Label label_pnc = new Label("PNC: ");
		label_pnc.setBounds(236, 80, 62, 22);
		contentPane.add(label_pnc);
		
		Label label_adress = new Label("Adress: ");
		label_adress.setBounds(236, 108, 62, 22);
		contentPane.add(label_adress);
		
		TextField textField_name = new TextField();
		textField_name.setBounds(80, 80, 120, 22);
		contentPane.add(textField_name);
		
		TextField textField_pnc = new TextField();
		textField_pnc.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent evt) {
				
			}
		});
		textField_pnc.addKeyListener(new KeyAdapter() {
		
			public void keyTyped(KeyEvent evt) {
				if(!Character.isDigit(evt.getKeyChar()))
				{
					evt.consume();
				}
			}
		});
		
		textField_pnc.setBounds(271, 80, 128, 22);
		contentPane.add(textField_pnc);
		
		TextArea textArea_adress = new TextArea();
		textArea_adress.setBounds(293, 119, 108, 114);
		contentPane.add(textArea_adress);
		
		TextField textField_bday = new TextField();
		textField_bday.setBounds(90, 108, 110, 22);
		contentPane.add(textField_bday);
		
	
		
		
		Button button_add = new Button("ADD");
		button_add.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				
				
				String name=textField_name.getText();
				String birthday=textField_bday.getText();
				String pnc=textField_pnc.getText();
				String adress=textArea_adress.getText();
			
				
				
				Student std= new Student();
				std.insertUpdateDeleteStudent('i', null, name, birthday, pnc, adress);
			
				ManageStudentForm.table_1.setModel(new DefaultTableModel(null,new Object[] {"ID", "Name", "Birthday", "PNC", "Adress"}));
				
				std.fillStudentJTABLE(ManageStudentForm.table_1, "");
			}
		});
		button_add.setBounds(34, 158, 124, 22);
		contentPane.add(button_add);
		
		JButton btnManageStudent = new JButton("Manage Student");
		btnManageStudent.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent evt) {
				
				ManageStudentForm msf= new ManageStudentForm();
				msf.setVisible(true);
				msf.pack();
				msf.setLocationRelativeTo(null);
				msf.setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
				
			}
		});
		btnManageStudent.setBounds(30, 210, 128, 23);
		contentPane.add(btnManageStudent);
		
		Button button_course = new Button("Course");
		button_course.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				
				AddCourseForm acf= new AddCourseForm();
				acf.setVisible(true);
				acf.pack();
				acf.setLocationRelativeTo(null);
				acf.setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
			}
		});
		button_course.setBounds(164, 210, 124, 22);
		contentPane.add(button_course);
		
		
		
	}
}
