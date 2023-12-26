package structure.linkedlist;

import java.util.LinkedHashMap;
import java.util.Map;

/**
 * @author wei.song
 * @since 2023/12/26 22:06
 */
public class LinkedHashMapDemo {

    public static void main(String[] args) {
        Map<Integer, Integer> map = new LinkedHashMap<>();
        map.put(3, 11);
        map.put(1, 12);
        map.put(5, 23);
        map.put(2, 22);

        for (Map.Entry<Integer, Integer> entry : map.entrySet()) {
            System.out.println(entry.getKey());
        }

        // 10 是初始大小，0.75 是装载因子，true 是表示按照访问时间排序
        Map<Integer, Integer> m = new LinkedHashMap<>(10, 0.75f, true);
        m.put(3, 11);
        m.put(1, 12);
        m.put(5, 23);
        m.put(2, 22);

        m.put(3, 26);
        m.get(5);

        for (Map.Entry<Integer, Integer> entry : m.entrySet()) {
            System.out.println(entry.getKey());
        }
    }

}
