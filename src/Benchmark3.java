import java.util.Random;

public class Benchmark3 {
    private final static Integer testZip1 = 11115;
    private final static Integer testZip2 = 98499;
    private static final int tries = 20;
    private static float min = Float.POSITIVE_INFINITY;
    private static float max = -1;
    public static void main(String[] args) {
        System.out.printf("#%5s%15s%14s%15s%15s\n", "type", "string zip 1", "string zip 2", "integer zip 1", "integer zip 2\n");
        benchmark();
    }
    private static void benchmark() {
        Integer[] randomZips = fillArrayWithRandomZips();
        ZipHashTable hashtable1 = new ZipHashTable();

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
}
