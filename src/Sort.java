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
    public static void mergeSort(){}

    public static void quickSort(){}
}
