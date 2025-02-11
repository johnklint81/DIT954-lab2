import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class ScaniaTest {

    Scania t;

    @BeforeEach
    void setup() {
        t = new Scania();
    }

    @Test
    void getBedAngle() {
        
        assertEquals(0, t.getBedAngle());
    }

    @Test
    void raiseBed() {
        
        t.raiseBed(10);
        assertEquals(10, t.getBedAngle());

        assertThrows(IllegalArgumentException.class, () -> t.raiseBed(70));
    }

    @Test
    void lowerBed() {
        
        t.raiseBed(10);

        t.lowerBed(10);
        assertEquals(0, t.getBedAngle());

        assertThrows(IllegalArgumentException.class, () -> t.lowerBed(70));
    }

    @Test
    void gas() {
        
        double amount = 0.9;
        double currentSpeed = t.getCurrentSpeed();
        t.gas(amount);
        double newSpeed = t.getCurrentSpeed();

        assertTrue(currentSpeed <= newSpeed);
        assertThrows(IllegalArgumentException.class, () -> t.gas(1.5));
        assertThrows(IllegalArgumentException.class, () -> t.gas(-1.5));
    }

    @Test
    void speedFactor() {
        double speedValue = t.getEnginePower() * 0.01;
        assertEquals(speedValue, t.speedFactor());
    }
}