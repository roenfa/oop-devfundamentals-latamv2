package ThirdApproach;

import java.util.Scanner;

public class Prompt {
    public static void print(String message){
        System.out.print(message);
    }
    public static void println(String message){
        System.out.println(message);
    }
    public static char getKey() {
        Scanner scanner = new Scanner(System.in);
        char key;
        String tmp;
        print("> ");
        do {
            tmp = scanner.nextLine().toUpperCase();
            if(tmp.length() != 1) {
                key = 'X';
            } else { key = tmp.charAt(0); }
        } while (key!='W' && key!='A' && key!='S' && key!='D');
        println("");
        return key;
    }
}
