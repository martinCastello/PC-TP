package tp;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;
import java.io.IOException;
import java.util.Date;

public class Main {

	public static void main ( String [] args ) throws InterruptedException, IOException {
		Date initialDate = new Date();
		File file = new File(".\\src\\inputs-ejemplo");
		FileReader fr = new FileReader(file);
		BufferedReader br=new BufferedReader(fr); 
		int rows = Integer.parseInt(br.readLine());
		ThreadPool threadPool = new ThreadPool(10, rows, initialDate);
		for(int i=1;i<=rows;i++) {
			threadPool.launch(new DummyTask(br.readLine(), i));
		}
		threadPool.stop();
		
//		StringBuffer sb=new StringBuffer(); 
//		String line;
//		while((line=br.readLine())!=null){  
//			sb.append(line);      
//			sb.append("\n");       
//		}  
		fr.close();
//		System.out.println("Contents of File: ");  
//		System.out.println(sb.toString());
	}

}
