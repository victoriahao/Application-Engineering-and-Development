public class Scissors extends Tool{
	
	//constructor	
	public Scissors(int strength) {
		super(strength);
		super.type = 's';
	}
	
    public boolean fight(Tool t) {
		//strength*2 -> fighting paper
    	//strength/2 -> fighting rock
    	if(t instanceof Rock) {
    		if(this.strength*0.5 > t.strength) {
    			return true;
    		}
    	}
    	else if(t instanceof Paper) {
    		if(this.strength*2 > t.strength) {
    			return true;
    		}
    	}
    	else if(t instanceof Scissors) {
    		if(this.strength > t.strength) {
    			return true;
    		}
    	}
    	return false;
	}
}
