public class Paper extends Tool{
	
	//constructor
    public Paper(int strength) {
		super(strength);
		super.type = 'p';
	}

	public boolean fight(Tool t) {
		//strength*2 -> fighting rock
    	//strength/2 -> fighting scissor
		if(t instanceof Rock) {
			if(this.strength*2 > t.strength) {
				return true;
			}
		}
		else if(t instanceof Scissors) {
			if(this.strength*0.5 > t.strength) {
				return true;
			}
		}
		else if(t instanceof Paper) {
			if(this.strength > t.strength) {
				return true;
			}
		}
		return false;		
	}
	
}
