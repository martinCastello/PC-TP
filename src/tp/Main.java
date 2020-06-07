package tp;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;
import java.io.IOException;
import java.util.Date;
import java.util.Scanner;

//no queremos que usen synchronizedList, el wrapper synchronized lo tienen que hacer ustedes

public class Main {

	public static void main ( String [] args ) throws InterruptedException, IOException {
		System.out.println("Indique la cantidad de LatinWorker a utilizar: ");
		Scanner sc = new Scanner(System.in);
		int quantityWorkersByUser = sc.nextInt();
		int quantityWorkers = quantityWorkersByUser;
		Date initialDate = new Date();
		File file = new File(".\\src\\inputs-ejemplo");
		FileReader fr = new FileReader(file);
		BufferedReader br=new BufferedReader(fr); 
		int rows = Integer.parseInt(br.readLine());
		if(quantityWorkersByUser > rows)
			quantityWorkers = rows;
		ThreadPool threadPool = new ThreadPool(quantityWorkers, rows, initialDate);
		for(int i=1;i<=rows;i++) {
			threadPool.launch(new DummyTask(br.readLine(), i));
		}
		fr.close();
		threadPool.stop();
		
//		StringBuffer sb=new StringBuffer(); 
//		String line;
//		while((line=br.readLine())!=null){  
//			sb.append(line);      
//			sb.append("\n");       
//		}  
//		fr.close();
//		System.out.println("Contents of File: ");  
//		System.out.println(sb.toString());
	}

}
