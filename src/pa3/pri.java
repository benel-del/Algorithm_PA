package pa3;

import java.io.*;

public class pri{
        public int pr;
        public String word;

// Define additional variables or functions if you need...

        public pri(){
                this.pr = 0x7FFFFFFF;
                this.word = null;
                return;
        }

        public pri(int p, String w){
                this.word = null;
                this.setPair(p, w);
                return;
        }

        public void setPair(int p, String w){
                if(this.word != null)   this.word = null;
                this.pr = p;
                this.word = w;
                return;
        }

        public void printPair(){
                System.out.println("["+this.pr+", "+this.word+"]");
        }
}

