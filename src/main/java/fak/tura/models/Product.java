package fak.tura.models;

import fak.tura.logic.StringUtil;

public class Product implements IProduct {
    private final int priceBeforeTax;
    private final int vat;
    private final String name;
    private final String quantityUnit;

    public Product(String priceBeforeTax, int vat, final String name, final String quantityUnit) throws NumberFormatException {
        int[] cena = StringUtil.parseStringToValue(priceBeforeTax);
        this.priceBeforeTax = cena[0] * 100 + cena[1];
        this.vat = vat;
        this.name = name;
        this.quantityUnit = quantityUnit;
    }

    public int getUnitPriceBeforeTax() {
        return priceBeforeTax;
    }

    public int getVat() {
        return vat;
    }

    public String getName() {
        return name;
    }

    public String getQuantityUnit() {
        return quantityUnit;
    }

}
