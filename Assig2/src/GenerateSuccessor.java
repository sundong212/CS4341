import java.util.ArrayList;
import java.util.Random;

public class GenerateSuccessor {

    public ArrayList<int[]> generateSuccessor(ArrayList<int[]> current_state) {
        ArrayList<int[]> all_bins = new ArrayList<>();

        int swap_one_row = new Random().nextInt(3) + 1;
        int swap_one_col = new Random().nextInt(current_state.get(0).length) + 1;
        int swap_two_row = new Random().nextInt(3) + 1;
        int swap_two_col = new Random().nextInt(current_state.get(0).length) + 1;

        int swap_one =
    }
}
