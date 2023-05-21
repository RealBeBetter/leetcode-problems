package weekly.date202305.week346;

/**
 * 6439. 删除子串后的字符串最小长度
 *
 * @author Real
 * @since 2023/5/21 10:38
 */
public class MinimumStringLength {

    public static void main(String[] args) {
        MinimumStringLength test = new MinimumStringLength();
        System.out.println(test.minLength("ABFCACDB"));
        System.out.println(test.minLength("ACBBD"));
    }

    public int minLength(String s) {
        String target1 = "AB";
        String target2 = "CD";
        String temp = s;

        while (temp.contains(target1) || temp.contains(target2)) {
            int index1 = temp.indexOf(target1);
            int index2 = temp.indexOf(target2);
            String end;
            if (index1 != -1) {
                end = temp.substring(index1 + 2);
                temp = temp.substring(0, index1) + end;
                continue;
            }

            if (index2 != -1) {
                end = temp.substring(index2 + 2);
                temp = temp.substring(0, index2) + end;
            }
        }

        return temp.length();
    }

}
