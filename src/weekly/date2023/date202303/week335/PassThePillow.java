package weekly.date2023.date202303.week335;

/**
 * @author Real
 * @since 2023/3/5 10:36
 */
public class PassThePillow {

    public static void main(String[] args) {
        int n = 4, time = 5;
        System.out.println(passThePillow(n, time));
    }

    /**
     * 递枕头
     *
     * @param n    人数，从 1 开始
     * @param time 时间
     * @return int
     */
    public static int passThePillow(int n, int time) {
        int round = (n - 1) * 2;
        time = time % round;

        if (time > n - 1) {
            time -= n - 1;
            // 倒序
            return n - time;
        }

        return time + 1;
    }

}
