import java.io.BufferedReader;
import java.io.FileReader;

public class ZipHashFunction {
    private Node[] data;
    private final int smallerSize = 10000;
    private final int modulo;
    public int[] collisionFrequency;
    public ZipHashFunction(String file, int modulo) { //fyller data med csv filen
        data = new Node[smallerSize];
        this.modulo = modulo;
        collisionFrequency = new int[modulo];
        try (BufferedReader reader = new BufferedReader(new FileReader(file))) {
            String line;
            while ((line = reader.readLine()) != null) {
                String[] row = line.split(",");
                Integer code = Integer.valueOf(row[0].replaceAll("\\s",""));
                Integer index = hashFunction(code);
                collisionCounter(index);
                data[index] = new Node(code, row[1], Integer.valueOf(row[2]));
            }
        } catch (Exception e) {
            System.out.println(" file " + file + " not found");
        }
    }
    private Integer hashFunction(Integer code) {
        return code % modulo;
    }
    private void collisionCounter(Integer index) {
        if (data[index] != null) {
            collisionFrequency[data[index].integerCode]++; //keyn är på rätt index och inkrementeras för varje kollision
        }
    }
}
