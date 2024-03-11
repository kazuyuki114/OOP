import java.util.Scanner;

public class Triangle {
    public static void main(String[] args){
        // 6_3
        Scanner scanner = new Scanner(System.in);
        int n;
         do{
            System.out.print("Enter n (non-negative): ");
            n = scanner.nextInt();
         }while(n <= 0);
        for (int i = 1; i <= n; i++){
            for(int j = 1; j <= n - i; j++){
                System.out.print(" ");
            }
            for(int k = 1; k <= (i * 2) - 1; k++){
                System.out.print("*");
            }
            System.out.print("\n");
        }
    }
}
