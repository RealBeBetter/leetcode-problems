package leetcode75.stack;

import java.util.ArrayList;
import java.util.List;

/**
 * 901. 股票价格跨度
 * https://leetcode.cn/problems/online-stock-span
 *
 * @author wei.song
 * @since 2023/6/27 14:47
 */
public class StockSpanner {

    private final List<Integer> stocks;

    public StockSpanner() {
        stocks = new ArrayList<>();
    }

    public int next(int price) {
        int span = 1;

        int size = stocks.size();
        for (int i = size - 1; i >= 0; i--) {
            if (stocks.get(i) <= price) {
                span++;
            } else {
                break;
            }
        }

        stocks.add(price);
        return span;
    }
}
