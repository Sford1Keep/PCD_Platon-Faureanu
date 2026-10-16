public class Faureanu implements Runnable {
    private final int[] array;
    private final int threadNumber;
    private final String[] results;

    public Faureanu(int[] array, int threadNumber, String[] results) {
        this.array = array;
        this.threadNumber = threadNumber;
        this.results = results;
    }

    public static String[] createResults(int[] array) {
        int evenPositionCount = (array.length + 1) / 2;
        return new String[evenPositionCount / 4];
    }

    @Override
    public void run() {
        int lastEvenIndex = array.length - 1;
        if (lastEvenIndex % 2 != 0) {
            lastEvenIndex--;
        }

        int differenceCount = results.length;

        for (int difference = threadNumber; difference < differenceCount; difference += 2) {
            int index = lastEvenIndex - difference * 8;
            int firstProduct = array[index] * array[index - 2];
            int secondProduct = array[index - 4] * array[index - 6];
            int result = firstProduct - secondProduct;

            results[difference] = "(" + array[index] + "*" + array[index - 2] + ")-("
                    + array[index - 4] + "*" + array[index - 6] + ") = " + result + "\n";
        }

    }
}
