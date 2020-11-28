package pa4;

public class maxSum{
    private int []money;
    int value1[], value2[];

//Declare and define additional variables or functions here if you need...
    public maxSum(int[] m){

            // DO NOT modify constructor

            int i=0, n=m.length;
            money = new int[n];
            for(i=0;i<n;i++)        this.money[i] = m[i];
            return;
    }

    public int max(){
        int r = 0;
        int p = money.length;
        
        value1 = new int[p];	// value1[i]: max when money[i] is used
        value2 = new int[p];	// value2[i]: max when money[i] is not used
    	for(int i = 1; i < p; i++) {
    		value1[i] = value2[i] = -1;
    	}
    	value1[0] = money[0];

    	r = sum(p-1, 0);	// sum(p-1, 0): money[money.length-1] is not used
    	if(r < (p = sum(p-1, 1)))	// sum(p-1, 1): money[money.length-1] is used
    		r = p;
    	
        return r;
    }
    
    private int sum(int n, int count) {	// n: array index, count: number of serial 1
    	int q;
    	if(count > 0)	// money[n] is used
    		q = value1[n];
    	else	// money[n] is not used
    		q = value2[n];
    	
    	if(count < 2 && q >= 0) {
    		return q;
    	}
    	
    	if(n > 0) {
    		q = sum(n-1, 0);
    		if(count < 2) {	// possible for next index is used
    			int r;
    			if(q < (r = sum(n-1, count+1)))
    				q = r;
    		}
    		if(count > 0)
    			q = value1[n] = q + money[n];
    		else
    			q = value2[n] = q;
    	}
    	return q;	// max when sum(n, count)
    }
}