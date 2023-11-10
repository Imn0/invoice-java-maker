package fak.tura.logic;

import fak.tura.models.Element;
import org.junit.Before;
import org.junit.Test;

import static org.junit.Assert.*;

public class ElementCalculatorTest {

    private ElementCalculator elementCalculator;
    private Element element;
    private Element element2;
    private Element element3;
    @Before
    public void setUp() throws Exception {
        elementCalculator = new ElementCalculator();
        element = new Element("10",23,"Test", "szt.","10");
        element2 = new Element("10",8,"Test", "szt.","10");
        element3 = new Element("10.99",23,"Test", "szt.","5.5");

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
    @Test
    public void calculateTotalPriceBeforeTax2() {
        FixedPointNumber price = elementCalculator.calculateTotalPriceBeforeTax(element2);
        FixedPointNumber expected = new FixedPointNumber(10000);
        assertTrue(price.isEqual(expected));
    }

    @Test
    public void calculateTotalTaxAmount2() {
        FixedPointNumber price = elementCalculator.calculateTotalTaxAmount(element2);
        FixedPointNumber expected = new FixedPointNumber(800);
        assertTrue(price.isEqual(expected));
    }

    @Test
    public void calucateTotalPriceAfterTax2() {
        FixedPointNumber price = elementCalculator.calucateTotalPriceAfterTax(element2);
        FixedPointNumber expected = new FixedPointNumber(10800);
        assertTrue(price.isEqual(expected));
    }
    @Test
    public void calculateTotalPriceBeforeTax3() {
        FixedPointNumber price = elementCalculator.calculateTotalPriceBeforeTax(element3);
        FixedPointNumber expected = new FixedPointNumber(6045);
        assertTrue(price.isEqual(expected));
    }

    @Test
    public void calculateTotalTaxAmount3() {
        FixedPointNumber price = elementCalculator.calculateTotalTaxAmount(element3);
        FixedPointNumber expected = new FixedPointNumber(1390);
        assertTrue(price.isEqual(expected));
    }

    @Test
    public void calucateTotalPriceAfterTax3() {
        FixedPointNumber price = elementCalculator.calucateTotalPriceAfterTax(element3);
        FixedPointNumber expected = new FixedPointNumber(7435);
        assertTrue(price.isEqual(expected));
    }
}