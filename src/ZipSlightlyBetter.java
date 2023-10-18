import java.io.BufferedReader;
import java.io.FileReader;
public class ZipSlightlyBetter extends HashTables {
    Bucket[] largerHashTable;
    int largerHashTableSize;
    int modulo;
    public ZipSlightlyBetter(String fileName, int modulo) {
        largerHashTable = new Bucket[modulo];
        this.modulo = modulo;
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
        while (largerHashTable[index] != null) {
            index++;
        }
        largerHashTable[index] = new Bucket(key, data);
    }
    public boolean lookup(Integer zip) {
        Integer lookupIndex = hashFunction(zip);
        Bucket desiredBucket = largerHashTable[lookupIndex];
        while((largerHashTable[lookupIndex] != null) && (lookupIndex < modulo)) {
            if (desiredBucket.key.equals(zip)) {
                return true;
            }
            lookupIndex++;
        }
        return false;
    }
}
