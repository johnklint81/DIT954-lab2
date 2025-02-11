import java.util.ArrayList;

public class CarWorkshop<T extends Car> {
   private final ArrayList<T> cars;
   private final int MAX_CARS;

   public CarWorkshop( int maxCars) {
      this.cars = new ArrayList<>();
      this.MAX_CARS = maxCars;
   }

   public void loadCar(T car) {
      if (getCarAmount() >= this.MAX_CARS) {
         throw new IllegalArgumentException("Workshop is full");
      }
      if (hasCar(car)) {
         throw new IllegalArgumentException("Car is already in workshop");
      }
      this.cars.add(car);
   }

   public T collectCar(T car) {
      if(!hasCar(car)) {
         throw new IllegalArgumentException("Car is not in workshop");
      }
      cars.remove(car);
      return car;
   }


   public int getCarAmount() {
      return this.cars.size();
   }

   public boolean hasCar(T car) {
     return this.cars.contains(car);
   }

}