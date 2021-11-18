package T501_1000;

import java.util.*;

/**
 * @ author : Real
 * @ date : 2021/10/27 21:01
 * @ description :
 * 一行中有 N 张多米诺骨牌，我们将每张多米诺骨牌垂直竖立。
 * 在开始时，我们同时把一些多米诺骨牌向左或向右推。
 * 每过一秒，倒向左边的多米诺骨牌会推动其左侧相邻的多米诺骨牌。
 * 同样地，倒向右边的多米诺骨牌也会推动竖立在其右侧的相邻多米诺骨牌。
 * 如果同时有多米诺骨牌落在一张垂直竖立的多米诺骨牌的两边，由于受力平衡，该骨牌仍然保持不变。
 * 就这个问题而言，我们会认为正在下降的多米诺骨牌不会对其它正在下降
 * 或已经下降的多米诺骨牌施加额外的力。
 * <p>
 * 给定表示初始状态的字符串 "S" 。如果第 i 张多米诺骨牌被推向左边，
 * 则 S[i] = 'L'；如果第 i 张多米诺骨牌被推向右边，则 S[i] = 'R'；
 * 如果第 i 张多米诺骨牌没有被推动，则 S[i] = '.'。
 * 返回表示最终状态的字符串。
 * 示例 1：
 * 输入：".L.R...LR..L.."
 * 输出："LL.RR.LLRRLL.."
 * <p>
 * 来源：力扣（LeetCode）
 * 链接：https://leetcode-cn.com/problems/push-dominoes
 * 著作权归领扣网络所有。商业转载请联系官方授权，非商业转载请注明出处。
 */
public class PushDominoes_838 {
    public static String pushDominoes(String dominoes) {
        // 三种情况不会倒下，左右末端未受力，左边的向左右边的向右，受力平衡
        StringBuilder ans = new StringBuilder();
        Map<Character, Integer> map = new LinkedHashMap<>(2);
        int point = 0;      // 判断答案移动位置

        // 判断段首
        for (int i = 0; i < dominoes.length(); i++) {
            if (dominoes.charAt(i) != '.') {
                point = i;
                break;
            }
        }

        // 定义第一个index
        if (dominoes.charAt(point) == 'L') {
            ans.append("L".repeat(point));
        } else {
            ans.append(".".repeat(point));
        }

        for (int i = point; i < dominoes.length(); i++) {
            char temp = dominoes.charAt(i);
            // 判断当前受力情况
            if (temp == 'L') {
                if (map.get(temp) != null) {
                    Integer before = map.get(temp);
                    Integer after = i;
                    ans.append("L".repeat(after - before));
                    point = i;
                }
                map.put('L', i);
            } else if (temp == 'R') {
                if (map.get(temp) != null) {
                    Integer before = map.get(temp);
                    Integer after = i;
                    ans.append("R".repeat(after - before));
                    point = i;
                }
                map.put('R', i);
            } else if (temp == '.') {
                continue;
            }

            if (map.size() == 2) {
                Character[] characters = new Character[2];
                int flag = 0;
                for (Character character : map.keySet()) {
                    characters[flag++] = character;
                }
                int smallIndex = map.get(characters[0]);
                int bigIndex = map.get(characters[1]);
                if (characters[0] == 'L' && characters[1] == 'R') {
                    ans.append("L");
                    ans.append(".".repeat(bigIndex - smallIndex - 1));
                } else if (characters[0] == 'R' && characters[1] == 'L') {
                    if ((bigIndex - smallIndex - 1) % 2 == 0) {
                        ans.append("R");
                        ans.append("R".repeat((bigIndex - smallIndex - 1) / 2));
                        ans.append("L".repeat((bigIndex - smallIndex - 1) / 2));
                    } else {
                        ans.append("R");
                        ans.append("R".repeat((bigIndex - smallIndex - 1) / 2));
                        ans.append(".");
                        ans.append("L".repeat((bigIndex - smallIndex - 1) / 2));
                    }
                }
                map.remove(characters[0]);
                point = bigIndex;
            }

        }

        // 判断尾部
        char c = dominoes.charAt(point);
        if (c == 'R') {
            ans.append("R".repeat(dominoes.length() - point));
        } else if (c == 'L') {
            ans.append("L");
            ans.append(".".repeat(dominoes.length() - point - 1));
        } else {
            ans.append(".".repeat(dominoes.length() - point));
        }

        return ans.toString();
    }

    public static void main(String[] args) {
        String s = ".L.R...LR..L..";
        String t = "LL.RR.LLRRLL..";
        String s1 = "RR.L";
        String t1 = "RR.L";
        String s2 = "LL";
        String t2 = "LL";
        System.out.println(pushDominoes(s2));
        System.out.println(pushDominoes(s2).equals(t2));
        System.out.println(pushDominoes(s1));
        System.out.println(pushDominoes(s1).equals(t1));
        System.out.println(pushDominoes(s));
        System.out.println(pushDominoes(s).equals(t));
    }
}
