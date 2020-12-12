package day._12;

import lombok.Getter;

@Getter
public class Position {

    private long x;
    private long y;
    private long heading;

    public Position() {
        heading = 90;
    }

    public Position(long x, long y) {
        this.x = x;
        this.y = y;
        this.heading = 0;
    }

    void shiftX(long increment) {
        x += increment;
    }

    void shiftY(long increment) {
        y += increment;
    }

    void rotate(long degrees) {
        long nextHeading = heading + degrees;

        if (nextHeading < 0) {
            nextHeading += 360;
        } else if (nextHeading >= 360) {
            nextHeading %= 360;
        }

        this.heading = nextHeading;
    }

}
