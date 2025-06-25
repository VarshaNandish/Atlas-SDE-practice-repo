public class HashLinearProbe<Key, Value> {

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

    public HashLinearProbe() {
        table = new Object[TABLE_SIZE];
        for (int j = 0; j < TABLE_SIZE; j++) {
            table[j] = new HashTableNode();
        }
    }

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

    public static void main(String[] args) {
        HashLinearProbe<String, Integer> ht = new HashLinearProbe<>();

        ht.put("Anitha", 25);
        ht.put("Kavitha", 30);
        ht.put("Meera", 35);
        ht.put("Anitha", 28); // Update existing key

        System.out.println("Hash table entries added successfully.");

        ht.printTable();
    }
}
