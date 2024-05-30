package org.example.util;

import org.example.entity.Categorie;
import org.example.entity.Clothing;
import org.example.service.ClothingService;

import java.util.Scanner;

public class IhmClothing {

    private Scanner scanner;
    private ClothingService clothingService;

    public IhmClothing() {
        scanner = new Scanner(System.in);
        clothingService = new ClothingService();
    }

    public void start() {
        String choice;
        do {
            menu();
            choice = scanner.nextLine();
            switch (choice) {
                case "1" -> addClothing();
                case "2" -> deleteClothing();
                case "3" -> updateClothing();
                case "4" -> displayClothing();

                case "0" -> System.out.println("Retour au menu principal");
                default -> System.out.println("choix invalide");
            }

        } while (!choice.equals("0"));

        clothingService.close();
    }

    private void menu() {
        System.out.println("- - - - - - MENU GESTION DES VÊTEMENTS - - - - - -");

        System.out.println("[1] Ajouter un vêtement");

        System.out.println("[2] Supprimer un vêtement");

        System.out.println("[3] Modifier un vêtement");

        System.out.println("[4] Afficher un vêtement");

        System.out.println("[0] Quitter");

        System.out.println("Votre choix :");

    }

    private void addClothing() {

        System.out.println("Ajout d'un vêtement");

        System.out.println("Nom : ");
        String name = scanner.nextLine();

        System.out.println("Prix : ");
        double price = scanner.nextDouble();
        scanner.nextLine();

        System.out.println("Description : ");
        String description = scanner.nextLine();

        System.out.println("Stock : ");
        int stock = scanner.nextInt();
        scanner.nextLine();

        System.out.println("Taille : ");
        String size = scanner.nextLine();

        int category;
        do {
            System.out.println("Catégorie : ");
            System.out.println("1. HOMME");
            System.out.println("2. FEMME");
            System.out.println("3. ENFANT");
            category = scanner.nextInt();
            scanner.nextLine();
        } while (category < 1 || category > 3);


        clothingService.create(Clothing.builder()
                        .categorie(Categorie.values()[category - 1])
                        .description(description)
                        .size(size)
                        .price(price)
                        .stock(stock)
                        .build());
    }

    private void deleteClothing() {
        System.out.println("Suppression d'un vêtement");
        System.out.println("Id : ");
        int id = scanner.nextInt();
        scanner.nextLine();
        Clothing clothing = clothingService.findById(id);
        if (clothing != null) {
            clothingService.delete(clothing);
        } else {
            System.out.println("Vêtement non trouvé avec l'id : " + id);
        }
    }

    private void updateClothing() {
        System.out.println("Modification d'un vêtement");
        System.out.println("Id : ");
        int id = scanner.nextInt();
        scanner.nextLine();
        Clothing clothing = clothingService.findById(id);
        System.out.println("Voici le vêtement que nous avons trouvé avec l'id : " + id);
        System.out.println(clothing);


        if (clothing != null) {
            System.out.println("Modifier le nom : ");
            String name = scanner.nextLine();

            System.out.println("Modifier le prix : ");
            double price = scanner.nextDouble();
            scanner.nextLine();

            System.out.println("Modifier la description : ");
            String description = scanner.nextLine();

            System.out.println("Modifier le stock : ");
            int stock = scanner.nextInt();

            System.out.println("Modifier la taille : ");
            String size = scanner.nextLine();
            int category;
            do {
                System.out.println("Modifier la catégorie : ");
                System.out.println("1. HOMME");
                System.out.println("2. FEMME");
                System.out.println("3. ENFANT");
                category = scanner.nextInt();
                scanner.nextLine();
            } while (category < 1 || category > 3);

            clothingService.update(Clothing.builder()
                    .id(id)
                    .categorie(Categorie.values()[category - 1])
                    .description(description)
                    .size(size)
                    .price(price)
                    .stock(stock)
                    .build());
        } else {
            System.out.println("Vêtement non trouvé avec l'id : " + id);
        }
    }

    private void displayClothing() {
        System.out.println("Affichage d'un vêtement");
        System.out.println("Id : ");
        int id = scanner.nextInt();
        scanner.nextLine();
        Clothing clothing = clothingService.findById(id);
        if (clothing != null) {
            System.out.println(clothing);
        } else {
            System.out.println("Vêtement non trouvé avec l'id : " + id);
        }
    }


}