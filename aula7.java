class aula7 {
	

	static int sortear (int n){
		return (int) (Math.random()*(n+1));
}
	
	static int constrains(int x, int a, int b){
		
		if(x>b){
			return b;
			
		}
			
		if (x<a){
			return a;
			
		}
		return x;
}
	
	static int contrains (int x){
		
		return constrains (x, 0, 255);
	}
	
	static boolean caraCoroa(){
		
		return (Math.random()>0.5);
	}
	
	static boolean [][] randomBooleanMatrix(int x, int a){
		
		boolean[][] m1 = new boolean [x][a];
		for(int i=0; i<m1.length; i++){
			for(int j=0; j<m1[i].length; j++){
				m1[i][j]= caraCoroa();

		}
	}
		return m1;
}
	
	static boolean[][] tabuleiroBinario(){
		
		boolean[][] m= new boolean [8][8];
		
		for(int i=0; i<m.length;i++){
			for (int j= 0; j<m[i].length; j++){
				if ((i+j)%2==0){
					m[i][j]= true;
					
				}else{
					
					m[i][j]= false;
				}
			}
		}
		return m;
	}

	static double distancia(int xa, int xb, int ya, int yb){
		
		return Math.sqrt(Math.pow(yb-ya,2)+Math.pow((xb-xa),2));
}
	static Color gray(int luminosidade){
		return new Color (luminosidade,luminosidade,luminosidade);
	}
	
	static Color randomGray(){
		
		return gray (sortear(255));
	}
	
	static Color randomColor(){
		
		return new Color (sortear(255),sortear(255),sortear(255));
	}

	static Color[] randomColorArray(int length) {
		Color[] v=  new Color [length];
		for(int i=0;i<v.length;i++){
			v[i]= randomColor();
		}
	return v;
	}
	
	static Color inverted(Color c){
		
		return new Color (255-c.getR(),255-c.getG(),255-c.getB())  ;
	}
	
	static Color changeBrightness(Color c,int delta){
		int r,g,b;
		r=contrains(c.getR()+ delta);
		g=contrains(c.getG()+ delta);
		b=contrains(c.getB()+ delta);
		return new Color (r,g,b);
	}
		
	static BinaryImage randomImage(int width, int height){
		
		BinaryImage img= new BinaryImage (width, height);
		
		for (int x=0; x<img.getWidth();x++){
			for (int y=0; y<img.getHeight();y++){
				if(caraCoroa()){
					img.setWhite(x,y);
					
				}
			}
		}
		return img;
					
				
	}
	
	static void drawSquare (BinaryImage img, int x0, int y0, int side){
		
		for (int x=x0; x<x0+side;x++){
			for (int y=y0;y<y0+side;y++){
				img.setWhite(x,y);
				
			}
		}
		
	}
	
	static void invert (BinaryImage img){
		
		for (int x=0; x<img.getWidth();x++){
			for (int y=0;y<img.getHeight();y++){
				if (img.isBlack(x,y)){
					img.setWhite(x,y);
				}else{
					img.setBlack(x,y);
					
				}
			}
		}
	}
	
	static BinaryImage convert (boolean[][] data){
		
		BinaryImage img = new BinaryImage (data[0].length,data.length);
		for(int i=0; i<data.length;i++){
			for (int j= 0; j<data[i].length; j++){
			
		
		if (data[i][j]){
			img.setWhite(j,i);
		}
			}
		}
		return img;
	}
		
		
		


	

	static void main(){
 
		Color c = new Color(255, 0, 0); // vermelho
		int r = c.getR(); // 255, componente de vermelho
		int g = c.getG(); // 0, componente de verde
		int b = c.getB(); // 0, componente de azul
		Color c1 = new Color(128, 128, 128);
		Color c2= gray(56);
		Color c3=randomGray();
		Color c4= randomColor();
		Color c5= inverted(c4);
		Color c6= changeBrightness (c5,-40);
		BinaryImage img = randomImage (200,100);
		drawSquare(img, 30, 30, 50);
		invert(img);
		BinaryImage img2 = convert (randomBooleanMatrix(200,100));
		
	}
}
