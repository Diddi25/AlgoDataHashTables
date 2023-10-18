public class Benchmark {
    private final static Integer testZip1 = 11115;
    private final static Integer testZip2 = 98499;
    private static final int tries = 20;
    private static float min = Float.POSITIVE_INFINITY;
    private static float max = -1;
    public static void main(String[] args) {
        System.out.printf("#%13s%14s%15s%15s\n", "string zip 1", "string zip 2", "integer zip 1", "integer zip 2\n");
        benchmark();
    }
    private static void benchmark() {
        Integer[] intTestZips = {testZip1, testZip2};
        String[] stringTestZips = {Integer.toString(testZip1), Integer.toString(testZip2),};

        String stringZip1 = Integer.toString(testZip1);
        String stringZip2 = Integer.toString(testZip2);

        ZipStringCode stringCode = new ZipStringCode("postnummer.csv");
        ZipIntegerCode integerCode = new ZipIntegerCode("postnummer.csv");

        testLinearLookup(stringCode, integerCode, stringZip1, stringZip2);
        testBinaryLookup(stringCode, integerCode, stringZip1, stringZip2);
    }

    private static void testLinearLookup(ZipStringCode stringCode, ZipIntegerCode integerCode, String stringZip1, String stringZip2) {
        System.out.print("Linear");
        restoreMinAndMax();
        float min1 = benchmarkLinearLookupForStrings(stringCode, stringZip1); //testZip1
        System.out.printf("%10.0f", min1);

        restoreMinAndMax();
        float min2 = benchmarkLinearLookupForStrings(stringCode, stringZip2); //testZip2
        System.out.printf("%10.0f", min2);

        restoreMinAndMax();
        float min3 = benchmarkLinearLookupForIntegers(integerCode, testZip1); //testZip1
        System.out.printf("%10.0f", min3);

        restoreMinAndMax();
        float min4 = benchmarkLinearLookupForIntegers(integerCode, testZip1); //testZip2
        System.out.printf("%10.0f\n", min4);
    }
    private static void testBinaryLookup(ZipStringCode stringCode, ZipIntegerCode integerCode, String stringZip1, String stringZip2) {
        System.out.print("Binary");
        restoreMinAndMax();
        float min1 = benchmarkBinaryLookupForStrings(stringCode, stringZip1); //testZip1
        System.out.printf("%10.0f", min1);

        restoreMinAndMax();
        float min2 = benchmarkBinaryLookupForStrings(stringCode, stringZip2); //testZip2
        System.out.printf("%10.0f", min2);

        restoreMinAndMax();
        float min3 = benchmarkBinaryLookupForIntegers(integerCode, testZip1); //testZip1
        System.out.printf("%10.0f", min3);

        restoreMinAndMax();
        float min4 = benchmarkBinaryLookupForIntegers(integerCode, testZip1); //testZip2
        System.out.printf("%10.0f\n", min4);
    }
    private static float benchmarkLinearLookupForStrings(ZipStringCode code, String testZip) {
        float takeTime = 0;
        for (int i = 0; i < tries; i++) {
            long t0 = System.nanoTime();
            code.linearLookup(testZip);
            long t1 = System.nanoTime();
            takeTime = averageTime(t1 - t0);
        }
        return takeTime;
    }
    private static float benchmarkLinearLookupForIntegers(ZipIntegerCode code, Integer testZip) {
        float takeTime = 0;
        for (int i = 0; i < tries; i++) {
            long t0 = System.nanoTime();
            code.linearLookup(testZip);
            long t1 = System.nanoTime();
            takeTime = averageTime(t1 - t0);
        }
        return takeTime;
    }
    private static float benchmarkBinaryLookupForStrings(ZipStringCode code, String testZip) {
        float takeTime = 0;
        for (int i = 0; i < tries; i++) {
            long t0 = System.nanoTime();
            code.binaryLookup(testZip);
            long t1 = System.nanoTime();
            takeTime = averageTime(t1 - t0);
        }
        return takeTime;
    }
    private static float benchmarkBinaryLookupForIntegers(ZipIntegerCode code, Integer testZip) {
        float takeTime = 0;
        for (int i = 0; i < tries; i++) {
            long t0 = System.nanoTime();
            code.binaryLookup(testZip);
            long t1 = System.nanoTime();
            takeTime = averageTime(t1 - t0);
        }
        return takeTime;
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
