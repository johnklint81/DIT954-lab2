import java.util.Deque;
import java.util.ArrayDeque;

public class Ramp {
    private Truck owner;    // the transporter that the ramp is installed on
                            // the ownership could change, ramp is moved to another truck
    private boolean down = false;   // is the ramp down or not?
    private final int capacity;    // how many cars can the ramp hold?
    private final Deque<Car> stack;   // lifo container for cars
    // constructor
    protected Ramp(Truck truck, int capacity) {
        this.owner = truck;
        this.capacity = capacity;
        stack = new ArrayDeque<>(capacity);
    }
    // check if the car is close enough to be loaded to ramp
    public boolean isClose(Car car) {
        double sum = 0;
        for (int i = 0; i < 2; i++) {
            sum += Math.pow((this.owner.getCurrentPosition()[i] - car.getCurrentPosition()[i]), 2);
        }
        // in meters, value to determine if car is close to ramp
        double threshold = 10;
        return Math.sqrt(sum) < threshold;
    }
    // push to stack
    public void load(Car car) {
        if (stack.size() >= capacity) {
            throw new IllegalStateException("The ramp is full. Cannot load any more cars.");
        }
        else if (!isClose(car)) {
            throw new IllegalStateException("That car is too fara away from the ramp.");
        }
        stack.push(car);
    }
    // pop from stack
    public Car unload() {
        if (stack.isEmpty()) {
            throw new IllegalStateException("The ramp is empty. Cannot unload any more cars.");
        }
        else if (!isDown()) {
            throw new IllegalStateException("The ramp is not down");
        }
        return stack.pop();
    }
    // peek on top of stack
    public Car peek() {
        return stack.peek();
    }
    // is ramp full?
    public boolean isFull() {
        return stack.size() == capacity;
    }
    // is ramp empty?
    public boolean isEmpty() {
        return stack.isEmpty();
    }
    // is ramp down?
    public boolean isDown() {
        return down;
    }
    // lower ramp
    protected void lower() {
        if (owner.getCurrentSpeed() == 0) {
            if (this.isDown()) {
                System.out.println("The ramp is already down.");
            }
            this.down = true;
        } else {
            throw new IllegalStateException("The ramp can only be lowered " +
                                            "when the transporter is not moving.");
        }
    }
    // raise ramp
    protected void raise() {
        if (!this.isDown()) {
            System.out.println("The ramp is already up.");
        }
        this.down = false;
    }
    // get the truck the ramp is installed to
    public Truck getOwner() {
        return owner;
    }
    // get number of cars the ramp can store
    public int getCapacity() {
        return capacity;
    }
}
