package application;

public class Menu {
    public static void welcomeMessage() {
        System.out.println("Welcome to the ADA Inventory Management System!");
    }

    public static void invalidOptionMessage() {
        System.out.println("Invalid option. Press ENTER to continue.");
    }

    public static void clearConsole() {
        System.out.print("\033[H\033[2J");
        System.out.flush();
    }

    public static void exitMessage() {
        System.out.println("Thank you for using our system!");
    }

    public static void options() {
        System.out.println("""
                Options:
                1 - Add Product
                2 - Remove Product
                3 - Edit Product
                4 - List Products
                5 - Export Inventory to CSV
                6 - Exit
                """);
    }
}
