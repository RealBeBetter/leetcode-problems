package leetcode75.graph;

/**
 * 547. 省份数量
 * https://leetcode.cn/problems/number-of-provinces
 *
 * @author wei.song
 * @since 2023/6/16 10:59
 */
public class NumberOfProvinces {

    public int findCircleNum(int[][] isConnected) {
        if (isConnected == null || isConnected.length == 0) {
            return 0;
        }

        int[] visited = new int[isConnected.length];
        int count = 0;
        for (int i = 0; i < isConnected.length; i++) {
            if (visited[i] == 0) {
                dfs(isConnected, visited, i);
                count++;
            }
        }

        return count;
    }

    private void dfs(int[][] isConnected, int[] visited, int i) {
        visited[i] = 1;
        for (int j = 0; j < isConnected.length; j++) {
            if (isConnected[i][j] == 1 && visited[j] == 0) {
                dfs(isConnected, visited, j);
            }
        }
    }

}
