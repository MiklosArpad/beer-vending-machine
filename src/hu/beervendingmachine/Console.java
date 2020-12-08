package hu.beervendingmachine;

// Static dolgok: nem STACK, nem HEAP
// STATIC/GLOBAL mem. területre pakolódnak ...

// Static class: Nem lehet példányosítani
// Minden tagjának statikusnak kell legyen:

import java.util.Scanner;

public class Console {
    private static final Scanner scanner = new Scanner(System.in);

    private Console() {
    }

    public static void writeLine(String message) {
        System.out.println(message);
    }

    public static void write(String message) {
        System.out.print(message);
    }

    public static int readInNumber() {
        return scanner.nextInt();
    }

    public static void printHeader() {
        System.out.println("***** Sör automata v1.0 *****");
    }
}
