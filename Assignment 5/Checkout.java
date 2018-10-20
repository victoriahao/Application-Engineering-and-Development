public class Checkout {
	private DessertItem[] myDessertItems;
	private int numberOfItems;
	private final int receiptWidth = 30;
	
	public Checkout() {
		myDessertItems = new DessertItem[100];
		numberOfItems = 0;
	}
	
	public int numberOfItems() {
		return numberOfItems;
	}
	
	public void enterItem(DessertItem item) {
		this.myDessertItems[numberOfItems] = item;
		numberOfItems++;
	}
	
	public void clear() {
		for(int i = 0; i < numberOfItems; i++)
			this.myDessertItems[i] = null;
		numberOfItems = 0;
	}
	
	public int totalCost() {
		int sum = 0;
		for(int i = 0; i < numberOfItems; i++) 
			sum += myDessertItems[i].getCost(); 
		return sum;
	}
	
	public int totalTax() {
		return (int)Math.round(this.totalCost() * DessertShoppe.taxRate / 100.00);
	}
	
	public String toString() {
		String s = "";		//print receipt
		
		
		s += "    " + DessertShoppe.dessertShoppeName + "\n";
		s += "    " + "--------------------" + "\n";
		
		for(int j = 0; j < numberOfItems; j++){
		
			String l = myDessertItems[j].getName();		// items of every line
			
			//String item = myDessertItems[j].getClass().toString().substring(6);		// get the item category
			
			String p = DessertShoppe.cents2dollarsAndCents(myDessertItems[j].getCost());	// price of every item
			if (p.length() > DessertShoppe.costwidth)		// verify the cost is within length
				p = p.substring(0, DessertShoppe.costwidth);
			
			if (myDessertItems[j] instanceof IceCream) {		//ice cream
				while(l.length() < receiptWidth - p.length()){
					l += " ";
				}
				s += l + p + "\n";
			}
			else if (myDessertItems[j] instanceof Sundae) {		//Sundae	
				s += ((Sundae)myDessertItems[j]).getToppingName() + " Sundae with\n";
				
				while(l.length() < receiptWidth - p.length()){
					l += " ";
				}
				s += l + p + "\n";
			}
			else if (myDessertItems[j] instanceof Candy){		//Candy
				s += ((Candy) myDessertItems[j]).getWeight() + " lbs. @ " + 
						DessertShoppe.cents2dollarsAndCents(((Candy) myDessertItems[j]).getPricePerPound()) + " /lb.\n";
				
				while(l.length() < receiptWidth - p.length()){
					l += " ";
				}
				s += l + p + "\n";	
			}
			else {		//Cookie
				s += ((Cookie)myDessertItems[j]).getNumber() + " @ " + 
						DessertShoppe.cents2dollarsAndCents(((Cookie)myDessertItems[j]).getPricePerDozen()) + " /dz.\n";
				
				while(l.length() < receiptWidth - p.length()){
					l += " ";
				}
				s += l + p + "\n";			
			}	
		}
		
		//Tax
		String line = "\nTax";		
		String tax = DessertShoppe.cents2dollarsAndCents(this.totalTax());
		while(line.length() <= receiptWidth - tax.length())
			line += " ";
		s += line + tax;
		
		//Total Cost
		String totalCost = DessertShoppe.cents2dollarsAndCents(this.totalCost() + this.totalTax());
		line = "\nTotal Cost";
		while(line.length() <= receiptWidth - totalCost.length())
			line += " ";
		s += line + totalCost;
	
		return s;
	}
}
