package sensor;

public class PressureSensorImpl implements IPotSensor{

    @Override
    public boolean isWarmerPlateFull() {
        return isWarmerPlateFull;
    }

    private boolean isPotEmpty;
    private boolean isWarmerPlateFull;

    public PressureSensorImpl() {}

    public PressureSensorImpl(boolean isPotEmpty, boolean isWarmerPlateFull) {
        this.isPotEmpty = isPotEmpty;
        this.isWarmerPlateFull = isWarmerPlateFull;
    }
    @Override
    public void setWarmerPlateFull(boolean warmerPlateFull) {
        isWarmerPlateFull = warmerPlateFull;
    }

    @Override
    public boolean isPotFull(boolean potFull) {
        return potFull;
    }

    public boolean isPotEmpty() {
        return isPotEmpty;
    }

    public void setPotEmpty(boolean potEmpty) {
        this.isPotEmpty = potEmpty;
    }
}
