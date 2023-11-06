package fak.tura.logic;

import fak.tura.models.Element;

/**
 * Protected variations
 */
public interface IElementCalculator {
    FixedPointNumber calculateTotalPriceBeforeTax(Element element);
    FixedPointNumber calculateTotalTaxAmount(Element element);

    FixedPointNumber calucateTotalPriceAfterTax(Element element);
}
