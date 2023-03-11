package problems.leet501_1000;

/**
 * 670. 最大交换
 * 给定一个非负整数，你至多可以交换一次数字中的任意两位。返回你能得到的最大值。
 * <p>
 * 示例 1 :
 * 输入: 2736
 * 输出: 7236
 * 解释: 交换数字2和数字7。
 * 示例 2 :
 * 输入: 9973
 * 输出: 9973
 * 解释: 不需要交换。
 * 注意:
 * 给定数字的范围是 [0, 108]
 *
 * @author Real
 * Date: 2022/11/25 21:52
 */
public class MaximumSwap_670 {

    /**
     * 遍历解决
     *
     * @param num 数字
     * @return 交换之后的得到的数字
     */
    public int maximumSwapByIterator(int num) {
        char[] charArray = String.valueOf(num).toCharArray();
        int length = charArray.length;
        int max = num;
        for (int i = 0; i < length; i++) {
            for (int j = length - 1; j >= 0; j--) {
                swap(charArray, i, j);
                String str = new String(charArray);
                max = Math.max(Integer.parseInt(str), max);
                swap(charArray, i, j);
            }
        }
        return max;
    }

    /**
     * 贪心法解决
     *
     * @param num 数字
     * @return 交换之后的得到的数字
     */
    public int maximumSwapByGreedy(int num) {
        char[] charArray = String.valueOf(num).toCharArray();
        int length = charArray.length;
        if (length == 1 || length == 0) {
            return num;
        }
        int indexMax = length - 1;
        int res = num;
        for (int i = length - 1; i >= 0; i--) {
            if (charArray[i] < charArray[indexMax]) {
                swap(charArray, i, indexMax);
                String str = new String(charArray);
                res = Math.max(Integer.parseInt(str), res);
                swap(charArray, i, indexMax);
            } else if (charArray[i] > charArray[indexMax]){
                indexMax = i;
            }
        }
        return res;
    }

    public char[] swap(char[] chars, int i, int j) {
        char temp = chars[i];
        chars[i] = chars[j];
        chars[j] = temp;
        return chars;
    }

}
