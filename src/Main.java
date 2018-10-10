import java.util.Scanner;

public class Main {

    public static void main(String[] args) {
        HashTable hashTable = new HashTable();
        try {
            importData(hashTable);
        } catch (Exception e) {
            System.out.println("An error occurred while importing data from file.");
        }
    }

    private static void importData(HashTable hashTable) throws Exception {
        java.io.File file = new java.io.File(
                "D:\\Documents\\Data Structures and Algorithms\\Lab\\Lab4\\table.txt");
        Scanner input = new Scanner(file);
        while (input.hasNextLine()) {
            String[] strings = input.nextLine().split(",");
            Student student = new Student(Integer.parseInt(strings[0]), strings[1],
                    strings[2], strings[3], Integer.parseInt(strings[4]), Integer.parseInt(strings[5]));
            hashTable.hashInsert(student.getName(), student);
        }
        input.close();
    }
}
