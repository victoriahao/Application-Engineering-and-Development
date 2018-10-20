public class DessertShoppe {
	
	public final static double taxRate = 6.5;  //6.5%
	public final static String dessertShoppeName = "M & M Dessert Shoppe";
	public final static int maxlength = 50;
	//String maxSize = java.lang.String.format("%" + maxlength + "s", toString()).trim();
	public final static int costwidth = 10;
	
	public static String cents2dollarsAndCents(int cents){
		String s = "";
		
		if(cents < 0) {
			s += "-";
			cents = cents * -1;
		}
		
		int dollars = cents/100; //ex. 105/100 = 1.05
		cents = cents % 100;
		//s = Double.toString(dollars);
		
		if(dollars > 0) {
			s += dollars;
		}
		
		s += ".";
		//s += "." + String.format("%02d", cents); 

		if(cents < 10) {
			s += "0";	
		}
		
		s += cents;
		
		return(s);
	}
	
	public void main(String[] args) {
		System.out.println(DessertShoppe.dessertShoppeName.length());
	}

}
