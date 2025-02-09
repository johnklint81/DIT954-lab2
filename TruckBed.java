public class TruckBed {
    private final double MIN_ANGLE = 0;     // degrees
    private final double MAX_ANGLE = 70;    // degrees
    private double currentAngle;    // degrees
    private Truck owner;

    public TruckBed(Truck truck) {
        this.owner = truck;
    }

    public double getCurrentAngle() {
        return currentAngle;
    }

    public void lower(double angle) {
        if (owner.getCurrentSpeed() == 0) {
            double newAngle = getCurrentAngle() - angle;
            this.currentAngle = Math.max(MIN_ANGLE, newAngle);
        }
        else {
            throw new IllegalStateException("The truck bed can only be lowered when speed is 0");
        }

    }
    public void raise(double angle) {
        if (owner.getCurrentSpeed() == 0) {
            double newAngle = getCurrentAngle() + angle;
            this.currentAngle = Math.min(MAX_ANGLE, newAngle);
        }
        else {
            throw new IllegalStateException("The truck bed can only be lowered when speed is 0");
        }

    }
    public double getMIN_ANGLE() {
        return MIN_ANGLE;
    }

    public double getMAX_ANGLE() {
        return MAX_ANGLE;
    }

}
