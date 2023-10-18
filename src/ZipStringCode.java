import java.io.BufferedReader;
import java.io.FileReader;

public class ZipStringCode {
    private Node[] data;
    private final int smallerSize = 10000;
    public ZipStringCode(String file) { //fyller data med csv filen
        data = new Node[smallerSize]; //10 000
        try (BufferedReader reader = new BufferedReader(new FileReader(file))) {
            String line;
            int position = 0;
            while ((line = reader.readLine()) != null) {
                String[] row = line.split(",");
                data[position++] = new Node(row[0], row[1], Integer.valueOf(row[2]));
            }
        } catch (Exception e) {
            System.out.println(" file " + file + " not found");
        }
    }
    public boolean linearLookup(String lookupZip) {
        for (Node zip : data) {
            if (zip.stringCode.equals(lookupZip)) {
                return true;
            }
        }
        return false;
    }
    public boolean binaryLookup(String lookupZip) {
        int min = 0;
        int max = data.length - 1;
        while (min <= max) {
            int middle = (min + max) / 2;
            if (data[middle].stringCode.equals(lookupZip)) {
                return true;
            } else if (data[middle].stringCode.compareTo(lookupZip) > 0) {
                max = middle - 1;
            } else {
                min = middle + 1;
            }
        }
        return false;
    }

}
