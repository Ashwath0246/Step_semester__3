package week2;
import java.util.Scanner;

public class BankTransactionReference {

    // Method to remove spaces and uppercase first 3 characters
    static String normalizeReference(String raw) {

        raw = raw.trim();

        // Uppercase only first 3 characters
        String bankCode = raw.substring(0, 3).toUpperCase();

        // Keep remaining characters unchanged
        String remaining = raw.substring(3);

        return bankCode + remaining;
    }

    // Method to validate and format
    static String validateAndFormat(String reference) {

        // Check length
        if (reference.length() != 14) {
            return "Invalid: wrong length";
        }

        // Check first 3 characters are letters
        for (int i = 0; i < 3; i++) {

            if (!Character.isLetter(reference.charAt(i))) {
                return "Invalid: bank code must be 3 letters";
            }
        }

        // Check remaining 11 characters are digits
        for (int i = 3; i < 14; i++) {

            if (!Character.isDigit(reference.charAt(i))) {
                return "Invalid: body must contain only digits";
            }
        }

        // Build formatted output
        StringBuilder result = new StringBuilder();

        result.append("[");
        result.append(reference.substring(0, 3));
        result.append("] DATE: ");

        // ddMMyy → dd/MM/yy
        result.append(reference.substring(3, 5));
        result.append("/");
        result.append(reference.substring(5, 7));
        result.append("/");
        result.append(reference.substring(7, 9));

        result.append(" | SEQ: ");
        result.append(reference.substring(9, 14));

        return result.toString();
    }

    public static void main(String[] args) {

        Scanner sc = new Scanner(System.in);

        System.out.print("Enter transaction reference: ");
        String raw = sc.nextLine();

        String normalized = normalizeReference(raw);

        String result = validateAndFormat(normalized);

        System.out.println(result);

        sc.close();
    }
}