package pa3;

import java.io.*;

public class concat{
    private pri[] pa;	// pa[] { int: pr, string: word }

// Define additional variables or functions if you need...
    private int i;	// for FOR statement
    private int n;	// array length
    
    /* counting sort */
    private String[] pb;	// the result of sorting - standard value: pr, result value: word
    private int max;	// for size of pc[]

    public concat(){
        this.pa = null;
    }

    public concat(int[] priority, String[] words){
        int i = 0, n = priority.length;
        this.pa = new pri[n];
        for(i=0;i<n;i++)        this.pa[i] = new pri(priority[i], words[i]);
        return;
    }

    public String concatenate(){
        String result = "";

        // Insert source code here...
        n = pa.length;

        getMax();	// for max
        countingSort();	// for STABLE sorting
        
        StringBuffer buffer = new StringBuffer();	// for 'string + string'
        for(i = 0; i < n; i++) {
        	//result += pb[i] + " ";	// score: 1.4s ~ 1.6s
        	buffer.append(pb[i] + " ");	// score: 14ms ~ 0.16ms
        }
        result = buffer.toString();
        return result;
    }
    
    private void getMax() {
    	max = pa[0].pr;
    	for(i = 1; i < n; i++) {
    		if(pa[i].pr > max)
    			max = pa[i].pr;
    	}
    }
    
    private void countingSort(){
    	int[] pc = new int[max + 1];	// assistant array
    	pb = new String[n];
    	
    	for(i = 0; i <= max; i++)	// initialization pc
    		pc[i] = 0;
    	for(i = 0; i < n; i++)
    		pc[pa[i].pr]++;
    	for(i = 1; i <= max; i++)	// Cumulative
    		pc[i] += pc[i-1];
    	for(i = n - 1; i >= n / 2; i--) {	// i >= floor(n/2)
    		pc[pa[i].pr]--;
    		pb[pc[pa[i].pr]] = new String(pa[i].word);
    	}
    	for(; i >= 0; i--) {	// i < floor(n/2) -> "-"
    		pc[pa[i].pr]--;
    		pb[pc[pa[i].pr]] = new String("-");
    	}
    }
}