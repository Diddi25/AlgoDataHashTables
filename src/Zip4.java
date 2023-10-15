import java.io.BufferedReader;
import java.io.FileReader;

public class Zip4 {
    private Node[] data;
    public int collisionFrequency;
    private final int smallerSize = 10000;
    private final int modulo = 10000;
    public Zip4 (String file, boolean hashValue) { //fyller data med csv filen
        data = new Node[smallerSize];
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

        //ska spara data[index] = key
        //antalet kollisioner för den specifika keyn för just
    }
}
