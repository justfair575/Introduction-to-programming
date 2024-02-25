import java.util.Scanner;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.PrintWriter;


class Ficheiros {
	
	//função de teste
	
	static void teste(){
		
		int [] v2 = {23, 66, 77 ,84};
		boolean b1 = contains ("teste.txt", "manga");
		boolean b2 = contains ("teste.txt", "pera");
		writeRandomInts("data.txt",10,2,100);
		int[] v1 = readIntArray("teste.intvector");
		writeIntVector("data.txt", v2);
		boolean[][] m = readBooleanMatrix("teste.booleanmatrix");
		
	}
	
	static boolean contains (String fileName, String searchWord){
	
	int lines = 0;
	
	try {
	Scanner scanner = new Scanner(new File("data.txt"));
	
	while(scanner.hasNextLine()) {
	String line = scanner.nextLine();
	if (line.contains(searchWord))
		return true;
	
	lines++;
	}
	scanner.close();
	
	}
	
	catch(FileNotFoundException e) {
	System.out.println("ficheiro data.txt não encontrado");
	}
	
	return false;
	
}
	
	static void writeRandomInts (String fileName, int num, int min, int max){
		
		try {
			PrintWriter writer = new PrintWriter(new File(fileName));
			for(int i = 0; i!=num; i++) {
			writer.println((int)(Math.random()*(max-min+1))+min);
			}
			writer.close();
			}
			catch(FileNotFoundException e) {
			System.out.println("o ficheiro data.txt não encontrado" );
			}
		
}
	
	static int [] readIntArray (String fileName){
		
		try {
		Scanner scanner = new Scanner(new File(fileName));
		
		String line = scanner.nextLine();
		int size = Integer.parseInt(line);
		int [] v = new int [size];
	

		
		for (int i = 0;scanner.hasNextLine(); i++) {
		line = scanner.nextLine();
		v[i]=Integer.parseInt(line);
		
		}
		scanner.close();
		
		return v;
		
		}
		catch(FileNotFoundException e) {
			System.out.println("o ficheiro data.txt não encontrado" );
			}
		
		return null;
		
}
	
	static void writeIntVector(String fileName, int[]v){
		
		try {
			PrintWriter writer = new PrintWriter(new File(fileName));
			writer.print(v.length);
			
			for(int i = 0; i!=v.length; i++) {
			writer.println(v[i]);
			}
			writer.close();
			}
			catch(FileNotFoundException e) {
			System.out.println("o ficheiro não pode ser escrito" );
			}
	}
	
	static boolean[][] readBooleanMatrix(String fileName){
		
		try {
			Scanner scanner = new Scanner(new File(fileName));
			
			int lines = Integer.parseInt(scanner.nextLine());
			int cols = Integer.parseInt(scanner.nextLine());
			
			boolean [][] m = new boolean [lines][cols] ;
		

			
			for (int i = 0;i!=m.length && scanner.hasNextLine(); i++)
				for(int j=0;j!=m[i].length && scanner.hasNextLine(); j++)
	
			if(scanner.nextLine().equals("T"))
			m[i][j]=true;
				else
			m[i][j]=false;
			
			
			scanner.close();
			
			return m;
			
			}
			catch(FileNotFoundException e) {
				System.out.println("o ficheiro data.txt não encontrado" );
				}
			
			return null;
		
		
}
}