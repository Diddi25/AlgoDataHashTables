import java.io.BufferedReader;
import java.io.FileReader;

public class ZipHashTable extends HashTables {
    Bucket[] hashTable;
    int modulo;
    public ZipHashTable(String fileName, int modulo) {
        int nearestPrime = Sieve.findNearestPrime(modulo);
        hashTable = new Bucket[nearestPrime];
        this.modulo = nearestPrime;
        try (BufferedReader reader = new BufferedReader(new FileReader(fileName))) {
            String line;
            while ((line = reader.readLine()) != null) {
                String[] row = line.split(",");
                Node data = new Node(row[0], row[1], Integer.valueOf(row[2]));
                Integer key = Integer.valueOf(row[0].replaceAll("\\s","")); //key
                Integer index = hashFunction(key);
                collisionControl(index, key, data);
            }
        } catch (Exception e) {
            System.out.println(" file " + fileName + " not found");
        }
    }
    public Integer hashFunction(Integer key) {
        return key % modulo;
    }
    public void collisionControl(Integer index, Integer key, Node data) {
        if (hashTable[index] == null) {
            hashTable[index] = new Bucket(key, data, null);
        } else {
            while (hashTable[index].nextKey != null) {
                hashTable[index] = hashTable[index].nextKey;
            }
            hashTable[index].nextKey = new Bucket(key, data, null);
        }
    }
    public boolean lookup(Integer zip) {
        Integer lookupIndex = hashFunction(zip);
        Bucket desiredBucket = hashTable[lookupIndex];
        if (desiredBucket == null) {
            return false;
        }
        if (desiredBucket.key.equals(zip)) {
            return true;
        } else {
            while (desiredBucket.nextKey != null) {
                if (desiredBucket.key.equals(zip)) {
                    return true;
                }
                desiredBucket = desiredBucket.nextKey;
            }
        }
        return false;
    }

}
