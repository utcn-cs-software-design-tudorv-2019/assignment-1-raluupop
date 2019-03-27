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
import javax.swing.JButton;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;
import javax.swing.JTable;
import javax.swing.table.DefaultTableModel;

import operationpackage.Course;

public class ManageCourseForm extends JFrame {

	private JPanel contentPane;
	private JTextField textField;
	private JTextField textField_1;
	static JTable table;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					ManageCourseForm frame = new ManageCourseForm();
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
	
	public ManageCourseForm() {
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 450, 300);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		JPanel panel = new JPanel();
		panel.setLayout(null);
		panel.setBorder(new EmptyBorder(5, 5, 5, 5));
		panel.setBounds(0, 0, 434, 261);
		contentPane.add(panel);
		
		JLabel lblManageCourse = new JLabel("Manage Course");
		lblManageCourse.setBounds(119, 11, 124, 49);
		panel.add(lblManageCourse);
		
		JLabel label_1 = new JLabel("Label: ");
		label_1.setBounds(21, 83, 68, 42);
		panel.add(label_1);
		
		textField = new JTextField();
		textField.setColumns(10);
		textField.setBounds(67, 94, 205, 20);
		panel.add(textField);
		
		Button button = new Button("ADD");
		button.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				
				AddCourseForm acf= new AddCourseForm();
				acf.setVisible(true);
				acf.pack();
				acf.setLocationRelativeTo(null);
				acf.setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
			}
		});
		button.setBounds(313, 94, 70, 22);
		panel.add(button);
		
		JButton btnRemove = new JButton("Remove");
		btnRemove.setBounds(313, 138, 71, 23);
		panel.add(btnRemove);
		
		JLabel lblId = new JLabel("ID:");
		lblId.setBounds(23, 50, 68, 42);
		panel.add(lblId);
		
		textField_1 = new JTextField();
		textField_1.setColumns(10);
		textField_1.setBounds(67, 61, 205, 20);
		panel.add(textField_1);
		
		JButton btnEdit = new JButton("Edit");
		btnEdit.setBounds(313, 177, 71, 23);
		panel.add(btnEdit);
		
		table = new JTable();
		table.setModel(new DefaultTableModel(
			new Object[][] {
			},
			new String[] {
				"ID", "Label"
			}
		));
		table.setFillsViewportHeight(true);
		table.setColumnSelectionAllowed(true);
		table.setCellSelectionEnabled(true);
		table.setBounds(67, 136, 210, 114);
		panel.add(table);
		c.fillCourseJTABLE(table);
		
		
		
		
	}
}
