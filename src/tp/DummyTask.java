package tp;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

public class DummyTask implements Runnable{

	private String[] numbers;
	private int[][] matriz;
	private int n;
	private int numRow;
	
	public DummyTask(String row, int numRow) {
		this.numRow = numRow;
		numbers = row.split(" ");
		this.n = Integer.parseInt(numbers[0]);
		this.matriz = new int[n][n];
		int p=1;
		for(int r=0; r<n; r++) {
			for (int c=0; c<n; c++) {
				matriz[r][c] = Integer.parseInt(numbers[p]);
				p++;
			}
		}
	}
	
	public int getNumRow() {
		return this.numRow;
	}
	
	@Override
	public void run() {
//		System.out.println("Task row ["+ this.numRow + "] running");
		
		for (int i=0; i<this.matriz.length; i++) {
			List<Integer> numbersRow = new ArrayList<Integer>();
            for (int j=0; j < this.matriz[i].length; j++) {
            	numbersRow.add(this.matriz[i][j]);
            }
            if(numbersRow.stream().filter(num -> num <= this.n).distinct().collect(Collectors.toList()).size() != this.n)
            	throw new NoPerfectException();
        }
		
		for (int j=0; j<this.matriz.length; j++) {
			List<Integer> numbersColumn = new ArrayList<Integer>();
            for (int i=0; i<this.matriz[j].length; i++) {
            	numbersColumn.add(this.matriz[i][j]);
            }
            if(numbersColumn.stream().filter(num -> num <= this.n).distinct().collect(Collectors.toList()).size() != this.n)
            	throw new NoPerfectException();
        }
	}

}
