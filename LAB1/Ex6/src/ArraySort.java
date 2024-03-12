import java.util.Scanner;

public class ArraySort {
    public static void main(String[] args){
        // 6_5
        Scanner scanner = new Scanner(System.in);
        int n;
        int[] arr;
        int sum = 0;
        // Input the number of elements
        do{
            System.out.print("Enter the number of elements in the array(>0): ");
            n = scanner.nextInt();
        } while (n <= 0);
        arr = new int[n];
        for(int i = 0; i < n; i++){
            while(true){
                try {
                    // Input array
                    System.out.print("a[" + (i + 1) + "]= ");
                    arr[i] = scanner.nextInt();
                    break;
                } catch (Exception e){
                    // Print error
                    System.out.println("Invalid input. Please enter a valid integer.");
                    // Kill buffer
                    scanner.nextLine();
                }
            }

            sum += arr[i];

        }
        System.out.println("Sum of all elements in the array: "+ sum);
        System.out.println("Average value of the array: "+ (double)(sum / arr.length));
        mergeSort(arr);
        System.out.println("The array after sorted: ");
        for(int i = 0; i < n; i++){
            System.out.println("a[" + (i + 1) + "]= " + arr[i]);
        }
    }
    public static void mergeSort(int[] array){
        int length = array.length;
        if (length <= 1) return;
        int middle = length / 2;
        int[] leftArray = new int[middle];
        int[] rightArray = new int[length - middle];
        int i = 0;
        int j = 0;
        for (; i < length; i++){
            if (i < middle){
                leftArray[i] = array[i];
            } else {
                rightArray[j] = array[i];
                j++;
            }
        }
        mergeSort(leftArray);
        mergeSort(rightArray);
        merge(leftArray, rightArray, array);
    }
    public static void merge(int[] leftArray, int[] rightArray, int[] Array){
        int leftSize = Array.length / 2;
        int rightSize = Array.length - leftSize;

        int i = 0, l = 0, r = 0;

        while(l < leftSize && r < rightSize){
            if (leftArray[l] < rightArray[r]){
                Array[i] = leftArray[l];
                i++;
                l++;
            } else {
                Array[i] = rightArray[r];
                i++;
                r++;
            }
        }
        while(l < leftSize){
            Array[i] = leftArray[l];
            i++;
            l++;
        }
        while(r < rightSize){
            Array[i] = rightArray[r];
            i++;
            r++;
        }
    }

}
