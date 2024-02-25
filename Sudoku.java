	import java.util.Scanner;
	import java.io.File;
	import java.io.FileNotFoundException;
	import java.io.PrintWriter;

class Sudoku {
	
	SudokuBoard sudokuBoard;
	private int[][] matriz;
	private int[][]matrizInicial;	
	
//Leitura de um ficheiro para matriz 9x9
	
	 static int[][] ficheiroMatriz(File file){
		 
		int[][] matriz = new int[9][9];
		
		try{
			
		Scanner s1 = new Scanner(file);	
		
		for(int i = 0; i!= matriz.length;i++)
			for(int j = 0; j!=matriz[i].length;j++){
				 if (s1.hasNextInt()) {
					 
				matriz[i][j] = s1.nextInt();
			}
			}
		s1.close();
		}
		catch(FileNotFoundException e){
			
			System.out.println("File nao encontrado");
		}
	return matriz;
	}
	
	
	
//Método construtor
	
	Sudoku(File file,double difficulty){
						
		matriz = ficheiroMatriz(file);	
		SudokuAux.colocar0(matriz,difficulty);
		matrizInicial = new int[9][9];
		
        for (int i = 0; i < 9; i++) {
        	for (int j = 0; j < 9; j++) {
        		
                matrizInicial[i][j] = matriz[i][j];
            }
        }
		sudokuBoard = new SudokuBoard(matriz);
		sudokuBoard.setMatrizInicial(matriz); // para nao confundir as matrizes (se tirar isto da erro) //
	}

//Métodos de jogo / Botões
	
	void jogada(int x, int y, int numero){
		
		sudokuBoard.jogada(x,y,numero);
	}	
	void undo(){
		
		sudokuBoard.undo();
	}
	void dica(){
		
		sudokuBoard.dica();
	}
	void reset(){
		
		sudokuBoard.reiniciar();
	}
	void estaConcluído(){
		
		sudokuBoard.concluído();
	}
	void save() {
		
	    try {
	    	
	            PrintWriter writer = new PrintWriter(new File("jogo1.sudgame"));
	            
	            for (int i = 0; i < matriz.length; i++) {
	                for (int j = 0; j < matriz[i].length; j++) {
	                	
	                    writer.print(matriz[i][j] + " ");
	                }
	                writer.println();
	            }
	            writer.close();
	            System.out.println("Jogo salvo com sucesso!");
	        }
	    catch (FileNotFoundException e) {
	    	
	        System.out.println("O arquivo jogo1.sudgame nao pode ser encontrado.");
	    }
	}
	void load() {	
		
	    sudokuBoard.limparTab();
	    int[][] matrizLoad = ficheiroMatriz(new File("jogo1.sudgame"));	   	   	   
	    this.matrizInicial = matrizLoad;	      
	    SudokuAux.desenharGrelha(sudokuBoard.img);
	    SudokuAux.colocarNumeros(sudokuBoard.img, matrizLoad);
	    System.out.println("Load concluido");
	}	
}
			
