package org.example.util;

import org.example.entity.Customer;
import org.example.service.ClothingService;
import org.example.service.CustomerService;

import java.util.Scanner;

public class IhmCustomer {
    private Scanner scanner;
    private CustomerService customerService;

    public IhmCustomer() {
        scanner = new Scanner(System.in);
        customerService = new CustomerService();
    }

    public void start() {
        String choice;
        do {
            menu();
            choice = scanner.nextLine();
            switch (choice) {
                case "1" -> addCustomer();
                case "2" -> deleteCustomer();
                case "3" -> updateCustomer();
                case "4" -> displayCustomer();

                case "0" -> System.out.println("Retour au menu principal");
                default -> System.out.println("choix invalide");
            }

        } while (!choice.equals("0"));

        customerService.close();
    }


    private void menu() {
        System.out.println("- - - - - - MENU CLIENT - - - - - -");

        System.out.println("[1] Ajouter un client");

        System.out.println("[2] Supprimer un client");

        System.out.println("[3] Modifier un client");

        System.out.println("[4] Afficher un client");

        System.out.println("[0] Quitter");

    }

    private void addCustomer() {
        System.out.println("Ajout d'un client");
        System.out.println("Nom : ");
        String name = scanner.nextLine();
        System.out.println("Email : ");
        String email = scanner.nextLine();

        customerService.create(Customer.builder().name(name).email(email).build());

    }

    private void deleteCustomer() {
        System.out.println("Suppression d'un client");
        System.out.println("Id : ");
        int id = scanner.nextInt();
        scanner.nextLine();

        if (customerService.findById(id) == null) {
            System.out.println("Client non trouvé avec l'id : " + id);
        } else {
            customerService.delete(Customer.builder().id(id).build());
        }
    }

    private void updateCustomer() {
        System.out.println("Modification d'un client");
        System.out.println("Id : ");
        int id = scanner.nextInt();
        scanner.nextLine();

        if (customerService.findById(id) == null) {
            System.out.println("Client non trouvé avec l'id : " + id);
        } else {
            System.out.println("Nom : ");
            String name = scanner.nextLine();
            System.out.println("Email : ");
            String email = scanner.nextLine();

            customerService.update(Customer.builder().name(name).email(email).build());
        }
    }

    private void displayCustomer() {
        System.out.println("Affichage d'un client");
        System.out.println("Id : ");
        int id = scanner.nextInt();
        scanner.nextLine();
        Customer customer = customerService.findById(id);
        if (customer != null) {
            System.out.println(customer);
        } else {
            System.out.println("Client non trouvé avec l'id : " + id);
        }
    }

}
