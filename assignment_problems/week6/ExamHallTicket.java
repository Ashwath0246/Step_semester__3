package week6;
class HallTicket {

    String studentName;
    int seatNumber;

    // Constructor
    HallTicket(String studentName, int seatNumber) {
        this.studentName = studentName;
        this.seatNumber = seatNumber;
    }
}

public class ExamHallTicket {

    public static void main(String[] args) {

        // Create one HallTicket object
        HallTicket priya =
                new HallTicket("Priya", 0);

        // Both variables point to the same object
        HallTicket copy = priya;

        // Change the object through copy
        copy.seatNumber = 45;

        // Create a separate object
        HallTicket separate =
                new HallTicket("Priya", 45);

        // Print results
        System.out.println(
                "Priya's seatNumber (via first variable): "
                        + priya.seatNumber
        );

        System.out.println(
                "copy == priya: " + (copy == priya)
        );

        System.out.println(
                "separate == priya: " + (separate == priya)
        );
    }
}