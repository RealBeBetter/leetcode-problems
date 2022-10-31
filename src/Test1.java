/**
 * @author : Real
 * @date : 2021/11/15 15:52
 * @description : 连续子串相加最大的和
 * [5，3，-10，2，-1，6，8]
 * 输出：15
 */
public class Test1 {

    public static int getSubArrayMaxCount(int[] array) {
        // 利用迭代算法，推算出最大的和
        if (array.length == 0) {
            return 0;
        }
        int maxCount = array[0];
        int ans = maxCount;
        for (int i = 1; i < array.length; i++) {
            maxCount = Math.max(maxCount + array[i], array[i]);
            if (maxCount > ans) {
                ans = maxCount;
            }
        }

        return ans;
    }

    public static void main(String[] args) {
        int[] array = {5, 3, -10, 2, -1, 6, 8};
        int maxCount = getSubArrayMaxCount(array);
        System.out.println(maxCount);
    }

}
