import java.util.Scanner;

public class Game {
    public void run() {
        Scanner sc = new Scanner(System.in);
        System.out.println("Welcome to the game!");
        System.out.print("Set size of the board: ");
        int limit = sc.nextInt();
        Table table = new Table(limit);
        Movement movement = new Movement();

        System.out.println("Table created");
        table.printTable();

        System.out.println("Do you want to:\n1. Shuffle the table\n2. Set a number of random moves");
        String answer = sc.next();
        if (answer.equals("1")) {
            table.shuffle(table.getMatriz());
            System.out.println("Shuffled table:");
        }
        if (answer.equals("2")) {
            System.out.print("Enter number of movements: ");
            int movements = sc.nextInt();
            table.setRandomMovements(movements);
        }

        //Frame f = new Frame("Demo");
        //f.setLayout(new FlowLayout());
        //f.setSize(200, 200);
        //Label l = new Label();
        //l.setText("This is a Game");
        //f.add(l);
        //f.setVisible(true);

        //adding the key listener
        //Movement movement= new Movement();
        //f.addKeyListener(movement);

        //while (movement != ) {}

        String movementString = "";
        while (!movementString.equals("exit")){
            table.printTable();
            System.out.println("Hole " + table.getHole().getPosition());
            System.out.println("Possible movements:");
            movement.possibleMovements(table).forEach(System.out::println);
            System.out.println("exit");
            movementString = sc.nextLine();
            movement.move(table, movementString);
        }
        movement.getMovementStorage().printMovements();
    }

}
