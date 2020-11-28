package pa4;

import java.io.*;

public class pa4{
        public static void main(String args[]) throws Exception{
                int i=0;
                //int[] money = {23, 10, 5, 3, 11, 32, 9};
                int[] money = {3, 5 ,4 ,5 ,8 ,8 ,12, 10, 14, 1, 12};
                maxSum ms = new maxSum(money);
                System.out.print("money[]: \t");
                for(i = 0; i < money.length; i++)
                	System.out.print(money[i] + "\t");
                System.out.println("\nYour Answer = " + ms.max());
                System.out.println("Answer = 61");
                
                ms = null;
                money = null;
        }
}
