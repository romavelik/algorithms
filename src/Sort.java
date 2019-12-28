import java.util.Arrays;

public class Sort {
    public static void bubbleSort(int[] array){
        int temp;
        for(int i = 0; i<array.length; i++)
        {
            for(int j = 1; j<array.length - 1; j++){
                if(array[j-1]>array[j])
                {
                    temp = array[j];
                    array[j] = array[j-1];
                    array[j-1] = temp;
                }
            }
        }
    }
    public static void mergeSort(int[] array){
        int size = array.length;
        if(size<2){
            return;
        }else{
            int mid = size/2;
            int[] left = Arrays.copyOfRange(array, 0, mid);
            int[] right = Arrays.copyOfRange(array, mid, size);
            mergeSort(left);
            mergeSort(right);
            merge(array, left, right);
        }
    }

    private static void merge(int[] array, int[] left, int[] right) {
        int resultIndex = 0;
        int leftIndex = 0;
        int rightIndex = 0;
        int leftSize = left.length;
        int rightSize = right.length;
        while (leftIndex < leftSize && rightIndex < rightSize){
            if (left[leftIndex] <= right[rightIndex]) {
                array [resultIndex++] = left [leftIndex++];
            }else{
                array[resultIndex++] = right[rightIndex++];
            }
        }
        while (leftIndex < leftSize){
            array[resultIndex++] = left [leftIndex++];
        }
        while (rightIndex < rightSize){
            array[resultIndex++] = right[rightIndex++];
        }
    }

    public static void quickSort(){}
}
