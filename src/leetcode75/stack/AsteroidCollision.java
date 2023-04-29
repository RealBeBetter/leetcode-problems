package leetcode75.stack;

import java.util.Arrays;
import java.util.Stack;

/**
 * 735. 行星碰撞
 *
 * @author wei.song
 * @since 2023/4/29 22:09
 */
public class AsteroidCollision {

    public static void main(String[] args) {
        AsteroidCollision test = new AsteroidCollision();
        System.out.println(Arrays.toString(test.asteroidCollision(new int[]{-2, -2, 2, -1})));
    }

    public int[] asteroidCollision(int[] asteroids) {
        Stack<Integer> planets = new Stack<>();
        for (int asteroid : asteroids) {
            planets.push(asteroid);
            if (asteroid < 0) {
                collision(planets);
            }
        }

        int[] ans = new int[planets.size()];
        for (int i = 0; i < planets.size(); i++) {
            ans[i] = planets.get(i);
        }
        return ans;
    }

    private void collision(Stack<Integer> planets) {
        if (planets == null || planets.isEmpty() || planets.size() == 1 || planets.peek() > 0) {
            return;
        }

        Integer top1 = planets.pop();
        Integer top2 = planets.pop();
        boolean sameSymbol = (top1 > 0 && top2 > 0) || (top1 < 0 && top2 < 0);
        if (sameSymbol) {
            planets.push(top2);
            planets.push(top1);
            return;
        }

        int top = 0;
        if (Math.abs(top1) > Math.abs(top2)) {
            top = top1;
        } else if (Math.abs(top1) < Math.abs(top2)) {
            top = top2;
        }

        if (top != 0) {
            planets.push(top);
        }
        collision(planets);
    }

}
