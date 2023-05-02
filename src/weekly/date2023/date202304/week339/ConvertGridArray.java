package weekly.date2023.date202304.week339;

import java.util.ArrayList;
import java.util.List;

/**
 * 6363. 转换二维数组
 *
 * @author Real
 * @since 2023/4/2 10:48
 */
public class ConvertGridArray {

    public static void main(String[] args) {
        ConvertGridArray test = new ConvertGridArray();
        int[] array = {1, 2, 3, 4};
        System.out.println(test.findMatrix(array));
    }

    public List<List<Integer>> findMatrix(int[] nums) {
        List<List<Integer>> ans = new ArrayList<>();
        List<Integer> first = new ArrayList<>();
        ans.add(first);

        for (int num : nums) {
            List<Integer> list = ans.get(0);
            if (!list.contains(num)) {
                list.add(num);
                continue;
            }
            int flag = 0;
            // 此时应该回溯之前的 List 判断是否可以进行添加
            for (int i = 1; i < ans.size(); i++) {
                List<Integer> temp = ans.get(i);
                if (!temp.contains(num)) {
                    temp.add(num);
                    flag = 1;
                    break;
                }
            }

            if (flag == 0) {
                // 新建一个 List
                List<Integer> temp = new ArrayList<>();
                temp.add(num);
                ans.add(temp);
            }
        }

        return ans;
    }

}
