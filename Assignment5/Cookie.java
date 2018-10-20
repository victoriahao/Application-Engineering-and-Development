public class Cookie extends DessertItem{
	
	private int number;
	private int pricePerDozen;
	
	public Cookie(String name, int number, int pricePerDozen) {
		super(name);
		this.number = number;
		this.pricePerDozen = pricePerDozen;
	}

	public int getCost() {
		// TODO Auto-generated method stub
		int cost = (int) Math.round(number * pricePerDozen/12);
		return cost;
	}
	
	public int getNumber() {
		return number;
	}
	
	public int getPricePerDozen() {
		return pricePerDozen;
	}

}
