public class BinOne {

    public int findScore(int[] bin) {
        int score = 0;
        int flag = 0;

        for (int a: bin) {
            if (flag == 0) {
                score = score + a;
                flag = 1;
            } else {
                score = score - a;
                flag = 0;
            }
        }

        return score;
    }
}
