class aula5 {
	static void dummy (int x, int[] v ){
		x= 999;
		v[0]=3;
		v[1]=2;
		v[2]=1;
	}

	static void teste(){
		int a = 5;
		int [] vector = new int [3];
		vector[0]=1;
		vector[1]=2;
		vector[2]=3;
		dummy(a,vector);
	}

	static char[] create(char c, int n){
		int i=0;
		char[]v= new char [n];
		while (i != v.length){
			v[i]=c;
			i++;
		}
		return v;
	}

	static void fill(char c, char[] v){
		int i=0;
		while (i!=v.length){
			v[i]=c;
			i++;
		}
			return;
	}

	static void replace(char c, char t, char[] v){
		int i=0;

		while (i!=v.length){
		if (v[i]==c){
			v[i]=t;
		}
		i++;
	}
	}
	 
	static void replace2(char c,char b, char[] v){
		int i=0;

		while (v[i]==c){
			v[i]=b;
		i++;
	}
	}

	static void replace3(char c,char b, char[] v){
	for (int i=v.length-1; i>-1;i--){
		if (v[i]==c){
			v[i]=b;
			return;
	}
	}

	}

	static void shiftLeft(char[]v1){
		char[]v2=new char[v1.length];
		int i=0;
		int b=v1.length-1;
		 while (i!=v1.length-1){
			 v1[i]=v2[b];
		 
			 i++;
			 b--;
		 }

	}

	static void shiftLeft1(char[]v){
		char c = v[0];
		for(int i=0; i<v.length-1;i++){
			v[i]=v[i+1];
		}
		v[v.length-1]=c;
	}

	static void shiftRight(char[]v){
		char c = v[v.length-1];
		for(int i=v.length-1; i>=0;i--){
			if(i>1){
			v[i]=v[i-1];
		}
		v[0]=c;
	}
	}

	static void swap(int a, int b, char[] v){
		int i=0;
		char c=v[b];
		while (i!=v.length-1){
				v[b]=v[a];
			v[a]=c;
					i++;
					return;
		}
	}

	static void inverter(char[]v){
		char c = v[0];
		for(int i=0; i<v.length-1;i++){
			v[i]=v[i+1];
		}
		v[v.length-1]=c;
	}

	static char[] copy(char[] v){
		int i=0;
		char[] v2=new char [v.length];
		while (i!=v.length){
		v[i]=v2[i];
		i++;
		}
	return v2;
	}

	static char[] subArray (int a,int b, char []v){
		char []v1=new char [b-a+1];
		int i=a;
		while (i<=b){
			v1[i-a]=v[i];
			i=i+1;
		}
		return v1;
	}

	static int randomIndex (int max){
		return(int) (Math.random()*(max+1));
	}

	static void replaceRandomPosition(char c,char[] v){
		int posicao= randomIndex(v.length-1);
		v[posicao]=c;
	}
	
	 public static boolean temRepetidos(int[] vetor) {
	        for (int i = 0; i < vetor.length; i++) {
	            for (int j = i + 1; j < vetor.length; j++) {
	                if (vetor[i] == vetor[j]) {
	                    // Encontramos um número repetido
	                    return true;
	                }
	            }
	        }

	        // Não encontramos números repetidos
	        return false;
	    }
}