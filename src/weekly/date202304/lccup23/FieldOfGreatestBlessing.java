package weekly.date202304.lccup23;

import java.util.ArrayList;
import java.util.List;

/**
 * @author Real
 * @since 2023/4/22 15:37
 */
public class FieldOfGreatestBlessing {

    public static void main(String[] args) {
        FieldOfGreatestBlessing test = new FieldOfGreatestBlessing();
        int[][] forceField = {{4, 4, 6}, {7, 5, 3}, {1, 6, 2}, {5, 6, 3}};
        System.out.println(test.fieldOfGreatestBlessing(forceField));
    }

    public int fieldOfGreatestBlessing(int[][] forceField) {
        int length = forceField.length;

        List<Square> squares = new ArrayList<>();
        for (int[] field : forceField) {
            squares.add(buildSquare(field));
        }

        int ans = 1;
        for (int i = 0; i < length; i++) {
            int maxRepetitive = 1;
            Square square = squares.get(i);
            for (int j = i + 1; j < length; j++) {
                Square temp = squares.get(j);
                boolean repetitive = checkSquareRepetitive(square, temp);
                if (repetitive) {
                    maxRepetitive++;
                }
            }
            ans = Math.max(ans, maxRepetitive);
        }

        return ans;
    }

    private boolean checkSquareRepetitive(Square square1, Square square2) {
        if (square1.xEnd < square2.xStart || square2.xEnd < square1.xStart) {
            return false;
        }

        return square1.yEnd >= square2.yStart && square2.yEnd >= square1.yStart;
    }

    private Square buildSquare(int[] field) {
        int x = field[0];
        int y = field[1];
        double side = field[2] / 2.0;
        return new Square(x - side, x + side, y - side, y + side);
    }

    public static class Square {
        public double xStart;
        public double xEnd;
        public double yStart;
        public double yEnd;

        public Square(double xStart, double xEnd, double yStart, double yEnd) {
            this.xStart = xStart;
            this.xEnd = xEnd;
            this.yStart = yStart;
            this.yEnd = yEnd;
        }
    }

}
