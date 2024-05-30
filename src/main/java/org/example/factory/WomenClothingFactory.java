package org.example.factory;

import org.example.entity.*;

public class WomenClothingFactory extends ClothingFactory {
    @Override
    public Jean createJean() {
        Jean jean = Jean.builder().build();
        jean.setCategorie(Categorie.FEMME);
        return jean;
    }

    @Override
    public Shirt createShirt() {
        Shirt shirt = Shirt.builder().build();
        shirt.setCategorie(Categorie.FEMME);
        return shirt;

    }

    @Override
    public Jacket createJacket() {
        Jacket jacket = Jacket.builder().build();
        jacket.setCategorie(Categorie.FEMME);
        return jacket;

    }
}
