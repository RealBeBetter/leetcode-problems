package weekly.date2023.date202304.lccup23;

import java.util.Arrays;
import java.util.Set;
import java.util.stream.Collectors;

/**
 * 2. 探险营地
 *
 * @author Real
 * @since 2023/4/22 15:26
 */
public class AdventureCamp {

    public int adventureCamp(String[] expeditions) {
        String sign = "->";
        Set<String> knownCamps = Arrays.stream(expeditions[0].split(sign)).collect(Collectors.toSet());

        int index = -1;
        int max = 0;
        int length = expeditions.length;
        for (int i = 1; i < length; i++) {
            if (expeditions[i] == null || expeditions[i].length() == 0) {
                continue;
            }

            Set<String> camps = Arrays.stream(expeditions[i].split(sign)).collect(Collectors.toSet());
            if (camps.size() == 0) {
                continue;
            }

            int originalSize = knownCamps.size();
            knownCamps.addAll(camps);
            int newCamps = knownCamps.size() - originalSize;
            if (newCamps > max) {
                max = newCamps;
                index = i;
            }
        }

        return index;
    }

}
