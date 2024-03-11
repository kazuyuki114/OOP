import java.util.Scanner;

public class DaysInMonth {
    public static void main(String[] args){
        // 6_4
        Scanner scanner = new Scanner(System.in);
        int month;
        int year;
        do{
            System.out.print("Enter the year(non-negative): ");
            year = scanner.nextInt();
            System.out.print("Enter the month(1 <= month <= 12): ");
            month = scanner.nextInt();
        } while (month > 12 || month < 0 || year < 0);
        switch (month){
            case 1,3,5,7,8,10,12:
                System.out.println("This month has 31 days");
                break;
            case 2:
                if (year % 4 ==0){
                    System.out.println("This month has 29 days");
                } else {
                    System.out.println("This month has 28 days");
                }
                break;
            case 4,6,9,11:
                System.out.println("This month has 30 days");
                break;
        }
    }
}
