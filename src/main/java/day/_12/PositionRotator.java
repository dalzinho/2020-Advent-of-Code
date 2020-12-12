package day._12;

import static java.lang.Math.abs;

public class PositionRotator implements Rotator {

    @Override
    public Position rotate(Position position, int turn) {
        int turns = turn / 90;
        return turns > 0 ? rotateClockwise(position, turns) : rotateAntiClockwise(position, abs(turns));
    }

    private Position rotateAntiClockwise(Position position, int turns) {
        if (turns == 0) {
            return position;
        }

        long y = position.getY();
        long x = position.getX();

        long nextX = y * -1;

        return rotateAntiClockwise(new Position(nextX, x), turns - 1);
    }

    private Position rotateClockwise(Position position, int turns) {
        if (turns == 0) {
            return position;
        }

        long x = position.getX();
        long y = position.getY();

        long nextY;

        nextY = x * -1;

        return rotateClockwise(new Position(y, nextY), turns - 1);
    }
}
