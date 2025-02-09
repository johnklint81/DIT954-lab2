import java.util.ArrayDeque;
import java.util.Deque;

public class Ramp {
    private Truck owner;    // the transporter that the ramp is installed on
    private boolean down = false;   // is the ramp down or not?
    private final int capacity;    // how many cars can the ramp hold
    private final Deque<Car> stack;   // container for cars
    private double threshold = 10;  // meters

    protected Ramp(Truck truck, int capacity) {
        this.owner = truck;
        this.capacity = capacity;
        stack = new ArrayDeque<>(capacity);
    }
    public boolean isClose(Car car) {
        double sum = 0;
        for (int i = 0; i < 2; i++) {
            sum += Math.pow((this.owner.getCurrentPosition()[i] - car.getCurrentPosition()[i]), 2);
        }
        return Math.sqrt(sum) < threshold;
    }
    public void push(Car car) {
        if (stack.size() >= capacity) {
            throw new IllegalStateException("The ramp is full. Cannot load any more cars.");
        }
        else if (!isClose(car)) {
            throw new IllegalStateException("That car is too fara away from the ramp.");
        }
        stack.push(car);
    }
    public Car pop() {
        if (stack.isEmpty()) {
            throw new IllegalStateException("The ramp is empty. Cannot unload any more cars.");
        }
        return stack.pop();
    }

    public Car peek() {
        return stack.peek();
    }
    public boolean isFull() {
        return stack.size() == capacity;
    }

    public boolean isEmpty() {
        return stack.isEmpty();
    }


    public boolean isDown() {
        return down;
    }

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

    protected void raise() {
        if (!this.isDown()) {
            System.out.println("The ramp is already up.");
        }
        this.down = false;
    }
    public void setDown(boolean down) {
        this.down = down;
    }

    public Truck getOwner() {
        return owner;
    }
    public int getCapacity() {
        return capacity;
    }
}
