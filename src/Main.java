public class Main {
    public static void main(String[] args) {
        int number = 20000;

        int prime = Sieve.findNearestPrime(number);

        System.out.println(prime);
    }
}