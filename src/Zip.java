import java.io.BufferedReader;
import java.io.FileReader;

public class Zip {
    Node[] data;
    int max;
    public Zip (String file) { //fyller data med csv filen
        data = new Node[10000]; //10 000
        try (BufferedReader reader = new BufferedReader(new FileReader(file))) {
            String line;
            int position = 0;
            while ((line = reader.readLine()) != null) {
                String[] row = line.split(",");
                data[position++] = new Node(row[0], row[1], Integer.valueOf(row[2]));
            }
            max = position - 1;
        } catch (Exception e) {
            System.out.println(" file " + file + " not found");
        }
    }
    public boolean lookupLinear(String lookupZip) {
        for (Node zip : data) {
            if (zip.code.equals(lookupZip)) {
                return true;
            }
        }
        return false;
    }
    public boolean lookupBinary(String lookupZip) {
        int min = 0;
        int max = data.length - 1;
        while (min <= max) {
            int middle = (min + max) / 2;
            if (data[middle].code.equals(lookupZip)) {
                return true;
            } else if (data[middle].code.compareTo(lookupZip) > 0) {
                max = middle - 1;
            } else {
                min = middle + 1;
            }
        }
        return false;
    }

}
