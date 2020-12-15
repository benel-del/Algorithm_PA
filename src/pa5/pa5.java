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
                G = new grid(7);
                //6: 5억 7578만 564 :: 56분32초~58분08초
                //7: 59분 11초 ~ ...
                System.out.println(G.numOfWays() + " patterns");
                G = null;
        }
}