import org.jetbrains.annotations.Contract;

public class HashTable {
    private Student[] students = new Student[100];

    Student hashSearch(String key) {
        int probe = 0;
        int index = hashFunction(key, probe);
        for (; students[index] != null && (students[index].isDeleted() || !students[index].getName().equals(key));
             index = hashFunction(key, probe))
            probe++;
        return students[index];
    }

    Student hashInsert(String key, Student studentObject) {
        // Make sure the studentObject is not null
        if (studentObject == null)
            throw new NullPointerException();

        // Makes sure the key is not already in the hashtable.
        int probe = 0;
        int index = hashFunction(key, probe);
        for (; students[index] != null && !students[index].isDeleted();
             index = hashFunction(key, probe)) {
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
            if (students[index] != null && !students[index].isDeleted()) continue;
            students[index] = studentObject;
            break;
        }
        return null;
    }

    boolean hashDelete(String key) {
        Student student = hashSearch(key);
        if (student == null) return false;
        student.setDeleted();
        return true;
    }

    private int hashFunction(String key, int probe) {
        key = key.concat(Integer.toString(probe));
        int hash = getHashCode(key);
        return (hash & 0x7FFFFFFF) % 100;
    }

    @Contract(pure = true)
    private static int getHashCode(String string) {
        byte[] value = string.getBytes();
        int h = 0;
        int length = value.length >> 1;
        for (int i = 0; i < length; i++)
            h = 31 * h + (char) value[i];
        return h;
    }
}