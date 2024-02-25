class SudokuAux {
	
	static final Color BLACK = new Color(0, 0, 0);
	static final Color RED = new Color(255, 0, 0);
	static final Color BLUE = new Color(0,0,255);
	static final Color WHITE = new Color(255,255,255);
	
// Função de teste
	
	static void main(){
		
		int[][] matriz = {{1, 2, 0, 4, 5, 0, 7, 0, 9},{4, 0, 6, 0, 8, 9, 0, 2, 3},{0, 8, 9, 0, 2, 3, 4, 5, 6},{2, 0, 0, 0, 6, 5, 8, 0, 7},{3, 0, 0, 8, 0, 7, 2, 1, 0},{8, 0, 0, 2, 1, 0, 3, 6, 5},{5, 0, 1, 0, 4, 2, 0, 7, 8},{6, 0, 2, 9, 0, 0, 0, 3, 1},{9, 0, 0, 5, 3, 1, 6, 4, 2}};
		ColorImage img = new ColorImage (450, 450, WHITE);		
		desenharGrelha(img);		
		colocarNumeros(img,matriz);
		//linhaErrada(img,1);
		//colunaErrada(img,9);
		//trocarNumeros(img,matriz,4,8,4);
		//segmentoErrado(img,1);
		//stringSudoku(matriz);			
		return;
	}
			
// Verifica se uma matriz Sudoku é válida;
	
	static boolean matrizSudokuValida(int[][] matriz){	
		
		if(matriz.length == 0)
			
		throw new IllegalArgumentException("matriz invalida");
			
		for (int i = 0; i != matriz.length; i++)
			for (int j = 0; j != matriz[i].length; j++)
				if (matriz.length != 9 || matriz[i].length != 9 || matriz[i][j] < 0 || matriz[i][j] > 9)
					
					return false;
		
		return true;
	}

// Coloca 0 na matriz Sudoku por percentagem;
	
	static int[][] colocar0(int[][] matriz, double percentagem) {
		
	    if (matrizSudokuValida(matriz)) { //nao e necessario//
	    	  	
	        int total = 81;
	        int zeros = (int) Math.round(total * percentagem / 100); // arredonda //
	        int count = 0;
	        
	        while (count < zeros) {
	        	
	            int linha = (int) (Math.random() * matriz.length);
	            int coluna = (int) (Math.random() * matriz[0].length);

	            if (matriz[linha][coluna] != 0) {
	            	
	                matriz[linha][coluna] = 0;
	                count++;
	            }
	        }
	    }

	    return matriz;
	}

// Fazer string com a matriz Sudoku; v2.0

	static String stringSudoku(int[][] matriz){	// vai ler um valor e concatenar para s //
		
		String s = new String();		
		
		for (int i = 0; i != matriz.length; i++){
			for (int j = 0; j != matriz[i].length; j++){	
				
				String aux = String.valueOf(matriz[i][j]);					
				s += aux;
		}
	}
		return s;
	}
	
// colocar matriz sudoku numa imagem 
	
	static void desenharGrelha(ColorImage img){ // colocar o desenho da grelha na imagem; (imagem tem de ter x e y iguais)	
		
		int size = img.getWidth()/9;
		int size2 = img.getWidth()/3;
		
		for (int x = 0; x != img.getWidth(); x++)
			for (int y = 0; y != img.getHeight(); y++){
				
				if( x % size == 0 || y % size == 0){	
					
				img.setColor(x, y, new Color (150,150,150));	
				
				if( x % size2 == 0 || y % size2 == 0){
					
					img.setColor(x,y,BLUE);
					img.setColor(449,y,BLUE); // forca o desenho da ultima coluna //
					img.setColor(x,449,BLUE); // forca o desenho da ultima linha //				
			}	
			}
	}
	}

	static void colocarNumeros(ColorImage img, int[][] matriz){// colocar os números na imagem
		
		int size = img.getWidth()/9;
		String s = stringSudoku(matriz);
		String aux = new String ();
		int i = 0;		
		
		for (int x = 0; x != img.getWidth(); x+=size)
			for (int y = 0; y != img.getHeight(); y+=size){
					if(s.charAt(i) != '0'){		
						
					aux = String.valueOf(s.charAt(i));	
					
					}else{		
						
						aux = " ";
					}					
					img.drawCenteredText(x+size/2,y+size/2,aux,25,new Color(43, 70, 73));
					i++;
			}
				}
			
	
// trocar os numeros v2.0
	
	static void trocarNumeros(ColorImage img, int [][] matriz, int X, int Y, int numero){ // pode sobrepor numeros // 

				matriz[X][Y] = numero;
				colocarNumeros(img, matriz);
		}
	
			
//trocar a linha errada para vermelho v3.0

	static void linhaErrada(ColorImage img, int index){	
		
		int size = img.getWidth()/9;
		
		for (int x = 0; x != img.getWidth(); x++)
			for (int y = 0; y != img.getHeight(); y++){		
					if((y%size==0) && (index>0 && index<9)){
						
						img.setColor(x, size*(index-1), RED);
						img.setColor(x, size*index, RED);					
					}
					if(index == 9){	// forcar o desenho da linha 9 //	
						
						img.setColor(x, size*(index-1), RED);
						img.setColor(x, 449, RED);						
					}					
					if(y > size*(index-1) && y < size*index){
						
					img.setColor(0,y,RED);
					img.setColor(449,y,RED);					
				}
			}
	}
		
//trocar a coluna errada para vermelho v3.0

	static void colunaErrada(ColorImage img, int index){	
		
		int size = img.getWidth()/9;	
		
		for (int x = 0; x != img.getWidth(); x++)
			for (int y = 0; y != img.getHeight(); y++){
				if((x%size == 0) && (index>0 && index<9)){	
					
					img.setColor(size*index, y, RED);
					img.setColor(size*(index-1), y, RED);
				}
				if(index == 9){	// forcar o desenho da coluna 9 //
					
					img.setColor(size*(index-1),y,RED);
					img.setColor(449,y,RED);
				}
				if(x > size*(index-1) && x < size*index){	
					
					img.setColor(x,0,RED);
					img.setColor(x,449,RED);
				}
			}
	}
	
//trocar segmento errado para vermelho v3.0

	static void segmentoErrado(ColorImage img, int index) {	
		
	    int size = img.getWidth() / 9; 
	    int linhaInicial = (index - 1) / 3 * size * 3;
	    int colunaInicial = (index - 1) % 3 * size * 3;
	    
	    for (int x = colunaInicial; x < colunaInicial + size * 3; x++) {
	    	 for (int y = linhaInicial; y < linhaInicial + size * 3; y++){	     	
	    		 if(index == 9){ // forca o desenho do segmento 9 //
	    			 
	 	        	img.setColor(x, linhaInicial, RED);
	 		        img.setColor(x,linhaInicial + size * 3-1 , RED);
	 		        img.setColor(colunaInicial, y, RED);
	 		        img.setColor(colunaInicial + size * 3 -1 , y, RED);
	 	       
	    		 }else{
	    			 
	        img.setColor(x, linhaInicial, RED);
	        img.setColor(x,linhaInicial + size * 3 , RED);
	        img.setColor(colunaInicial, y, RED);
	        img.setColor(colunaInicial + size * 3  , y, RED);
	    }
	    }
	}
	}

// valida uma coluna v2.0
	
	 static boolean colunaValida(int[][] matriz, int coluna) {	
		 
	        boolean[] numerosEncontrados = new boolean[10];	// vetor para verificar quais numeros ja foram encontrados //
	        
	        for (int linha = 0; linha < 9; linha++) {	
	        	
	            int numeroAtual = matriz[coluna][linha];
	            
	            if (numeroAtual != 0 && numerosEncontrados[numeroAtual]) {	    
	            	
	                return false;	                
	            }
	            numerosEncontrados[numeroAtual] = true; // marca o numero atual como encontrado //
	        }
	        return true;
	    }
	 
// valida um segmento
	 
	static boolean segmentoValido(int[][] matriz, int linha, int coluna, int numero) {	
		
		   	int linhaInicial = linha - linha % 3;
		    int colunaInicial = coluna - coluna % 3;
		    
		        for (int i = linhaInicial; i < linhaInicial + 3; i++) {
		            for (int j = colunaInicial; j < colunaInicial + 3; j++) {
		                if (matriz[i][j] == numero) {
		                	
		                    return false; 		                    
		                }
		            }
		        }		        
		        return true; 		        
		    }
	
// valida uma linha 
	
	static boolean linhaValida(int[][] matriz, int linha) {
		
	    boolean[] numerosEncontrados = new boolean[10]; // vetor para verificar quais numeros ja foram encontrados //
	    
	    for (int coluna = 0; coluna < 9; coluna++) {
	    	
	        int numeroAtual = matriz[coluna][linha];
	        if (numeroAtual != 0 && numerosEncontrados[numeroAtual]) {
	            return false;
	        }
	        numerosEncontrados[numeroAtual] = true; // marca o numero atual como encontrado //
	    }
	    return true;
	}

//calcula o índice do segmento pelas coordenadas (auxilio para a board)

	static int calcularIndiceSegmento(int x, int y) {	
				    		   
		    int indiceX = x / 3;
		    int indiceY = y / 3;		    		
		    return ((indiceY*3)+indiceX)+1;		    
		}
}









		
		
		
		
	
		
		
	

				
	
				
		

	
	


		
		
	
	
		
		
			
				
	
	
					
				
				
		
	


					
					
			
					
			
			
			
		



					
	
