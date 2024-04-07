package utils;

import java.util.Scanner;

public class ScannerSingleton {
    private static final Scanner sc = new Scanner(System.in);

    private ScannerSingleton() {}

    public static Scanner getScanner() {
        return sc;
    }

    public static void closeScanner() {
        sc.close();
    }
}
