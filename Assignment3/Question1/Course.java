
public class Course {
	
		String name;
		int numberOfStudent = 0;
		Student[] students = new Student[10];
		
		public Course(String name) {
			this.name = name;
		}
		
		public Student[] getStudents() {
			return students;
		}
		
		public String getName() {
			return name;
		}
		
		public int getNumberOfStudents() {
			return numberOfStudent;
		}
		
		public boolean isFull() {
			if(numberOfStudent >= 10) {
				return true;
			}
			else {
				return false;
			}
		}	
		
		public void registerStudent(Student student) {
			if(numberOfStudent < 10) {
				students[numberOfStudent] = student;
				numberOfStudent++;
			}
		}		
}


