package sensor;

public interface IPotSensor {
    boolean isWarmerPlateFull();
    void setWarmerPlateFull(boolean warmerPlateFull);
    boolean isPotFull(boolean potFull);
}
