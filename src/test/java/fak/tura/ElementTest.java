package fak.tura;

import org.junit.Test;
import org.junit.jupiter.api.BeforeEach;

import static org.junit.Assert.assertEquals;


class ElementTest {
  Product produkt;
  @BeforeEach
  void setUp() {
    produkt = new Product("123.25", 23, "Test","szt.");
  }

  @Test
  void getWartoscNetto1() {
    Element element = new Element(produkt, "2");
    assertEquals(2*produkt.getUnitPriceBeforeTax(), element.getPriceBeforeTAX());
  }
  @Test
  void getWartoscNetto2() {
    Element element = new Element(produkt, "2.5");
    assertEquals(2*produkt.getUnitPriceBeforeTax() + (produkt.getUnitPriceBeforeTax()*50)/100, element.getPriceBeforeTAX());
  }

  @Test
  void getWartoscNetto3() {
    Element element = new Element(produkt, "2.33");
    assertEquals(2*produkt.getUnitPriceBeforeTax() + (produkt.getUnitPriceBeforeTax()*33)/100, element.getPriceBeforeTAX());
  }

  @Test
  void getWartoscNetto4() {
    Element element = new Element(produkt, "0.1");
    assertEquals(produkt.getUnitPriceBeforeTax()/10, element.getPriceBeforeTAX());
  }


  @Test
  void getKowotaVAT1() {
    Element element = new Element(produkt, "1");
    assertEquals(produkt.getUnitPriceBeforeTax()*23/100, element.getTaxAmount());
  }
  @Test
  void getKowotaVAT2() {
    Element element = new Element(produkt, "2.5");
    assertEquals((2*produkt.getUnitPriceBeforeTax()+ produkt.getUnitPriceBeforeTax()/2)*23/100, element.getTaxAmount());
  }


  @Test
  void getWartoscBrutto1() {
    Element element = new Element(produkt, "2");
    assertEquals(2*produkt.getUnitPriceBeforeTax() + 2*produkt.getUnitPriceBeforeTax()*23/100, element.getPriceAfterTAX());
  }
  @Test
  void getWartoscBrutto2() {
    Element element = new Element(produkt, "2.5");
    assertEquals((2*produkt.getUnitPriceBeforeTax()+ produkt.getUnitPriceBeforeTax()/2) + (2*produkt.getUnitPriceBeforeTax()+ produkt.getUnitPriceBeforeTax()/2)*23/100, element.getPriceAfterTAX());
  }

}