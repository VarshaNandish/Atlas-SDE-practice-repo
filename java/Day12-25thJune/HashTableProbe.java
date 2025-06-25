public class HashTableProbe<Key, Value> {

    // Inner class for hash table node
    private class HashTableNode {
        private Key key;
        private Value value;
        private boolean active;
        private boolean tombstoned;

        public HashTableNode() {
            key = null;
            value = null;
            active = false;
            tombstoned = false;
        }

        public HashTableNode(Key initKey, Value initData) {
            key = initKey;
            value = initData;
            active = true;
            tombstoned = false;
        }
    }

    private final static int TABLE_SIZE = 9;
    private Object[] table;

    // Constructor to initialize the table with empty nodes
    public HashTableProbe() {
        table = new Object[TABLE_SIZE];
        for (int j = 0; j < TABLE_SIZE; j++) {
            table[j] = new HashTableNode();
        }
    }

    // Put method to insert or update key-value pairs
    @SuppressWarnings("unchecked")
    public Value put(Key key, Value value) {
        int hash = Math.abs(key.hashCode() % TABLE_SIZE);
        int originalHash = hash;
        int tombstoneIndex = -1;

        while (true) {
            HashTableNode node = (HashTableNode) table[hash];

            if (!node.active) {
                if (tombstoneIndex != -1) {
                    hash = tombstoneIndex;
                }
                table[hash] = new HashTableNode(key, value);
                return null;
            }

            if (node.active && node.key.equals(key)) {
                Value oldValue = node.value;
                node.value = value;
                return oldValue;
            }

            if (node.tombstoned && tombstoneIndex == -1) {
                tombstoneIndex = hash;
            }

            hash = (hash + 1) % TABLE_SIZE;

            if (hash == originalHash) {
                throw new RuntimeException("Hash table is full");
            }
        }
    }

    // Method to print all active key-value pairs in the table
    @SuppressWarnings("unchecked")
    public void printTable() {
        System.out.println("\nHash Table Contents:");
        for (int i = 0; i < TABLE_SIZE; i++) {
            HashTableNode node = (HashTableNode) table[i];
            if (node != null && node.active) {
                System.out.println("Index " + i + ": " + node.key + " → " + node.value);
            }
        }
    }

    // Main method to demonstrate usage
    public static void main(String[] args) {
        // ✅ String as both key and value
        HashTableProbe<String, String> ht = new HashTableProbe<>();

        ht.put("101", "Anitha");
        ht.put("102", "Kavitha");
        ht.put("103", "Meera");
        ht.put("101", "Anu"); // Update value for existing key "101"

        System.out.println("Hash table entries added successfully.");

        // Display the contents of the hash table
        ht.printTable();
    }
}

