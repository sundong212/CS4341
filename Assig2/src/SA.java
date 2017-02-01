import sun.security.jgss.wrapper.GSSNameElement;

import java.util.ArrayList;
import java.util.Stack;

/**
 * Created by Noah on 1/30/17.
 */
public class SA {

    public int getOptimize(Stack<Integer> all_numbers, double time_constraint) {

        double temperature = 100; //TODO: need to find the best initial temperature
        double coolingRate = 0; //TODO: need to find the best cooling rate

        //Stack<Integer> potential_answers = new Stack<>();
        int highestScore = 0;

        RandomAllocate randomAllocate = new RandomAllocate();
        // initial the empty Arraylist with numbers
        ArrayList<int[]> currentState = randomAllocate.randomAllocate(all_numbers);

        // object of the bin to compute score
        Bin bin = new Bin();

        // Object to get the random successor state
        GenerateSuccessor generateSuccessor = new GenerateSuccessor();

        // the tracker for the highest score state
        ArrayList<int[]> highestState = new ArrayList<>();

        while ( temperature > 1.0 ) {

            // the score of the current state
            int currentScore = bin.findScore(currentState);

            ArrayList<int[]> successor = generateSuccessor.generateSuccessor(currentState);

            // the score of the successor's state
            int successorScore = bin.findScore(successor);

            // consider if we accept the successor by using the acceptance probability
            if (getProbability(currentScore, successorScore, temperature) > Math.random()) {
                currentState = successor;
            }

            highestScore = bin.findScore(highestState);
            // compare the score to determine which one is better
            if (highestScore < successorScore) {
                highestState = currentState;
            }

            temperature *= 1 - coolingRate; //TODO: Schedule
        }

        return bin.findScore(highestState);
    }

    // the method to get the probability by using the formula.
    public static double getProbability(int E, int newE, double temperature) {
        if (newE > E) {
            return 1.0;
        }
        return Math.exp((E - newE) / temperature);
    }

    /*public static int find_highest(Stack<Integer> stack) {

        int temp = Integer.MIN_VALUE;

        for (int a : stack) {
            if (a > temp) {
                temp = a;
            }
        }

        return temp;
    }*/
}
