package weekly.date2022.date202210.week317;

import java.util.*;

/**
 * 给你两个字符串数组 creators 和 ids ，和一个整数数组 views ，所有数组的长度都是 n 。平台上第 i 个视频者是creator[i] ，视频分配的 id 是 ids[i] ，且播放量为 views[i] 。
 * <p>
 * 视频创作者的 流行度 是该创作者的 所有 视频的播放量的 总和 。请找出流行度 最高 创作者以及该创作者播放量 最大 的视频的 id 。
 * <p>
 * 如果存在多个创作者流行度都最高，则需要找出所有符合条件的创作者。
 * 如果某个创作者存在多个播放量最高的视频，则只需要找出字典序最小的 id 。
 * 返回一个二维字符串数组 answer ，其中 answer[i] = [creatori, idi] 表示 creatori 的流行度 最高 且其最流行的视频 id 是 idi ，可以按任何顺序返回该结果。
 * <p>
 * <p>
 * <p>
 * 示例 1：
 * <p>
 * 输入：creators = ["alice","bob","alice","chris"], ids = ["one","two","three","four"], views = [5,10,5,4]
 * 输出：[["alice","one"],["bob","two"]]
 * 解释：
 * alice 的流行度是 5 + 5 = 10 。
 * bob 的流行度是 10 。
 * chris 的流行度是 4 。
 * alice 和 bob 是流行度最高的创作者。
 * bob 播放量最高的视频 id 为 "two" 。
 * alice 播放量最高的视频 id 是 "one" 和 "three" 。由于 "one" 的字典序比 "three" 更小，所以结果中返回的 id 是 "one" 。
 * 示例 2：
 * <p>
 * 输入：creators = ["alice","alice","alice"], ids = ["a","b","c"], views = [1,2,2]
 * 输出：[["alice","b"]]
 * 解释：
 * id 为 "b" 和 "c" 的视频都满足播放量最高的条件。
 * 由于 "b" 的字典序比 "c" 更小，所以结果中返回的 id 是 "b" 。
 * <p>
 * <p>
 * 提示：
 * <p>
 * n == creators.length == ids.length == views.length
 * 1 <= n <= 105
 * 1 <= creators[i].length, ids[i].length <= 5
 * creators[i] 和 ids[i] 仅由小写英文字母组成
 * 0 <= views[i] <= 105
 * <p>
 * <p>
 * 来源：力扣（LeetCode）
 * 链接：https://leetcode.cn/problems/most-popular-video-creator
 * 著作权归领扣网络所有。商业转载请联系官方授权，非商业转载请注明出处。
 *
 * @author wei.song
 * @since 2022-10-31 13:05
 */
public class MostPopularVideoCreator2456 {

    public List<List<String>> mostPopularCreator(String[] creators, String[] ids, int[] views) {
        Map<String, IdsAndViewsCount> map = new HashMap<>();
        List<List<String>> ans = new ArrayList<>();
        int length = creators.length;

        // 存下最大的单个播放量以及对应的 Creators
        long max = 0;
        for (int i = 0; i < length; i++) {
            String creator = creators[i];
            String id = ids[i];
            int view = views[i];
            IdsAndViewsCount idCount = map.get(creator);
            if (idCount == null) {
                IdsAndViewsCount temp = new IdsAndViewsCount(id, view, (long) view);
                map.put(creator, temp);
                max = Math.max(view, max);
            } else {
                long tempCount = idCount.count + view;
                int tempIdsCount = 0;
                String tempIds = null;
                if (idCount.idsCount < view) {
                    tempIdsCount = view;
                    tempIds = id;
                } else if (idCount.idsCount > view) {
                    tempIdsCount = idCount.idsCount;
                    tempIds = idCount.ids;
                } else {
                    tempIdsCount = idCount.idsCount;
                    if (idCount.ids.compareTo(id) < 0) {
                        tempIds = idCount.ids;
                    } else {
                        tempIds = id;
                    }
                }
                IdsAndViewsCount temp = new IdsAndViewsCount(tempIds, tempIdsCount, tempCount);
                map.put(creator, temp);
                max = Math.max(tempCount, max);
            }
        }
        Set<String> creatorSet = map.keySet();
        for (String creatorName : creatorSet) {
            IdsAndViewsCount idCount = map.get(creatorName);
            if (idCount.count == max) {
                List<String> list = new ArrayList<>();
                list.add(creatorName);
                list.add(idCount.ids);
                ans.add(list);
            }
        }
        return ans;
    }

    public static class IdsAndViewsCount {
        // 存播放量最大的 ID
        public String ids;
        // 存当前播放量最大的 ID 对应的播放量
        public Integer idsCount;
        // 存当前播放量之和
        public Long count;

        public IdsAndViewsCount(String ids, Integer idsCount, Long count) {
            this.ids = ids;
            this.idsCount = idsCount;
            this.count = count;
        }
    }
}
