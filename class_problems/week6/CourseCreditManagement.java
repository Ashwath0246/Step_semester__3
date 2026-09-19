package week6;
class Course {

    String code;
    String title;
    int credits;
    int labCredits;

    // Four-argument constructor
    public Course(String code, String title, int credits, int labCredits) {

        this.code = code;
        this.title = title;
        this.credits = credits;
        this.labCredits = labCredits;
    }

    // Three-argument constructor
    // Calls the four-argument constructor
    public Course(String code, String title, int credits) {

        this(code, title, credits, 0);
    }

    // Method to calculate total credits
    public int totalCredits() {

        return credits + labCredits;
    }
}

public class CourseCreditManagement {

    public static void main(String[] args) {

        // Theory-only course
        Course theoryCourse = new Course(
                "21CSC201J",
                "Data Structures",
                4
        );

        // Course with lab
        Course labCourse = new Course(
                "21CSC205L",
                "DSA Lab",
                3,
                1
        );

        System.out.println(
                theoryCourse.code + " total credits: "
                        + theoryCourse.totalCredits()
        );

        System.out.println(
                labCourse.code + " total credits: "
                        + labCourse.totalCredits()
        );
    }
}