package org.example.factory;

import org.example.entity.Categorie;
import org.example.entity.Jacket;
import org.example.entity.Jean;
import org.example.entity.Shirt;

public class MenClothingFactory extends ClothingFactory{
    @Override
    public Jean createJean() {
        Jean jean = Jean.builder().build();
        jean.setCategorie(Categorie.HOMME);
        return jean;
    }

    @Override
    public Shirt createShirt() {
        Shirt shirt = Shirt.builder().build();
        shirt.setCategorie(Categorie.HOMME);
        return shirt;
    }

    @Override
    public Jacket createJacket() {
        Jacket jacket = Jacket.builder().build();
        jacket.setCategorie(Categorie.HOMME);
        return jacket;
    }
}
