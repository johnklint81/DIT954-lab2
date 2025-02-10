import org.junit.jupiter.api.Test;
import java.awt.*;
import java.util.Arrays;
import java.util.NoSuchElementException;
import static org.junit.jupiter.api.Assertions.*;

public class GarageTest {
    @Test
    void addCar() {
        Garage garage = new Garage(10, Arrays.asList(Brand.Saab95));
        Saab95 saab = new Saab95();
        Volvo240 volvo = new Volvo240();
        garage.addCar(saab);
        assertThrows(IllegalArgumentException.class, () -> garage.addCar(volvo));
    }
    @Test
    void removeCar() {
        Garage garage = new Garage(10, Arrays.asList(Brand.Saab95, Brand.Volvo240));
        Saab95 saab = new Saab95();
        Volvo240 volvo = new Volvo240();
        garage.addCar(saab);
        garage.addCar(volvo);
        garage.removeCar(Brand.Saab95);
        assertThrows(NoSuchElementException.class, () -> garage.removeCar(Brand.Saab95));
    }
}
