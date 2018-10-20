public class Candy extends DessertItem{
	
	private double weight;
	private int pricePerPound; //price per pound
	
	public Candy(String name, double weight, int pricePerPound) {
		super(name);
		this.weight = weight;
		this.pricePerPound = pricePerPound;
	}

	public int getCost() {
		// TODO Auto-generated method stub
		int cost = (int) Math.round(weight * pricePerPound);
		return cost;
	}
	
	public double getWeight() {
		return weight;
	}
	
	public int getPricePerPound() {
		return pricePerPound;
	}



}
