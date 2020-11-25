package pa4;

public class maxSum{
    private int []money;

//Declare and define additional variables or functions here if you need...
    int i;

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
            //r = Math.max(sum(money.length-2, 1), sum(money.length-1, 1));
            r = sum(money.length-1, 1);
            return r;
    }
    	
    private int sum(int n, int count) {
    	if(n < 0)
    		return 0;
    	int q;
    	if(count == 3)
    		q = 0;
    	else
    		q = money[n];

    	if(n > 0) {
    		if(count < 3)
    			q += sum(n-1, count+1);
        	q = Math.max(sum(n-1, 1), q);
    	}

    	return q;
    }
}