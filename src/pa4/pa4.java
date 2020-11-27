package pa4;

import java.io.*;

public class pa4{
        public static void main(String args[]) throws Exception{
                int i=0;
                //int[] money = {23, 10, 5, 3, 11, 32, 9};
                int[] money = {10, 7, 13, 15, 4, 2, 2, 7, 10, 5, 5};
                maxSum ms = new maxSum(money);
                for(i = 0; i < money.length; i++)
                	System.out.print(money[i] + " ");
                System.out.println("\nYour Answer = " + ms.max());
                System.out.println("Answer = 62");
                
                ms = null;
                money = null;
        }
}
