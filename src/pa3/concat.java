package pa3;

import java.io.*;

public class concat{
        private pri[] pa;

// Define additional variables or functions if you need...

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

                return result;
        }
}

