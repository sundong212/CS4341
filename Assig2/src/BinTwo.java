public class BinTwo {

    public int findScore(int[] bin) {
        int score = 0;
        int size = bin.length;

        for (int i = 0; i < (size -1); i++) {
            if (bin[i] < bin[i+1]) {
                score = score + 3;
            } if (bin[i] == bin[i+1]) {
                score = score + 5;
            } else {
                score = score - 10;
            }
        }

        return score;
    }
}
