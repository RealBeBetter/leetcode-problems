package plan.track;

import java.util.ArrayList;
import java.util.List;

/**
 * <a href="https://leetcode.cn/problems/restore-ip-addresses/">...</a>
 *
 * @author wei.song
 * @since 2023/10/13 23:20
 */
public class RestoreIpAddresses {

    public static void main(String[] args) {
        RestoreIpAddresses test = new RestoreIpAddresses();
        List<String> res = test.restoreIpAddresses("25525511135");
        System.out.println(res);
    }

    List<String> result = new ArrayList<>();

    /**
     * 复原ip地址
     *
     * @param s s
     * @return {@link List}<{@link String}>
     */
    public List<String> restoreIpAddresses(String s) {
        if (s == null || s.length() < 4 || s.length() > 12) {
            return result;
        }

        backTrack(s, 0, 0);

        return result;
    }

    private void backTrack(String s, int startIndex, int pointNum) {
        if (pointNum == 3) {
            // 判断第四段⼦字符串是否合法，如果合法就放进 result 中
            if (isValid(s, startIndex, s.length() - 1)) {
                result.add(s);
            }
            return;
        }

        for (int i = startIndex; i < s.length(); i++) {
            if (!isValid(s, startIndex, i)) {
                break;
            }

            // 在str的后⾯插⼊⼀个逗点
            s = s.substring(0, i + 1) + "." + s.substring(i + 1);
            pointNum++;
            // 插⼊逗点之后下⼀个⼦串的起始位置为i+2
            backTrack(s, i + 2, pointNum);
            // 回溯到上一个位置
            pointNum--;
            // 回溯删掉逗点
            s = s.substring(0, i + 1) + s.substring(i + 2);
        }
    }

    private boolean isValid(String s, int start, int end) {
        if (start > end) {
            return false;
        }
        // 0 开头的数字不合法
        if (s.charAt(start) == '0' && start != end) {
            return false;
        }
        int num = 0;
        for (int i = start; i <= end; i++) {
            // 遇到⾮数字字符不合法
            if (s.charAt(i) > '9' || s.charAt(i) < '0') {
                return false;
            }
            num = num * 10 + (s.charAt(i) - '0');
            // 如果⼤于 255 了不合法
            if (num > 255) {
                return false;
            }
        }
        return true;
    }

}
