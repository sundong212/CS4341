import java.util.ArrayList;
import java.util.Random;

public class GenerateSuccessor {

    public ArrayList<int[]> generateSuccessor(ArrayList<int[]> current_state) {

        int bin_size = current_state.get(0).length;

        int[] new_bin_one = new int[bin_size];
        int[] new_bin_two = new int[bin_size];
        int[] new_bin_three = new int[bin_size];

        ArrayList<int[]> new_bins = new ArrayList<>();
        new_bins.add(new_bin_one);
        new_bins.add(new_bin_two);
        new_bins.add(new_bin_three);

        copy_bins(current_state, new_bins, bin_size);

        while (true) {

            // consider as a matrix
            int swap_one_row = new Random().nextInt(3) + 1;
            int swap_one_col = new Random().nextInt(bin_size) + 1;
            int swap_two_row = new Random().nextInt(3) + 1;
            int swap_two_col = new Random().nextInt(bin_size) + 1;

            if (swap_one_row == swap_two_row) { // if to swap in one bin

                if (swap_one_col == swap_one_col) { // if two selected are the same

                    continue;
                } else { // if two selected are not the same
                    if (current_state.get(swap_one_row - 1)[swap_one_col - 1] == current_state.get(swap_one_row - 1)[swap_two_col - 1]) { // if two swap in one bin are the same
                        continue;

                    } else { // if two selected are now the same and not equal --> able to swap

                        int swap_one = current_state.get(swap_one_row - 1)[swap_one_col - 1];
                        int swap_two = current_state.get(swap_two_row - 1)[swap_two_col - 1];

                        for (int i = 0; i < bin_size; i++) {

                            if (i == (swap_one_col - 1)) {

                                new_bins.get(swap_one_row - 1)[i] = swap_two;

                            } else if (i == (swap_two_col - 1)) {

                                new_bins.get(swap_one_row - 1)[i] = swap_one;

                            } else {} // this one do nothing, just label clearly

                        }

                        break;
                    }
                }
            } else { // if to swap in two different bins
                if (current_state.get(swap_one_row - 1)[swap_one_col - 1] == current_state.get(swap_two_row - 1)[swap_two_col - 1]) { // if in different bins but value equals
                    continue;
                } else { // if in different bin and value not equal --> able to swap

                    int swap_one = current_state.get(swap_one_row - 1)[swap_one_col - 1];
                    int swap_two = current_state.get(swap_two_row - 1)[swap_two_col - 1];

                    if (swap_one_col == swap_two_col) { // if index equals

                        for (int i = 0; i < bin_size; i++) {

                            if (i == (swap_one_col - 1)) {

                                new_bins.get(swap_one_row - 1)[i] = swap_two;
                                new_bins.get(swap_two_row - 1)[i] = swap_one;

                            }
                        }

                        break;
                    } else { // if index not equal

                        for (int i = 0; i < bin_size; i++) {
                            if (i == (swap_one_col - 1)) {

                                new_bins.get(swap_one_row - 1)[i] = swap_two;

                            } else if(i == (swap_two_col - 1)) {

                                new_bins.get(swap_two_row - 1)[i] = swap_one;

                            } else {} // do nothing just label clearly
                        }

                        break;
                    }

                }
            }
        }

        return new_bins;

    }

    public static void copy_bins(ArrayList<int[]> copy_from, ArrayList<int[]> copy_to, int size) {

        for (int i = 0; i < size; i++) {
            copy_to.get(0)[i] = copy_from.get(0)[i];
            copy_to.get(1)[i] = copy_from.get(1)[i];
            copy_to.get(2)[i] = copy_from.get(2)[i];
        }

    }
}
