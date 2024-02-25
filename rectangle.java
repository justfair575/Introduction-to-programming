class rectangle {
	
	// atributos
	
	private int width; // inteiros > 0 
	private int height; // inteiros > 0
	
	// Métodos construtores
	
	rectangle(int width, int height){
		
		if(height<=0 || width<=0)
			throw new IllegalArgumentException("valores positivos oh meu ganda filha da puta");
		
		this.width = width;
		this.height = height;
		
	}
	
	// Métodos de instância
	
	int area () {
		
		return width*height;
	}
	
	int perimeter (){
		
		return 2*height+2*width;
	}
	
	double diagonal (){
		
		return Math.sqrt(width*width+height*height);
	}
	
	boolean isSquare(){
		
		return (height==width);
	}
	
	rectangle scaledCopy (int factor){
		if (factor <= 0)
			throw new IllegalArgumentException("valores positivos crlh");
		
		return new rectangle(width*factor, height*factor);
	}
	
	rectangle sum(int width, int height){
		
		return new rectangle (this.width+width, this.height+height);
	}
	 
	rectangle sum(rectangle r){
		
		return new rectangle (width+r.width, height+r.height);
	}
	
	boolean fits(rectangle r){
		
		return width<=r.width && height<=r.height;
	}
	
	// Métodos estáticos, funções auxiliares
	
	static rectangle quadrado(int size){
		
		
		return new rectangle (size, size);
	}
	
	
		
	
	
	
	// Função de teste
	
	static void teste (){
		
		rectangle r1 = new rectangle (8,12);
		rectangle r2 = new rectangle (5,2);
		rectangle r3 = new rectangle (6,7);
		int aux = r3.area();
		rectangle r4 = r3.sum(r2);
		rectangle r5 = r2.sum(r3);
		boolean b1 = r4.fits(r3);
		boolean b2 = r3.fits(r4);
		return;
	}

	
}