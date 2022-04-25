package scanner;

import interfaces.IGamePlay;

import java.util.*;

public class ScannerClass implements IScanner{
    private Set<String> menuSet = new TreeSet<>();

    public Set<String> getMenuSet() {
        return menuSet;
    }
/*
    public String returnToPrint(List<Integer> posiblesKeysList){
        String zeroPosition = (String) scannerClass.getMenuSet().toArray()[0];
        return zeroPosition;
    }
    *//*
        Map<Integer, Map<Integer, Integer>> posiblePositionsList = posiblePositionsList();

        List<Integer> posiblesKeysList = new ArrayList<>();
        for (Integer integer : posiblePositionsList.keySet()) {
            posiblesKeysList.add(integer);
        }

        Scanner scanner = new Scanner(System.in);

        int number;
        do {
            System.out.println("\n1 = North, 2 = South, 3 = East, 4 = West");
            System.out.println("Please enter a number among the options: " + posiblesKeysList);


    */

    @Override
    public int askUserForBoardSize(ScannerClass scannerClass) {
        Scanner scanner = new Scanner(System.in);

        int number;
        do {
            String zeroPosition = (String) scannerClass.getMenuSet().toArray()[0];
            System.out.print(zeroPosition);

            while (!scanner.hasNextInt()) {
                String input = scanner.next();
                System.out.printf("\"%s\" is not a valid number.%n", input);
            }
            number = scanner.nextInt();

        } while (number < 0);

        String firstPosition = (String) scannerClass.getMenuSet().toArray()[1];
        System.out.print(firstPosition + number + "\n\n");

        number = number * number;

        return number;
    }

    @Override
    public int askUserForDecision(ScannerClass scannerClass, IGamePlay gamePlay) {
        Map<Integer, Map<Integer, Integer>> possiblePositionsList = gamePlay.possiblePositionsList();

        List<Integer> possiblesKeysList = new ArrayList<>();
        for (Integer integer : possiblePositionsList.keySet()) {
            possiblesKeysList.add(integer);
        }

        Scanner scanner = new Scanner(System.in);

        int number;
        do {
            System.out.println("\n" + scannerClass.getMenuSet().toArray()[0]);
            System.out.println((String) scannerClass.getMenuSet().toArray()[1] + possiblesKeysList);
            while (!scanner.hasNextInt()) {
                String input = scanner.next();
                System.out.printf("\"%s\" is not a valid number.%n", input);
            }
            number = scanner.nextInt();

            if (number == 5){
                System.exit(0);
            }

        } while (!possiblesKeysList.contains(number));

        System.out.print((String) scannerClass.getMenuSet().toArray()[2] + number + "\n\n");

        return number;
    }
}