public class ThreadSum extends Thread {
    private int[] array;
    private int start;
    private int end;
    private int threadID;
    private int partialSum = 0;

    public ThreadSum(int[] array, int start, int end, int threadID) {
        this.array = array;
        this.start = start;
        this.end = end;
        this.threadID = threadID;
    }

    @Override
    public void run() {
        System.out.print("Thread " + threadID + " - Elementos para somar: ");
        for (int i = start; i < end; i++) {
            partialSum += array[i];
            System.out.print(array[i] + " ");
        }
        System.out.println("\nThread " + threadID + " - Soma parcial: " + partialSum);
    }

    public int getPartialSum() {
        return partialSum;
    }
}
