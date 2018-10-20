public class Sundae extends IceCream{
	
	private String toppingName;
	private int toppingCost;
	private int cost;
	
	public Sundae(String iceCreamName, int iceCreamCost, String toppingName, int toppingCost) {
		super(iceCreamName, iceCreamCost);
		this.toppingName = toppingName;
		this.toppingCost = toppingCost;
	}
	
	public int getCost() {
		// TODO Auto-generated method stub
		cost = this.toppingCost + super.getCost();
		return cost;
	}
	
	public String getToppingName() {
		return toppingName;
	}

	
	public static void main(String[] args) {
		DessertItem di = new Sundae("Vanilla Ice Cream", 105, "Caramel", 50);
		
		System.out.println(di.getClass().toString().substring(6));
		
		System.out.println(((Sundae)di).getToppingName());
	}
	
}
