import java.awt.*;

public class Scania extends Truck {

    public boolean turboOn;
    protected TruckBed truckBed;

    protected Scania() {
        super(2, 125, Color.BLACK, "Scania");
        this.truckBed = new TruckBed(this);
        turboOn = false;
    }
    @Override
    public boolean canMove() {
        if (this.truckBed == null || this.truckBed.getCurrentAngle() == 0) {
            return true;
        }
        else {
            throw new IllegalStateException("You cannot drive with the truck bed is raised!");
        }

    }
    public void setTurboOn() {
        turboOn = true;
    }

    public void setTurboOff() {
        turboOn = false;
    }
    @Override
    public double speedFactor() {
        double turbo = 1;
        if (turboOn) turbo = 1.1;
        return getEnginePower() * 0.01 * turbo;
    }
}
