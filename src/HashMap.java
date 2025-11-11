public class HashMap {
    // Instance Variables

    // Decently sized prime number for optimal spread
    private static final int DEFAULT_TABLE_SIZE = 101;
    private static final int RADIX = 31;
    private int tablesize;

    // Variable to keep track of the current number of key-value pairs
    private int numberOfPairs;

    // Lists for both keys and values
    private String[] keys;
    private String[] values;

    // Constructor
    public HashMap () {
        tablesize = DEFAULT_TABLE_SIZE;
        numberOfPairs = 0;

        keys = new String[tablesize];
        values = new String[tablesize];
    }

    public int hash (String key) {
        // Variable to keep track
        long hash = 0;

        for (int i = 0; i < key.length(); i++) {
            // Polynomial hash function:
            hash = (hash * RADIX + key.charAt(i)) % tablesize;
        }

        return (int) hash;
    }

    public void add (String key, String value) {
        // Base case
        if (numberOfPairs  >= tablesize * 0.5) {
            resize();
        }

        int keyHash = hash(key);
        int index = keyHash;

        while (keys[index] != null) {
            // Module by table size for wrapping around
            index = (index + 1) % tablesize;
        }

        keys[index] = key;
        values[index] = value;
        numberOfPairs++;
    }

    public String get (String key) {
        // Save variables
        int keyHash = hash(key);
        int index = keyHash;

        // Make sure the index isn't null
        while (keys[index] != null && !keys[index].equals(key)) {
            index = (index + 1) % tablesize;
        }

        return values[index];
    }

    private void resize () {
        // Formula to maximize module spread
        tablesize = (tablesize * 2) - 1;

        // Keep track of old pairs
        String[] oldKeys = keys;
        String[] oldValues = values;

        // Update the new lists
        keys = new String[tablesize];
        values = new String[tablesize];

        // Reset pairs
        numberOfPairs = 0;

        // Rehash values
        for (int i = 0; i < oldKeys.length; i++) {
            if (oldKeys[i] != null) {
                int currentHash = hash(oldKeys[i]);

                // Use add function to assist
                add(oldKeys[i], oldValues[i]);
            }
        }
    }
}
