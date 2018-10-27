public class Cat extends Pet implements Boardable
{
	private String hairLength;
	public int BoardStartMonth, BoardStartDay, BoardStartYear, BoardEndMonth, BoardEndDay, BoardEndYear;
	
	//constructor
	public Cat(String name, String ownerName, String color, String hairLength) {
		super(name, ownerName, color);
		this.hairLength = hairLength;
	}
	
	//methods
	public String getHairLength() {
		return hairLength;
	}
	
	public String toString() {
		String result = "";
		if(this.getClass().equals(Cat.class)) {
			result = "CAT:\n" + super.toString() + "\n" + "Hair: " + getHairLength();
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
	    Cat cat = new Cat("Tom", "Bob", "black", "short");
	    cat.setSex(2);
	    System.out.println(cat.toString());
	    //set boarding start/end dates (20170131 - 20190815)
	    cat.setBoardStart(1, 31, 2017);
	    cat.setBoardEnd(8, 15, 2019);
	    System.out.println("boarding validity: " + cat.boarding(1, 1, 2018));
	    //set boarding start/end dates (20180101 - 20181010) and boarding date is 20181010
	    cat.setBoardStart(1, 1, 2018);
	    cat.setBoardEnd(10, 10, 2018);
	    System.out.println("boarding validity: " + cat.boarding(10, 10, 2018));
	    //set boarding start/end dates (20280101 - 20180101), and boarding date is 20180909
	    //this is edge case where start date is after end date
	    cat.setBoardStart(1, 1, 2028);
	    cat.setBoardEnd(1, 1, 2018);
	    System.out.println("boarding validity: " + cat.boarding(9, 9, 2018));
	    //set boarding start/end dates (199990101 - 20180101), and boarding date is 20170101
	    //this is edge case where start date is invalid (should throw an error message)
	    cat.setBoardStart(1, 1, 19999);
	    cat.setBoardEnd(1, 1, 2018);
	    System.out.println("boarding validity: " + cat.boarding(1, 1, 2017));
	    
	}
	
	/* Output of the unit test for toString
	 CAT: 
	 Tom owned by Bob 
     Color: black 
     Sex: spayed 
     Hair: short
	*/
}