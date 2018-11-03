public class RockPaperScissorsGame {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Scissors s = new Scissors(5);
		Paper p = new Paper(7);
		Rock r = new Rock(15);
		System.out.println(s.fight(p) + "," + p.fight(s)); //10>7 , 3.5<5
		System.out.println(p.fight(r) + "," + r.fight(p)); //14<15, 7.5>7
		System.out.println(r.fight(s) + "," + s.fight(r)); //30>5, 2.5<15

	}

}
