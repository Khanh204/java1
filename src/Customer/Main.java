package Customer;

import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        CustomerRelationshipManagement crm = new CustomerRelationshipManagement();
        Scanner scanner = new Scanner(System.in);
        int choice;
        do {
            System.out.println("1. Add new customer");
            System.out.println("2. Find by name");
            System.out.println("3. Display all");
            System.out.println("4. Exit");
            System.out.print("Enter choice: ");
            choice = scanner.nextInt();
            scanner.nextLine(); // consume newline
            switch (choice) {
                case 1:
                    crm.addCustomer();
                    break;
                case 2:
                    crm.findByName();
                    break;
                case 3:
                    crm.displayAll();
                    break;
                case 4:
                    System.out.println("Goodbye.");
                    break;
                default:
                    System.out.println("Invalid choice.");
            }
        } while (choice != 4);
    }
}

