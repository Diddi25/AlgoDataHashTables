import java.io.BufferedReader;
import java.io.FileReader;

public class Zip2 {
    private Node[] data;
    private int max;
    public Zip2(String file) { //fyller data med csv filen
        data = new Node[10000]; //10 000
        try (BufferedReader reader = new BufferedReader(new FileReader(file))) {
            String line;
            int position = 0;
            while ((line = reader.readLine()) != null) {
                String[] row = line.split(",");
                Integer code = Integer.valueOf(row[0].replaceAll("\\s",""));
                data[position++] = new Node(code, row[1], Integer.valueOf(row[2]));
            }
            max = position - 1;
        } catch (Exception e) {
            System.out.println(" file " + file + " not found");
        }
    }
}
