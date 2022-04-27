package org.fundacionjala.devops.bootcamp.History;

public class MovementsHistory {
    String movementsOption = "";

    public MovementsHistory() {
    }

    public void getMovementsOption() {
        System.out.println(movementsOption);
    }

    public void setMovementsOption(String movementsOption) {
        this.movementsOption += " " + movementsOption;
    }

    public String rollBack(int quantity) {
        String[] movements = movementsOption.split(" ");
        String removedMovements = "";
        for (int i = movements.length - 1; i >= movements.length - quantity; i--) {
            removedMovements += " " + movements[i];
            movementsOption = movementsOption.replace(movements[i], "");
        }
        System.out.println("The following movements were removed: " + removedMovements);
        return removedMovements;
    }

    public void printMovementsOption() {
        System.out.println(movementsOption);
    }

    @Override
    public String toString() {
        return "MovementsHistory{" +
                "movementsOption='" + movementsOption + '\'' +
                '}';
    }
}
