package org.example.util;

import org.example.entity.*;
import org.example.service.ClothingService;
import org.example.service.CustomerService;
import org.example.service.SaleLineService;
import org.example.service.SaleService;

import java.util.List;
import java.util.Scanner;

public class IhmSale {

    private Scanner scanner;
    private SaleService saleService;
    private SaleLineService saleLineService;
    private ClothingService clothingService;
    private CustomerService customerService;

    public IhmSale() {
        scanner = new Scanner(System.in);
        saleService = new SaleService();
        saleLineService = new SaleLineService();
        clothingService = new ClothingService();
        customerService = new CustomerService();
    }

    public void start() {
        String choice;
        do {
            menu();
            choice = scanner.nextLine();
            switch (choice) {
                case "1" -> makeAPurchase();
                case "0" -> System.out.println("Retour au menu principal");
                default -> System.out.println("choix invalide");
            }

        } while (!choice.equals("0"));

        saleService.close();
    }

    private void menu() {
        System.out.println("- - - - - - MENU ACHAT - - - - - -");

        System.out.println("[1] Réaliser des achats");

        System.out.println("[0] Quitter");

        System.out.println("Votre choix :");

    }

    private void makeAPurchase() {
        System.out.println("Réaliser des achats");
        System.out.println("Id du client : ");
        int customerId = scanner.nextInt();
        scanner.nextLine();
        Customer customer = customerService.findById(customerId);
        if (customer == null) {
            System.out.println("Client non trouvé");
            return;
        }
        String customerName = customer.getName();
        System.out.println("Client : " + customerName);

        Sale sale = Sale.builder()
                .customer(customer)
                .build();

        int idSale = saleService.createAndReturnId(sale);

        saleService.updateStateSale(idSale, StateSale.INPROGRESS);

        String answer;

        do {
            Clothing clothing = null;

            do {
                System.out.println("Id du vêtement : ");
                int clothingId = scanner.nextInt();
                scanner.nextLine();
                clothing = clothingService.findById(clothingId);

                if (clothing == null) {
                    System.out.println("Vêtement non trouvé");
                } else {
                    System.out.println("Le vêtement sélectionné :");
                    System.out.println(clothing);
                    System.out.println("Prix unitaire : " + clothing.getPrice());
                }

            } while (clothing == null);

            System.out.println("Quantité : ");
            int quantity = scanner.nextInt();
            scanner.nextLine();

            double total = clothing.getPrice() * quantity;

            SaleLine saleLine = SaleLine.builder()
                    .total(total)
                    .quantity(quantity)
                    .clothing(clothing)
                    .sale(sale)
                    .build();

            saleService.addSaleLine(idSale, saleLine);

            System.out.println("Voulez-vous ajouter un autre vêtement ? (O/N)");
            answer = scanner.nextLine();

        } while (answer.equalsIgnoreCase("O"));

        System.out.println("Vente enregistrée");

        saleService.updateStateSale(idSale, StateSale.FINALIZED);

    }
}
