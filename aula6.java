class aula6 {
static int[][] create(int lines, int columns) {
		
		int [][] m= new int[lines][columns];
		
		for(int i=0; i<m.length;i++){
			for (int j=0; j<m[i].length;j++){
				m[i][j]=(int) (Math.random()*10);
			}
		}
		return m;
	}
	
	static int[][] create2 (int linescolumns){
		
		return create (linescolumns,linescolumns);
		
	}
	
	static int soma (int[][] m){
		
		int sum=0;
		
		for(int i=0; i<m.length;i++){
			for (int j=0; j<m[i].length;j++){
				sum+=m[i][j];
			}
		}
		return sum;
	}
	
	static int contagem (int [][] m){
		
		int cont=0;
		for(int i=0; i<m.length;i++){
			for (int j=0; j<m[i].length;j++){
				cont++;
			}
		}
		return cont ;
	}
	
	static int[] unroll(int[][] m) {
		
		int[] v= new int [contagem(m)];
		int k=0;
		
		for(int i=0; i<m.length;i++){
			for (int j=0; j<m[i].length;j++){
				v[k]=m[i][j];
				k++;
			}
		}
		return v;
	}
	static int[][] createMatrix(int[] v, int lines, int columns) {
		
		int[][] m= new int[lines][columns];
		int k=0;
		
		for(int i=0; i<m.length;i++){
			for (int j=0; j<m[i].length;j++){
				
				if(k!=v.length){
					m[i][j]=v[k];
					k++;
				}
			}
		
		}
		return m;
	}
				
	static int[][] createIdentity(int tamanho) {
		
		int [][] m= new int[tamanho][tamanho];
		
		for(int i=0; i<m.length;i++){
			for (int j=0; j<m[i].length;j++){
				
				if(i==j){
					m[i][j]=1;
					
				}
			}
		}
		return m;
		
	}
	
	static void scalarMultiplication(int[][] m, int c) {
		
		for(int i=0; i<m.length;i++){
			for (int j=0; j<m[i].length;j++){
				
				m[i][j]=m[i][j]*c;
				
			}
			
		}
		 return;
		 
	}			
		
	static boolean verificarIdentidade(int[][] m){
		
		for(int i=0; i<m.length;i++){
			for (int j=0; j<m[i].length;j++){
				
				if (i==j && m[i][j]!=1){
					return false;
				}
					if (i!=j &&m[i][j]!=0){
						return false;
					}
				}
			}
			
					
					
		
		return true;
		
}
	
	static void addition(int[][] a, int[][] b) {
		
		if (a.length==b.length && a[0].length==b[0].length){
			
			for(int i=0; i<a.length;i++){
				for (int j=0; j<a[i].length;j++){
					
					a[i][j]+=b[i][j];
					
					
				}
			}
			return;
	}
	}
		
	static boolean matrizValida(int[][]m){
		
		for(int i=0; i<m.length;i++){
			for (int j=0; j<m[i].length;j++){
		
		if(m[0].length!=m[i].length){
			return false;
		}
			
			}
			
		}
		return true;
	}
	
static boolean matrizValida2(int[][]m){
	
		if(matrizValida(m)==true && m.length==m[0].length){
			
			return true;
			
		}

return false;

}

static boolean matrizesIguais (int[][]m,int[][]n){
	

	for(int i=0; i<m.length;i++){
		for (int j=0; j<m[i].length;j++){
			
			if (m[i][j]!=n[i][j]){
				return false;
			}
		}
	}
	return true;
}
static int[] obterColuna(int[][]m,int n){
	int[] v= new int [m[n].length];
	
	for(int i=0; i<m.length;i++){
		for (int j=0; j<m[i].length;j++){
			
			v[i]=m[i][n];
		}
	}
	return v;
}
	
static int[][] obterTransposta(int[][] m){
	
	int[][] n = new int[m.length][m[0].length];
	
	for(int i=0; i<m.length;i++){
		for (int j=0; j<m[i].length;j++){
			
			n[i][j]=m[j][i];
		}
	}
	return n;
}

	static boolean simetria(int[][]m){
		
		for(int i=0; i<m.length;i++){
			for (int j=0; j<m[i].length;j++){
				
				if(m[i][j]!=m[j][i]){
					return false;
				}
			}
		
		}
		return true;
		
	}
	static int[][] multiplicarMatrizes(int[][]m,int [][]n){
		
		int [][] b= new int [m.length][n[0].length];
		int stack=0;
		
		for(int i=0; i<b.length;i++){
			for (int j=0; j<b[i].length;j++){
				for (int k=0; k<i;k++){
					
					stack+=m[i][k]*n[k][j];
					
					
					
				}
				b[i][j]=stack;
			}
		}
	return b;
	}
	
					
					
}