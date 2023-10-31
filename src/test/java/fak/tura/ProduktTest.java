package fak.tura;

import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class ProduktTest {
  @Test
  void getCenaNetto1() {
    Produkt produkt = new Produkt("123.12", 23, "Test");
    assertEquals(12312, produkt.getCenaNetto());
  }
  @Test
  void getCenaNetto2() {
    Produkt produkt = new Produkt("123", 23, "Test");
    assertEquals(12300, produkt.getCenaNetto());
  }
  @Test
  void getCenaNetto3() {
    Produkt produkt = new Produkt("123.02", 23, "Test");
    assertEquals(12302, produkt.getCenaNetto());
  }
  @Test
  void getCenaNetto4() {
    Produkt produkt = new Produkt("123.2", 23, "Test");
    assertEquals(12320, produkt.getCenaNetto());
  }

}