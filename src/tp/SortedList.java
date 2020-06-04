package tp;

import java.util.List;

public class SortedList {
	
//	private int n;
	private List<Integer> result;
//	private int[][] matriz;
	
	public SortedList() {
//		this.matriz = new int[n][n];
	}

	public synchronized void insert(Integer num) {
		result.add(num);
		result.stream().sorted();
//		for(int position=0; position<n; position++) {
//			for(int row = 0; row < n; row++) {
//				for (int column = 0; column < n; column++) {
//					matriz[row][column] = numbers[position];	
//				}
//			}
//		}
		
	}
}
