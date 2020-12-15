package pa5;

public class grid{
    private int n;
    long result;
    int arr[][][];
//Declare more variables here if you need...

    public grid(int n){
    	this.n = n;
    	this.result = 0;
    }
    long numOfWays(){
    	result = 0;
    	arr = new int[n+1][n+1][4];
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
		func2(0, 0);
		return result;
    }

//Define more functions here if you need...

    private void func2(int x, int y) {
    	if(x == n && y == n)
    		result ++;
    	else {
    		for(int i = 0; i < 4; i++) {
    			if(arr[x][y][i] == 0) { // 아직 안 감
    				arr[x][y][i] = 1;
    				if(i == 0) {
    					arr[x+1][y][1] = 1;
    					func2(x+1, y);
    					arr[x+1][y][1] = 0;
    				}
    				else if(i == 1) {
    					arr[x-1][y][0] = 1;
    					func2(x-1, y);
    					arr[x-1][y][0] = 0;
    				}
    				else if(i == 2) {
    					arr[x][y+1][3] = 1;
    					func2(x, y+1);
    					arr[x][y+1][3] = 0;
    				}
    				else {
    					arr[x][y-1][2] = 1;
    					func2(x, y-1);
    					arr[x][y-1][2] = 0;
    				}
    				arr[x][y][i] = 0;
    			}
    		}
    	}
    }
}