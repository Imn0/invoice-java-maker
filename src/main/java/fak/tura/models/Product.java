package fak.tura.models;

import fak.tura.logic.FixedPointNumber;

public class Product {
    public final FixedPointNumber priceBeforeTax;
    public final FixedPointNumber vat;
    public final String name;
    public final String quantityUnit;

    public Product(String priceBeforeTax, int vat, final String name, final String quantityUnit) throws NumberFormatException {
        this.priceBeforeTax = new FixedPointNumber(priceBeforeTax);
        this.vat = new FixedPointNumber(vat);
        this.name = name;
        this.quantityUnit = quantityUnit;
    }
}
