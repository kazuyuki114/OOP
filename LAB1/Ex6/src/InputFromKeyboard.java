import java.util.Scanner;

public class InputFromKeyboard {
    public static void main(String[] args){
        // 6_2
        Scanner keyboard = new Scanner(System.in);

        System.out.println("What's your name?:");
        String strName = keyboard.nextLine();
        System.out.println("How old are old");
        int iAge = keyboard.nextInt();
        System.out.println("How tall are you (m)");
        double dHeight = keyboard.nextDouble();

        System.out.println("Mrs/Ms " + strName + ", " + iAge + " years old. " + "Your height is " + dHeight +".");
    }
}
