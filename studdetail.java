import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.util.Scanner;

public class studdetail {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        // Prompt the user to enter the date of birth
        System.out.println("Enter the date of birth (DD-MM-YYYY or YYYY-MM-DD):");
        String dobString = scanner.nextLine();

        // Parse the date of birth string into a LocalDate object
        LocalDate dob = parseDate(dobString);

        // Calculate age
        int age = calculateAge(dob);

        // Display the age
        System.out.println("The person's age is: " + age);
    }

    // Method to parse the date of birth string into a LocalDate object
    private static LocalDate parseDate(String dobString) {
        DateTimeFormatter formatter = null;

        // Check if the date format is DD-MM-YYYY or YYYY-MM-DD
        if (dobString.contains("-")) {
            formatter = DateTimeFormatter.ofPattern("dd-MM-yyyy");
        } else if (dobString.contains("/")) {
            formatter = DateTimeFormatter.ofPattern("dd/MM/yyyy");
        } else {
            formatter = DateTimeFormatter.ofPattern("yyyy-MM-dd");
        }

        return LocalDate.parse(dobString, formatter);
    }

    // Method to calculate age based on date of birth
    private static int calculateAge(LocalDate dob) {
        LocalDate currentDate = LocalDate.now();
        return currentDate.minusYears(dob.getYear()).getYear();
    }
}