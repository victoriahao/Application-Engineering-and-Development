import java.awt.Container;

import java.awt.Dimension;
import java.util.ArrayList;
import java.util.Collection;

import javax.swing.BorderFactory;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JSplitPane;
import javax.swing.JTable;
import javax.swing.JTextField;
import javax.swing.border.TitledBorder;
import javax.swing.event.TableModelListener;
import javax.swing.table.TableModel;

public class StudentInformationSystem extends JFrame {

	private JTable studentsTable;

	public StudentInformationSystem(Students students) {
		
		JTextField SaveTextField = new JTextField(26);
		JButton SaveButton = new JButton("Save");
		
		JPanel ctrlPane = new JPanel();
		ctrlPane.add(SaveTextField);
		ctrlPane.add(SaveButton);
		
		StudentsTableModel model = new StudentsTableModel(students);
		studentsTable = new JTable(model);
		JScrollPane jsp = new JScrollPane(studentsTable);

		//Container con = getContentPane();
		//con.add(jsp);
		//setSize(400, 400);
		//setVisible(true);
		
		//JScrollPane tableScrollPane = new JScrollPane(table);
		//tableScrollPane.setPreferredSize(new Dimension(700, 182));
		//tableScrollPane.setBorder(BorderFactory.createTitledBorder(BorderFactory.createEtchedBorder(), "Market Movers",
		//TitledBorder.CENTER, TitledBorder.TOP));
		JSplitPane splitPane = new JSplitPane(JSplitPane.VERTICAL_SPLIT, ctrlPane, jsp);
		splitPane.setDividerLocation(35);
		splitPane.setEnabled(false);
		// Display it all in a scrolling window and make the window appear
		JFrame frame = new JFrame("Student Information");
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		frame.add(splitPane);
		frame.pack();
		frame.setLocationRelativeTo(null);
		frame.setVisible(true);
	}

	public static void main(String[] args) {
		Students s = new Students();
		s.addStudent(new Student(100, "Tom", "Thompson", "male"));
		s.addStudent(new Student(101, "Jerry", "Carpenter", "male"));
		s.addStudent(new Student(102, "Sarah", "Walker", "female"));
		new StudentInformationSystem(s);

	}

}

class Students {
	private Collection<Student> students = new ArrayList<Student>();

	public Collection<Student> getStudents() {
		return students;

	}

	public void addStudent(Student s) {
		students.add(s);
	}

	public int getNumberOfStudents() {
		return getStudents().size();
	}

}

class Student {
	int ID;
	String first;
	String last;
	String gender;

	public Student(int id, String first, String last, String gender) {
		this.ID = id;
		this.first = first;
		this.last = last;
		this.gender = gender;
	}
}

class StudentsTableModel implements TableModel {

	private Students students;

	public StudentsTableModel(Students students) {
		this.students = students;
	}

	@Override
	public int getRowCount() {
		return students.getNumberOfStudents();
	}

	@Override
	public int getColumnCount() {
		return 4;
	}

	@Override
	public String getColumnName(int columnIndex) {
		if (columnIndex == 0) {
			return "ID";
		}
		if (columnIndex == 1) {
			return "First Name";
		}
		if (columnIndex == 2)
			return "Last Name";
		if (columnIndex == 3)
			return "Gender";
		return null;
	}

	@Override
	public Class<?> getColumnClass(int columnIndex) {
		/*if (columnIndex == 3) {
			return Boolean.class;
		}*/
		return String.class;
	}

	@Override
	public boolean isCellEditable(int rowIndex, int columnIndex) {

		return false;
	}

	@Override
	public Object getValueAt(int rowIndex, int columnIndex) {
		Collection<Student> s = students.getStudents();
		int row = -1;
		for (Student student : s) {
			row++;
			if (row == rowIndex) {
				if (columnIndex == 0) {
					return student.ID + "";
				}
				if (columnIndex == 1) {
					return student.first;
				}
				if (columnIndex == 2) {
					return student.last;
				}
				if (columnIndex == 3) {
					return student.gender;
				}
			}
		}
		return null;
	}

	@Override
	public void setValueAt(Object aValue, int rowIndex, int columnIndex) {
		// TODO Auto-generated method stub

	}

	@Override
	public void addTableModelListener(TableModelListener l) {
		// TODO Auto-generated method stub

	}

	@Override
	public void removeTableModelListener(TableModelListener l) {
		// TODO Auto-generated method stub

	}

}
