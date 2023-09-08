package algorithm.recursion;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

/**
 * @author Real
 * @since 2023/3/11 14:18
 */
public class Permutation {

    /**
     * 得到字符串排列
     *
     * @param str str
     * @return {@link List}<{@link String}>
     */
    private List<String> getPermutationOfString(String str) {
        if (str == null || str.isEmpty()) {
            return Collections.emptyList();
        }

        // 排列组合，计算出所有的形式，存储最终结果
        List<String> result = new ArrayList<>();
        // 调用递归函数
        permutation(str, "", result);
        return result;
    }


    private void permutation(String str, String prefix, List<String> result) {
        // 字符串为空时，说明已经遍历完所有位置
        if (str.isEmpty()) {
            // 将当前结果添加到列表中
            result.add(prefix);
            return;
        }
        // 遍历字符串中的每个字符
        for (int i = 0; i < str.length(); i++) {
            // 取出第 i 个字符作为当前位置的字符
            char c = str.charAt(i);
            // 去掉第 i 个字符后剩余的字符串
            String rest = str.substring(0, i) + str.substring(i + 1);
            // 将剩余的字符串和当前位置的字符传递给下一层递归
            permutation(rest, prefix + c, result);
        }
    }

}
