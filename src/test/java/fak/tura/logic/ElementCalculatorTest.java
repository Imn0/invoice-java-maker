package fak.tura.logic;

import fak.tura.models.Element;
import org.junit.Before;
import org.junit.Test;

import static org.junit.Assert.*;

public class ElementCalculatorTest {

    private ElementCalculator elementCalculator;
    private Element element;
    @Before
    public void setUp() throws Exception {
        elementCalculator = new ElementCalculator();
        element = new Element("10",23,"Test", "szt.","10");
    }

    @Test
    public void calculateTotalPriceBeforeTax() {
        FixedPointNumber price = elementCalculator.calculateTotalPriceBeforeTax(element);
        FixedPointNumber expected = new FixedPointNumber(10000);
        assertTrue(price.isEqual(expected));
    }

    @Test
    public void calculateTotalTaxAmount() {
        FixedPointNumber price = elementCalculator.calculateTotalTaxAmount(element);
        FixedPointNumber expected = new FixedPointNumber(2300);
        assertTrue(price.isEqual(expected));
    }

    @Test
    public void calucateTotalPriceAfterTax() {
        FixedPointNumber price = elementCalculator.calucateTotalPriceAfterTax(element);
        FixedPointNumber expected = new FixedPointNumber(12300);
        assertTrue(price.isEqual(expected));
    }
}