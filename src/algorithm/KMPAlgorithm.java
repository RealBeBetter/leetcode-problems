package algorithm;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

/**
 * https://pdai.tech/md/algorithm/alg-domain-char-match-kmp.html
 *
 * @author wei.song
 * @since 2022-10-17 12:55
 */
public class KMPAlgorithm {

    public static void main(String[] args) {
        String source = "ABCDABC";
        String target = "BBC ABCDAB ABCDABCDABDE";
        int stringIndex = getStringIndex(source, target);
        System.out.println(stringIndex);
    }

    private static int getStringIndex(String source, String target) {
        String commonStr = findCommonStr(source);
        int offset = source.length() - commonStr.length();
        int step = source.length() - offset;
        // 每次匹配，匹配合适的长度 > step ，则跳转 step；反之，跳转单个
        int length = target.length();
        for (int i = 0; i < length; i++) {
            int beginInx = 0;
            int checkInx = 0;
            if (length - beginInx < source.length()) {
                break;
            }
            int realInx = i;
            while (checkInx < source.length()) {
                if (target.charAt(realInx) == source.charAt(beginInx)) {
                    checkInx++;
                    beginInx++;
                    realInx++;
                } else {
                    if (checkInx >= step) {
                        i += step - 1;
                    }
                    break;
                }
            }
            if (checkInx == source.length()) {
                return i;
            }
        }
        return -1;
    }

    /**
     * 找出前缀和后缀公共部分
     * "A"的前缀和后缀都为空集，共有元素的长度为0；
     * "AB"的前缀为[A]，后缀为[B]，共有元素的长度为0；
     * "ABC"的前缀为[A, AB]，后缀为[BC, C]，共有元素的长度0；
     * "ABCD"的前缀为[A, AB, ABC]，后缀为[BCD, CD, D]，共有元素的长度为0；
     * "ABCDA"的前缀为[A, AB, ABC, ABCD]，后缀为[BCDA, CDA, DA, A]，共有元素为"A"，长度为1；
     * "ABCDAB"的前缀为[A, AB, ABC, ABCD, ABCDA]，后缀为[BCDAB, CDAB, DAB, AB, B]，共有元素为"AB"，长度为2；
     * "ABCDABD"的前缀为[A, AB, ABC, ABCD, ABCDA, ABCDAB]，后缀为[BCDABD, CDABD, DABD, ABD, BD, D]，共有元素的长度为0。
     */
    private static String findCommonStr(String source) {
        int length = source.length();
        if (length == 0) {
            return "";
        }
        StringBuilder prefix = new StringBuilder();
        List<String> prefixList = new ArrayList<>();
        List<String> suffixList = new ArrayList<>();
        for (int i = 0, j = 1; i < length - 1 && j < length; i++, j++) {
            prefix.append(source.charAt(i));
            prefixList.add(prefix.toString());
            suffixList.add(source.substring(j));
        }
        List<String> commonStr = prefixList.stream().filter(suffixList::contains).collect(Collectors.toList());
        int max = 0;
        String maxStr = "";
        for (String str : commonStr) {
            if (str.length() > max) {
                maxStr = str;
            }
            max = Math.max(max, str.length());
        }
        return maxStr;
    }

}
