package leetcode75.graph;

import java.util.LinkedList;
import java.util.List;
import java.util.Queue;

/**
 * 1466. 重新规划路线
 * https://leetcode.cn/problems/reorder-routes-to-make-all-paths-lead-to-the-city-zero
 *
 * @author wei.song
 * @since 2023/6/16 15:07
 */
public class ReorderRoutes {

    @SuppressWarnings("unchecked")
    public int minReorder(int n, int[][] connections) {
        // 到达当前点，to 值
        List<Integer>[] in = new LinkedList[n];
        // 从当前出发，from 值
        List<Integer>[] out = new LinkedList[n];

        for (int i = 0; i < n; i++) {
            in[i] = new LinkedList<>();
            out[i] = new LinkedList<>();
        }

        for (int[] connection : connections) {
            in[connection[1]].add(connection[0]);
            out[connection[0]].add(connection[1]);
        }

        boolean[] visited = new boolean[n];
        Queue<Integer> queue = new LinkedList<>();
        queue.offer(0);
        int count = 0;

        while (!queue.isEmpty()) {
            int node = queue.poll();
            visited[node] = true;
            // 处理与当前节点有关的 in 图
            for (int inNode : in[node]) {
                if (!visited[inNode]) {
                    queue.offer(inNode);
                }
            }
            // 处理与当前节点有关的 out 图
            for (int outNode : out[node]) {
                if (!visited[outNode]) {
                    // 反转 out 图记录成本
                    count++;
                    queue.offer(outNode);
                }
            }
        }
        return count;
    }

}
