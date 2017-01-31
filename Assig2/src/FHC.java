import java.util.ArrayList;
import java.util.Stack;

public class FHC {

    public int getOptimize(Stack<Integer> all_numbers, double time_constraint) {

        int count = 0;

        Stack<Integer> potential_answers = new Stack<>();

        RandomAllocate randomAllocate = new RandomAllocate();
        Bin bin = new Bin();
        GenerateSuccessor generateSuccessor = new GenerateSuccessor();
        ArrayList<int[]> current_state;

        long tStart = System.currentTimeMillis();

        while(true) {

            long tEnd = System.currentTimeMillis();
            long tDelta = tEnd - tStart;
            double elapsedSeconds = tDelta / 1000.0;

            if (elapsedSeconds >= time_constraint) {
                break;
            }

            current_state = randomAllocate.randomAllocate(all_numbers);

            while (true) {

                if (count > 100) {

                    potential_answers.push(bin.findScore(current_state));
                    count = 0;
                    break;
                }

                long now = System.currentTimeMillis();
                long delta = now - tStart;
                double elapsed = delta / 1000.0;

                if (elapsed >= time_constraint) {
                    potential_answers.push(bin.findScore(current_state));
                    break;
                }

                ArrayList<int[]> successor = generateSuccessor.generateSuccessor(current_state);

                int current_score = bin.findScore(current_state);
                int successor_score = bin.findScore(successor);

                if (successor_score > current_score) {

                    current_state = successor;
                    continue;

                } else {

                    count++;
                    continue;
                }
            }
        }

        return find_highest(potential_answers);

    }

    public static int find_highest(Stack<Integer> stack) {

        int temp = Integer.MIN_VALUE;

        for (int a : stack) {
            if (a > temp) {
                temp = a;
            }
        }

        return temp;
    }
}
