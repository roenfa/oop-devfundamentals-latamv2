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


        setHoleInSpecificPosition(table);

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
        String movementString = "";
        table.printTable();
        System.out.println("Hole " + table.getHole().getPosition());
        System.out.println("Possible movements:");
        movement.possibleMovements(table).forEach(System.out::println);
        System.out.println("exit");
        System.out.println("history (h)");
        movementString = sc.nextLine();
        if (movementString.equals("exit")) {
            System.exit(0);
        } else if (movementString.equals("h")) {
            getHistory(movement);
            play(table, movement);
        } else {
            movement.move(table, movementString);
            play(table, movement);
        }
    }

    public void getHistory(Movement movement) {
        System.out.println("Do you want to see the history of movements?\n1. Yes\n2. No");
        int answer = sc.nextInt();
        if (answer == 1) {
            movement.getMovementStorage().printMovements();
        } else if (answer == 2) {
            System.out.println("Ok");
        }   else {
            System.out.println("Invalid answer");
            getHistory(movement);
        }
    }

    public void setHoleInSpecificPosition(Table table){
        System.out.println("Do you want to set hole on any specific position?\nYou'll probably lose track of movements\n1. Yes\n2. No");
        int answer2 = sc.nextInt();
        if (answer2 == 1) {
            Position position = new Position();
            position.enterPosition();
            if (position.getRow() > table.getLimit() || position.getColumn() > table.getLimit() || position.getRow() < 1 || position.getColumn() < 1) {
                System.out.println("Invalid position");
                setHoleInSpecificPosition(table);
            } else {
                table.switchPositions(table.getHole().getPosition(), position);
                table.resetHole(table.getMatriz());
            }
        } else if (answer2 == 2) {
            shuffleOrGetMovements(table);
        } else {
            System.out.println("Invalid answer");
            setHoleInSpecificPosition(table);
        }
    }

    public void shuffleOrGetMovements(Table table){
        System.out.println("Do you want to:\n1. Shuffle the table\n2. Set a number of random moves");
        String answer = sc.next();
        if (answer.equals("1")) {
            table.shuffle(table.getMatriz());
            System.out.println("Shuffled table:");
        } else if (answer.equals("2")) {
            System.out.print("Enter number of movements: ");
            int movements = sc.nextInt();
            table.setRandomMovements(movements);
        } else {
            System.out.println("Invalid answer");
            shuffleOrGetMovements(table);
        }
    }




}
