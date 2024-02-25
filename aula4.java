class aula4 {
static int[] naturals(int n){
		
		int i = 0;
		int[] v = new int[n];
		
		while (i<v.length){
			
			v[i]=i+1;
			i=i+1;
			
		}
		
		return v;

	}
	
	static int sum(int[] v){
		
		int i=0;
		int res = 0;
		
		while (i<v.length){
			
			res=res+v[i];
			i=i+1;
			
		}
		
		return res;
	}
	
	static int[] randomDigits (int size){
	
	int [] v = new int [size];

	int i = 0;
	
	while (i<v.length){
		v[i]=(int)(Math.random()*10);
		i=i+1;
		
	}
	
	return v;
	
}

	static double mean (int[] v){
	
return (double)sum(v)/v.length;

	
	}

	static int[] copy(int[] v, int length){
		
		int i= 0;
		int[] y = new int [length];
		
		while (i<v.length){
			
			y[i]=v[i];
			i=i+1;
			
		}
		return y;
	}

static int[] copy(int[] v){
	
	int i= 0;
	int[] y = new int [v.length];
	
	while (i<v.length){
		y[i]=0;
		i=i+1;
	}
return y;
}

static boolean exists(int n, int[] v){
	int i=0;
	
	while (i<v.length){

	if(v[i]==n){
	
	return true;
	
}
	i=i+1;
}


return false;

}

static int contagem(int n, int[]v){
	int i=0;
	int cont=0;
	while (i<v.length){
	if(v[i]==n){
		
		cont=cont+1;

	}
	i=i+1;
}
	return cont;
}

static int max(int[] v){
	int i=0;
	int max = v[0];
	while (i<v.length){
		if (v[i]>max){
			max=v[i];
		}
		i=i+1;
		
	}
return max;
}

static int[] subArray(int indice1, int indice2, int[]v){
	int[] subv = new int [indice2-indice1+1];
	int i=0;
	while (i<subv.length){
		subv[i]=v[indice1+i];
		i=i+1;
	}
	return subv;
}

static int[] firstHalf(int[] v, boolean includeMiddle){
	int x=v.length/2;
	if (v.length % 2==1 && includeMiddle==true){
		x=x+1;
	}
	return subArray(0, x-1, v);
}

static int[] secondHalf(int[]v, boolean includeMiddle){
	int x=v.length/2;
	
	if (v.length % 2==1 && includeMiddle==true){
		x=x+1;
	}
	return subArray(v.length/2,v.length-1,v);
}

static int[] merge(int[] left, int[] right){
	int[]y = new int [left.length+right.length];
	int i=0;
	while (i<left.length && i<right.length){
		y[i]=left[i];
		y[left.length+i]=right[i];
		i=i+1;
	}
	return y;
}

static int[] invert(int[]v){
	int i=0;
	int x=v[i];
	while (i<v.length/2){
		v[i]=v[v.length-1-i];
		v[v.length-1-i]=x;
		i=i+1;
	}
	return v;
}

static int random(int[]v){
	
 return v[(int) (Math.random()*v.length)];
}
}