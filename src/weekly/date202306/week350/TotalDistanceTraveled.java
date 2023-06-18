package weekly.date202306.week350;

/**
 * 6901. 总行驶距离
 *
 * @author wei.song
 * @since 2023/6/18 10:34
 */
public class TotalDistanceTraveled {

    public int distanceTraveled(int mainTank, int additionalTank) {
        int traveled = 0;
        while (mainTank > 0) {
            if (mainTank >= 5) {
                mainTank -= 5;
                if (additionalTank > 0) {
                    additionalTank--;
                    mainTank++;
                }
                traveled += 50;
            } else {
                traveled += mainTank * 10;
                mainTank -= mainTank;
            }
        }

        return traveled;
    }

}
