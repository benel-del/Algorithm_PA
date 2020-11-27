package pa4;

public class maxSum{
    private int []money;
    int i;
    int arr[][];

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
        //r = 5;
    	arr = new int[r][2];
    	for(i = 0; i < r; i++)
    		arr[i][0] = arr[i][1] = -1;
    	r = Math.max(sum(r-1, 0, 0), sum(r-1, 1, 1));
    	//r = sum(r-1, 1, 1);
    	
        return r;
    }
    
    private int sum(int n, int count, int isUsed) {
    	//System.out.println("sum(" + n + ", " + count + ", " + isUsed + ") : " + arr[n][isUsed]);
    	int q = 0;
		if(arr[n][isUsed] >= 0) {
			return arr[n][isUsed];
		}
    	if(n == 0) {
    		if(isUsed == 1)
    			q = money[0];
    		else
    			q = 0;
    	}
    	else {
    		if(isUsed == 1) {	// money[n] 사용
    			if(count < 2)
    				q = sum(n-1, count+1, 1) + money[n];	// money[n-1] 사용
				q = Math.max(q, sum(n-1, 0, 0) + money[n]);	// money[n-1] 사용x
    		}
    		else {	// money[n] 사용x
				q = Math.max(sum(n-1, 1, 1), sum(n-1, 0, 0));	// money[n-1] 사용x
    		}
    	}
    	
    	return arr[n][isUsed] = q;
    }
}