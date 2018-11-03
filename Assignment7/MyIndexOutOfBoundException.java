public class MyIndexOutOfBoundException extends IndexOutOfBoundsException{
	
	public int lowerBound = 0, upperBound = 9;
	
	public MyIndexOutOfBoundException(int index){
		System.out.println("Error Message: Index: "+index+", but Lower Bound: "+lowerBound+", Upper Bound: "+upperBound);
	}

	public static void main(String[] args) {
		int index = 10;
		if(index <= 9 && index >= 0) {
			System.out.println("Current index: "+index);
		}else{
			throw new MyIndexOutOfBoundException(index);
		}
	}
}

/*
main method output error message should be like this:
"Error Message: Index: 10, but Lower bound: 0, Upper bound: 9"
*/
