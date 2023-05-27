package weekly.date202305.biweek105;

/**
 * 6395. 购买两块巧克力
 *
 * @author Real
 * @since 2023/5/27 22:31
 */
public class BuyTwoChocolates {

    public static void main(String[] args) {
        BuyTwoChocolates test = new BuyTwoChocolates();
        int[] prices = {69, 91, 78, 19, 40, 13};
        System.out.println(test.buyChoco(prices, 94));
    }

    public int buyChoco(int[] prices, int money) {
        int min = Math.min(prices[0], prices[1]), secondMin = Math.max(prices[0], prices[1]);
        int length = prices.length;
        for (int i = 2; i < length; i++) {
            if (prices[i] >= secondMin) {
                continue;
            }

            if (prices[i] < min) {
                secondMin = min;
                min = prices[i];
            } else {
                secondMin = prices[i];
            }
        }

        int cost = min + secondMin;
        int rest = money - cost;
        return rest >= 0 ? rest : money;
    }

}
