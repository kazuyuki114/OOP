package AimsProject.hust.soict.globalict.aims;

import java.util.Scanner;

public class Aims {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int menuChoice = -1;
        while (menuChoice != 0) {
            showMenu();
            menuChoice = scanner.nextInt();
            switch (menuChoice){
                case 1:
                    int storeChoice = -1;
                    while (storeChoice != 0){
                        storeMenu();
                        storeChoice = scanner.nextInt();
                    }
                    break;
                case 2:
                    break;
                case 3:
                    break;
                case 0:
                    System.out.println("EXIT");
                    break;
                default:
                    System.out.println("Invalid choice");
                    break;
            }
        }
    }
    public static void showMenu(){
        System.out .println("AIMS: ");
        System.out .println("--------------------------------");
        System.out .println("1. View store");
        System.out .println("2. Update store");
        System.out .println("3. See current cart");
        System.out .println("0. Exit");
        System.out .println("--------------------------------");
        System.out .print("Please choose a number (0-1-2-3): ");
    }
    public static void storeMenu(){
        System.out .println("Options: ");
        System.out .println("--------------------------------");
        System.out .println("1. See a media’s details");
        System.out .println("2. Add a media to cart");
        System.out .println("3. Play a media");
        System.out .println("4. See current cart");
        System.out .println("0. Back");
        System.out .println("--------------------------------");
        System.out .println("Please choose a number (0-1-2-3-4): ");
    }
    public static void mediaDetailsMenu(){
        System.out .println("Options: ");
        System.out .println("--------------------------------");
        System.out .println("1. Add to cart");
        System.out .println("2. Play");
        System.out .println("0. Back");
        System.out .println("--------------------------------");
        System.out .println("Please choose a number: 0-1-2");
    }
    public static void cartMenu(){
        System.out .println("1. Add to cart");
        System.out .println("2. Play");
        System.out .println("0. Back");
        System.out .println("--------------------------------");
        System.out .println("Please choose a number: 0-1-2");
    }
}

