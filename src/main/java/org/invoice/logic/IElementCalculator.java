package org.invoice.logic;

import org.invoice.models.Element;


public interface IElementCalculator {
    FixedPointNumber calculateTotalPriceBeforeTax(Element element);
    FixedPointNumber calculateTotalTaxAmount(Element element);

    FixedPointNumber calucateTotalPriceAfterTax(Element element);
}
