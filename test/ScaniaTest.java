import org.junit.jupiter.api.Test;

import java.util.Arrays;

import static org.junit.jupiter.api.Assertions.*;

public class ScaniaTest {
    @Test
    void gas() {
        Scania scania = new Scania();
        scania.truckBed.raise(20);
        assertThrows(IllegalStateException.class, scania::move);
        scania.truckBed.lower(30);
        double[] initialPos = scania.getCurrentPosition().clone();
        scania.gas(0.1);
        scania.move();
        assertFalse(Arrays.equals(initialPos, scania.getCurrentPosition()));
    }

    void raise() {
        Scania scania = new Scania();
        scania.truckBed.raise(100);
        assertEquals(scania.truckBed.getMAX_ANGLE(), scania.truckBed.getCurrentAngle());
    }

}
