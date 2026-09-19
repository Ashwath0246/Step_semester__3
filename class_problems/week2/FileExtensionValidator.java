package week2;
import java.util.Scanner;

public class FileExtensionValidator {

    static String validateFileExtension(String filename) {

        // Find the position of the last '.'
        int dotPosition = filename.lastIndexOf('.');

        // If there is no '.' or it is the last character
        if (dotPosition == -1 || dotPosition == filename.length() - 1) {
            return "Rejected — invalid file type";
        }

        // Extract extension
        String extension = filename.substring(dotPosition + 1);

        // Compare ignoring case
        if (extension.equalsIgnoreCase("pdf")
                || extension.equalsIgnoreCase("docx")
                || extension.equalsIgnoreCase("zip")) {

            return "Accepted";

        } else {
            return "Rejected — invalid file type";
        }
    }

    public static void main(String[] args) {

        Scanner sc = new Scanner(System.in);

        System.out.print("Enter filename: ");
        String filename = sc.nextLine();

        System.out.println(validateFileExtension(filename));

        sc.close();
    }
}