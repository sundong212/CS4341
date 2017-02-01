import java.util.ArrayList;
import java.util.Random;
import java.util.Stack;

public class RandomAllocate {

    public ArrayList<int[]> randomAllocate(Stack<Integer> all_numbers) {

        ArrayList<int[]> current_state = new ArrayList<>();

        Stack<Integer> temp_one = new Stack<>();
        Stack<Integer> temp_two = new Stack<>();
        Stack<Integer> temp_three = new Stack<>();

        System.out.println(all_numbers.size());

        int iterate = all_numbers.size() / 3;
        int bin_number = 1;

        for (int i = 0; i < 27; i++) {

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

//        System.out.print(temp_one.size());
//        System.out.print(temp_two.size());
//        System.out.print(temp_three.size());

        int bin_one[] = new int[iterate];
        int bin_two[] = new int[iterate];
        int bin_three[] = new int[iterate];
        current_state.add(bin_one);
        current_state.add(bin_two);
        current_state.add(bin_three);

        popToArray(temp_one, current_state.get(0));
        popToArray(temp_two, current_state.get(1));
        popToArray(temp_three, current_state.get(2));

        return current_state;

    }

    public static void randomChoose(Stack<Integer> all_numbers, Stack<Integer> bin_number) {
        int j = 0;
        int item = new Random().nextInt(all_numbers.size()) + 0; // 0 is minimum and size is maximum
//        Stack<Integer> new_stack = new Stack<>();

        for (int a: all_numbers) {
            if (j == item) {
                bin_number.push(a);
//                all_numbers.remove(a);
            }

            j++;
        }

        all_numbers.remove(item);

//        System.out.println(new_stack);

//        all_numbers = new_stack;

    }

    public static void popToArray(Stack<Integer> from, int[] to) {



        for (int i = 0; i < to.length; i++) {
            to[i] = from.pop();
        }
    }
}
