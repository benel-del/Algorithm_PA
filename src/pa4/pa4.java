package pa4;

import java.io.*;

public class pa4{
        public static void main(String args[]) throws Exception{
                int i=0;
                int[] money = {23, 10, 5, 3, 11, 32, 9};
                maxSum ms = new maxSum(money);
                System.out.println("Maximum = " + ms.max());
                ms = null;
                money = null;
        }
}
