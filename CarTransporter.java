import java.awt.*;

public abstract class CarTransporter extends Truck {
    private Ramp ramp;

    protected CarTransporter(int nrDoors, double enginePower, Color color,
                             String modelName, int capacity) {
        super(nrDoors,  enginePower, color, modelName);
        this.ramp = new Ramp(this, capacity);
        stopEngine();
    }

}
