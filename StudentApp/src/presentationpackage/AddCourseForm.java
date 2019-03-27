package presentationpackage;
import java.awt.BorderLayout;
import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JTextField;
import java.awt.Button;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;
import javax.swing.JTable;
import javax.swing.table.DefaultTableModel;

import operationpackage.Course;

import javax.swing.JButton;

public class AddCourseForm extends JFrame {

	private JPanel contentPane;
	private JTextField textField_label;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					AddCourseForm frame = new AddCourseForm();
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
	Course c= new Course();
	public AddCourseForm() {
		
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(500, 500, 450, 300);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		JLabel lblAddCourse = new JLabel("Add Course");
		lblAddCourse.setBounds(101, 23, 124, 49);
		contentPane.add(lblAddCourse);
		
		JLabel lblLabel = new JLabel("Label: ");
		lblLabel.setBounds(21, 83, 68, 42);
		contentPane.add(lblLabel);
		
		textField_label = new JTextField();
		textField_label.setBounds(67, 94, 205, 20);
		contentPane.add(textField_label);
		textField_label.setColumns(10);
		
		Button button = new Button("ADD");
		button.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				
				if(!c.isCourseExist(textField_label.getText()))
				{
				String label=textField_label.getText();
				c.insertUpdateDeleteStudent('i',null, label);
				
				//ManageCourseForm.table.setModel(new DefaultTableModel(null, new Object[],("ID","Label")));
				}
				else
				{
					JOptionPane.showMessageDialog(null, "Course already exists!");
				}
			}
		});
		button.setBounds(306, 94, 70, 22);
		contentPane.add(button);
		
		JButton btnNewButton = new JButton("Manage course");
		btnNewButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				ManageCourseForm mcf= new ManageCourseForm();
				mcf.setVisible(true);
				mcf.pack();
				mcf.setLocationRelativeTo(null);
				mcf.setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
			}
		});
		btnNewButton.setBounds(66, 158, 89, 23);
		contentPane.add(btnNewButton);
		
		
	}
}
