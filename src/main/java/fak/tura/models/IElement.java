package fak.tura.models;

public interface IElement {
    String getProduct();

    String getQuantityUnit();

    int getCenaNetto();

    int getVat();

    int getPriceBeforeTAX();

    int getTaxAmount();

    int getPriceAfterTAX();

    String getAmount();
}
