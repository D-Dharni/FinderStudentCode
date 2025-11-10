import java.io.BufferedReader;
import java.io.IOException;
/**
 * Finder
 * A puzzle written by Zach Blick
 * for Adventures in Algorithms
 * At Menlo School in Atherton, CA
 *
 * Completed by: [YOUR NAME HERE]
 **/

public class Finder {

    private static final String INVALID = "INVALID KEY";
    private HashMap hashmap;

    // Constructor
    public Finder() {
        hashmap = new HashMap();
    }

    public void buildTable (BufferedReader br, int keyCol, int valCol) throws IOException {
        // Loop through each line in BufferedReader object
        String currentKey = br.readLine();

        while (currentKey != null) {
            String[] arr = currentKey.split(",");

            hashmap.add(arr[keyCol], arr[valCol]);

            // Read next line
            currentKey = br.readLine();
        }
        br.close();
    }

    public String query (String key) {
        // Use built-in hashmap function
        String value = hashmap.get(key);

        // Return correct value
        if (value == null) {
            return INVALID;
        }
        else {
            return value;
        }
    }
}