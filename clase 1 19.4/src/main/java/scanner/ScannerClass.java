package scanner;

import interfaces.IGamePlay;

import java.util.*;

public class ScannerClass implements IScanner{
    private Set<String> menuSet = new TreeSet<>();

    public Set<String> getMenuSet() {
        return menuSet;
    }

    @Override
    public int askUserForWayOfPlaying(ScannerClass scannerClass) {
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

        } while (number < 1 || number > 2);

        String firstPosition = (String) scannerClass.getMenuSet().toArray()[1];
        System.out.print(firstPosition + number + "\n\n");

         return number;
    }

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
                return 5;
            }

            if (number == 6){
                System.exit(0);
            }

        } while (!possiblesKeysList.contains(number));

        System.out.print((String) scannerClass.getMenuSet().toArray()[2] + number + "\n\n");

        return number;
    }
}