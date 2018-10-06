public class Test {
		
	public static void main(String[] args) {
		
		//New course
		Course course = new Course("History");
		System.out.println("Course Name: " + course.getName());
		System.out.println("Number of Students: " + course.getNumberOfStudents());
		
		//Student registrations
		Student a = new Student("Amy", 1);
		System.out.println("First Student Name: " + a.getName() + ", ID: " + a.getId());
		Student b = new Student("Rachel", 2);
		System.out.println("Second Student Name: " + b.getName() + ", ID: " + b.getId());
		Student c = new Student("John", 3);
		System.out.println("Third Student Name: " + c.getName() + ", ID: " + c.getId());
		Student d = new Student("Marie", 4);
		System.out.println("Fourth Student Name: " + d.getName() + ", ID: " + d.getId());
		Student e = new Student("Jack", 5);
		System.out.println("Fifth Student Name: " + e.getName() + ", ID: " + e.getId());
		Student f = new Student("Sarah", 6);
		System.out.println("Sixth Student Name: " + f.getName() + ", ID: " + f.getId());
		Student g = new Student("Ben", 7);
		System.out.println("Seventh Student Name: " + g.getName() + ", ID: " + g.getId());
		Student h = new Student("Jeremy", 8);
		System.out.println("Eighth Student Name: " + h.getName() + ", ID: " + h.getId());
		Student i = new Student("Michelle", 9);
		System.out.println("Ninth Student Name: " + i.getName() + ", ID: " + i.getId());
		Student j = new Student("Christina", 10);
		System.out.println("Tenth Student Name: " + j.getName() + ", ID: " + j.getId());
		Student k = new Student("Bob", 11);
		System.out.println("Eleventh Student Name: " + k.getName() + ", ID: " + k.getId());
		
		Student[] students = new Student[]{a,b,c,d,e,f,g,h,i,j,k};
		
		for(int id = 0; id < students.length; id++) {
			if(!course.isFull()) {
				course.registerStudent(students[id]);
				System.out.println("Student Name: " + students[id].getName());
				System.out.println("Number of Students now: " + course.getNumberOfStudents());
			}else {
				System.out.println("Class is full");
			}
		}
	}
}
