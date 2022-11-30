package weekly_competition.date2022_10.week316;

/**
 * https://leetcode.cn/contest/weekly-contest-316/problems/determine-if-two-events-have-conflict/
 * <p>
 * 给你两个字符串数组 event1 和 event2 ，表示发生在同一天的两个闭区间时间段事件，其中：
 * <p>
 * event1 = [startTime1, endTime1] 且
 * event2 = [startTime2, endTime2]
 * 事件的时间为有效的 24 小时制且按 HH:MM 格式给出。
 * <p>
 * 当两个事件存在某个非空的交集时（即，某些时刻是两个事件都包含的），则认为出现 冲突 。
 * <p>
 * 如果两个事件之间存在冲突，返回 true ；否则，返回 false 。
 * <p>
 * <p>
 * <p>
 * 示例 1：
 * <p>
 * 输入：event1 = ["01:15","02:00"], event2 = ["02:00","03:00"]
 * 输出：true
 * 解释：两个事件在 2:00 出现交集。
 * 示例 2：
 * <p>
 * 输入：event1 = ["01:00","02:00"], event2 = ["01:20","03:00"]
 * 输出：true
 * 解释：两个事件的交集从 01:20 开始，到 02:00 结束。
 * 示例 3：
 * <p>
 * 输入：event1 = ["10:00","11:00"], event2 = ["14:00","15:00"]
 * 输出：false
 * 解释：两个事件不存在交集。
 * <p>
 * <p>
 * 提示：
 * <p>
 * evnet1.length == event2.length == 2.
 * event1[i].length == event2[i].length == 5
 * startTime1 <= endTime1
 * startTime2 <= endTime2
 * 所有事件的时间都按照 HH:MM 格式给出
 * <p>
 * https://leetcode.cn/problems/determine-if-two-events-have-conflict/
 *
 * @author Real
 * Date: 2022/10/23 15:35
 */
public class JudgeEventConflict6214 {

    public static void main(String[] args) {
        String[] strings1 = {"10:00", "11:00"};
        String[] strings2 = {"14:00", "15:00"};
        boolean b = haveConflict(strings1, strings2);
        System.out.println(b);
        System.out.println(calculateMinute(strings1[0], strings1[1]));
        System.out.println(calculateMinute(strings2[0], strings1[1]));
    }

    /**
     * 判断时间/事件是否有交集
     * 根据反向推理法，证明两者不存在交集
     * ①的结束时间早于②的开始时间 且 ①的开始时间早于②的开始时间
     * ②的结束时间早于①的开始时间 且 ②的开始时间早于①的开始时间
     *
     * @param event1 开始时间和结束时间的数组
     * @param event2 同上
     * @return 是否有冲突
     */
    public static boolean haveConflict(String[] event1, String[] event2) {
        String start1 = event1[0];
        String end1 = event1[1];
        String start2 = event2[0];
        String end2 = event2[1];
        Integer integer1 = calculateMinute(end2, start1);
        Integer integer2 = calculateMinute(start2, start1);
        Integer integer3 = calculateMinute(end1, start2);
        Integer integer4 = calculateMinute(start1, start2);
        if ((integer1 > 0 && integer2 > 0) || ((integer3 > 0 && integer4 > 0))) {
            return false;
        }
        return true;
    }

    private static Integer calculateMinute(String start, String end) {
        String[] split1 = start.split(":");
        String hour1 = split1[0];
        String minute1 = split1[1];
        String[] split2 = end.split(":");
        String hour2 = split2[0];
        String minute2 = split2[1];

        int minuteTotal = 60 * (Integer.parseInt(hour2) - Integer.parseInt(hour1));
        return minuteTotal + Integer.parseInt(minute2) - Integer.parseInt(minute1);
    }
}
