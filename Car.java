import java.awt.*;

public abstract class Car extends Vehicle implements Movable {
    // We need to discuss whether we want to use interfaces also...
    // Inheritance is nice here because the subclasses share a lot of functionality

    private double[] currentPosition = {0, 0};    // (x, y)
    private double currentDirection = 0; // Angle in degrees (from unit vector perspective)
    private double currentSpeed = 0; // The current speed of the car
    private Color color; // Color of the car

    protected Car(int nrDoors, double enginePower, Color color, String modelName) {
        super(nrDoors,  enginePower, color, modelName);
        stopEngine();
    }
    @Override
    protected boolean canMove() {
        return true;
    }

}
