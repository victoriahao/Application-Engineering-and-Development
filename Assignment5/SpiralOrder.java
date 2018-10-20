//Extra Credit
import java.util.ArrayList;
import java.util.List;

public class SpiralOrder{
	
	public List<Integer> spiralOrder(int[][] matrix) {
		List<Integer> result = new ArrayList<Integer>();
		
		if(matrix == null || matrix.length == 0) {
			return result;
		}
		
		int m = matrix.length;
		int n = matrix[0].length;
		
		int a = 0;
		int b = 0;
		
		while(m>0 && n>0) {
			
			if(m==1) {
				for(int i=0; i<n; i++) {
					result.add(matrix[a][b++]);
				}
				break;
			}
			else if(n==1) {
				for(int i=0; i<m; i++) {
					result.add(matrix[a++][b]);
				}
				break;
			}
			
			//top move right
			for(int i=0; i<n-1; i++) {
				result.add(matrix[a][b++]);
			}
			
			//right move down
			for(int i=0; i<m-1; i++) {
				result.add(matrix[a++][b]);
			}
			
			//bottom move left
			for(int i=0; i<n-1; i++) {
				result.add(matrix[a][b--]);
			}
			
			//left move up
			for(int i=0; i<m-1; i++) {
				result.add(matrix[a--][b]);
			}
			
			a++;
			b++;
			m=m-2;
			n=n-2;
		}
		
		return result;
	}

	public static void main(String[] args) {
		
		SpiralOrder so = new SpiralOrder();
		
		int[][] matrix= {
				        {1, 2, 3},
				        {4, 5, 6},
				        {7, 8, 9}
		                };
		
		so.spiralOrder(matrix);
		List<Integer> aftermatrix = so.spiralOrder(matrix);
		System.out.println(aftermatrix);
				
		//System.out.println(so.spiralOrder(matrix));
    }
}
