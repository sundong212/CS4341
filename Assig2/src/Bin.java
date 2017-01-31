import java.util.ArrayList;

public class Bin {

    static public int BinOneScore(int[] bin) {
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

    static public int BinTwoScore(int[] bin) {
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

    static public int BinThreeScore(int[] bin) {
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

    public int findScore(ArrayList<int[]> all_bins) {
        return BinOneScore(all_bins.get(0)) + BinTwoScore(all_bins.get(1)) + BinThreeScore(all_bins.get(2));
    }

}
