import java.util.Scanner;

public class Ex2_2_5 {
    public static void main(String[] args){
        Scanner scanner = new Scanner(System.in);
        double num1,num2;
        while(true){
            System.out.print("Enter the first number: ");
            try {
                num1 = scanner.nextDouble();
                break;
            } catch(Exception e) {
                System.out.println("Invalid input. Please enter a valid double.");
                scanner.nextLine();
            }
        }
        while(true){
            System.out.print("Enter the second number: ");
            try {
                num2 = scanner.nextDouble();
                break;
            } catch(Exception e) {
                System.out.println("Invalid input. Please enter a valid double.");
                scanner.nextLine();
            }
        }
        double sum = num1 + num2;
        double diff = num1 - num2;
        double prod = num1 * num2;
        System.out.println("Sum = " + sum);
        System.out.println("Difference = " + diff);
        System.out.println("Product = " + prod);

        if (num2 == 0){
            System.out.println("Cannot divide a number by zero");
        } else {
            double quotient = num1 / num2;
            System.out.println("Quotient = " + quotient);
        }
    }
}
