/*
package pa4;

public class maxSum{
    private int []money;
    int value[][], used[];

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
        value = new int[2][r];
        used = new int[r];
    	for(int i = 0; i < r; i++) {
    		value[0][i] = value[1][i] = used[i] = -1;
    	}
    	sum(r-1);
    	
    	System.out.print("\nused[]:\t\t");
    	for(int i = 0; i < r; i++)
    		System.out.print(used[i] + "\t");
    	
    	System.out.print("\nvalue[0]:\t");
    	for(int i = 0; i < r; i++)
    		System.out.print(value[0][i] + "\t");
    	System.out.print("\nvalue[1]:\t");
    	for(int i = 0; i < r; i++)
    		System.out.print(value[1][i] + "\t");
    	
        return r = Math.max(value[0][r-1], value[1][r-1]);
    }
    
    private void sum(int n) {
    		if(n > 1 && used[n] == -1)
        		sum(n-1);
    		if(n < 2) {
    			if(used[n] == -1) {
    				used[0] = used[1] = 1;
        			if(money[0] == 0)
        				used[0] = 0;
        			if(money[1] == 0)
        				used[1] = 0;
            		value();
    			}
        	}
        	else{
        		if(money[n] == 0) {
        			used[n] = 0;
        			value();
        		}
        		else {
        			if(used[n-2] + used[n-1] == 2) {
            			if(money[n] <= money[n-1] && money[n] <= money[n-2]) {	// min: n
            				used[n] = 0;
            				value();
            			}
            			else if(money[n-1] < money[n-2] && money[n-1] <= money[n]) {	// min: n-1
            				used[n-1] = 0;
            				used[n] = 1;
            				value();
            			}
            			else if(money[n-2] < money[n] && money[n-2] < money[n-1]){	// min: n-2
            				used[n-2] = 0;
            				used[n] = 1;
            				used(n-2, 0);
            			}
            			else if(money[n-1] == money[n-2] && money[n-1] < money[n]) {
            				used[n] = 1;
                			used(n, 1);
            			}
            		}
            		else {
            			used[n] = 1;
            			value();
            		}
        		}
        	}
    	return;
    }
    private void value() {
    	int i;
    	if(used[0] == 1) value[1][0] = money[0];
		else	value[0][0] = 0;
		for(i = 1; i < money.length && used[i] != -1; i++) {
			if(used[i] == 1)
				value[1][i] = value[used[i-1]][i-1] + money[i];
			else
				value[0][i] = value[used[i-1]][i-1];
		}
    }
    
    private int used(int n, int count) {
    	int p = 0;
    	if(count > 0)
    		p = 1;
    	used[n] = p;
    	if(n == 0)
    		return value[p][n];
		int q = used(n-1, 0);
		value();
		if(count < 2) {
			if(used(n-1, count+1) < q) {
				used[n-1] = 0;
			}
		}
    	return value[p][n];
    }
}
 

*/

// 3.1score
/*
package pa4;

public class maxSum{
    private int []money;
    int value[][], used[];

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
        used = new int[r];
    	for(int i = 0; i < r; i++) {
    		value[0][i] = value[1][i] = used[i] = -1;
    	}
    	value[0][0] = 0;
    	value[1][0] = money[0];
    	
    	value[0][r] = sum(r-1, 0);

    	for(int i = 0; i < r; i++) {
    		value[0][i] = value[1][i] = used[i] = -1;
    	}
    	value[0][0] = 0;
    	value[1][0] = money[0];
    	
    	value[1][r] = sum(r-1, 1);

    	System.out.print("\nused[]:\t\t");
    	for(int i = 0; i < r; i++)
    		System.out.print(used[i] + "\t");
    	
    	System.out.print("\nvalue[0]:\t");
    	for(int i = 0; i <= r; i++)
    		System.out.print(value[0][i] + "\t");
    	System.out.print("\nvalue[1]:\t");
    	for(int i = 0; i <= r; i++)
    		System.out.print(value[1][i] + "\t");
    	
    	
        return Math.max(value[0][r], value[1][r]);
    }
    
    private int sum(int n, int count) {
    	int p = 0;
    	if(count > 0)
    		p = 1;
    	
    	if(n > 0) {
    		int q = sum(n-1, 0);
    		int r = 0;
    		
    		if(count < 2) {
    			r = sum(n-1, count+1);
    		}
    		if(q > r) {
    			value[p][n] = q + money[n] * p;
    			used[n-1] = 0;
    		}
    		else {
    			value[p][n] = r + money[n] * p;
    			used[n-1] = 1;
    		}
    	}
    	return value[p][n];
    }
}
*/

// score 7.6~8
/*

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
        value = new int[2][r];
    	for(int i = 1; i < r; i++) {
    		value[0][i] = value[1][i] = -1;
    	}
    	value[0][0] = 0;
    	value[1][0] = money[0];
 
        return r = Math.max(sum(r-1, 0), sum(r-1, 1));
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

1. value[][] -> value[], value[]
2. sum()' p delete
*/