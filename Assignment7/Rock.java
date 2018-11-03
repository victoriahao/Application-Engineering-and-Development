public class Rock extends Tool{
	
	//constructor
	public Rock(int strength) {
		super(strength);
		super.type = 'r';
	}
	
	public boolean fight(Tool t) {
		//strength*2 -> fighting scissors
		//strength/2 -> fighting paper
		
		if(t instanceof Scissors) {
			if(this.strength*2 > t.strength) {
				return true;
			}			
		}
		else if(t instanceof Paper) {
			if(this.strength*0.5 > t.strength) {
				return true;
			}			
		}
		else if(t instanceof Rock) {
			if(this.strength > t.strength) {
				return true;
			}
		}
		return false;
    }
}
