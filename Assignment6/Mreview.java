import java.util.ArrayList;
//import java.util.Arrays;

public class Mreview implements Comparable<Mreview>
{
  // instance variables
  private String title;   // title of the movie
  private ArrayList<Integer> ratings;
  
  // constructors
  public Mreview() {
	  this.title = "";
	  this.ratings = new ArrayList<Integer>();
  }
  
  public Mreview(java.lang.String ttl) {
	  this.title = ttl;
	  this.ratings = new ArrayList<Integer>();
  }
  
  public Mreview(java.lang.String ttl, int firstRating) {
	  this.title = ttl;
	  this.ratings = new ArrayList<Integer>(firstRating);
  }
  
  // methods
  public java.lang.String getTitle(){
	  return this.title;
  }
  
  public void addRating(int r) {
	  ratings.add(r);
  }
  
  public double aveRating() {
	  
	  double sum = 0;
	  for(int i = 0; i < ratings.size(); i++) {
		  sum += ratings.get(i);
	  }
	  return sum/numRatings();
	  
  }
  
  public int numRatings() {
	  return ratings.size();
  }
  
  @Override
  public int compareTo(Mreview obj) {
	  int sort = this.getTitle().compareTo(obj.getTitle());
	  return sort; //return negative number if this title is before objective title
  }
  
  @Override
  public boolean equals(java.lang.Object obj) {
	  
	  if(this.getTitle().equals(((Mreview) obj).getTitle())){
		  return true;
	  }
	  else {
		  return false;
	  }
	  
  }
  
  @Override
  public java.lang.String toString(){
	  
	  return getTitle()+", average "+aveRating()+" out of "+numRatings()+" ratings";
  }
  
  public static void main(String[] args) {
	  //Test example 1: first movie review
	  Mreview mreview = new Mreview("Gone With The Wind");
	  System.out.println("First Movie Review:");
	  System.out.println("Name - " + mreview.getTitle());
	  mreview.addRating(4);
	  mreview.addRating(5);
	  mreview.addRating(5);
	  String result = mreview.toString();
	  System.out.println(result);
	  System.out.println("Average Ratings - " + mreview.aveRating()); //4.67
	  //Test example 2: second movie review
	  Mreview mreview2 = new Mreview("La La Land",4);
	  System.out.println("Second Movie Review:");
	  System.out.println("Name - " + mreview2.getTitle());
	  mreview2.addRating(5);
	  mreview2.addRating(3);
	  mreview2.addRating(4);
	  mreview2.addRating(5);
	  String result2 = mreview2.toString();
	  System.out.println(result2);
	  System.out.println("Average Ratings - " + mreview2.aveRating());
	  
	  //test whether two movie reviews are the same
	  boolean eq = mreview.equals(mreview2);
	  System.out.println(mreview.getTitle() + " vs. " + mreview2.getTitle() + ": " + eq);
	  
	  //compare two movie reviews using compareTo() method
	  int comp = mreview.compareTo(mreview2);
	  System.out.println(mreview.getTitle() + " vs. " + mreview2.getTitle() + ": " + comp);
	  
  }
  
}
