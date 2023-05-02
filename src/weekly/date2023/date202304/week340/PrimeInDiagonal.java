package weekly.date2023.date202304.week340;

import java.util.Comparator;
import java.util.Set;
import java.util.TreeSet;

/**
 * 6361. 对角线上的质数
 *
 * @author Real
 * @since 2023/4/9 10:35
 */
public class PrimeInDiagonal {

    /**
     * 对角线' 最大质数，正方形二维数组
     *
     * @param nums 数组
     * @return int
     */
    public int diagonalPrime(int[][] nums) {
        // 找出对角线上的所有数字，添加进集合
        int length = nums.length;
        Set<Integer> diagonals = new TreeSet<>(Comparator.reverseOrder());

        int rows = 0;
        for (int i = 0, j = length - 1; i < length && j >= 0; i++, j--) {
            diagonals.add(nums[rows][i]);
            diagonals.add(nums[rows][j]);
            rows++;
        }

        for (Integer diagonal : diagonals) {
            if (isPrimeNumber(diagonal)) {
                return diagonal;
            }
        }

        return 0;
    }

    private boolean isPrimeNumber(int num) {
        if (num <= 1) {
            return false;
        }

        boolean isPrime = true;
        int mid = num / 2;
        for (int i = 2; i < mid; i++) {
            if (num % i == 0) {
                isPrime = false;
                break;
            }
        }
        return isPrime;
    }

}
