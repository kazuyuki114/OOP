import java.util.Scanner;

public class AddMatrix {
    public static void main(String[] args){
        // 6_6
        Scanner scanner = new Scanner(System.in);
        int n, m;
        do{
           System.out.print("Enter the number of columns: ");
           n = scanner.nextInt();
           System.out.print("Enter the number of rows: ");
           m = scanner.nextInt();
        } while (n <= 0 || m <= 0);
        int[][] matrix1 = new int[n][m];
        int[][] matrix2 = new int[n][m];
        int[][] sum = new int[n][m];
        System.out.println("Input the first maxtrix:");
        for (int i = 0; i < n; i++){
            for (int j = 0; j < m; j++){
                matrix1[i][j] = scanner.nextInt();
            }
        }
        System.out.println("Input the second maxtrix:");
        for (int i = 0; i < n; i++){
            for (int j = 0; j < m; j++){
                matrix2[i][j] = scanner.nextInt();
            }
        }

        for (int i = 0; i < n; i++){
            for (int j = 0; j < m; j++){
                sum[i][j] = matrix1[i][j] + matrix2[i][j];
            }
        }
        System.out.println("The sum of the two given matrices:");
        for (int i = 0; i < n; i++){
            for (int j = 0; j < m; j++){
                System.out.print(sum[i][j] + " ");
            }
            System.out.println();
        }

    }
}
