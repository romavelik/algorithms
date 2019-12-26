public class BinarySearch {
    public static int binarySearsh(int[] arr, int key, int start, int end) {
        int middle = start + end / 2;
        if (arr[middle] == key) {
            return middle;
        } else if (key > arr[middle]) {
            return binarySearsh(arr, key, middle - 1, end);
        } else {
            return binarySearsh(arr, key, start, middle + 1);
        }
    }
}
