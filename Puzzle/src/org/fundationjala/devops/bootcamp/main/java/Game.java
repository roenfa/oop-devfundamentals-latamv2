import java.util.Scanner;

public class Game {
    public void run() {
        Scanner sc = new Scanner(System.in);
        System.out.println("Welcome to the game!");
        System.out.print("Set size of the board: ");
        int limit = sc.nextInt();
        Table table = new Table(limit);
        Movement movement = new Movement();
        MovementStorage movementStorage = new MovementStorage();
        System.out.println("Table created");
        table.printTable();
        table.shuffle(table.getMatriz());
        System.out.println("Shuffled table:");
        String movementString = "";
        do {
            table.printTable();
            System.out.println("Hole " + table.getHole().getPosition());
            System.out.println("Possible movements:");
            movement.possibleMovements(table);
            System.out.println("exit");
            movementString = sc.nextLine();
            movement.move(table, movementString);
            movementStorage.addMovement(movement.getMovement());
        }while (!movementString.equals("exit"));
        movementStorage.printMovements();
    }
    public boolean isSolved(Table table) {
        Table solvedTable = new Table(table.getLimit());
        System.out.println("original table:");
        solvedTable.printTable();
        System.out.println("table:");
        table.printTable();
        for (int i = 0; i < table.getLimit(); i++) {
            for (int j = 0; j < table.getLimit(); j++) {
                if (table.getMatriz()[i][j] != solvedTable.getMatriz()[i][j]) {
                    return false;
                }
            }
        }
        return true;
    }
}
