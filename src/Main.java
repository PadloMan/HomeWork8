import java.util.Arrays;
import java.util.Random;
import java.util.Scanner;
public class Main {
    public static void main(String[] args) {
        int[] arr = new int[15];
        Random random = new Random();
        for (int i = 0; i < arr.length; i++) {
            arr[i] = random.nextInt(100) + 1;
        }
        System.out.println("Початковий вигляд масиву:");
        System.out.println(Arrays.toString(arr));
        insertionSort(arr);
        System.out.println("\nВідсортований масив:");
        System.out.println(Arrays.toString(arr));
        Scanner scanner = new Scanner(System.in);
        System.out.print("\nВведіть число для пошуку: ");
        int key = scanner.nextInt();
        int index = binarySearch(arr, key);
        if (index != -1) {
            System.out.println("Число " + key + " знаходиться у відсортованому масиві на позиції " + index);
        } else {
            System.out.println("Число " + key + " не знайдено у відсортованому масиві");
        }
    }
    public static void insertionSort(int[] array) {
        for (int i = 1; i < array.length; i++) {
            int current = array[i];
            int j = i - 1;
            while (j >= 0 && array[j] > current) {
                array[j + 1] = array[j];
                j--;
            }
            array[j + 1] = current;
        }
    }
    public static int binarySearch(int[] array, int key) {
        int left = 0;
        int right = array.length - 1;
        while (left <= right) {
            int mid = left + (right - left) / 2;
            if (array[mid] == key) {
                return mid;
            } else if (array[mid] < key) {
                left = mid + 1;
            } else {
                right = mid - 1;
            }
        }
        return -1;
    }
}