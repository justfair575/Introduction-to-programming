class SudokuBoard {
	
	ColorImage img;
	private int[][] matrizInicial = {{1, 2, 0, 4, 5, 0, 7, 0, 9},{4, 0, 6, 0, 8, 9, 0, 2, 3},{0, 8, 9, 0, 2, 3, 4, 5, 6},{2, 0, 0, 0, 6, 5, 8, 0, 7},{3, 0, 0, 8, 0, 7, 2, 1, 0},{8, 0, 0, 2, 1, 0, 3, 6, 5},{5, 0, 1, 0, 4, 2, 0, 7, 8},{6, 0, 2, 9, 0, 0, 0, 3, 1},{9, 0, 0, 5, 3, 1, 6, 4, 2}};
	private static int[][] matriz = {{1, 2, 0, 4, 5, 0, 7, 0, 9},{4, 0, 6, 0, 8, 9, 0, 2, 3},{0, 8, 9, 0, 2, 3, 4, 5, 6},{2, 0, 0, 0, 6, 5, 8, 0, 7},{3, 0, 0, 8, 0, 7, 2, 1, 0},{8, 0, 0, 2, 1, 0, 3, 6, 5},{5, 0, 1, 0, 4, 2, 0, 7, 8},{6, 0, 2, 9, 0, 0, 0, 3, 1},{9, 0, 0, 5, 3, 1, 6, 4, 2}};
	private static final Color WHITE = new Color(255,255,255);
	int jogadas=0;
	private int[] historicoDeX = new int[81];
	private int[] historicoDeY = new int[81];
	
//criar o jogo (Método construtor)
	
	SudokuBoard(int[][] matriz){
		
		this.matriz = matriz; // vou deixar assim porque se tirar o codigo nao funciona //
		this.matrizInicial = copiarMatriz(matriz); // usar copia da matriz para tornar a inicial na matriz do argumento //
		img = new ColorImage(450,450, new Color(255,255,255));
		SudokuAux.desenharGrelha(img);
		SudokuAux.colocarNumeros(img,matriz);			
		return;
	}
	
//retornar um índice dado coordenadas
	
	private int darNumero(int x, int y){
		
		if(matriz[x][y] != 0)	
			
			return matriz[x][y];
		
		return 0;
	}
 //efetuar jogada
	void jogada(int x, int y, int valor) { // nao pode sobrepor numeros //
		
		if(valor==0){
			
			System.out.println("Nao podes jogar um zero");
			
		}else{
		
		if(matriz[x][y]!=0){
			
			System.out.println("Nao podes jogar aqui!");
			
		}else{
			
	    jogadas++; // para o undo //
	    ultimaJogada(x, y); // atualiza a o historico do undo //

		    if (!SudokuAux.segmentoValido(matriz, x, y, valor)) { // verifica e pinta segmentos //
		    	
	        SudokuAux.segmentoErrado(img, SudokuAux.calcularIndiceSegmento(x, y));
	        SudokuAux.trocarNumeros(img, matriz, x, y, valor);
	        
	        }
	    
	    SudokuAux.trocarNumeros(img, matriz, x, y, valor);
	    validarColuna(); // verifica e pinta colunas //
	    validarLinha(); // verifica e pinta linhas //
	}	
	}
	}
	
	
//jogada aleatoria / dica a respeitar a regra do segmento)
	
	void dica() {
	  
	    int i = (int) (Math.random() * 9);
	    int j = (int) (Math.random() * 9);
	    int randomNum = (int) (Math.random() * 9) + 1;	
	    
	    if (matriz[i][j] == 0 && SudokuAux.segmentoValido(matriz, i, j, randomNum)){ // verifica regra do segmento //
	    	
	        matriz[i][j] = randomNum;
	        SudokuAux.trocarNumeros(img, matriz, i, j,randomNum);
	        jogadas++;
		    ultimaJogada(i,j);// atualiza a o historico do undo //
		    
	    }else{	 
	    	
	       dica();
	    }
	    validarLinha(); // verifica e pinta linhas //
	    validarColuna(); // verifica e pinta colunas //
	    
}
	
//Reiniciar o tabuleiro

	void reiniciar(){
		
	limparTab();	
	SudokuAux.colocarNumeros(img,matrizInicial);	
	SudokuAux.desenharGrelha(img);	
	jogadas = 0;
			 for (int i = 0; i < 9; i++) 
			        for (int j = 0; j < 9; j++) {
			        	
			            matriz[i][j] = matrizInicial[i][j];
		 }
	}
					
//Validar coluna
	
	private void validarColuna(){ // valida e pinta colunas //
			
		for (int i = 0; i < 9; i++) 
			if (!SudokuAux.colunaValida(matriz, i)){
				
				SudokuAux.colunaErrada(img,i+1);
			}
		}

//Validar linha
	
	private void validarLinha(){ // valida e pinta linhas //
		
		for (int i = 0; i < 9; i++) 
			if (!SudokuAux.linhaValida(matriz, i)){		
				
				SudokuAux.linhaErrada(img,i+1);
			}
	}
		
//Validar segmento não precisou de implementação aqui
				
//Saber se o Sudoku está concluído
	
	void concluído(){
		
		for(int i = 0; i!=matriz.length;i++){
			for(int j = 0; j!=matriz[i].length;j++){
				if(matriz[i][j]==0 || !SudokuAux.linhaValida(matriz,i) || !SudokuAux.colunaValida(matriz,i)){ // verifica se o sudoku esta incompleto ou errado //
					
					System.out.println("O Sudoku nao esta concluido!");
					return;
				}				
			}
		}
		System.out.println("O Sudoku esta concluido");
	}
				
//Metodo para copiar uma matriz	(auxilio para o metodo construtor sudoku)
	
	private int[][] copiarMatriz(int[][] matriz) {
	 
	    int[][] copia = new int[matriz.length][matriz[0].length];
	    
	    for (int i = 0; i < matriz.length; i++) {
	        for (int j = 0; j < matriz[0].length; j++) {
	        	
	            copia[i][j] = matriz[i][j];
	        }
	    }
	    return copia;
	}		
	
//Metodo para transformar uma copia de uma matriz na matriz inicial (auxilio para o metodo construtor sudoku)
	
	 void setMatrizInicial(int[][] matrizInicial) {
		  
	        this.matrizInicial = copiarMatriz(matrizInicial);
	    }			
			
//limpar tabuleiro
	 
	 void limparTab(){
		 
		 for(int x = 0; x!=img.getWidth();x++)
			 for(int y = 0; y!=img.getHeight();y++){
				 
				 img.setColor(x,y,WHITE);
			 }
	 }
			
//Atualizar o historico de jogadas (auxilio para o undo)
	 
	 void ultimaJogada(int x, int y){
		 
		 historicoDeX[jogadas] = x;
		 historicoDeY[jogadas] = y;
	 }
	 
//Undo
	 
	 void undo(){
		 
		 if(jogadas!=0){
			 
			 matriz[historicoDeX[jogadas]][historicoDeY[jogadas]] = 0;
			 limparTab();
			 SudokuAux.desenharGrelha(img);
			 SudokuAux.colocarNumeros(img,matriz);
			 historicoDeX[jogadas] = 0;
			 historicoDeY[jogadas] = 0;
			 jogadas--;
			 validarLinha();
			 validarColuna();	
			 
		 }else{
			 
			 System.out.println("Nao podes fazer mais undo");
		 }
	 }
////////////////////////////////////////////////"////////////////////////////////////
	 
// funçao de teste
		
		static void teste(){
					
			SudokuBoard board = new SudokuBoard(matriz);
			return;
		}
}

////////////////////////////////////////////////"////////////////////////////////////
