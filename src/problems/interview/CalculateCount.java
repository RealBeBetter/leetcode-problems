package problems.interview;

/**
 * @author wei.song
 * @since 2023/10/17 20:59
 */
public class CalculateCount {

    public static void main(String[] args) {
        getResults();
    }

    private static void getResults() {
        for (int i = 0; i < Integer.MAX_VALUE; i++) {
            int temp = 3 * i + 59;
            if (5 * i - temp <= 5 && 5 * i - temp >= 0) {
                System.out.println("x = " + i + ", y = " + temp);
            }
        }

    }

}
