package sensor;

import static java.lang.Thread.sleep;

public class PressureSensorImpl implements ISensor, IPotSensor{

    @Override
    public boolean isFull(boolean isPotEmpty) {return isPotEmpty;}

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

    public boolean isPotEmpty() {
        return isPotEmpty;
    }

    public void setPotEmpty(boolean potEmpty) {
        this.isPotEmpty = potEmpty;
    }
}
