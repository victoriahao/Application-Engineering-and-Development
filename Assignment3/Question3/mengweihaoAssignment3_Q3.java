public class mengweihaoAssignment3_Q3 {
	
	static String reverseWords(String str)
	{
		String[] temp = str.split("\\s");
		String result = "";
		
		for (int i = 0; i < temp.length; i++) { 
            if (i == temp.length - 1) 
                result = temp[i] + result; 
            else
                result = " " + temp[i] + result; 
        } 
        return result; 
    }
	
	public static void main(String[] args) 
    { 
        String s = "The sky is blue"; 
        System.out.println(reverseWords(s));
    } 
		
}
