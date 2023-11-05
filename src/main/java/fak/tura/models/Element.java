package fak.tura.models;

import fak.tura.logic.StringUtil;

public class Element implements IElement {
    public final IProduct product;
    public final String amount;
    private int priceBeforeTAX;
    private int taxAmount;
    private int priceAfterTAX;


    public Element(final String priceBeforeTax, final int vat, final String name, final String quantityUnit, final String amount) throws NumberFormatException {
        this.amount = amount;
        this.product = new Product(priceBeforeTax, vat, name, quantityUnit);

        setPriceBeforeTAX();
        setVATamount();
        setPriceAfterTAX();
    }

    public Element(final IProduct product, final String amount) throws NumberFormatException {
        this.amount = amount;
        this.product = product;

        setPriceBeforeTAX();
        setVATamount();
        setPriceAfterTAX();
    }

    private void setPriceBeforeTAX() {
        int[] aLongVariableName = StringUtil.parseStringToValue(amount, 3);

        int iloscCalkowita = aLongVariableName[0];
        int iloscUlamkowa = aLongVariableName[1];
        int price = product.getUnitPriceBeforeTax();

        this.priceBeforeTAX = price * iloscCalkowita + price * iloscUlamkowa / 1000;
    }

    private void setVATamount() {
        this.taxAmount = priceBeforeTAX * product.getVat() / 100;
    }

    private void setPriceAfterTAX() {
        this.priceAfterTAX = taxAmount + priceBeforeTAX;
    }
    @Override
    public String getProduct() {
        return product.getName();
    }
    @Override
    public String getQuantityUnit() {
        return product.getQuantityUnit();
    }
    @Override
    public int getCenaNetto() {
        return product.getUnitPriceBeforeTax();
    }
    @Override
    public int getVat() {
        return product.getVat();
    }
    @Override
    public int getPriceBeforeTAX() {
        return priceBeforeTAX;
    }
    @Override
    public int getTaxAmount() {
        return taxAmount;
    }
    @Override
    public int getPriceAfterTAX() {
        return priceAfterTAX;
    }
    @Override
    public String getAmount() {
        return amount;
    }
}
