package other;

import java.util.LinkedHashMap;
import java.util.Map;
import java.util.Set;

/**
 * @author wei.song
 * @since 2023/3/24 11:18
 */
public class NumberToChinese {

    public static void main(String[] args) {
        NumberToChinese test = new NumberToChinese();
        int number = 102034501;
        System.out.println(test.convertNumberToChinese(number));
    }


    private Map<Integer, String> constructMap() {
        Map<Integer, String> sizeMap = new LinkedHashMap<>();
        sizeMap.put(1000000000, "十亿");
        sizeMap.put(100000000, "亿");
        sizeMap.put(10000000, "千万");
        sizeMap.put(1000000, "百万");
        sizeMap.put(100000, "十万");
        sizeMap.put(10000, "万");
        sizeMap.put(1000, "千");
        sizeMap.put(100, "百");
        sizeMap.put(10, "十");
        sizeMap.put(9, "九");
        sizeMap.put(8, "八");
        sizeMap.put(7, "七");
        sizeMap.put(6, "六");
        sizeMap.put(5, "五");
        sizeMap.put(4, "四");
        sizeMap.put(3, "三");
        sizeMap.put(2, "二");
        sizeMap.put(1, "一");
        sizeMap.put(0, "零");


        return sizeMap;
    }


    /**
     * 将数字转换成汉字，限制[0,十亿]
     *
     * @param number 数量
     * @return {@link String}
     */
    private String convertNumberToChinese(int number) {
        int maxSize = 1000000000;
        if (number < 0 || number > maxSize) {
            throw new IllegalArgumentException("argument error");
        }

        Map<Integer, String> sizeMap = constructMap();

        Set<Map.Entry<Integer, String>> entries = sizeMap.entrySet();

        int temp = number;
        StringBuilder ans = new StringBuilder();
        for (Map.Entry<Integer, String> entry : entries) {
            Integer current = entry.getKey();
            if (current == 0) {
                break;
            }
            if (temp == 0) {
                if (ans.length() > 0) {
                    break;
                }
                ans.append(sizeMap.get(temp));
                break;
            }

            if (String.valueOf(temp).length() == 1) {
                ans.append(sizeMap.get(temp));
                break;
            }

            if (temp < current && String.valueOf(temp).length() < String.valueOf(current).length()) {
                continue;
            }
            int num = temp / current;
            if (num != 0) {
                ans.append(sizeMap.get(num));
            }
            ans.append(entry.getValue());
            if (temp - num == 0) {
                temp = current;
            } else {
                int next = temp - num * current;
                if (Math.abs(String.valueOf(next).length() - String.valueOf(temp).length()) > 1) {
                    ans.append(sizeMap.get(0));
                }
                temp = next;
            }
        }

        return ans.toString();
    }

}
