package pa4;

public class maxSum{
    private int []money;

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

            // Insert source code here...
            r = sum(money.length-1, 1);
            return r;
    }
    	
    private int sum(int n, int count) {
    	if(n == 0) {
    		if(count < 3)
    			return money[n];
    		else
    			return 0;
    	}
    	int q = sum(n-1, 1);
    	if(count < 3) {
    		if(n-1 == 0)
    			if(count+1 < 3)
    				q = Math.max(q, money[n-1] + money[n]);
    			else
    				q = Math.max(q,  money[n]);
    		else
    			q = Math.max(q, sum(n-1, count+1) + money[n]);
    	}
    	return q;
    }
}