import java.util.Random;
public class Benchmark2 {
    private final static Integer testZip1 = 11115;
    private final static Integer testZip2 = 98499;
    private static final int tries = 20;
    private static float min = Float.POSITIVE_INFINITY;
    private static float max = -1;
    public static void main(String[] args) {
        System.out.printf("#%40s\n", "super time for memory waste algorithm\n");
        benchmark();
    }
    private static void benchmark() {
        Integer[] randomZipsToLookup = fillArrayWithRandomZips();
        ZipMemoryWaste largeDataArray = new ZipMemoryWaste("postnummer.csv");
        float min = benchmarkLookupInMemoryWaste(randomZipsToLookup, largeDataArray);
        System.out.printf("%10.0f", min);
    }
    private static float benchmarkLookupInMemoryWaste(Integer[] randomZips, ZipMemoryWaste largeDataArray) {
        float takeTime = 0;
        for (int i = 0; i < tries; i++) {
            for (Integer lookupZip: randomZips) {
                long t0 = System.nanoTime();
                largeDataArray.lookup(lookupZip);
                long t1 = System.nanoTime();
                takeTime = averageTime(t1 - t0);
            }
        }
        return takeTime;
    }
    private static Integer[] fillArrayWithRandomZips() {
        Integer[] randomZips = new Integer[40];
        for(int i = 0; i < randomZips.length; i++) {
            randomZips[i] = generateRandomIntegersInRange(testZip1, testZip2);
        }
        return randomZips;
    }
    private static Integer generateRandomIntegersInRange(int min, int max) {
        return new Random().nextInt(max - min + 1) + min;
    }
    private static float averageTime(long t) {
        if (t < min) {
            min = t;
        }
        if (t > max) {
            max = t;
        }
        return min;
    }
    private static void restoreMinAndMax() {
        min = Float.POSITIVE_INFINITY;
        max = -1;
    }
}
