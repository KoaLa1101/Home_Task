package StudentSerialize;

import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.util.ArrayList;

public class Main {
    public static void main(String[] args) {
        ArrayList<Student> arr = new ArrayList<>();
        arr.add(new Student("Rinat A.", "11-902", 'M', 2001, 11, 22));
        arr.add(new Student("Sanya M.", "11-906", 'F', 2001, 1, 3));
        arr.add(new Student("Google ", "11-901", 'M', 1998, 9, 4));
        Student.serialize(arr, "test.txt");
        ArrayList<Student> arr1 = (ArrayList<Student>) Student.deserialize("test.txt");
        for (Student student : arr1)
            System.out.println(student);

        try (StudentDataOutputStream out = new StudentDataOutputStream(new FileOutputStream("test.txt"));
             StudentDataInputStream in = new StudentDataInputStream(new FileInputStream("test.txt"))) {
            Student s1 = new Student("qwe", "r", 't', 1,2,3);
            out.writeStudent(s1);
            Student s2 = in.readStudent();
            System.out.println("Name: " + s2.getName() + "\n"
                    + "Group: " + s2.getGroup() + "\n"
                    + "gender: " + s2.getGender() + "\n"
                    + "Birthday: " + s2.getBirthDay() + "." + s2.getBirthMonth() + "." + s2.getBirthYear() + "\n");
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}
