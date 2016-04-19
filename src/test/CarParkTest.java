package test;

import main.CarPark;
import org.junit.Before;
import org.junit.Test;

import static org.junit.Assert.assertEquals;

public class CarParkTest {

    private CarPark carPark;
    private String entryTime;
    private String exitTime;
    private int expected;

    @Before
    public void setUp() {
        carPark   = new CarPark();
    }

    @Test
    public void testPartialHourOnly() {
        entryTime = "15:00";
        exitTime  = "15:01";
        expected  = 5;
        assertEquals("Partial hour only", expected, carPark.till(entryTime, exitTime));
    }

    @Test
    public void testFirstHourOnly() {
        entryTime = "08:00";
        exitTime  = "09:00";
        expected  = 5;
        assertEquals("Full hour only", expected, carPark.till(entryTime, exitTime));
    }

    @Test
    public void testOneHourAndPartialSecondHour() {
        entryTime = "14:00";
        exitTime  = "15:27";
        expected  = 9;
        assertEquals("Full 1st hour and partial 2nd", expected, carPark.till(entryTime, exitTime));
    }
}