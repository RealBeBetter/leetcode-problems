package weekly.date202305.week344;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * 6417. 频率跟踪器
 * Your FrequencyTracker object will be instantiated and called as such:
 * FrequencyTracker obj = new FrequencyTracker();
 * obj.add(number);
 * obj.deleteOne(number);
 * boolean param_3 = obj.hasFrequency(frequency);
 *
 * @author Real
 * @since 2023/5/7 10:41
 */
public class FrequencyTracker {

    private final Map<Integer, Integer> numberMap;
    private final Map<Integer, List<Integer>> frequencyMap;

    public FrequencyTracker() {
        this.numberMap = new HashMap<>();
        this.frequencyMap = new HashMap<>();
    }

    public void add(int number) {
        numberMap.compute(number, (k, v) -> v = v == null ? 1 : v + 1);
        Integer frequency = numberMap.get(number);
        if (frequency == 1) {
            // 第一次加入
            List<Integer> onceNumbers = frequencyMap.get(1);
            if (onceNumbers == null) {
                onceNumbers = new ArrayList<>();
            }
            onceNumbers.add(number);
            frequencyMap.put(1, onceNumbers);
        } else {
            List<Integer> lessNumbers = frequencyMap.get(frequency - 1);
            lessNumbers.remove(number);
            if (lessNumbers.isEmpty()) {
                frequencyMap.remove(frequency - 1);
            } else {
                frequencyMap.put(frequency - 1, lessNumbers);
            }

            List<Integer> moreNumbers = frequencyMap.get(frequency);
            if (moreNumbers == null) {
                moreNumbers = new ArrayList<>();
            }
            moreNumbers.add(number);
            frequencyMap.put(frequency, moreNumbers);
        }
    }

    public void deleteOne(int number) {
        if (!numberMap.containsKey(number)) {
            return;
        }

        Integer frequency = numberMap.get(number);

        List<Integer> moreNumbers = frequencyMap.get(frequency);
        moreNumbers.remove(number);
        if (moreNumbers.isEmpty()) {
            frequencyMap.remove(frequency);
        } else {
            frequencyMap.put(frequency, moreNumbers);
        }

        if (frequency > 1) {
            numberMap.put(number, frequency - 1);
            List<Integer> lessNumbers = frequencyMap.get(frequency - 1);
            if (lessNumbers == null) {
                lessNumbers = new ArrayList<>();
            }
            lessNumbers.add(number);
            frequencyMap.put(frequency - 1, lessNumbers);
        } else {
            numberMap.remove(number);
        }

    }

    public boolean hasFrequency(int frequency) {
        return frequencyMap.get(frequency) != null;
    }
}
