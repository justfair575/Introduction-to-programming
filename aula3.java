class aula3 {
static int divisors (int n){
		
		int i=1;
		int cont=0;
		
		while (i<=n){
			
			if (n%i==0){
				cont=cont+1;
			}
			i=i+1;
		}
		return cont;
	}
		
	

static int sumDivisors (int n){
	
	int i=1;
	int res=0;
	
	while (i<n){
		
		if (n%i==0){
			res=res+1;
		}
		
		i=i+1;
	}
	return res;
}

static int numberOfPerfectNumbersUpTo (int n){


	int i=1;
    int cont=0;
    
    while (n<=n){
    	
    	if (sumDivisors(i)==i){
    		cont=cont+1;
    	}
    	i=i+1;
    }
    return cont;
}

static boolean isPrime (int n){
	
	
	
	if (divisors(n)==2){
		return true;
	} else {
		return false;
		
	}
}

static int sumPrimesSmallerThan (int n){
	
	int i=1;
	int res=0;
	while (i<n){
		if (isPrime(i)==true){
			res=res+i;
		}
		i=i+1;
	}
	return res;
}

static int countPrimesUpTo (int n){
	 
	int i=1;
	int count=0;
	while (i<=n){
		if (isPrime(i)==true){
			count=count+1;
		}
		i=i+1;
	}
	return count;

}



static boolean existsPrimeBetween (int min, int max){
	
        int i=min+1;
        
		 while (min<i && i<max){
		if (isPrime(i)==true){
			return true;
		
		}
		i=i+1;
		 }
return false;
}


	static int fibonacci(int n) {
		 if(n <= 1) {
		 return n;
		 } else {
		 return fibonacci(n - 1) + fibonacci(n - 2);
		 }
		}

	static int fatorial(int n){
		if (n==0){
			return 1;
		} else {
			return n*fatorial(n-1);
		

	}
}
	static int gcd(int n, int a){
		if (a==0){
			return n;
		} else {
			return gcd(a, n % a);
		}
	}

	static int[] f(int[] v) {
        int[] u = new int[v.length];
        int i = 0;
        while(i != v.length) {
            u[v.length - i - 1] = v[i];
            i = i + 1;
        }
        return u;
    }
}