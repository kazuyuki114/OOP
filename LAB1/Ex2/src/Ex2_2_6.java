import java.util.Scanner;

import static java.lang.Math.sqrt;

public class Ex2_2_6 {
    public static void main(String[] args){
        Scanner scanner = new Scanner(System.in);
        int choice = 0;
        while(choice != -1){
            System.out.println("[1] Solve the first-degree equation with one variable");
            System.out.println("[2] Solve the system of first-degree equations with two variables");
            System.out.println("[3] Solve the second-degree equation with one variable");
            System.out.println("[-1] Exit");
            System.out.print("Enter your choice: ");
            choice = scanner.nextInt();
            switch (choice){
                case 1:
                    System.out.println("Solve ax + b = 0");
                    System.out.print("Enter a: ");
                    double a = scanner.nextDouble();
                    System.out.print("Enter b: ");
                    double b = scanner.nextDouble();
                    if (a == 0){
                        if (b == 0){
                            System.out.println("The equation has infinitely solutions");
                        } else {
                            System.out.println("The equation has no solutions");
                        }
                    } else {
                        System.out.println("The solution: x = " + (-b) / a);
                    }
                    break;
                case 2:
                    System.out.println("Solve a11*x1 + a12*x2 = a1/ a21*x1 + a22*x2 = b2");
                    System.out.print("Enter a11: ");
                    double a11 = scanner.nextDouble();
                    System.out.print("Enter a12: ");
                    double a12 = scanner.nextDouble();
                    System.out.print("Enter b1: ");
                    double b1 = scanner.nextDouble();
                    System.out.print("Enter a21: ");
                    double a21 = scanner.nextDouble();
                    System.out.print("Enter a22: ");
                    double a22 = scanner.nextDouble();
                    System.out.print("Enter b2: ");
                    double b2 = scanner.nextDouble();
                    double d = a11 * a22 - a21 * a12;
                    double d1 = b1 * a22 - b2 * a12;
                    double d2 = a11 * b2 - a21 * b1;
                    if (d == 0){
                        if (d1 == 0 && d2 == 0){
                            System.out.println("The system has infinitely solutions");
                        } else {
                            System.out.println("The system has no solution");
                        }
                    } else {
                        System.out.println("The system has one solution");
                        System.out.println("x1 = " + d1 / d);
                        System.out.println("x2 = " + d2 / d);
                    }
                    break;
                case 3:
                    System.out.println("Solve A*x^2 + B*x + C = 0");
                    System.out.print("Enter A: ");
                    double A = scanner.nextDouble();
                    System.out.print("Enter B: ");
                    double B = scanner.nextDouble();
                    System.out.print("Enter C: ");
                    double C = scanner.nextDouble();
                    if (A == 0){
                        if (B == 0){
                            if (C == 0){
                                System.out.println("The equation has infinitely solutions");
                            }
                            else {
                                System.out.println("The equation has no solution");
                            }
                        } else {
                            System.out.println("The equation has one solution x = " + (-C) / B);
                        }
                    } else {
                        double delta = B * B - 4 * A * C;
                        if (delta == 0){
                            System.out.println("The equation has one solution x = " + (-B) / (2 * A));
                        } else if (delta > 0){
                            System.out.println("The equation has two solutions");
                            System.out.println("x1 = " + (-B + sqrt(delta))/(2 * A));
                            System.out.println("x2 = " + (-B - sqrt(delta))/(2 * A));
                        } else {
                            System.out.println("The equation has no real solution");
                        }
                    }
                    break;
                case -1:
                    System.out.println("Quit!!");
                    break;
                default: System.out.println("Invalid choice!");
            }
        }
    }
}
