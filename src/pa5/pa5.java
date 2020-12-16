package pa5;

import java.io.*;

public class pa5{
        public static void main(String args[]) throws Exception{
        		long before = System.currentTimeMillis();
                grid G;
                /*
                if(args.length == 0){
                        System.out.println("Error..\nUsage: java pa5 [number]");
                        return;
                }
                G = new grid(Integer.parseInt(args[0]));
                */
                G = new grid(6);
                //6: 5¾ï 7578¸¸ 564 :: return(x):: 1min 33sec, 1min 51sec, 2min 19sec
                //6: return(0) :: 1min 56sec, 1min 34sec
                //7: ...
                System.out.println(G.numOfWays() + " patterns");
                G = null;
                long time = System.currentTimeMillis() - before;
                System.out.println(time/60000 + "m " + (time%60000)/1000 + "s");
        }
}