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

    public Finder() {}

    public void buildTable(BufferedReader br, int keyCol, int valCol) throws IOException {
        // TODO: Complete the buildTable() function!
        br.close();
    }

    public String query(String key){
        // TODO: Complete the query() function!
        return INVALID;
    }
}


/*

// Node class for each key and value
    private static class Node {
        // Key value pair
        private String key;
        private String value;

        // Basic constructor
        Node (String key, String value) {
            this.key = key;
            this.value = value;
        }

        // Getters and Setters
        public String getKey() {
            return key;
        }

        public void setKey(String key) {
            this.key = key;
        }

        public String getValue() {
            return value;
        }

        public void setValue(String value) {
            this.value = value;
        }
    }

// Hashing function
    private int calculateHash(String key) {
        // Variables for set-up
        long hash = 0;
        long power = 1;

        // Rolling hash function implementation
        for (int i = 0; i < key.length(); i++) {
            hash = (hash + (key.charAt(i)) * radix) % modulo;
            power = (power * radix) % modulo;
        }

        // Return the int version
        return (int) hash;
    }
 */