public class Faureanu implements Runnable {
    private final int[] array;

    public Faureanu(int[] array) {
        this.array = array;
    }

    @Override
    public void run() {
        long result = calculateDifferenceOfPairProducts();
        Main.show(Thread.currentThread().getName() + " => " + result + "\n");
    }

    private long calculateDifferenceOfPairProducts() {
        if (array == null || array.length == 0) {
            return 0;
        }

        long result = 0;

        for (int i = 0; i + 2 < array.length; i += 2) {
            long currentProduct = (long) array[i] * array[i + 2];
            if (i == 0) {
                result = currentProduct;
            } else {
                result -= currentProduct;
            }
        }

        result += array[array.length - 1];
        return result;
    }
}

