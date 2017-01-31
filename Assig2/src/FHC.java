import java.util.ArrayList;
import java.util.Stack;
import java.util.Random;

public class FHC {

    public int getOptimize(Stack<Integer> all_numbers, double time) {

        int count = 0;

        Stack<Integer> potential_answers = new Stack<>();

        RandomAllocate randomAllocate = new RandomAllocate();
        Bin bin = new Bin();
        GenerateSuccessor generateSuccessor = new GenerateSuccessor();
        ArrayList<int[]> current_state;


        while(true) { // TODO: add time constraint

            current_state = randomAllocate.randomAllocate(all_numbers);

            while (true) {

                if (count > 100) {

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





        //TODO: return something


    }
}
