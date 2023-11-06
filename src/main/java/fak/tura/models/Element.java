package fak.tura.models;
import fak.tura.logic.FixedPointNumber;

/**
 * Creator, creates it's own product.
 */
public class Element {
    public final Product product;
    public final FixedPointNumber amount;
    public Element(final String priceBeforeTax, final int vat, final String name, final String quantityUnit, final String amount) throws NumberFormatException {
        this.amount = new FixedPointNumber(amount);
        this.product = new Product(priceBeforeTax, vat, name, quantityUnit);
    }

    public Element(final Product product, final String amount) throws NumberFormatException {
        this.amount = new FixedPointNumber(amount);
        this.product = product;
    }

}
