//mengweihaoAssignment2

/**
 * Assignment for your lecture 2. Please finish all the questions under 'Assignment'
 * Please try to think the extra credit question. 
 * The deadline of this assignment is 09/21/2018 23:59 PST.
 * Please feel free to contact Amanda and Zane for any questions.
 */

class Employee {
    String name;
    int age;
    Gender gender;
    double salary;// salary per month
    
	// Constructor. Please set all the data in constructor.
    public Employee(String name, int age, Gender gender, double salary) {
    	//write your code here
    	this.name = name;
    	this.age = age;
    	this.gender = gender;
    	this.salary = salary;
    }
    
    // Getter for 'name'. Return the current 'name' data 
    public String getName() {
    	//write your code here
    	return name;	
    }
    
    // Setter for 'name'. Set 'name' data
    public void setName(String name) {
    	//write your code here
    	this.name = name;
    }
    
    public void raiseSalary(double byPercent) {
    	salary=salary*(byPercent/100.00);
    }
}

enum Gender {
    MALE,
    FEMALE;
}


public class mengweihaoAssignment2 {
    // Assignment

    /**
     * Write a method to calculate the Social Security Tax of an employee and print it.
     * If the salary is less than or equal to 8900, the Social Security Tax is 6.2% of the salary.
     * If the salary is more than 8900, the Social Security Tax is 6.2% of 106,800.
     */
	
    public double socialSecurityTax(Employee employee) {
    	//write your code here
    	double sst;
    	double emp_sal;
    	emp_sal = employee.salary;
    	if(emp_sal <= 8900) {
    		sst = emp_sal * 0.062;
    	}
    	else {
    		sst = 106800 * 0.062;
    	}
    	System.out.println("The social security tax is" + sst);
    	return sst;
    }

    /**
     * Write a method to calculate an employee's contribution for insurance coverage and print it.
     * Amount of deduction is computed as follows:
     * If the employee is under 35, rate is 3% of salary; if the employee is between 35 and 50(inclusive), rate is 4% of salary;
     * If the employee is between 50 and 60(exclusive), rate is 5% of salary; If the employee is above 60, rate is 6% of salary.
     */
    
    
    public double insuranceCoverage(Employee employee) {
        //write your code here
    	double insuCover;
    	double emp_sal;
    	int emp_age;
    	emp_age = employee.age;
    	emp_sal = employee.salary;
    	if(emp_age < 35) {
    		insuCover = emp_sal * 0.03;
    	}
    	else if(emp_age >= 35 && emp_age <= 50) {
    		insuCover = emp_sal * 0.04;
    	}
    	else if(emp_age > 50 && emp_age < 60) {
    		insuCover = emp_sal * 0.05;
    	}
    	else {
    		insuCover = emp_sal * 0.06;
    	}
    	return insuCover;
    }

    /**
     * Write a method to sort three employees' salary from low to high, and then print their name in order.
     * For example, Alice's salary is 1000, John's salary is 500, Jenny's salary is 1200, you should print:
     * John Alice Jenny
     */
    public void sortSalary(Employee e1, Employee e2, Employee e3) {
        //write your code here
    	
    	double a_sal;
    	double b_sal;
    	double c_sal;
    	a_sal = e1.salary;
    	b_sal = e2.salary;
    	c_sal = e3.salary;
    	double temp;
    	System.out.println("Input first employees' salary:");
    	System.out.println("Input second employees' salary:");
    	System.out.println("Input third employees' salary:");
    	if(a_sal>b_sal) {
    		temp=a_sal; a_sal=b_sal; b_sal=temp;
    	}
    	if(a_sal>c_sal) {
    		temp=a_sal; a_sal=c_sal; c_sal=temp;
    	}
    	if(b_sal>c_sal) {
    		temp=b_sal; b_sal=c_sal; c_sal=temp;
    	}
    	System.out.println("Salaries from low to high:"+a_sal+","+b_sal+","+c_sal);
    	System.out.println("Print name in order:"+e1+","+e2+","+e3);
    	
    }
    /**
     * Write a method to raise an employee's salary to three times of his/her original salary.
     * Eg: original salary was 1000/month. After using this method, the salary is 3000/month.
     * Do not change the input of this method.
     * Try to add a new method in Employee class: public void raiseSalary(double byPercent)
     */
    public void tripleSalary(Employee employee) {
    	//write your code here
    	System.out.println("Employee's original salary is:" + employee.salary);
    	employee.raiseSalary(300.00);
    	System.out.println("Employee's new salary is:" + employee.salary);
    }
    


    //Extra credit

    /**
     * I have written some code below. What I want is to swap two Employee objects.
     * One is Jenny and one is John. But after running it, I got the result below:
     * Before: a=Jenny
     * Before: b=John
     * After: a=Jenny
     * After: b=John
     * There is no change after swap()! Do you know the reason why my swap failed?
     * Write your understanding of the reason and explain it.
     */
    /*
     write your understanding here.
     Ans:
     
     I think the reason swap failed is because you can't simply swap objects itself. Instead, you can
     only swap those values inside objects. That is to say, JAVA is pass by value, not pass by reference. 
     For instance, you can't swap a and b because a and b are objects; however, your goal is to swap 
     the name (i.e. value) inside a (i.e. object) and swap the name (i.e. value) inside b (i.e. object). 
     Therefore, you may call name in a object "name_1", and call name in b object "name_2". After you swap 
     these two names, you will be able to swap Jenny and John successfully. Or it is possible to consider 
     using array or list to swap two objects. For instance, create a swap method which contains two lists 
     and then execute this method. After executing this method, a will have the contents of b, and b will 
     have the contents of a.
     
    */
    public static void main(String[] args) {
    	
        Employee a = new Employee("Jenny", 20, Gender.FEMALE, 2000);
        Employee b = new Employee("John", 30, Gender.MALE, 2500);
        
        System.out.println("Before: a=" + a.getName());
        System.out.println("Before: b=" + b.getName());
        String name = a.getName();
    	a.setName(b.getName());
    	b.setName(name);
        //a.setName("John");
        //swap(name_1, name_2);
        //swap(a, b);
        System.out.println("After: a=" + a.getName());
        System.out.println("After: b=" + b.getName());
    }

    public static void swap(Employee x, Employee y) {
        Employee temp = x;
        x = y;
        y = temp;
    }
}

/*public class mengweihaoAssignment2 
{

	public static void main(String[] args) 
	{
		// TODO Auto-generated method stub
		System.out.println("");
		

	}

}*/