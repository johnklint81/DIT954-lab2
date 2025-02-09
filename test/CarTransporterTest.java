import org.junit.jupiter.api.Test;
import java.util.Arrays;
import static org.junit.jupiter.api.Assertions.*;


public class CarTransporterTest {
    @Test
    void gas() {
        CarTransporter ct = new CarTransporter(10);
        double[] initialPos = ct.getCurrentPosition().clone();
        ct.gas(0.1);
        ct.move();
        // check if it moved
        assertFalse(Arrays.equals(initialPos, ct.getCurrentPosition()));
        // should not be able to lower the ramp while moving
        assertThrows(IllegalStateException.class, () ->ct.ramp.lower());
    }
    @Test
    void load() {
        CarTransporter ct1 = new CarTransporter(2);
        Saab95 saab1 = new Saab95();
        Saab95 saab2 = new Saab95();
        Volvo240 volvo = new Volvo240();
        ct1.ramp.lower();
        ct1.ramp.load(saab1);
        // load same car twice
        assertThrows(IllegalArgumentException.class, () -> ct1.ramp.load(saab1));
        ct1.ramp.load(volvo);
        // over capacity
        assertThrows(IllegalStateException.class, () -> ct1.ramp.load(saab2));
    }
    @Test
    void unload() {
        CarTransporter ct1 = new CarTransporter(2);
        Saab95 saab1 = new Saab95();
        Volvo240 volvo = new Volvo240();
        ct1.ramp.lower();
        ct1.ramp.load(saab1);
        ct1.ramp.load(volvo);
        ct1.ramp.peek();
        ct1.ramp.unload();
        ct1.ramp.raise();
        assertThrows(IllegalStateException.class, () -> ct1.ramp.unload());
        ct1.ramp.lower();
        ct1.ramp.unload();
        assertThrows(IllegalStateException.class, () -> ct1.ramp.unload());
    }
    @Test
    void isClose() {
        CarTransporter ct1 = new CarTransporter(2);
        Saab95 saab1 = new Saab95();
        saab1.gas(1);
        saab1.gas(1);
        saab1.gas(1);
        saab1.gas(1);
        saab1.move();
        saab1.getCurrentPosition();
        // Make sure isClose gives error when saab1 is "far" away from the ramp
        assertFalse(ct1.ramp.isClose(saab1));
    }
}
