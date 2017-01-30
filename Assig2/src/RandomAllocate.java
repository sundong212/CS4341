import java.util.Random;
import java.util.Stack;

public class RandomAllocate {

    public void randomAllocate(Stack<Integer> all_numbers, int[] bin_one, int[] bin_two, int[] bin_three) {
        Stack<Integer> temp_one = new Stack<>();
        Stack<Integer> temp_two = new Stack<>();
        Stack<Integer> temp_three = new Stack<>();
        int iterate = all_numbers.size() / 3;
        int bin_number = 1;

        for (int i = 0; i < iterate; i++) {

            if (bin_number == 1) {

                randomChoose(all_numbers, temp_one);

                bin_number = 2;

            } else if(bin_number == 2) {

                randomChoose(all_numbers, temp_two);

                bin_number = 3;

            } else {

                randomChoose(all_numbers, temp_three);

                bin_number = 1;
            }

        }

        // not done yet
        // depends on what we need, may need int[] or stack<Integer>
    }

    public static void randomChoose(Stack<Integer> all_numbers, Stack<Integer> bin_number) {
        int j = 0;
        int item = new Random().nextInt(all_numbers.size()) + 0; // 0 is minimum and size is maximum

        for (int a: all_numbers) {
            if (j == item) {
                bin_number.push(a);
                all_numbers.remove(a);
            }

            j++;
        }
    }
}
