public class Main {
    public static void main(String[] args) {
        int [] array = {8, 5, 2, 6, 77, 55};
        Sort.mergeSort(array);
        for(int i : array){
            System.out.println(i);
        }
    }
}
