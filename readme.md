# ECF3 - Système de Gestion d'Inventaire pour un Magasin de Vêtements

Ceette exercice a pour but de créer une application de gestion d'inventaire pour un magasin de vêtements. Elle doi permettre aux employés de suivre les stocks de vêtements, de gérer les ventes et de tenir à jour les informations des clients.

## Les fonctionnalités que j'ai implémentées :

- **Gérer les produits(vêtements)** : Permet d'ajouter, modifier, supprimer et consulter les articles de l'inventaire.
- **Gestion les ventes** : Enregistre les ventes réalisées en magasin, informe le client du changement d'état de la vente au cours de sa commande.
- **Gestion des clients** : Permet de créer, modifier, supprimer et consulter les informations des clients. 

## Technologies utilisées

- Java : Le projet est écrit en Java. J'ai utilisé le modèle d'Observateur pour gérer les notifications aux clients.
  (Design pattern abstract factory pour la création de vêtements non terminé)
- Hibernate : Utilisé pour la persistance des données et l'interaction avec la base de données.
- MySQL : Système de gestion de base de données utilisé pour stocker les données de l'application.

## Comment exécuter le projet

1. Clonez le dépôt git sur votre machine locale.
2. Ouvrez le projet dans votre IDE.
3. Créer une base donnée MySQL avec les informations contenu dans le fichier ressources/hibernate.properties
4. Le code SQl
   ```sql
   CREATE DATABSE ecf3;
6. Exécutez le fichier `Main.java` pour démarrer l'application.
7. Si vous le souhaitez vous pouvez insérer des données fictives gràce à ce script SQL
      ```sql
      use ecf3;
      INSERT INTO clothing (id, categorie, description, size, price, stock) VALUES (1, 'HOMME', 'T-shirt bleu', 'M', 19.99, 100);
      INSERT INTO clothing (id, categorie, description, size, price, stock) VALUES (2, 'FEMME', 'Robe rouge', 'L', 29.99, 50);
      INSERT INTO clothing (id, categorie, description, size, price, stock) VALUES (3, 'ENFANT', 'Pantalon vert', 'S', 39.99, 75);
      INSERT INTO customer (id, name, email) VALUES (1, 'Jean Dupont', 'jean.dupont@example.com'), (2, 'Marie Durand', 'marie.durand@example.com');
      INSERT INTO sale (id, customer_id, state_sale) VALUES (1, 1, 'INPROGRESS'), (2, 2, 'FINALIZED');
      INSERT INTO sale_line (id, quantity, total, clothing_id, sale_id) VALUES (1, 1, 19.99, 1, 1), (2, 2, 59.98, 2, 2);
      
## Utilisation de l'application  
Trois menus sont disponibles :  
- Gérer les produits
- Gérer les ventes
- Gérer les clients

Chaque thématique contient un sous menu  
Attention : pour réaliser un achat/vente vous devez créer un client



  
