class rational {

	//atributos
	
	final int num; //inteiro positivo ou negativo
	final int den; //inteiro positivo
	
	//Métodos construtores
	
	rational(int num){
		this.num = num;
		this.den=1;
		
	}
	
	rational(int num, int den){
		
		if(den<=0)
			throw new IllegalArgumentException("valores positivos no denominador");
		this.num=num;
		this.den=den;
	}
	
	public String toString(){
		
		return num+"/"+den;
	}
	
	double value(){
		
		return (double)num/den;
	}
	
	rational multiply(int num, int den){
		
		return new rational (this.num*num, this.den*den);
		
		
	}
	
	rational addition(int num, int den){
		
		return new rational ((this.num*den)+(this.den*num), this.den*den);
	}
	
	boolean isBigger(rational r){
		
		 if (value()==r.value());
		 return true;
		 
	
	}
	
	
	
	
	
	//Função de teste
	
	rational scale (int factor){
		if (factor<=0)
			throw new IllegalArgumentException("");
		
		return new rational (num*factor, den);
	}
	
	static void teste(){
		
		rational r1 = new rational(5);
		rational r2 = new rational(6,11);
		rational r3 = new rational(9,8);
		rational r4 = r2.scale(5);
		
				
			return;
	}
}
				
				
				