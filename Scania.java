import java.awt.*;

public class Scania extends Truck {
    private double bedAngle = 0;

    protected Scania() {
        super(2, 300, Color.RED, "650S");
    }

    public double getBedAngle() {
        return this.bedAngle;
    }

    public void raiseBed(double increment) {
        if(this.bedAngle + increment > 70) {
            throw new IllegalArgumentException("Bed angle bigger than 70 degrees");
        }
        this.bedAngle += increment;
    }


    public void lowerBed(double decrement) {
        if(this.bedAngle - decrement < 0) {
            throw new IllegalArgumentException("Bed angle less than 0 degrees");
        }
        this.bedAngle -= decrement;
    }

    @Override
    public void gas(double amount) {
        if (amount < 0 || amount > 1) {
            throw new IllegalArgumentException("gas amount must be in interval [0, 1].");
        }
        if (getBedAngle() > 0) {
            throw new IllegalArgumentException("Bed angle not 0");
        }

        incrementSpeed(amount);
    }

    @Override
    protected double speedFactor() {
        return getEnginePower() * 0.01;
    }
}
