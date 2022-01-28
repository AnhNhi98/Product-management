package Asm2;

import java.io.IOException;
import java.util.Scanner;

public class AS2_Main {
    public static void showMenu() {
        System.out.println("Product list:");
        System.out.println("1. Load data from file and display");
        System.out.println("2. Input & add to the end.");
        System.out.println("3. Display data");
        System.out.println("4. Save product list to file.");
        System.out.println("5. Search by ID");
        System.out.println("6. Delete by ID");
        System.out.println("7. Sort by ID.");
        System.out.println("8. Convert to Binary");
        System.out.println("9. Load to stack and display");
        System.out.println("10. Load to queue and display.");
        System.out.println("0. Exit");
    }
    public static void main(String[] args) throws IOException {
        Scanner sc = new Scanner(System.in);
        int choice = 0;
        do {
            showMenu();
            System.out.print("Choice your option: ");
            choice = sc.nextInt();

            OperationToProduct.xuLy(choice);
        } while (choice != 0);
        sc.close();
    }
}
