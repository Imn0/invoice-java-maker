package fak.tura.logic;

import fak.tura.models.Invoice;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

/**
 * Polymorphism
 */
@Component
public class InvoiceCalculator implements IInvoiceCalculator{

    private final IElementCalculator elementCalculator;
    @Autowired
    public InvoiceCalculator(IElementCalculator elementCalculator) {
        this.elementCalculator = elementCalculator;
    }

    @Override
    public FixedPointNumber totalAfetTax(Invoice invoice) {
        FixedPointNumber total = new FixedPointNumber(0);
        for(var element: invoice.elements){
            total.add(elementCalculator.calucateTotalPriceAfterTax(element));
        }
        return total;
    }

    @Override
    public FixedPointNumber totalTax(Invoice invoice) {
        FixedPointNumber total = new FixedPointNumber(0);
        for(var element: invoice.elements){
            total.add(elementCalculator.calculateTotalTaxAmount(element));
        }
        return total;
    }

    @Override
    public FixedPointNumber totalBeforeTax(Invoice invoice) {
        FixedPointNumber total = new FixedPointNumber(0);
        for (var element: invoice.elements){
            total.add(elementCalculator.calculateTotalPriceBeforeTax(element));
        }
        return total;
    }

    @Override
    public FixedPointNumber totalAfetTax(Invoice invoice, FixedPointNumber taxRate) {
        FixedPointNumber total = new FixedPointNumber(0);
        for(var element: invoice.elements){
            if (element.product.vat == taxRate){
                total.add(elementCalculator.calucateTotalPriceAfterTax(element));
            }
        }
        return total;

    }

    @Override
    public FixedPointNumber totalTax(Invoice invoice, FixedPointNumber taxRate) {
        FixedPointNumber total = new FixedPointNumber(0);
        for (var element: invoice.elements){
            if (element.product.vat == taxRate){
                total.add(elementCalculator.calculateTotalTaxAmount(element));
            }
        }
        return total;
    }

    @Override
    public FixedPointNumber totalBeforeTax(Invoice invoice, FixedPointNumber taxRate) {
        FixedPointNumber total = new FixedPointNumber(0);
        for (var element: invoice.elements){
            if (element.product.vat == taxRate){
                total.add(elementCalculator.calculateTotalPriceBeforeTax(element));
            }
        }
        return total;
    }
}
