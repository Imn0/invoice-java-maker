package org.invoice.logic;

import org.invoice.models.Invoice;

public interface IInvoiceCalculator {
    FixedPointNumber totalAfetTax(Invoice invoice);
    FixedPointNumber totalTax(Invoice invoice);
    FixedPointNumber totalBeforeTax(Invoice invoice);
    FixedPointNumber totalAfetTax(Invoice invoice, FixedPointNumber taxRate);
    FixedPointNumber totalTax(Invoice invoice, FixedPointNumber taxRate);
    FixedPointNumber totalBeforeTax(Invoice invoice, FixedPointNumber taxRate);
}
