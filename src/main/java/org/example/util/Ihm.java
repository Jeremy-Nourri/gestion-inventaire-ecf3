package org.example.util;

import java.util.Scanner;

public class Ihm {

    IhmClothing ihmClothing = new IhmClothing();
    IhmSale ihmSale = new IhmSale();
    IhmCustomer ihmCustomer = new IhmCustomer();
    Scanner scanner = new Scanner(System.in);

    public void start() {
        String choice;
        do {
            menu();
            choice = scanner.nextLine();
            switch (choice) {
                case "1" -> ihmClothing.start();
                case "2" -> ihmSale.start();
                case "3" -> ihmCustomer.start();
                case "0" -> System.out.println("Au revoir !!!");
                default -> System.out.println("choix invalide");
            }

        } while (!choice.equals("0"));

    }

    private void menu() {
        System.out.println("- - - - - - MENU - - - - - -");

        System.out.println("[1] Gérer les produits");

        System.out.println("[2] Gérer les ventes");

        System.out.println("[3] Gérer les clients");

//        System.out.println("[2] Calculer le prix moyen des produits.");
//
//        System.out.println("[3] Récupérer la liste des produits d'une marque choisie.");
//
//        System.out.println("[4] Supprimer les produits d'une marque choisie de la table produit.");
//
//        System.out.println("[5] Ajouter une image à un produit.");
//
//        System.out.println("[6] Ajouter un commentaire à un produit.");
//
//        System.out.println("[7] Afficher les produits ave une note min.");

        System.out.println("[0] Quitter");

        System.out.println("Votre choix :");

    }
}
