package pa4;

import java.io.*;

public class pa4{
        public static void main(String args[]) throws Exception{
                int i=0;
                //int[] money = {23, 10, 5, 3, 11, 32, 9};
                int[] money = {11, 5, 9, 8, 0, 13, 2, 3, 14, 6};
                maxSum ms = new maxSum(money);
                for(i = 0; i < money.length; i++)
                	System.out.print(money[i] + " ");
                System.out.println("\nYour Answer = " + ms.max());
                System.out.println("Answer = 63");
                
                ms = null;
                money = null;
        }
}
