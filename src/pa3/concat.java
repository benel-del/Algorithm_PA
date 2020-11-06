package pa3;

import java.io.*;

public class concat{
        private pri[] pa;

// Define additional variables or functions if you need...
        private int n, k, max, min;
        private int i, j;	// for statement
        
        /* counting sort */
        private pri[] pb;	// sorting result
        private int[] pc;	// 보조

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
                
                getMaxMin();	// for the range of pb[] in coungintSort
                countingSort();
                
                for(i = 0; i < n - k; i++)
                	result += pb[i].word;

                return result;
        }
        
        private void getMaxMin() {	//min 안 쓰면 지우기
        	max = min = pa[k].pr;
        	i = k + 1;
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
        	if((n - k) % 2 == 0) {	// # = even
        		if(pa[n-1].pr < min)
        			min = pa[n-1].pr;
        		if(pa[n-1].pr > max)
        			max = pa[n-1].pr;
        	}
        }
        
        private void countingSort(){
        	pc = new int[max+1];
        	pb = new pri[n - k];
        	for(i = 0; i <= max; i++)	// init pc
        		pc[i] = 0;
        	for(i = k; i < n; i++)
        		pc[pa[i].pr]++;
        	for(i = 1; i <= max; i++)
        		pc[i] += pc[i-1];
        	for(i = n - k; n >= 0; i--) {
        		pc[pa[i].pr]--;
        		pb[pc[pa[i].pr] - 1] = new pri(pa[i].pr, pa[i].word);
        		//pb[pc[pa[i].pr]].pr = pa[i].pr;
        		//pb[pc[pa[i].pr]].word = pa[i].word;
        	}
        }    
}
// pa : pri[] 객체를 담은 배열
// pa.pr, pa.word

