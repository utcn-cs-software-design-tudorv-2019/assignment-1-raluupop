package presentationpackage;
import java.awt.BorderLayout;
import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import java.awt.Label;
import java.awt.TextField;
import java.awt.TextArea;
import java.awt.Button;
import javax.swing.JTable;
import java.awt.Component;
import javax.swing.Box;
import javax.swing.UIManager;
import javax.swing.table.DefaultTableModel;

import operationpackage.Student;

import java.awt.Color;
import javax.swing.border.LineBorder;
import java.awt.Font;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;

public class ManageStudentForm extends JFrame {

	private JPanel contentPane;
	static JTable table_1;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					ManageStudentForm frame = new ManageStudentForm();
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
	
	public ManageStudentForm() {
		
		
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 903, 523);
		contentPane = new JPanel();
		contentPane.setBorder(new LineBorder(Color.WHITE, 14, true));
		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		JPanel panel = new JPanel();
		panel.setLayout(null);
		panel.setBorder(new EmptyBorder(5, 5, 5, 5));
		panel.setBounds(10, 37, 308, 281);
		contentPane.add(panel);
		
		Label label_1 = new Label("Manage Student:");
		label_1.setBounds(34, 10, 85, 22);
		panel.add(label_1);
		
		Label label_2 = new Label("Name:");
		label_2.setBounds(34, 80, 62, 22);
		panel.add(label_2);
		
		Label label_3 = new Label("Birthday: ");
		label_3.setBounds(34, 108, 62, 22);
		panel.add(label_3);
		
		Label label_4 = new Label("PNC: ");
		label_4.setBounds(34, 136, 62, 22);
		panel.add(label_4);
		
		Label label_5 = new Label("Adress: ");
		label_5.setBounds(34, 164, 62, 22);
		panel.add(label_5);
		
		TextField textField = new TextField();
		textField.setBounds(80, 80, 120, 22);
		panel.add(textField);
		
		TextField textField_1 = new TextField();
		textField_1.setBounds(87, 136, 113, 22);
		panel.add(textField_1);
		
		TextArea textArea = new TextArea();
		textArea.setBounds(92, 165, 108, 114);
		panel.add(textArea);
		
		TextField textField_2 = new TextField();
		textField_2.setBounds(90, 108, 110, 22);
		panel.add(textField_2);
		
		Label label_id = new Label("ID Student:");
		label_id.setBounds(34, 52, 62, 22);
		panel.add(label_id);
		
		TextField textField_3 = new TextField();
		textField_3.setBounds(95, 52, 105, 22);
		panel.add(textField_3);
		
		Button button = new Button("ADD");
		button.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				
				AddForm af= new AddForm();
				af.setVisible(true);
				af.pack();
				af.setLocationRelativeTo(null);
				af.setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
			}
		});
		button.setBounds(220, 52, 70, 22);
		panel.add(button);
		
		Button button_edit = new Button("EDIT");
		button_edit.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent evt) {
				
				String name=textField.getText();
				String birthday=textField_1.getText();
				String pnc=textField_2.getText();
				String adress=textArea.getText();
				
				int id= Integer.valueOf(textField_3.getText());
				
				Student std= new Student();
				std.insertUpdateDeleteStudent('u', id, name, birthday, pnc, adress);
			
				//ManageStudentForm.table_1.setModel(new DefaultTableModel(null,new Object[] {"ID", "Name", "Birthday", "PNC", "Adress"}));
				
				//std.fillStudentJTABLE(ManageStudentForm.table_1, "");
			}
		});
		button_edit.setBounds(220, 80, 70, 22);
		panel.add(button_edit);
		
		Button button_remove = new Button("REMOVE");
		button_remove.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				if(textField_3.getText().equals(""))
				{
					JOptionPane.showMessageDialog(null, "No student Selected!");
				}
				else {
				int id = Integer.valueOf(textField_3.getText());
				std.insertUpdateDeleteStudent('d', id, null, null, null, null);
				
				ManageStudentForm.table_1.setModel(new DefaultTableModel(null,new Object[] {"ID", "Name", "Birthday", "PNC", "Adress"}));
				std.fillStudentJTABLE(table_1, "");
				}
			}
		});
		button_remove.setBounds(220, 108, 70, 22);
		panel.add(button_remove);
		
		Component verticalGlue = Box.createVerticalGlue();
		verticalGlue.setBounds(118, 391, 1, 1);
		contentPane.add(verticalGlue);
		
		table_1 = new JTable();
		table_1.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent arg0) {
				
				int rowIndex=table_1.getSelectedRow();
				DefaultTableModel model= (DefaultTableModel) table_1.getModel();
				textField_3.setText(model.getValueAt(rowIndex, 0).toString());
				textField.setText(model.getValueAt(rowIndex, 1).toString());
				textField_1.setText(model.getValueAt(rowIndex, 2).toString());
				textField_2.setText(model.getValueAt(rowIndex, 3).toString());
				textArea.setText(model.getValueAt(rowIndex, 4).toString());
				
				
				
			}
		});
		table_1.setFont(new Font("Times New Roman", Font.BOLD, 14));
		table_1.setBounds(328, 37, 409, 316);
		contentPane.add(table_1);
		table_1.setBackground(Color.WHITE);
		table_1.setCellSelectionEnabled(true);
		table_1.setColumnSelectionAllowed(true);
		table_1.setSurrendersFocusOnKeystroke(true);
		table_1.setToolTipText("");
		table_1.setForeground(Color.GRAY);
		table_1.setModel(new DefaultTableModel(
			new Object[][] {
			},
			new String[] {
				"ID", "Name", "Birthday", "PNC", "Adress"
			}
		));
		table_1.getColumnModel().getColumn(0).setPreferredWidth(28);
		table_1.getColumnModel().getColumn(0).setMinWidth(17);
		table_1.getColumnModel().getColumn(0).setMaxWidth(36);
		table_1.getColumnModel().getColumn(1).setPreferredWidth(138);
		table_1.getColumnModel().getColumn(2).setPreferredWidth(113);
		table_1.getColumnModel().getColumn(3).setPreferredWidth(113);
		table_1.getColumnModel().getColumn(4).setPreferredWidth(124);
		table_1.getColumnModel().getColumn(4).setMaxWidth(124);
		table_1.setBorder(UIManager.getBorder("Table.focusCellHighlightBorder"));
	
		std.fillStudentJTABLE(table_1,"");
	}
}
