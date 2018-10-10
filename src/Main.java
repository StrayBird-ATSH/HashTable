import org.jetbrains.annotations.NotNull;

import java.util.Scanner;

public class Main {
    /**
     * The main function imports data from the file which is in
     * the UTF-8 format, and then calls the {@code testData} function
     * to perform the testing task specified in the requirements.
     * <p>
     * This method also handles the potential exception thrown from
     * reading file function and then prints the corresponding error
     * information.
     */
    public static void main(String[] args) {
        HashTable hashTable = new HashTable();
        try {
            importData(hashTable);
        } catch (Exception e) {
            System.out.println("An error occurred while importing data from file.");
            e.printStackTrace();
        }
        testData(hashTable);
    }

    /**
     * This function imports data from the file located at the specified String
     * Then an Student object is created in the function according to the data
     * types. After that, it calls the function in the HashTable class to
     * insert such object into the table.
     *
     * @param hashTable The hashTable object that this function is operating on
     * @throws Exception if there is problem reading file or accomplishing other
     *                   tasks.
     */
    private static void importData(HashTable hashTable) throws Exception {
        java.io.File file = new java.io.File(
                "D:\\Documents\\Data Structures and Algorithms\\Lab\\Lab4\\Book1.csv");
        Scanner input = new Scanner(file);
        input.nextLine();
        while (input.hasNextLine()) {
            String[] strings = input.nextLine().trim().split("\\s+");
            for (int i = 0; i < strings.length; i++)
                strings[i] = strings[i].trim();
            Student student = new Student(Long.parseLong(strings[0].trim()), strings[1],
                    strings[2], strings[3], Integer.parseInt(strings[4].trim()), Long.parseLong(strings[5].trim()));
            hashTable.hashInsert(student.getName(), student);
        }
        input.close();
    }

    /**
     * This function tests the search method with all the samples given.
     * It prints the time consumed to perform all the searches.
     *
     * @param hashTable The hashTable object that this function is operating on
     */
    private static void testData(@NotNull HashTable hashTable) {
        long time = System.currentTimeMillis();
        System.out.println(hashTable.hashSearch("苏沃").getStudentID());
        System.out.println(hashTable.hashSearch("叶青").getStudentID());
        System.out.println(hashTable.hashSearch("王宸").getStudentID());
        System.out.println(hashTable.hashSearch("唐昕悦").getStudentID());
        System.out.println(hashTable.hashSearch("黄元敏").getStudentID());
        System.out.println(hashTable.hashSearch("刘铭涵").getStudentID());
        System.out.println(hashTable.hashSearch("刘海强").getStudentID());
        System.out.println(hashTable.hashSearch("李璠").getStudentID());
        System.out.println(hashTable.hashSearch("陆逸凡").getStudentID());
        System.out.println(hashTable.hashSearch("吴新铭").getStudentID());
        System.out.println(hashTable.hashSearch("金毅铭").getStudentID());
        System.out.println(hashTable.hashSearch("黎沈少杰").getStudentID());
        System.out.println(hashTable.hashSearch("周钰承").getStudentID());
        System.out.println(hashTable.hashSearch("林晨").getStudentID());
        System.out.println(hashTable.hashSearch("林国鹏").getStudentID());
        System.out.println(hashTable.hashSearch("俞继涛").getStudentID());
        System.out.println(hashTable.hashSearch("李翀").getStudentID());
        System.out.println(hashTable.hashSearch("邓朋").getStudentID());
        System.out.println(hashTable.hashSearch("李玎善").getStudentID());
        System.out.println(hashTable.hashSearch("卢永强").getStudentID());
        System.out.println(hashTable.hashSearch("王永立").getStudentID());
        System.out.println(hashTable.hashSearch("翟登展").getStudentID());
        System.out.println(hashTable.hashSearch("杜东方").getStudentID());
        System.out.println(hashTable.hashSearch("姜向阳").getStudentID());
        System.out.println(hashTable.hashSearch("石林").getStudentID());
        System.out.println(hashTable.hashSearch("王尚").getStudentID());
        System.out.println(hashTable.hashSearch("夏禹天").getStudentID());
        System.out.println(hashTable.hashSearch("梁伟业").getStudentID());
        System.out.println(hashTable.hashSearch("李江渝").getStudentID());
        System.out.println(hashTable.hashSearch("刘佳兴").getStudentID());
        System.out.println(hashTable.hashSearch("杨辉").getStudentID());
        System.out.println(hashTable.hashSearch("张思源").getStudentID());
        System.out.println(hashTable.hashSearch("王麒迪").getStudentID());
        System.out.println(hashTable.hashSearch("胡彦雯").getStudentID());
        System.out.println(hashTable.hashSearch("黄佳妮").getStudentID());
        System.out.println(hashTable.hashSearch("石睿欣").getStudentID());
        System.out.println(hashTable.hashSearch("吴琛宁").getStudentID());
        System.out.println(hashTable.hashSearch("吴楚盈").getStudentID());
        System.out.println(hashTable.hashSearch("张岑湲").getStudentID());
        System.out.println(hashTable.hashSearch("周君怡").getStudentID());
        System.out.println(hashTable.hashSearch("刘佳楠").getStudentID());
        System.out.println(hashTable.hashSearch("张逸涵").getStudentID());
        System.out.println(hashTable.hashSearch("胡宵宵").getStudentID());
        System.out.println(hashTable.hashSearch("刘书宁").getStudentID());
        System.out.println(hashTable.hashSearch("宋怡景").getStudentID());
        System.out.println(hashTable.hashSearch("黄蕙茹").getStudentID());
        System.out.println(hashTable.hashSearch("罗蓉").getStudentID());
        System.out.println(hashTable.hashSearch("贺曦").getStudentID());
        System.out.println((System.currentTimeMillis() - time) + " milliseconds");
        System.out.println("Average time is " + (System.currentTimeMillis() - time) + " milliseconds");
    }
}
