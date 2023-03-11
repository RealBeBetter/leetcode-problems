package weekly.date2022.date202212.week322;

import java.util.HashMap;
import java.util.Map;

/**
 * 6255. 两个城市间路径的最小分数 显示英文描述
 * 给你一个正整数 n ，表示总共有 n 个城市，城市从 1 到 n 编号。
 * 给你一个二维数组 roads ，其中 roads[i] = [ai, bi, distancei] 表示城市 ai 和 bi 之间有一条 双向 道路，
 * 道路距离为 distancei 。城市构成的图不一定是连通的。
 * 两个城市之间一条路径的 分数 定义为这条路径中道路的 最小 距离。
 * 城市 1 和城市 n 之间的所有路径的 最小 分数。
 * <p>
 * 注意：
 * 一条路径指的是两个城市之间的道路序列。
 * 一条路径可以 多次 包含同一条道路，你也可以沿着路径多次到达城市 1 和城市 n 。
 * 测试数据保证城市 1 和城市n 之间 至少 有一条路径。
 * <p>
 * 示例 1：
 * 输入：n = 4, roads = [[1,2,9],[2,3,6],[2,4,5],[1,4,7]]
 * 输出：5
 * 解释：城市 1 到城市 4 的路径中，分数最小的一条为：1 -> 2 -> 4 。这条路径的分数是 min(9,5) = 5 。
 * 不存在分数更小的路径。
 * 示例 2：
 * 输入：n = 4, roads = [[1,2,2],[1,3,4],[3,4,7]]
 * 输出：2
 * 解释：城市 1 到城市 4 分数最小的路径是：1 -> 2 -> 1 -> 3 -> 4 。这条路径的分数是 min(2,2,4,7) = 2 。
 * <p>
 * 提示：
 * 2 <= n <= 105
 * 1 <= roads.length <= 105
 * roads[i].length == 3
 * 1 <= ai, bi <= n
 * ai != bi
 * 1 <= distancei <= 104
 * 不会有重复的边。
 * 城市 1 和城市 n 之间至少有一条路径。
 * https://leetcode.cn/contest/weekly-contest-322/problems/minimum-score-of-a-path-between-two-cities/
 *
 * @author Real
 * Date: 2022/12/4 11:13
 */
public class MinimumScoreOfPathBetweenTwoCities {

    /**
     * 通过的节点最多的路径，求出路径中最小的 distance 值
     * 并查集+哈希表
     *
     * @param n     目标节点
     * @param roads 路径，格式为 [1,2,2],[1,3,4] 前两者表示节点编号，最后一个值表示 distance 值
     * @return 节点最小数
     */
    public int minScore(int n, int[][] roads) {
        Map<Integer, Integer> map = new HashMap<>();
        UnionFind uf = new UnionFind(n + 1);
        for (int[] r : roads) {
            uf.union(r[0], r[1]);
        }
        for (int[] r : roads) {
            int z = uf.find(r[0]);
            if (!map.containsKey(z)) map.put(z, Integer.MAX_VALUE);
            map.put(z, Math.min(map.get(z), r[2]));
        }
        return map.get(uf.find(1));
    }
}


class UnionFind {
    int[] root;
    int[] rank;

    public UnionFind(int size) {
        root = new int[size];
        rank = new int[size];
        for (int i = 0; i < size; i++) {
            root[i] = i;
            rank[i] = 1;
        }
    }

    public int find(int x) {
        if (x == root[x]) {
            return x;
        }
        return root[x] = find(root[x]);
    }

    public void union(int x, int y) {
        int rootX = find(x);
        int rootY = find(y);
        if (rootX != rootY) {
            if (rank[rootX] > rank[rootY]) {
                root[rootY] = rootX;
            } else if (rank[rootX] < rank[rootY]) {
                root[rootX] = rootY;
            } else {
                root[rootY] = rootX;
                rank[rootX] += 1;
            }
        }
    }

    public boolean connected(int x, int y) {
        return find(x) == find(y);
    }
}
