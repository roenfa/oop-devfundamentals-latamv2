import java.util.Scanner;

public class Game {
    Scanner sc = new Scanner(System.in);
    public void run() {
        System.out.println("Welcome to the game!");
        System.out.print("Set size of the board: ");
        int limit = sc.nextInt();
        Table table = new Table(limit);
        Movement movement = new Movement();

        System.out.println("Table created");
        table.printTable();


        setHoleInSpecificPosition(table, movement);

        play(table, movement);

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
    }

    private void play(Table table, Movement movement) {
        String movementString;
        table.printTable();
        System.out.println("Hole " + table.getHole().getPosition());
        System.out.println("Possible movements:");
        movement.possibleMovements(table).forEach(System.out::println);
        System.out.println("reset game (r)");
        System.out.println("history (h)");
        System.out.println("exit");
        movementString = sc.nextLine();
        if (movementString.equals("exit")) {
            System.exit(0);
        } else if (movementString.equals("h")) {
            movement.printMovements();
            play(table, movement);
        } else if (movementString.equals("r")) {
            run();
        } else {
            movement.move(table, movementString);
            play(table, movement);
        }
    }

    public void setHoleInSpecificPosition(Table table, Movement movement) {
        System.out.println("""
                Do you want to set hole on any specific position?
                You'll probably lose track of movements
                1. Yes
                2. No""");
        int answer2 = sc.nextInt();
        if (answer2 == 1) {
            Position position = new Position();
            position.enterPosition();
            if (position.getRow() > table.getLimit() ||
                    position.getColumn() > table.getLimit() ||
                    position.getRow() < 0 ||
                    position.getColumn() < 0) {
                System.out.println("Invalid position");
                setHoleInSpecificPosition(table, movement);
            } else {
                table.switchPositions(table.getHole().getPosition(), position);
                table.resetHole(table.getMatriz());
                System.out.println("Do you want to also set movements from this position? (y/n)");
                String answer3 = sc.next();
                if (answer3.equals("y")) {
                    System.out.println("Enter a number of random movements");
                    int numberOfMovements = sc.nextInt();
                    movement.setRandomMovements(numberOfMovements, table);
                }
            }
        } else if (answer2 == 2) {
            shuffleOrGetMovements(table, movement);
        } else {
            System.out.println("Invalid answer");
            setHoleInSpecificPosition(table, movement);
        }
    }

    public void shuffleOrGetMovements(Table table, Movement movement) {
        System.out.println("Do you want to:\n" +
                "1. Shuffle the table\n" +
                "2. Set a number of random moves");
        String answer = sc.next();
        if (answer.equals("1")) {
            table.shuffle(table.getMatriz());
            System.out.println("Shuffled table:");
        } else if (answer.equals("2")) {
            System.out.print("Enter number of movements: ");
            int movements = sc.nextInt();
            movement.setRandomMovements(movements, table);
        } else {
            System.out.println("Invalid answer");
            shuffleOrGetMovements(table, movement);
        }
    }
}
