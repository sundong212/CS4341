import java.io.BufferedReader;
import java.io.FileReader;
import java.util.Stack;

public class Optimize {
    public static void main(String[] args) {
        String approach = args[0];
        String file = args[0];
        double timing = Double.parseDouble(args[2]);
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

//        int[] all_numbers = new int[all_integers.size()];
//
//        for (int i = 0; i < all_integers.size(); i++) {
//            all_numbers[i] = all_integers.pop();
//        }

        // array all_numbers is now all the integers in the file
    }
}
