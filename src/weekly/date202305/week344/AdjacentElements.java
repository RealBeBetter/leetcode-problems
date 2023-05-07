package weekly.date202305.week344;

/**
 * 6418. 有相同颜色的相邻元素数目
 *
 * @author Real
 * @since 2023/5/7 11:16
 */
public class AdjacentElements {

    public int[] colorTheArray(int n, int[][] queries) {
        int len = queries.length;
        int[] res = new int[len];

        int[] num = new int[n];
        int sum = 0;
        for (int i = 0; i < len; i++) {
            if (queries[i][0] >= 1 && num[queries[i][0] - 1] != 0) {
                if (num[queries[i][0] - 1] == num[queries[i][0]]) {
                    sum--;
                }
            }
            if (queries[i][0] <= n - 2 && num[queries[i][0] + 1] != 0) {
                if (num[queries[i][0] + 1] == num[queries[i][0]]) {
                    sum--;
                }
            }

            num[queries[i][0]] = queries[i][1];

            if (queries[i][0] >= 1 && num[queries[i][0] - 1] != 0) {
                if (num[queries[i][0] - 1] == num[queries[i][0]]) {
                    sum++;
                }
            }
            if (queries[i][0] <= n - 2 && num[queries[i][0] + 1] != 0) {
                if (num[queries[i][0] + 1] == num[queries[i][0]]) {
                    sum++;
                }
            }

            res[i] = sum;
        }
        return res;
    }

}
