package plan.binary;

/**
 * @author Real
 * @since 2023/3/1 22:48
 */
public class FirstBadVersion {

    public int firstBadVersion(int n) {
        int left = 1, right = n;

        while (left <= right) {
            int mid = (right - left) / 2 + left;
            boolean isBadVersion = isBadVersion(mid);

            if (isBadVersion) {
                if (mid == 1 || !isBadVersion(mid - 1)) {
                    return mid;
                } else {
                    right = mid - 1;
                }
            } else {
                left = mid + 1;
            }
        }

        return -1;
    }

    private boolean isBadVersion(int version) {
        return false;
    }

}
