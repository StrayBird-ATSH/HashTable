public class HashTable {
    private Student[] students = new Student[100];

    Student hashSearch(String key) {
        int probe = 0;
        int index = hashFunction(key, probe);
        for (; students[index] != null && !students[index].getName().equals(key);
             index = hashFunction(key, probe))
            probe++;
        return students[index];
    }

    Student hashInsert(String key, Student studentObject) {
        // Make sure the studentObject is not null
        if (studentObject == null) {
            throw new NullPointerException();
        }

        // Makes sure the key is not already in the hashtable.
        int probe = 0;
        int index = hashFunction(key, probe);
        for (; students[index] != null; index = hashFunction(key, probe)) {
            Student oldStudent = students[index];
            if (oldStudent.getName().equals(key)) {
                students[index] = studentObject;
                return oldStudent;
            }
            probe++;
        }

        probe = 0;
        index = hashFunction(key, probe);
        for (; ; probe++, index = hashFunction(key, probe)) {
            if (students[index] != null) continue;
            students[index] = studentObject;
            break;
        }
        return null;
    }

    void hashDelete() {
    }

    private int hashFunction(String key, int probe) {
        key = key.concat(Integer.toString(probe));
        int hash = key.hashCode();
        return (hash & 0x7FFFFFFF) % 100;
    }
}