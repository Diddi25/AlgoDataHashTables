import java.util.Random;
public class Benchmark3 {
    private final static Integer testZip1 = 11115;
    private final static Integer testZip2 = 98499;
    private static final int tries = 20;
    private static float min = Float.POSITIVE_INFINITY;
    private static float max = -1;
    public static void main(String[] args) {
        System.out.printf("#%5s%10s%17s\n", "n", "original", "slightly better\n");
        benchmark();
    }
    private static void benchmark() {
        int[] modulos = {10075, 15000, 20000, 25000};
        for (int modulo: modulos) {
            Integer[] randomZips = fillArrayWithRandomZips();

            ZipHashTable hashtable1 = new ZipHashTable("postnummer.csv", modulo);
            ZipSlightlyBetter hashtable2 = new ZipSlightlyBetter("postnummer.csv", modulo);

            System.out.printf("%3d", modulo);
            restoreMinAndMax();
            float min1 = benchmarkHashTable(hashtable1, randomZips);
            System.out.printf("%10.0f", min1);

            restoreMinAndMax();
            float min2 = benchmarkHashTable(hashtable2, randomZips);
            System.out.printf("%10.0f\n", min2);
        }
    }
    private static float benchmarkHashTable(HashTables hashTable, Integer[] lookupZips) {
        float takeTime = 0;
        for (int i = 0; i < tries; i++) {
            for (Integer lookupZip: lookupZips) {
                long t0 = System.nanoTime();
                hashTable.lookup(lookupZip);
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
