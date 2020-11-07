package pa3;

import java.io.*;

public class concat{
    private pri[] pa;	// pa[] { int: pr, string: word }

// Define additional variables or functions if you need...
    private int i, j;	// for FOR statement
    private int n, m = 0;	// n: array length pa[], m: sum of length pb[i]
    private char[] rs;	// the set of entire character of pb[] for RESULT
    
    /* counting sort */
    private String[] pb;	// the result of sorting - standard value: pr, result value: word
    private int[] pc;	// assistant array
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
        String result;

        // Insert source code here...
        n = pa.length;
        getValue();	// get max & sum of array length
        countingSort();	// for STABLE sorting
        
        rs = new char[m + n - 1 + n / 2];	// m을 pa[]에서 구했기 때문에 n/2 필요
        for(i = max = 0; i < n; i++) {
        	for(j = 0; j < pb[i].length(); j++)
        		rs[max++] = pb[i].charAt(j);	// max: not meaning of max. just index
        	if(i != n - 1)
        		rs[max++] = ' ';
        }
        
        result = new String(rs);
        return result;
    }
    
    private void getValue() {
    	max = pa[0].pr;
    	for(i = 1; i < n; i++) {
    		if(pa[i].pr > max)
    			max = pa[i].pr;
    		if(i >= n / 2)	// the condition 4)
    			m += pa[i].word.length();
    	}
    }
    
    private void countingSort(){
    	pc = new int[max + 1];
    	pb = new String[n];
    	
    	for(i = 0; i <= max; i++)	// initialization pc
    		pc[i] = 0;
    	for(i = 0; i < n; i++)
    		pc[pa[i].pr]++;
    	for(i = 1; i <= max; i++)	// Cumulative
    		pc[i] += pc[i-1];
    	for(i = n - 1; i >= n / 2; i--)	// i > floor(n/2)
    		//pc[pa[i].pr]--;
    		pb[--pc[pa[i].pr]] = new String(pa[i].word);
    	for(; i >= 0; i--)	// the condition 4) i < floor(n/2) -> "-"
    		//pc[pa[i].pr]--;
    		pb[--pc[pa[i].pr]] = new String("-");
    }
}