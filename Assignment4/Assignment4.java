import java.util.Arrays;

public class Assignment4 {
	
	/**
	 * The deadline of assignment4 is 10/12/2018 23:59 PST.
	 * Please feel free to contact Zane and Amanda for any questions.
	 */
	
	/*
	 * Given a string, find the first non-repeating character in it and return it's index. If it doesn't exist, return -1.
	 * s = "leetcode" return 0. 
	 * s = "loveleetcode" return 2.
	 */
    public int firstUniqChar(String s) {
    	if (s.isEmpty()) {
    		return -1;
    	}
    	//TODO
    	int[] totalChar = new int[26];
    	int[] firstAppear = new int[26];
    	for (int i=0; i < s.length(); i++) {
    		char c = s.charAt(i);
    		int index = c - 'a';
    		totalChar[index]++;
    		if (firstAppear[index]==0) {
    			firstAppear[index]=i;
    		}
    	}
    	
    	int index = Integer.MAX_VALUE;
    	
    	for (int j=0; j < 26; j++) {
    		if (totalChar[j] == 1) {
    			index = Math.min(index, firstAppear[j]);
    		}
    	}
    			
    	return index == Integer.MAX_VALUE ? -1 : index;		
    }
    
    /*
     *Given a non-negative integer num, repeatedly add all its digits until the result has only one digit.
     * Input: 38 Output: 2
     * Explanation: The process is like: 3 + 8 = 11, 1 + 1 = 2. Since 2 has only one digit, return it.
     */
    // zero is neither negative nor positive
    public int addDigits(int n) {
        //TODO
    	int sum = 0;
    	
    	String s = String.valueOf(n);
    	for(int i=0; i<s.length(); i++) {
    		sum = sum + (s.charAt(i) - '0');
    	}
    	
    	if (sum<10) {
    		return sum;
    	}
    	else {
    		return addDigits(sum);
    	}
    }
    
    /*
     *  Given an array nums, write a function to move all 0's to the end of it while maintaining the relative order of the non-zero elements.
     *  Input: [0,1,0,3,12] Output: [1,3,12,0,0]
     */
    //non-zero elements should come first
    //use swap to move zeroes to the end
    public void moveZeroes(int[] nums) {
    		//TODO
    	int temp;
        for (int i = 0; i < nums.length; i++) {
        	if (nums[i] == 0) {
        		for (int j = i + 1; j < nums.length; j++) {
        			if (nums[j] != 0) {
        				temp = nums[j];
        				nums[j] = nums[i];
        				nums[i] = temp;
        				break;
        			}
        		}
        	}
        }
        System.out.println(Arrays.toString(nums));
    }
	
    /*
     * Given a string s, find the longest palindromic substring in s. You may assume that the maximum length of s is 1000.
     * Input: "babad" Output: "bab" Note: "aba" is also a valid answer.
     */
	public String longestPalindrome(String s) {
		//TODO
		String palindrome;
		int start = 0;
		int maxLen = 1;
		int left, right;	
		
		for(int i = 0; i < s.length(); i++) {
			//even number of characters in string
			left = i;
			right = i+1;
			while(left >= 0 && right < s.length() && s.charAt(left) == s.charAt(right)) {
				if(right-left+1 > maxLen) {
					start = left;
					maxLen = right-left+1;
				}
				left--;
				right++;
				
			}
		}	
			//odd number of characters in string
		 for(int j = 0; j < s.length(); j++) {
			 //odd number of characters in string
			 left = j;
			 right = j;
			 while(left >= 0 && right < s.length() && s.charAt(left) == s.charAt(right)) {
				 if(right-left+1 > maxLen) {
					 start = left;
					 maxLen = right-left+1;
				 }
				 left--;
				 right++;
					
			 }
		 }
		palindrome = s.substring(start, start+maxLen);
		return palindrome;
       
	 
   } 
    /*
     * You are given an n x n 2D matrix representing an image. Rotate the image by 90 degrees (clockwise).
     * Given input matrix = [ [1,2,3],
  			      [4,5,6],
  			      [7,8,9] ],
     * rotate the input matrix in-place such that it becomes: [  [7,4,1],
  								 [8,5,2],
  								  [9,6,3] ],
     */
    public int[][] rotate(int[][] matrix) {
    	//TODO
    	for (int i = 0; i < matrix.length/2; i++) {
    		for (int j = 0; j < matrix[i].length; j++) {
    			int temp = matrix[i][j];
    			matrix[i][j] = matrix[matrix.length - 1 - i][j];
    			matrix[matrix.length - 1 - i][j] = temp;
    		}
    	}
    	for (int i = 0; i < matrix.length; i++) {
    		for (int j = i + 1; j < matrix[i].length; j++) {
    			int temp = matrix[i][j];
    			matrix[i][j] = matrix[j][i];
    			matrix[j][i] = temp;
    		}
    	}
    	return matrix;
    	
    }

    public static void main(String[] args) {
	// TODO Auto-generated method stub
    	Assignment4 assign = new Assignment4();
    	
    	//Question 1
    	String s = "leetcode";
    	int firstindex = assign.firstUniqChar(s);
    	System.out.println(firstindex);
    	
    	//Question 2
    	int n = 38;
    	int onlyonedigit = assign.addDigits(n);
    	System.out.println(onlyonedigit);
    	
    	//Question 3
    	int[] nums = {0,4,5,8,9,0,3,2,0};
    	assign.moveZeroes(nums);
    	
    	//Question 4
    	String st = "baabdc"; //even number
    	String palindrome = assign.longestPalindrome(st);
    	System.out.println(palindrome);
    	//test on odd number
    	String st1 = "abadccdcc";
    	String palindrome1 = assign.longestPalindrome(st1);
    	System.out.println(palindrome1);
    	
    	//Question 5
    	int matrix[][] = {{1,2,3},{4,5,6},{7,8,9}};
    	int[][] aftermatrix = assign.rotate(matrix);
    	int N = aftermatrix.length;
    	for(int i=0; i<N; i++) {
    		for (int j=0; j<N; j++) {
    			System.out.print(aftermatrix[i][j]+" ");
    		}
    		System.out.println(" ");
    	}
    }
}
