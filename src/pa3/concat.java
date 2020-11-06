package pa3;

import java.io.*;

public class concat{
        private pri[] pa;

// Define additional variables or functions if you need...
        private int n, k, max;
        private int i;
        
        /* counting sort */
        private String[] pb;
        private int[] pc;

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
                k = n/2;
                
                //getMaxMin();	// for the range of pb[] in coungintSort
                getMax();
                countingSort();
                
                for(i = 0; i < n; i++) {
                	result += pb[i] + " ";
                }

                return result;
        }
        
        private void getMax() {
        	max = pa[0].pr;
        	for(i = 1; i < n; i++) {
        		if(pa[i].pr > max)
        			max = pa[i].pr;
        	}
        }
        
        /*
        private void getMaxMin() {
        	max = min = pa[0].pr;
        	i = 1;
        	while(i + 2 <= n) {
        		if(pa[i].pr < pa[i+1].pr) {
        			if(pa[i].pr < min)
        				min = pa[i].pr;
        			if(pa[i+1].pr > max)
        				max = pa[i+1].pr;
        		}
        		else {
        			if(pa[i].pr > max)
        				max = pa[i].pr;
        			if(pa[i+1].pr < min)
        				min = pa[i+1].pr;
        		}
        		i += 2;
        	}
        	if(n % 2 == 0) {	// # = even
        		if(pa[n-1].pr < min)
        			min = pa[n-1].pr;
        		if(pa[n-1].pr > max)
        			max = pa[n-1].pr;
        	}
        }
        */
        private void countingSort(){
        	pc = new int[max+1];
        	//pb = new pri[n];
        	pb = new String[n];
        	for(i = 0; i <= max; i++)
        		pc[i] = 0;
        	for(i = 0; i < n; i++)
        		pc[pa[i].pr]++;
        	for(i = 1; i <= max; i++)
        		pc[i] += pc[i-1];
        	for(i = n - 1; i >= k; i--) {
        		pc[pa[i].pr]--;
        		//pb[pc[pa[i].pr]] = new pri(pa[i].pr, pa[i].word);
        		pb[pc[pa[i].pr]] = new String(pa[i].word);
        	}
        	for(; i >= 0; i--) {
        		pc[pa[i].pr]--;
        		//pb[pc[pa[i].pr]] = new pri(pa[i].pr, "-");
        		pb[pc[pa[i].pr]] = new String("-");
        	}
        }
}
// pa : pri[] 객체를 담은 배열
// pa.pr, pa.word

