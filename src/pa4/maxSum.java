package pa4;

public class maxSum{
    private int []money;
    int value[][];

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

        r = money.length;
        value = new int[2][r+1];

    	for(int i = 0; i < r; i++) {
    		value[0][i] = value[1][i] = -1;
    	}
    	value[0][0] = 0;
    	value[1][0] = money[0];
    	
    	value[0][r] = sum(r-1, 0);

    	for(int i = 0; i < r; i++) {
    		value[0][i] = value[1][i] = -1;
    	}
    	value[0][0] = 0;
    	value[1][0] = money[0];
    	
    	value[1][r] = sum(r-1, 1);


        return Math.max(value[0][r], value[1][r]);
    }
    
    private int sum(int n, int count) {
    	int p = 0;
    	if(count > 0)
    		p = 1;
    	
    	if(count < 2 && value[p][n] >= 0) {
    		return value[p][n];
    	}
    	
    	if(n > 0) {
    		int q = sum(n-1, 0);
    		int r = 0;
    		
    		if(count < 2) {
    			r = sum(n-1, count+1);
    		}
    		if(q > r) {
    			value[p][n] = q + money[n] * p;
    		}
    		else {
    			value[p][n] = r + money[n] * p;
    		}
    	}
    	return value[p][n];
    }
}