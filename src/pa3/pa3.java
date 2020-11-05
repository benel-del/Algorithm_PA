package pa3;

import java.io.*;

public class pa3{
        public static void main(String args[]) throws Exception{
                String word[] = {"Hello", "World", "interesting", "algorithm", "Sookmyung", "Women\'s", "University", "a", "a", "I", "am", "boy", "are", "you", "girl"};
                int priority[] = {11, 10, 9, 0, 0, 4, 1, 8, 2, 1, 1, 8, 6, 4, 2};
                int i=0;
                concat con = new concat(priority, word);
                System.out.println(con.concatenate());

                con = null;

        }
}
