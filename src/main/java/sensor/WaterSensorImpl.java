package sensor;

public class WaterSensorImpl implements ISensor{

    @Override
    public boolean isFull(boolean isBoilerFull) {
        this.isBoilerFull = isBoilerFull;
        return isBoilerFull;
    }

    private boolean isBoilerFull;

}
