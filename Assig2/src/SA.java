import sun.security.jgss.wrapper.GSSNameElement;

import java.util.ArrayList;
import java.util.Stack;

/**
 * Created by Noah on 1/30/17.
 */
public class SA {

    public static void main() {

        double temperature = 100; //TODO: need to find the best initial temperature
        double coolingRate = 0; //TODO: need to find the best cooling rate

        Stack<Integer> numbers = new Stack<Integer>();

        // the object to get all numbers
        Optimize getNumbers = new Optimize();
        numbers = getNumbers.all_integers; //TODO:

        // initial an empty arraylist that used to be modified later
        ArrayList<int[]> initialState = new ArrayList<>();

        // initial the empty arraylist with numbers
        RandomAllocate ra = new RandomAllocate(numbers, initialState); //TODO

        /*public double getTemperature() {
            return this.getTemperature();
        }

        public double getCoolingRate() {
            return this.getCoolingRate();
        }*/

        // the tracker for the highest score state
        ArrayList<int[]> highestState = new ArrayList<>();

        while ( temperature > 1.0 ) {

            Bin newbin = new Bin(); // Object to get scores

            // the score of the current state
            int currentScore = newbin.findScore(highestState<1>, highestState<2>, highestState<3>); //TODO: bin list

            // Object to get the random successor state
            GenerateSuccessor getSuccessor = new GenerateSuccessor();
            getSuccessor.generateSuccessor(highestState);

            // the score of the successor's state
            int successorScore = newbin.findScore(getSuccessor<1>, getSuccessor<2>, getSuccessor<3>); //TODO: bin list

            // consider if we accept the successor by using the acceptance probability
            if (getProbability(currentScore, successorScore, temperature) > Math.random()) {
                highestState = getSuccessor.generateSuccessor(highestState);
            }

            // compare the score to determine which one is better
            if (currentScore < successorScore) {
                highestState = initialState;
            }

            temperature *= 1 - coolingRate;
        }
    }

    // the method to get the probability by using the formula.
    public static double getProbability(int E, int newE, double temperature) {
        if (newE > E) {
            return 1.0;
        }
        return Math.exp((E - newE) / temperature);
    }
}
