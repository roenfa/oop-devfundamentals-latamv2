package sensor;

public class WaterSensorImpl implements ISensor{

    @Override
    public boolean isFull(int amountOfWater, int numberOfCups) {
        if (amountOfWater<numberOfCups)return false;
        return true;
    }

    private boolean isBoilerFull;

}
