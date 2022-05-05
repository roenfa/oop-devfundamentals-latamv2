package sensor;

public interface ISensor {
//    boolean isFull(boolean state);
    boolean isFull(int amountOfWater, int numberOfCups);
}
