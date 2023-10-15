import java.io.BufferedReader;
import java.io.FileReader;

public class Zip3 {
    private Node[] data;
    private final int largerSize = 100000;
    public Zip3 (String file) { //fyller data med csv filen
        data = new Node[largerSize];
        try (BufferedReader reader = new BufferedReader(new FileReader(file))) {
            String line;
            while ((line = reader.readLine()) != null) {
                String[] row = line.split(",");
                Integer code = Integer.valueOf(row[0].replaceAll("\\s",""));
                data[code++] = new Node(code, row[1], Integer.valueOf(row[2]));
            }
        } catch (Exception e) {
            System.out.println(" file " + file + " not found");
        }
    }
    public boolean lookup(Integer zip) {
        return data[zip] == null;
    }
}
