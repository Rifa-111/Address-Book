/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Main.java to edit this template
 */
package address_book;

/**
 *
 * @author rifa
 */
import java.util.ArrayList;
import java.util.Scanner;

class Contact {
    private String name;
    private String phoneNumber;
    private String email;
    private String address;

    public Contact(String name, String phoneNumber, String email, String address) {
        this.name = name;
        this.phoneNumber = phoneNumber;
        this.email = email;
        this.address = address;
    }

    public String getName() {
        return name;
    }

    @Override
    public String toString() {
        return "Name: " + name + "\nPhone Number: " + phoneNumber + "\nEmail: " + email + "\nAddress: " + address;
    }
}

public class AddressBook {
    private ArrayList<Contact> contacts = new ArrayList<>();
    private Scanner scanner = new Scanner(System.in);

    public void addContact(String name, String phoneNumber, String email, String address) {
        contacts.add(new Contact(name, phoneNumber, email, address));
        System.out.println("Contact added successfully.");
    }

    public void listContacts() {
        if (contacts.isEmpty()) {
            System.out.println("Address book is empty.");
        } else {
            System.out.println("\nContacts in the Address Book:");
            for (int i = 0; i < contacts.size(); i++) {
                System.out.println((i + 1) + ". " + contacts.get(i).getName());
            }
        }
    }

    public void searchContact(String name) {
        boolean found = false;
        for (Contact contact : contacts) {
            if (contact.getName().equalsIgnoreCase(name)) {
                System.out.println("\nContact Details:\n" + contact);
                found = true;
                break;
            }
        }
        if (!found) {
            System.out.println("Contact not found.");
        }
    }

    public void deleteContact(int index) {
        if (index >= 0 && index < contacts.size()) {
            contacts.remove(index);
            System.out.println("Contact deleted successfully.");
        } else {
            System.out.println("Invalid contact index.");
        }
    }

    public void run() {
        while (true) {
            System.out.println("\nOptions:");
            System.out.println("1. Add Contact");
            System.out.println("2. List Contacts");
            System.out.println("3. Search Contact");
            System.out.println("4. Delete Contact");
            System.out.println("5. Quit");

            System.out.print("Enter your choice: ");
            int choice = scanner.nextInt();
            scanner.nextLine();  // Consume the newline character

            switch (choice) {
                case 1:
                    System.out.print("Enter Name: ");
                    String name = scanner.nextLine();
                    System.out.print("Enter Phone Number: ");
                    String phoneNumber = scanner.nextLine();
                    System.out.print("Enter Email: ");
                    String email = scanner.nextLine();
                    System.out.print("Enter Address: ");
                    String address = scanner.nextLine();
                    addContact(name, phoneNumber, email, address);
                    break;
                case 2:
                    listContacts();
                    break;
                case 3:
                    System.out.print("Enter Name to Search: ");
                    String searchName = scanner.nextLine();
                    searchContact(searchName);
                    break;
                case 4:
                    System.out.print("Enter Index to Delete: ");
                    int deleteIndex = scanner.nextInt();
                    deleteContact(deleteIndex - 1);
                    break;
                case 5:
                    scanner.close();
                    System.out.println("Goodbye!");
                    System.exit(0);
                default:
                    System.out.println("Invalid choice. Please try again.");
            }
        }
    }

    public static void main(String[] args) {
        AddressBook addressBook = new AddressBook();
        addressBook.run();
    }
}
