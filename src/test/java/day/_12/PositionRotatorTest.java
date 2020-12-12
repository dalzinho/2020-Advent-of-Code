package day._12;

import org.junit.Test;

import static org.junit.Assert.*;

public class PositionRotatorTest {

    @Test
    public void test() {
        Rotator positionRotator = new PositionRotator();

        Position position = new Position(10, 4);

        final Position rotated = positionRotator.rotate(position, 90);
        assertEquals(4, rotated.getX());
        assertEquals(-10, rotated.getY());
    }

    @Test
    public void testNegative() {
        Rotator positionRotator = new PositionRotator();

        Position position = new Position(10, 4);

        final Position rotated = positionRotator.rotate(position, -90);
        assertEquals(-4, rotated.getX());
        assertEquals(10, rotated.getY());
    }
}