package weekly.date2023.date202304.week343;

import java.util.HashSet;
import java.util.Set;

/**
 * @author wei.song
 * @since 2023/4/30 10:33
 */
public class DetermineWinnerBowlingGame {

    public int isWinner(int[] player1, int[] player2) {
        Set<Integer> fullIndex1 = new HashSet<>();
        Set<Integer> fullIndex2 = new HashSet<>();
        int length = player1.length;

        long score1 = 0, score2 = 0;
        for (int i = 0; i < length; i++) {
            if (player1[i] == 10) {
                fullIndex1.add(i + 1);
                fullIndex1.add(i + 2);
            }

            if (player2[i] == 10) {
                fullIndex2.add(i + 1);
                fullIndex2.add(i + 2);
            }

            if (fullIndex1.contains(i)) {
                score1 += 2L * player1[i];
            } else {
                score1 += player1[i];
            }

            if (fullIndex2.contains(i)) {
                score2 += 2L * player2[i];
            } else {
                score2 += player2[i];
            }
        }

        return score1 > score2 ? 1 : score1 < score2 ? 2 : 0;
    }

}
