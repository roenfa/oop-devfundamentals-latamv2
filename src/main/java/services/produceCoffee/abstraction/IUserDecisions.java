package services.produceCoffee.abstraction;

public interface IUserDecisions {
    boolean defineIfPotIsFull();
    boolean defineWarmerPlateIsFull();
    int defineWaterIsPresent();
}
