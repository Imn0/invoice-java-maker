package fak.tura.models;

public interface IProduct {
    int getUnitPriceBeforeTax();

    int getVat();

    String getName();

    String getQuantityUnit();
}
