package weekly.date202303.week338;

/**
 * 6354. K 件物品的最大和
 *
 * @author Real
 * @since 2023/3/26 10:33
 */
public class ItemsWithMaximumSum {

    public static void main(String[] args) {
        System.out.println(kItemsWithMaximumSum(6, 6, 6, 13));
        System.out.println(kItemsWithMaximumSum(2, 1, 1, 4));
        System.out.println(kItemsWithMaximumSum(3, 3, 5, 11));
    }

    public static int kItemsWithMaximumSum(int numOnes, int numZeros, int numNegOnes, int k) {
        if (k <= 0) {
            return 0;
        }

        if (k <= numOnes) {
            return k;
        }
        if (k <= numOnes + numZeros) {
            return numOnes;
        }
        if (k <= numNegOnes + numOnes + numZeros) {
            return numOnes - (k - numZeros - numOnes);
        }

        return 0;
    }

}
