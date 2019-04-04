package presentationL;

import java.awt.BorderLayout;
import java.awt.EventQueue;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.List;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JTable;
import javax.swing.JTextField;
import javax.swing.border.EmptyBorder;

import business.Entities.EnrolmentBLL;
import business.Entities.StudentBLL;
import data.Entities.CourseEntity;
import data.Entities.EnrolmentEntity;
import data.Entities.StudentEntity;

import javax.swing.JLabel;
import javax.swing.JOptionPane;

public class CourseUI extends JFrame {

	private JPanel contentPane;

	EnrolmentBLL enrolmentBLL = new EnrolmentBLL();
	StudentBLL studentBLL = new StudentBLL();

	public CourseUI(CourseEntity course) {
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 450, 300);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);

		JLabel lblWelcome = new JLabel("Welcome!");
		lblWelcome.setBounds(49, 34, 71, 14);
		contentPane.add(lblWelcome);

		List<EnrolmentEntity> enrollments = enrolmentBLL.getByIdCourse(course.getID());

		String[] columnNames = { "ID", "Student", "Start date", "Grade" };

		String[][] data = new String[enrollments.size()][4];

		for (int i = 0; i < enrollments.size(); i++) {
			StudentEntity student = studentBLL.getByID(enrollments.get(i).getStudentID());

			data[i][1] = student.getFirstname() + " " + student.getLastname();
			data[i][0] = Integer.toString(enrollments.get(i).getEnrolmentID());
			data[i][2] = enrollments.get(i).getStartDate().toString();

			int grade = enrollments.get(i).getGrade();
			if (grade == -1) {
				data[i][4] = "Error";
			} else {
				data[i][4] = Integer.toString(grade);
			}
		}
		JTable table = new JTable(data, columnNames);

		JScrollPane sp = new JScrollPane(table);
		table.setVisible(true);

		table.setAutoResizeMode(JTable.AUTO_RESIZE_OFF);
		table.getColumnModel().getColumn(1).setPreferredWidth(180);
		table.getColumnModel().getColumn(0).setPreferredWidth(40);

		contentPane.add(sp);

		JLabel grade = new JLabel("grade");
		contentPane.add(grade);

		JTextField textField_grade = new JTextField();
		textField_grade.setBounds(129, 121, 117, 20);
		contentPane.add(textField_grade);
		textField_grade.setColumns(20);

		JButton button = new JButton("Adaugare nota");
		contentPane.add(button);
		button.setBounds(117, 176, 139, 23);
		contentPane.add(button);
		button.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				int id = Integer.parseInt((String) table.getValueAt(table.getSelectedRow(), 0));
				enrolmentBLL.update(id, Integer.parseInt(textField_grade.getText()));
				JOptionPane.showMessageDialog(null, "Succes!");
				setVisible(false);
			}

		});

	}

}
