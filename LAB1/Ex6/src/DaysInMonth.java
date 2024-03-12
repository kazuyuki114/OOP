import java.util.Scanner;

public class DaysInMonth {
    public static void main(String[] args){
        // 6_4
        Scanner scanner = new Scanner(System.in);
        // Define the available months
        String[] months = {"January","Jan.","Jan","1",
                "February","Feb.","Feb","2",
                "March","Mar.","Mar","3",
                "April","Apr.","Apr","4",
                "May","5",
                "June","Jun","6",
                "July", "Jul","7",
                "August","Aug.","Aug","8",
                "September","Sept.","Sep","9",
                "October","Oct.","Oct","10",
                "November","Nov.","Nov","11",
                "December","Dec.","Dec","12"};
        int year;
        String month = "";
        int check = 0;
        while(check == 0){
            System.out.print("Enter the month(Full name(Ex: January)/Abbreviation(Ex: Jan.)/3-letter(Ex: Jan)/Number(Ex: 1)): ");
            month = scanner.nextLine();
            for(String i: months) {
                if (month.equals(i)) {
                    check = 1;
                    break;
                }
            }
        }

        do{
            System.out.print("Enter the year(non-negative integer): ");
            year = scanner.nextInt();
        } while (year < 0);
        switch (month){
            case    "January","Jan.","Jan","1",
                    "March","Mar.","Mar","3",
                    "May","5",
                    "July", "Jul","7",
                    "August","Aug.","Aug","8",
                    "October","Oct.","Oct","10",
                    "December","Dec.","Dec","12":
                System.out.println("This month has 31 days");
                break;
            case "February","Feb.","Feb","2":
                if ((year % 4 == 0 && year % 100 != 0) || (year % 400 == 0)){
                    System.out.println("This month has 29 days");
                } else {
                    System.out.println("This month has 28 days");
                }
                break;
            case    "April","Apr.","Apr","4",
                    "June","Jun","6",
                    "September","Sept.","Sep","9",
                    "November","Nov.","Nov","11":
                System.out.println("This month has 30 days");
                break;
        }
    }
}
