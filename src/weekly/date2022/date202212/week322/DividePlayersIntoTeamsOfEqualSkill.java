package weekly.date2022.date202212.week322;

import java.util.Arrays;

/**
 * 6254. 划分技能点相等的团队 显示英文描述
 * 给你一个正整数数组 skill ，数组长度为 偶数 n ，其中 skill[i] 表示第 i 个玩家的技能点。
 * 将所有玩家分成 n / 2 个 2 人团队，使每一个团队的技能点之和 相等 。
 * 团队的 化学反应 等于团队中玩家的技能点 乘积 。
 * 返回所有团队的 化学反应 之和，如果无法使每个团队的技能点之和相等，则返回 -1 。
 * <p>
 * <p>
 * 示例 1：
 * 输入：skill = [3,2,5,1,3,4]
 * 输出：22
 * 解释：
 * 将玩家分成 3 个团队 (1, 5), (2, 4), (3, 3) ，每个团队的技能点之和都是 6 。
 * 所有团队的化学反应之和是 1 * 5 + 2 * 4 + 3 * 3 = 5 + 8 + 9 = 22 。
 * 示例 2：
 * 输入：skill = [3,4]
 * 输出：12
 * 解释：
 * 两个玩家形成一个团队，技能点之和是 7 。
 * 团队的化学反应是 3 * 4 = 12 。
 * 示例 3：
 * 输入：skill = [1,1,2,3]
 * 输出：-1
 * 解释：
 * 无法将玩家分成每个团队技能点都相等的若干个 2 人团队。
 * <p>
 * 提示：
 * 2 <= skill.length <= 105
 * skill.length 是偶数
 * 1 <= skill[i] <= 1000
 *
 * @author Real
 * Date: 2022/12/4 11:06
 */
public class DividePlayersIntoTeamsOfEqualSkill {

    public static void main(String[] args) {
        int[] array = {3, 2, 5, 1, 3, 4};
        DividePlayersIntoTeamsOfEqualSkill test = new DividePlayersIntoTeamsOfEqualSkill();
        System.out.println(test.dividePlayers(array));
    }

    /**
     * 划分成两两相等的队伍，和相等，求队伍内的乘积之和，否则返回 -1
     *
     * @param skill 技能点
     * @return 乘积
     */
    public long dividePlayers(int[] skill) {
        if (skill == null || skill.length == 0 || skill.length % 2 != 0) {
            return -1L;
        }
        int length = skill.length;
        Arrays.sort(skill);
        long tempSum = skill[0] + skill[length - 1];
        long ans = 0;
        for (int i = 0, j = length - 1; i < skill.length / 2 && i < j; i++, j--) {
            long temp = skill[i] + skill[j];
            if (temp != tempSum) {
                return -1;
            }
            ans += (long) skill[i] * skill[j];
        }
        return ans;
    }
}
