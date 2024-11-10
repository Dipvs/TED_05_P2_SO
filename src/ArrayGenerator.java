import java.util.Random;

public class ArrayGenerator {
    public static int[] generateRandomArray(int size) {
        int[] array = new int[size];
        Random random = new Random();

        for (int i = 0; i < size; i++) {
            array[i] = random.nextInt(100); // números entre 0 e 99
        }

        return array;
    }
}
