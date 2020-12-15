package pa5;

import java.io.*;

public class pa5{
        public static void main(String args[]) throws Exception{
                grid G;
                /*
                if(args.length == 0){
                        System.out.println("Error..\nUsage: java pa5 [number]");
                        return;
                }
                G = new grid(Integer.parseInt(args[0]));
                */
                G = new grid(2);
                System.out.println(G.numOfWays() + " patterns");
                G = null;
        }
}