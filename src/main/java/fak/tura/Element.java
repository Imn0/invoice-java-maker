package fak.tura;

public class Element implements IElement {
    public final IProduct product;
    public final String amount;
    private int priceBeforeTAX;
    private int taxAmount;
    private int priceAfterTAX;

    public Element(final IProduct product, final String amount) throws NumberFormatException {
        this.amount = amount;
        this.product = product;

        setPriceBeforeTAX();
        setVATamount();
        setPriceAfterTAX();
    }

    private void setPriceBeforeTAX() {
        int[] c = StringUtil.parseStringToValue(amount, 3);

        int iloscCalkowita = c[0];
        int iloscUlamkowa = c[1];
        int price = product.getUnitPriceBeforeTax();

        this.priceBeforeTAX = price * iloscCalkowita + price * iloscUlamkowa / 1000;
    }

    private void setVATamount() {
        this.taxAmount = priceBeforeTAX * product.getVat() / 100;
    }

    private void setPriceAfterTAX() {
        this.priceAfterTAX = taxAmount + priceBeforeTAX;
    }

    public String getProduct() {
        return product.getName();
    }

    public String getQuantityUnit() {
        return product.getQuantityUnit();
    }

    public int getCenaNetto() {
        return product.getUnitPriceBeforeTax();
    }

    public int getVat() {
        return product.getVat();
    }

    public int getPriceBeforeTAX() {
        return priceBeforeTAX;
    }

    public int getTaxAmount() {
        return taxAmount;
    }

    public int getPriceAfterTAX() {
        return priceAfterTAX;
    }

    public String getAmount() {
        return amount;
    }
}
