import java.util.ArrayList;
import java.util.List;
import java.util.Arrays;
import java.util.NoSuchElementException;

public class Garage<T extends Car> {

    private final int capacity;     // allowed number of cars in the garage
    private List<Brand> allowedBrands;  // allowed brands for the garage
    private List<T> carList = new ArrayList<>();  // cars in the garage

    // Takes a list of enums specifying car brands
    protected Garage(int capacity, List<Brand> allowedBrands) {
        this.capacity = capacity;
        this.allowedBrands = allowedBrands;
    }
    // If we accept all brands
    protected Garage(int capacity) {
        this.capacity = capacity;
        this.allowedBrands = Arrays.asList(Brand.values());
    }

    public void addCar(T car) {
        if (checkAllowedBrands(car) && carList.size() < this.capacity) {
            carList.add(car);
        }
        else {
            throw new IllegalArgumentException("This brand is not allowed at this garage!");
        }
    }
    // Remove a car by selecting the brand of car.
    public T removeCar(Brand brand) {
        for (T car : carList) {
            if (car.getBrand() == brand) {
                carList.remove(car);
                // Keeping type Car as return-type is maybe safer than using generic?
                return car;
            }
        }
        throw new NoSuchElementException("There was no car of this brand in the garage!");

    }
    // Statically check if we may add this brand to the garage
    public boolean checkAllowedBrands(Car car) {
        return allowedBrands.contains(car.getBrand());
    }
}
