public class Pet
{
	private String PetName;
	private String OwnerName;
	private String color;
	protected int sex;
	public static final int MALE = 0, FEMALE = 1, SPAYED = 2, NEUTERED = 3;
	
	//constructor
	public Pet(String name, String ownerName, String color) {
		this.PetName = name;
		this.OwnerName = ownerName;
		this.color = color;
	}
	
	//Methods
	public String getPetName() {
		return PetName;
	}
	
	public String getOwnerName() {
		return OwnerName;
	}
	
	public String getColor() {
		return color;
	}
	
	public void setSex(int sexid) {
		if(sexid == 0) {
			sex = MALE;
		}
		if(sexid == 1) {
			sex = FEMALE;
		}
		if(sexid == 2) {
			sex = SPAYED;
		}
		if(sexid == 3) {
			sex = NEUTERED;
		}
	}
	
	public String getSex() {
		String sexName = "";
		if(this.sex == 0) {
			sexName = "Male";
		}
		if(this.sex == 1) {
			sexName = "Female";
		}
		if(this.sex == 2) {
			sexName = "Spayed";
		}
		if(this.sex == 3) {
			sexName = "Neutered";
		}
		return sexName;
	}
	
	public String toString() {
		String result = getPetName() + " owned by " + getOwnerName() + "\n" +
				        "Color: " + getColor() + "\n" +
				        "Sex: " + getSex();
		return result;
	}
	
	public static void main(String[] args){
	    Pet pet = new Pet("Spot", "Mary", "Black and White");
	    pet.setSex(0);
	    System.out.println(pet.toString());
	}
	
	/* Output of the unit test 
	 Spot owned by Mary 
     Color: Black and White 
     Sex: Male 
	*/
}