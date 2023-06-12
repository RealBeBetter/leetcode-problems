package other;

/**
 * @author wei.song
 * @since 2023/6/12 22:23
 */
public class NumberReverse {

    public static void main(String[] args) {
        NumberReverse test = new NumberReverse();
        System.out.println(test.reverseLong(12345L));
        System.out.println(test.reverseLong(54321L));
        System.out.println(test.reverseLong(-54321L));
        System.out.println(test.reverseLong(-5431231232121L));
        System.out.println(test.reverseLong(-3431231212673828199L));
        System.out.println(test.reverseLong(-3431231212673828199L));
        System.out.println(test.reverseLong(-9218283762121321343L));
    }

    private long reverseLong(long arg) {
        long ans = 1;
        boolean start = true;
        boolean negative = arg < 0;
        arg = Math.abs(arg);
        while (arg >= 1) {
            long mod = arg % 10;
            if (start) {
                ans = mod;
                arg /= 10;
                start = false;
                continue;
            }

            if (ans > ans * 10 + mod) {
                long tempCount = mod * 10;
                while (ans > Long.MAX_VALUE - mod) {
                    tempCount -= mod;
                    ans += mod;
                }
                ans = mod - (Long.MAX_VALUE - ans);
                ans += tempCount - mod;
            } else {
                ans = ans * 10 + mod;
            }
            arg /= 10;
        }

        return negative ? ans * -1 : ans;
    }

    private long reverse(long number) {
        return Long.reverse(number);
    }

}
