import org.jetbrains.annotations.Contract;

/**
 * This class implements a hash table, which maps keys to values. In
 * this implementation, a String, i.e. the name of the student is used
 * as the key and the Object of the student is used as the value of the
 * table.
 * <p>
 * An instance of {@code HashTable} has two parameters that affect its
 * performance: <i>initial capacity</i> and <i>load factor</i>.  The
 * <i>capacity</i> is the number of <i>buckets</i> in the hash table, and the
 * <i>initial capacity</i> is simply the capacity at the time the hash table
 * is created.  As required, this hash table is <i>open</i>: in the case of a "hash
 * collision", a single bucket stores multiple entries, which must be searched
 * sequentially.  The <i>load factor</i> is a measure of how full the hash
 * table is allowed to get before its capacity is automatically increased.
 * The initial capacity and load factor parameters are merely hints to
 * the implementation. In this version of implementation, we clearly know that the
 * elements to be put into the hash table is 48, therefore, in order to make the hash
 * table efficient and meanwhile less space-consuming, I have set the capacity at
 * 101, thus making the load factor 0.47.
 * <p>
 * For the hashing function, this hash table accomplishes this task in the following two
 * functions {@code hashFunction} and {@code getHashCode}. It utilizes the byte representation
 * of the name String to get a outstanding scattering in the slots. Probe is used in the hashing
 * process to make the open slot accessible.
 *
 * @author Wang, Chen
 */
class HashTable {

    /**
     * The hash table data.
     */
    private Student[] students = new Student[101];


    /**
     * Returns the value to which the specified key is mapped,
     * or {@code null} if this map contains no mapping for the key.
     *
     * <p>More formally, if this map contains a mapping from a key
     * {@code key} to a value {@code students[index]} such that
     * {@code (key.equals(students[index].getName()))}, then this
     * method returns {@code students[index]}; otherwise it returns
     * {@code null}. (There can be at most one such mapping.)
     *
     * @param key the key whose associated value is to be returned
     * @return the value to which the specified key is mapped, or
     * {@code null} if this map contains no mapping for the key
     * @throws NullPointerException if the specified key is null
     * @see #hashInsert(String, Student)
     * @see #hashDelete(String)
     * @see #hashFunction(String, int)
     * @see #getHashCode(String)
     */
    Student hashSearch(String key) {
        int probe = 0;
        int index = hashFunction(key, probe);
        for (; students[index] != null && (students[index].isDeleted() || !students[index].getName().equals(key));
             index = hashFunction(key, probe))
            probe++;
        return students[index];
    }

    /**
     * Maps the specified {@code key} to the specified
     * {@code studentObject} in this hash table. Neither
     * the key nor the value can be {@code null}.
     * <p>
     * The value can be retrieved by calling the
     * {@code hashSearch} method with a key that is equal
     * to the original key.
     *
     * @param key           the hashtable key
     * @param studentObject the value
     * @return the previous value of the specified key in
     * this hash table, or {@code null} if it did
     * not have one
     * @throws NullPointerException if the key or value is
     *                              {@code null}
     * @see Object#equals(Object)
     * @see #hashSearch(String)
     */
    Student hashInsert(String key, Student studentObject) {
        // Make sure the studentObject is not null
        if (studentObject == null)
            throw new NullPointerException();

        // Makes sure the key is not already in the hash table.
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

    /**
     * Removes the key (and its corresponding value) from this
     * hashtable. This method does nothing if the key is not in the hashtable.
     *
     * @param key the key that needs to be removed
     * @return whether the specified element is successfully removed from
     * the hash table.
     * @throws NullPointerException if the key is {@code null}
     */
    boolean hashDelete(String key) {
        Student student = hashSearch(key);
        if (student == null) return false;
        student.setDeleted();
        return true;
    }

    private int hashFunction(String key, int probe) {
        key = key.concat(Integer.toString(probe));
        int hash = getHashCode(key);
        return (hash & 0x7FFFFFFF) % 101;
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