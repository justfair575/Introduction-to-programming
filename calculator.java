class calculator {
	
	// atributos
	
	int value;   // inteiro maior ou igual a 0
	
	// Métodos construtores
	
	
	// Métodos de instância
	
	void plus(int n){
		
		if(n<0)
			return;
		
		value+=n;
	}
	
	void subtract(int n){
		
		if(n<0)
			return;
		
		value-=n;
		
		if (value<0)
			value=0;
		
	}
	
	void reset(){
		value=0;
	}
	
	void multiply(int n){
		
		if(n<0)
			return;
		
		int aux=value;
		for (int i= 0; i!=n-1; i++)
			plus(aux);
	}
	
	void exponent (int n){
		
		if(n<0)
			return;
		
		int aux=value;
		
		for(int i=0; i!=n-1;i++)
			multiply(aux);
	}
	
	void divide (int n){
		
		if(n<0)
			return;
		
		int i=0;
		for( ; value>=n; i++)
			subtract(n);
		
		value= i;
	}
		
	void resto (int n){
		
		if(n<0)
			return;
		
		while(value>=n)
			subtract(n);
	}
	
	
	// Função de teste
	
	static void teste(){
		
		calculator calc1 = new calculator ();
		calculator calc2 = new calculator ();
		return;
		
	}
}