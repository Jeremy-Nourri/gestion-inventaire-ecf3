package org.example.factory;

import org.example.entity.Jacket;
import org.example.entity.Jean;
import org.example.entity.Shirt;

public abstract class ClothingFactory {
    public abstract Jean createJean();
    public abstract Shirt createShirt();
    public abstract Jacket createJacket();

}
