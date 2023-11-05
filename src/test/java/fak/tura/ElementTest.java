package fak.tura;

import fak.tura.models.Element;
import fak.tura.models.IProduct;
import fak.tura.models.Product;
import org.junit.Test;

import static org.junit.Assert.assertEquals;

public class ElementTest {

  @Test
  public void getWartoscNetto1() {
    IProduct produkt = new Product("123.25", 23, "Test","szt.");
    Element element = new Element(produkt, "2");
    assertEquals(2*produkt.getUnitPriceBeforeTax(), element.getPriceBeforeTAX());
  }
  @Test
  public void getWartoscNetto2() {
    IProduct produkt = new Product("123.25", 23, "Test","szt.");
    Element element = new Element(produkt, "2.5");
    assertEquals(2*produkt.getUnitPriceBeforeTax() + (produkt.getUnitPriceBeforeTax()*50)/100, element.getPriceBeforeTAX());
  }

  @Test
  public void getWartoscNetto3() {
    IProduct produkt = new Product("123.25", 23, "Test","szt.");
    Element element = new Element(produkt, "2.33");
    assertEquals(2*produkt.getUnitPriceBeforeTax() + (produkt.getUnitPriceBeforeTax()*33)/100, element.getPriceBeforeTAX());
  }

  @Test
  public void getWartoscNetto4() {
    IProduct produkt = new Product("123.25", 23, "Test","szt.");
    Element element = new Element(produkt, "0.1");
    assertEquals(produkt.getUnitPriceBeforeTax()/10, element.getPriceBeforeTAX());
  }


  @Test
  public void getKowotaVAT1() {
    IProduct produkt = new Product("123.25", 23, "Test","szt.");
    Element element = new Element(produkt, "1");
    assertEquals(produkt.getUnitPriceBeforeTax()*23/100, element.getTaxAmount());
  }
  @Test
  public void getKowotaVAT2() {
    IProduct produkt = new Product("123.25", 23, "Test","szt.");
    Element element = new Element(produkt, "2.5");
    assertEquals((2*produkt.getUnitPriceBeforeTax()+ produkt.getUnitPriceBeforeTax()/2)*23/100, element.getTaxAmount());
  }


  @Test
  public void getWartoscBrutto1() {
    IProduct produkt = new Product("123.25", 23, "Test","szt.");
    Element element = new Element(produkt, "2");
    assertEquals(2*produkt.getUnitPriceBeforeTax() + 2*produkt.getUnitPriceBeforeTax()*23/100, element.getPriceAfterTAX());
  }
  @Test
  public void getWartoscBrutto2() {
    IProduct produkt = new Product("123.25", 23, "Test","szt.");
    Element element = new Element(produkt, "2.5");
    assertEquals((2*produkt.getUnitPriceBeforeTax()+ produkt.getUnitPriceBeforeTax()/2) + (2*produkt.getUnitPriceBeforeTax()+ produkt.getUnitPriceBeforeTax()/2)*23/100, element.getPriceAfterTAX());
  }

}