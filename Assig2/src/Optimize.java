import java.io.BufferedReader;
import java.io.FileReader;
import java.util.Stack;
import java.util.Random;

public class Optimize {
    public static void main(String[] args) {
//        String approach = args[0];
        String file = args[0];
//        double timing = Double.parseDouble(args[2]);
        Stack<Integer> all_integers = new Stack();

        try {
            BufferedReader buf = new BufferedReader(new FileReader(file));
            String buf_line;
            String[] wordsArray;

            while (true) {
                buf_line = buf.readLine();

                if (buf_line == null) {
                    break;
                } else {
                    wordsArray = buf_line.split("\t");

                    for (String each: wordsArray) {
                        if (!"".equals(each)) {
                            all_integers.push(Integer.parseInt(each));
                        }
                    }
                }
            }

        } catch (Exception e) {
            e.printStackTrace();
        }

        int size = all_integers.size();
        int[] Bin1 = new int[size/3];
        int[] Bin2 = new int[size/3];
        int[] Bin3 = new int[size/3];


        Random rand = new Random();


        for (int a: all_integers) {
            int n = rand.nextInt(3) + 1;
        }



    }
}
