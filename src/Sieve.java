public class Sieve {
    public static int findNearestPrime(int number) {
        int smallerPrime = number;
        int greaterPrime = number;

        while (true) {
            smallerPrime--;
            greaterPrime++;
            if (isPrime(smallerPrime)) {
                return smallerPrime;
            }
            if (isPrime(greaterPrime)) {
                return greaterPrime;
            }
        }
    }
    private static boolean isPrime(int n) {
        if (n <= 1) {
            return false;
        }
        for (int i = 2; i * i <= n; i++) {
            if (n % i == 0) {
                return false;
            }
        }
        return true;
    }
}
