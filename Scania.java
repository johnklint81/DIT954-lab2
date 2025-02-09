import java.awt.*;

public class Scania extends Truck {

    public boolean turboOn;
    protected Scania() {
        super(2, 125, Color.BLACK, "Scania");
        turboOn = false;
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
        if (turboOn) turbo = 1.3;
        return getEnginePower() * 0.01 * turbo;
    }
}
