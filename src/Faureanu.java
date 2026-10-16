public class Faureanu implements Runnable {
    private final int[] array;
    private final int threadNumber;

    public Faureanu(int[] array, int threadNumber) {
        this.array = array;
        this.threadNumber = threadNumber;
    }

    @Override
    public void run() {
        String threadName = Thread.currentThread().getName();
        Main.show(threadName + " начал вычисление\n");

        int lastEvenIndex = array.length - 1;
        if (lastEvenIndex % 2 != 0) {
            lastEvenIndex--;
        }

        int evenPositionCount = (array.length + 1) / 2;
        int differenceCount = evenPositionCount / 4;

        for (int difference = threadNumber; difference < differenceCount; difference += 2) {
            int index = lastEvenIndex - difference * 8;
            int firstProduct = array[index] * array[index - 2];
            int secondProduct = array[index - 4] * array[index - 6];
            int result = firstProduct - secondProduct;

            Main.show(threadName + ": (" + array[index] + "*" + array[index - 2] + ")-("
                    + array[index - 4] + "*" + array[index - 6] + ") = " + result + "\n");

            try {
                Thread.sleep(100);
            } catch (InterruptedException e) {
                Thread.currentThread().interrupt();
            }
        }

        Main.show(threadName + " завершил вычисление\n");
    }
}
