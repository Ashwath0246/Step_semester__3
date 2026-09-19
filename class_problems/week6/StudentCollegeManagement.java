package week6;
class Student {

    // Instance fields
    String name;
    double attendance;

    // Static fields - shared by all Student objects
    static String collegeName = "SRM Institute of Science and Technology";
    static int studentCount = 0;

    // Constructor
    Student(String name, double attendance) {
        this.name = name;
        this.attendance = attendance;

        // Increase count whenever a new Student object is created
        studentCount++;
    }

    // Static method
    static void printCollegeInfo() {
        System.out.println(collegeName);
        System.out.println("Students created: " + studentCount);
    }
}

public class StudentCollegeManagement {

    public static void main(String[] args) {

        // Create two Student objects
        Student student1 = new Student("Ravi", 85.5);
        Student student2 = new Student("Anitha", 90.0);

        System.out.println("2 Student objects created");
        System.out.println();

        // Call static method using class name
        Student.printCollegeInfo();
    }
}