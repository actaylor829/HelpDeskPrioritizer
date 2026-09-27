import java.util.Scanner;

public class HelpDeskTicketPrioritizer {

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        String continueProgram = "yes";

        // Continue processing tickets until the user chooses to stop.
        while (continueProgram.equalsIgnoreCase("yes")) {

            // Get information about the support ticket.
            System.out.print("Enter the problem type: ");
            String problemType = scanner.nextLine();

            System.out.print("Enter the number of users affected: ");
            int usersAffected = scanner.nextInt();

            System.out.print("Are normal business operations prevented? (yes/no): ");
            String operationsPrevented = scanner.next();
            scanner.nextLine();

            String priority;
            String responseTime;

            // High priority: many users are affected and business operations
            // cannot continue.
            if (operationsPrevented.equalsIgnoreCase("yes")
                    && usersAffected >= 10) {

                priority = "High";
                responseTime = "within 30 minutes";

            // High priority: either many users are affected or operations
            // are prevented.
            } else if (usersAffected >= 10
                    || operationsPrevented.equalsIgnoreCase("yes")) {

                priority = "High";
                responseTime = "within 1 hour";

            // Medium priority: several users are affected.
            } else if (usersAffected >= 3) {

                priority = "Medium";
                responseTime = "within 4 business hours";

            // Low priority: only a small number of users are affected and
            // normal operations can continue.
            } else {

                priority = "Low";
                responseTime = "within 1 business day";
            }

            // Display the completed ticket assessment.
            System.out.println("\n--- Ticket Assessment ---");
            System.out.println("Problem type: " + problemType);
            System.out.println("Priority: " + priority);
            System.out.println("Recommended response: " + responseTime);

            // Ask whether another ticket should be processed.
            System.out.print("\nProcess another ticket? (yes/no): ");
            continueProgram = scanner.nextLine();

            System.out.println();
        }

        scanner.close();
        System.out.println("Help desk ticket processing complete.");
    }
}