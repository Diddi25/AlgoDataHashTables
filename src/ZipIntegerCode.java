import java.io.BufferedReader;
import java.io.FileReader;

public class ZipIntegerCode {
    private Node[] data;
    private final int smallerSize = 10000;
    public ZipIntegerCode(String file) { //fyller data med csv filen
        data = new Node[smallerSize]; //kan ändras
        try (BufferedReader reader = new BufferedReader(new FileReader(file))) {
            String line;
            int position = 0;
            while ((line = reader.readLine()) != null) {
                String[] row = line.split(",");
                Integer code = Integer.valueOf(row[0].replaceAll("\\s",""));
                data[position++] = new Node(code, row[1], Integer.valueOf(row[2]));
            }
        } catch (Exception e) {
            System.out.println(" file " + file + " not found");
        }
    }
    public boolean linearLookup(Integer lookupZip) {
        for (Node zip : data) {
            if (zip.integerCode.equals(lookupZip)) {
                return true;
            }
        }
        return false;
    }
    public boolean binaryLookup(Integer lookupZip) {
        int min = 0;
        int max = data.length - 1;
        while (min <= max) {
            int middle = (min + max) / 2;
            if (data[middle].integerCode.equals(lookupZip)) {
                return true;
            } else if (data[middle].integerCode > lookupZip) {
                max = middle - 1;
            } else {
                min = middle + 1;
            }
        }
        return false;
    }

}
