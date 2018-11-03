public class FindMedian{
	
	public double findMedianSortedArrays(int[] nums1, int[] nums2) {
		int length1 = nums1.length;
		int length2 = nums2.length;
		if(length1 == 0 && length2 == 0) {
			return 0;	
		}				
		int middleIndex = (length1 + length2) /2;
		int[] k = new int[length1 + length2];
		double result = 0.0;
		int index = 0;
		for(int i = 0, j = 0; i < length1 || j < length2;) {
			if(index - 1 == middleIndex) {
				break;
			}				
			if(i >= length1 || (j < length2 && nums1[i] > nums2[j])) {
				k[index++] = nums2[j];
				j++;
			}
			else {
				k[index++] = nums1[i];
				i++;
			}
		}
		if((length1 + length2) % 2 == 0) {
			result = (k[middleIndex] + k[middleIndex - 1]) / 2.0;
		}
		else {
			result = k[middleIndex];
		}
		return result;
	}
	
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		FindMedian findMedian = new FindMedian();
		int[] nums1 = {1, 3};		
		int[] nums2 = {2};
		System.out.println("The median is " + findMedian.findMedianSortedArrays(nums1, nums2));
		
		int[] nums3 = {1, 2};
		int[] nums4 = {3, 4};
		System.out.println("The median is " + findMedian.findMedianSortedArrays(nums3, nums4));
		
		
		
	}

}
