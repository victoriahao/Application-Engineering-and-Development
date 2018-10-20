public abstract class DessertItem extends java.lang.Object {
	
	protected java.lang.String name;
	
	//null constructor
	public DessertItem() {
		this("");
	}
	
	//initialization
	public DessertItem(java.lang.String name) {
		if(name.length() <= DessertShoppe.maxlength) {
			this.name = name;
		}
		else {
			this.name = name.substring(0, DessertShoppe.maxlength);
		}
	}
	
	public final java.lang.String getName() {
		return name;
	}
	
	public abstract int getCost();

}
