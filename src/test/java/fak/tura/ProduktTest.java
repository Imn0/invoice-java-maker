package fak.tura;

import org.junit.Test;

import static org.junit.jupiter.api.Assertions.*;

class ProduktTest {
  @Test
  void getCenaNetto1() {
    Product produkt = new Product("123.12", 23, "Test", "szt.");
    assertEquals(12312, produkt.getUnitPriceBeforeTax());
  }
  @Test
  void getCenaNetto2() {
    Product produkt = new Product("123", 23, "Test", "szt.");
    assertEquals(12300, produkt.getUnitPriceBeforeTax());
  }
  @Test
  void getCenaNetto3() {
    Product produkt = new Product("123.02", 23, "Test", "szt.");
    assertEquals(12302, produkt.getUnitPriceBeforeTax());
  }
  @Test
  void getCenaNetto4() {
    Product produkt = new Product("123.2", 23, "Test", "szt.");
    assertEquals(12320, produkt.getUnitPriceBeforeTax());
  }

}