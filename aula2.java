class aula2 {
static int max(int a, int b){
		
		if(a>b) {
			return a;
		} else {
			return b;
		}
		
	}
		
static boolean eMultiploDe(int a, int b){
	
	while(a>=b){
		a=a-b;
	}
		
		return (a==0);
				
	}


static int modulo(int x){
	
	if(x>=0) {
		return x;
	} else {
return -x;
	}

} 


static int irs(int x){
	
	if(x<=10000){
		return 1;
	}else{
		if(x<=25500){
			return 2;
		}else{
			if(x<=48500){
				return 3;
			}else{
				
					return 4;
				} 
			}
		}
}
	
	static char proximaLetra (char x){
		if (x=='z'){
			return 'a';
		}else{
			return (char) (x+1);
		}
	}

	static int primeiroDigito (int x){
		while (x>=10){
			x=x/10;
		}
		return x;
	}

	static int divide(int x, int z){
		int cont=0;
		while(x>=z){
			x=x-z;
			cont = cont+1;
		}
		return cont;
	}

static int doisElevadoA(int x){
	int cont=0;
	int res=1;
	while (cont<=x){
		res=res*2;
		cont=cont+1; 
	}
	return res/2;
}

static int somatorio(int x){
	int cont=1;
	int res=0;
			while (cont<=x){
				res=res+cont;
				cont=cont+1;
			}
			return res;
}

static int somatorioMasMaisDifÃ­cil(int x, int z){
	int cont=x;
			int sum=0;
			while(cont<=z){
				cont=cont+1;
				if(cont%2==0){
					sum=sum+cont;
				}
			}
				return sum;
			}

}