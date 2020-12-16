package pa5;

public class grid{
    private int n;
    long result;
    int arr[][];	// (x, y). 0: not visit yet, 1: visited
//Declare more variables here if you need...

    public grid(int n){
    	this.n = n;
    	this.result = 0;
    }
    long numOfWays(){
    	result = 0;
    	arr = new int[n+1][n+1];
    	arr[0][0] = 1;
		func2(0, 0);
		return result;
    }

//Define more functions here if you need...

    private void func2(int x, int y) {
    	if(x == n && y == n)	// now position: (n, n)
    		result ++;
    	else {
			arr[x][y] = 1;
			if(x < n && arr[x+1][y] == 0)
				func2(x+1, y);
			if(x > 0 && arr[x-1][y] == 0)
				func2(x-1, y);
			if(y < n && arr[x][y+1] == 0)
				func2(x, y+1);
			if(y > 0 && arr[x][y-1] == 0)
				func2(x, y-1);
			arr[x][y] = 0;	// return
    	}
    	return;	// no way
    }
}