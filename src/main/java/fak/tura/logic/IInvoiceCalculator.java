package fak.tura.logic;

import fak.tura.models.Invoice;

/**
 * Protected variations, polymorphism
 */
public interface IInvoiceCalculator {
    FixedPointNumber totalAfetTax(Invoice invoice);
    FixedPointNumber totalTax(Invoice invoice);
    FixedPointNumber totalBeforeTax(Invoice invoice);
    FixedPointNumber totalAfetTax(Invoice invoice, FixedPointNumber taxRate);
    FixedPointNumber totalTax(Invoice invoice, FixedPointNumber taxRate);
    FixedPointNumber totalBeforeTax(Invoice invoice, FixedPointNumber taxRate);
}
