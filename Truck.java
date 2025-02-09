import java.awt.*;

public abstract class Truck extends Vehicle {
    private double[] currentPosition = {0, 0};    // (x, y)
    private double currentDirection = 0; // Angle in degrees (from unit vector perspective)
    private double currentSpeed = 0; // The current speed of the car
    private Color color; // Color of the car

    protected Truck(int nrDoors, double enginePower, Color color, String modelName) {
        super(nrDoors,  enginePower, color, modelName);
        stopEngine();
    }
}
