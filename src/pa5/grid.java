package pa5;

public class grid{
    private int n;
    long result;

//Declare more variables here if you need...

    public grid(int n){
    	this.n = n;
    	this.result = 0;
    }
    long numOfWays(){
    	int arr[][][] = new int[n+1][n+1][4];
		for(int x = 0; x <= n; x++) {
			for(int y = 0; y <= n; y++) {
				if(x == 0)
					arr[x][y][1] = 1;
				else if(x == n)
					arr[x][y][0] = 1;
				if(y == 0)
					arr[x][y][3] = 1;
				else if(y == n)
					arr[x][y][2] = 1;
			}
		}
		func2(arr, 0, 0);
		return result;
    }

//Define more functions here if you need...

    private void func2(int arr[][][], int x, int y) {
    	if(x == n && y == n)
    		result ++;
    	else {
    		for(int i = 0; i < 4; i++) {
    			if(arr[x][y][i] == 0) { // 아직 안 감
    				arr[x][y][i] = 1;
    				int arrB[][][] = arr.clone();
    				if(i == 0)
    					func2(arrB, x+1, y);
    				else if(i == 1)
    					func2(arrB, x-1, y);
    				else if(i == 2)
    					func2(arrB, x, y+1);
    				else
    					func2(arrB, x, y-1);
    			}
    		}
    	}
    }
}