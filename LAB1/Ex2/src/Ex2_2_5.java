import java.util.Scanner;

public class Ex2_2_5 {
    public static void main(String[] args){
        Scanner scanner = new Scanner(System.in);
        System.out.print("Enter the first number: ");
        double num1 = scanner.nextDouble();
        System.out.print("Enter the second number: ");
        double num2 = scanner.nextDouble();
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
