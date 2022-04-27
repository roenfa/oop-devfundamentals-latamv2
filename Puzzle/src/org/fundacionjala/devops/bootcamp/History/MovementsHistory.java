package org.fundacionjala.devops.bootcamp.History;

public class MovementsHistory {
    //method to Store every movement made by the user:
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
        //must store the removed last movement quantity times, and erase them from the movementsOption:
        //reverse for loop to remove the last movements:
        for (int i = movements.length - 1; i >= movements.length - quantity; i--) {
            removedMovements += " " + movements[i];

            //remove the last movement from the movementsOption:
            movementsOption = movementsOption.replace(movements[i], "");
        }
        //print the removed movements:
        System.out.println("The following movements were removed: " + removedMovements);
        return removedMovements;
    }

//        for (int i = 0; i < quantity; i++) {
//            movementsOption = movementsOption.replaceFirst(movements[i], "");
//        }


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
