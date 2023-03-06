package Customer;
import java.util.HashMap;
import java.util.Scanner;

public class CustomerRelationshipManagement {
    private HashMap<String, Customer> customers = new HashMap();
    public void addCustomer() {
        Scanner scanner = new Scanner(System.in);
        System.out.print("Enter name: ");
        String name = scanner.nextLine();
        System.out.print("Enter email: ");
        String email = scanner.nextLine();
        System.out.print("Enter phone: ");
        String phone = scanner.nextLine();
        Customer customer = new Customer(name, email, phone);
        customers.put(name, customer);
        System.out.println("Customer added.");
    }

    public void findByName() {
        Scanner scanner = new Scanner(System.in);
        System.out.print("Enter name: ");
        String name = scanner.nextLine();
        Customer customer = customers.get(name);
        if (customer != null) {
            System.out.println("Name :"+customer.getName());
            System.out.println("Email :"+customer.getEmail());
            System.out.println("Phone :"+customer.getPhone());
        } else {
            System.out.println("Not found.");
        }
    }

    public void displayAll() {
        if (customers.isEmpty()) {
            System.out.println("No customers.");
        } else {
            for (Customer customer : customers.values()) {
                System.out.println("Name :"+customer.getName());
                System.out.println("Email :"+customer.getEmail());
                System.out.println("Phone :"+customer.getPhone());
            }
        }
    }
    }
