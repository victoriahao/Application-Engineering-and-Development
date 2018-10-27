public class Dog extends Pet implements Boardable
{
	private String size;
	public int BoardStartMonth, BoardStartDay, BoardStartYear, BoardEndMonth, BoardEndDay, BoardEndYear;
	
	//constructor
	public Dog(String name, String ownerName, String color, String size) {
		super(name, ownerName, color);
		this.size = size;
	}
	
	//methods
	public String getSize() {
		return size;
	}
	
	public String toString() {
		String result = "";
		if(this.getClass().equals(Dog.class)) {
			result = "DOG:\n" + super.toString() + "\n" + "Size: " + getSize();
		}
		return result;
	}

	@Override
	public void setBoardStart(int month, int day, int year) {
		if(month >= 1 & month <= 12) {
			BoardStartMonth = month;
		}else {
			throw new java.lang.Error("board start month is invalid"); //to prevent edge cases (ex. month 100)
		}
		if(day >= 1 & day <= 31) {
			BoardStartDay = day;
		}else {
			throw new java.lang.Error("board start day is invalid");
		}
		if(year/1000 >= 1 & year/1000 < 10) { //this is to check whether year is a four digit number
			BoardStartYear = year;
		}else {
			throw new java.lang.Error("board start year is invalid");
		}
	}

	@Override
	public void setBoardEnd(int month, int day, int year) {
		if(month >= 1 & month <= 12) {
			BoardEndMonth = month;
		}else {
			throw new java.lang.Error("board end month is invalid"); //to prevent edge cases (ex. month 100)
		}
		if(day >= 1 & day <= 31) {
			BoardEndDay = day;
		}else {
			throw new java.lang.Error("board end day is invalid");
		}
		if(year/1000 >= 1 & year/1000 < 10) { //this is to check whether year is a four digit number
			BoardEndYear = year;
		}else {
			throw new java.lang.Error("board end year is invalid");
		}
	}

	@Override
	public boolean boarding(int month, int day, int year) {
		boolean boardingValid = false;
		boolean checkStart = false;
		boolean checkEnd = false;
		
		//checking whether boarding date is at or after boarding start date
		if(year > BoardStartYear) {
			checkStart = true;
		}else if(year == BoardStartYear) {
			if(month > BoardStartMonth) {
				checkStart = true;
			}else if(month == BoardStartMonth) {
				if(day >= BoardStartDay) {
					checkStart = true;
				}
			}
		}
		//checking whether boarding date is at or before boarding end date
		if(year < BoardEndYear) {
			checkEnd = true;
		}else if(year == BoardEndYear) {
			if(month < BoardEndMonth) {
				checkEnd = true;
			}else if(month == BoardEndMonth) {
				if(day <= BoardEndDay) {
					checkEnd = true;
				}
			}
		}
		
		
		if(checkStart == true & checkEnd == true) boardingValid = true;
		return boardingValid;
	}
	
	public static void main(String[] args){
	    Dog dog = new Dog("Spot", "Susan", "white", "medium");
	    dog.setSex(2);
	    System.out.println(dog.toString());
	    //set boarding start/end dates (20170131 - 20190815)
	    dog.setBoardStart(1, 31, 2017);
	    dog.setBoardEnd(8, 15, 2019);
	    System.out.println("boarding validity: " + dog.boarding(1, 1, 2018));
	    //set boarding start/end dates (20180101 - 20181010) and boarding date is 20181010
	    dog.setBoardStart(1, 1, 2018);
	    dog.setBoardEnd(10, 10, 2018);
	    System.out.println("boarding validity: " + dog.boarding(10, 10, 2018));
	    //set boarding start/end dates (20280101 - 20180101), and boarding date is 20180909
	    //this is edge case where start date is after end date
	    dog.setBoardStart(1, 1, 2028);
	    dog.setBoardEnd(1, 1, 2018);
	    System.out.println("boarding validity: " + dog.boarding(9, 9, 2018));
	    //set boarding start/end dates (199990101 - 20180101), and boarding date is 20170101
	    //this is edge case where start date is invalid (should throw an error message)
	    dog.setBoardStart(1, 1, 19999);
	    dog.setBoardEnd(1, 1, 2018);
	    System.out.println("boarding validity: " + dog.boarding(1, 1, 2017));
	    
	}
	
	/* Output of the unit test for toString
	 DOG: 
	 Spot owned by Susan
     Color: white 
     Sex: spayed 
     Size: medium
	*/
}