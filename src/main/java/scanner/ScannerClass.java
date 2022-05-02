package scanner;

import java.util.Scanner;
import java.util.Set;
import java.util.TreeSet;

public class ScannerClass implements IScanner{
    private Set<String> menuSet = new TreeSet<>();

    public Set<String> getMenuSet() {
        return menuSet;
    }

    @Override
    public int askUserForNumberOfCups(ScannerClass scannerClass) {
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

        } while (number < 1 || number > 12);

        String firstPosition = (String) scannerClass.getMenuSet().toArray()[1];
        System.out.print(firstPosition + number + "\n\n");

        return number;
    }

    @Override
    public int askUserIfPotIsFull(ScannerClass scannerClass) {
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
}
