import java.util.ArrayList;
import java.util.List;

public class Main {
    private static final int NUM_THREADS = 4; // quantidade de threads
    private static final int ARRAY_SIZE = 20; // tamanho do array (múltiplo de NUM_THREADS)

    public static void main(String[] args) {
        // Gera um array de números aleatórios
        int[] array = ArrayGenerator.generateRandomArray(ARRAY_SIZE);

        // Lista para armazenar threads
        List<ThreadSum> threads = new ArrayList<>();

        // Define o intervalo de elementos que cada thread irá somar
        int rangeSize = ARRAY_SIZE / NUM_THREADS;

        // Inicializa e inicia cada ThreadSum com seu intervalo de elementos
        for (int i = 0; i < NUM_THREADS; i++) {
            int start = i * rangeSize;
            int end = start + rangeSize;
            ThreadSum thread = new ThreadSum(array, start, end, i + 1);
            threads.add(thread);
            thread.start();
        }

        // Aguarda todas as threads terminarem e soma seus resultados
        int totalSum = 0;
        for (ThreadSum thread : threads) {
            try {
                thread.join();
                totalSum += thread.getPartialSum();
            } catch (InterruptedException e) {
                System.err.println("Thread interrompida: " + e.getMessage());
            }
        }

        // Exibe o resultado final da soma
        System.out.println("Soma total dos elementos do array: " + totalSum);
    }
}
