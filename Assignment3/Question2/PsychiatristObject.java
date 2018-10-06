
public class PsychiatristObject {
	
	public void examine(MoodyObject moodyObject) {
		System.out.println("How are you feeling today?");
	}
	public void observe(MoodyObject moodyObject) {
		System.out.print("Observation: ");
	}
	
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		PsychiatristObject p = new PsychiatristObject();
		SadObject s = new SadObject();
		HappyObject h = new HappyObject();
		//Examine Happy Object
		p.examine(h);
		System.out.println(h.getMood());
		h.expressFeelings();
		p.observe(h);
		System.out.println(h.toString());
		
		//Examine Sad Object
		p.examine(s);
		System.out.println(s.getMood());
		s.expressFeelings();
		p.observe(s);
		System.out.println(s.toString());
		
	}
	
	

}

/*
public class PsychiatristObject
private examine
private observe

abstract MoodyObject
getMood()

extend SadObject
print String "cry";

extend HappyObject
print String "laugh";
*/