public class BinThree {

    public int findScore(int[] bin) {
        int score = 0;
        int size = bin.length;
        int half = size/2;

        for (int i = 0; i < half; i++) {
            if (bin[i] > 0) {
                if (isPrime(bin[i])) {
                    score = score + 4;
                } else {
                    score = score - bin[i];
                }
            } if (bin[i] == 0) {
                score = score + 0;
            } else {
                score = score - 2;
            }

            if (bin[size - 1 - i] > 0) {
                if (isPrime(bin[size - 1 - i])) {
                    score = score - 4;
                } else {
                    score = score + bin[size - 1 - i];
                }
            } if (bin[size - 1 - i] == 0) {
                score = score + 0;
            } else {
                score = score + 2;
            }
        }

        return score;
    }

    static public boolean isPrime(int n) {
        if (n % 2 == 0) return false; //check if n is a multiple of 2

        //if not, then just check the odds
        for(int i = 3; i * i <= n; i += 2) {
            if(n % i == 0)
                return false;
        }

        return true;
    }
}
