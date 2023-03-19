package weekly.date202303.week337;

import java.util.Arrays;

/**
 * 6319. 奇偶位数
 *
 * @author Real
 * @since 2023/3/19 10:37
 */
public class NumberEvenOddBits {

    public static void main(String[] args) {
        System.out.println(Arrays.toString(evenOddBit(17)));
        System.out.println(Arrays.toString(evenOddBit(2)));
    }

    public static int[] evenOddBit(int n) {
        String number = Integer.toBinaryString(n);
        StringBuilder sb = new StringBuilder(number);
        String s = sb.reverse().toString();
        int even = 0, odd = 0;
        int length = s.length();
        for (int i = 0; i < length; i++) {
            if (Integer.parseInt(s.charAt(i) + "") == 1) {
                if (i % 2 == 0) {
                    even++;
                } else {
                    odd++;
                }
            }
        }
        return new int[]{even, odd};
    }

}
