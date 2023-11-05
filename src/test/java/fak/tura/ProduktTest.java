package fak.tura;

import fak.tura.models.Product;
import org.junit.Test;

import static org.junit.Assert.assertEquals;


public class ProduktTest {
  @Test
  public void getCenaNetto1() {
    Product produkt = new Product("123.12", 23, "Test", "szt.");
    assertEquals(12312, produkt.getUnitPriceBeforeTax());
  }
  @Test
  public void getCenaNetto2() {
    Product produkt = new Product("123", 23, "Test", "szt.");
    assertEquals(12300, produkt.getUnitPriceBeforeTax());
  }
  @Test
  public void getCenaNetto3() {
    Product produkt = new Product("123.02", 23, "Test", "szt.");
    assertEquals(12302, produkt.getUnitPriceBeforeTax());
  }
  @Test
  public void getCenaNetto4() {
    Product produkt = new Product("123.2", 23, "Test", "szt.");
    assertEquals(12320, produkt.getUnitPriceBeforeTax());
  }

}