import java.awt.*;

public class CarTransporter extends Truck {
    // This class corresponds to the Scania/Saab95/Volvo240 subclasses
    private Ramp ramp;

    protected CarTransporter(int capacity) {
        super(2, 125, Color.BLACK, "Scania");
        // Give the CarTransporter a ramp with specified capacity
        this.ramp = new Ramp(this, capacity);
        stopEngine();
    }
    public boolean turboOn;
    protected TruckBed truckBed;

    @Override
    public boolean canMove() {
        if (this.ramp == null || !this.ramp.isDown()) {
            return true;
        }
        else {
            throw new IllegalStateException("You cannot drive with the ramp lowered!");
        }

    }
    @Override
    public double speedFactor() {
        return getEnginePower() * 0.01;
    }

}
