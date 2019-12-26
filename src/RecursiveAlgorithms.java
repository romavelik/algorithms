public class RecursiveAlgorithms {

    public static int fibonacci(int number) {
        if (number == 0) {
            return 0;
        } else if (number == 1) {
            return 1;
        } else {
            return fibonacci(number - 1) + fibonacci(number - 2);
        }
    }

    public static int factorial(int number) {
        if (number == 1 || number == 0) {
            return 1;
        } else {
            return number * factorial(number);
        }
    }

    public static void towersOfHanoi(int count, char from, char inner, char destination) {
        if (count == 1) {
            System.out.printf("Disk %d moves from %s to %s\n", count, from, destination);
        } else {
            towersOfHanoi(count - 1, from, destination, inner);
            System.out.printf("Disk %d moves from %s to %s\n", count, from, destination);
            towersOfHanoi(count - 1, inner, from, destination);
        }
    }
}