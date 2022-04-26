package org.fundacionjala.devops.bootcamp.History;

public class MovementsHistory {
    //method to Store every movement made by the user:
    String movementsOption = "";

    public MovementsHistory() {

    }

    public String getMovementsOption() {
        System.out.println(movementsOption);
        return movementsOption;
    }

    public void setMovementsOption(String movementsOption) {
        this.movementsOption += movementsOption;
    }

    @Override
    public String toString() {
//        String separatedMovements = "";
//        for (int i = 0; i < movementsOption.length(); i++) {
//            separatedMovements += movementsOption.charAt(i) + ",";
//        }
        return
               // "movementsOption='" + separatedMovements ;
                movementsOption;

    }
}
