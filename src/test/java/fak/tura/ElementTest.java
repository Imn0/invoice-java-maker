package fak.tura;

import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class ElementTest {
  Produkt produkt;
  @BeforeEach
  void setUp() {
    produkt = new Produkt("123.25", 23, "Test");
  }

  @Test
  void getWartoscNetto1() {
    Element element = new Element(produkt, "2", "szt.");
    assertEquals(2*produkt.getCenaNetto(), element.getWartoscNetto());
  }
  @Test
  void getWartoscNetto2() {
    Element element = new Element(produkt, "2.5", "szt.");
    assertEquals(2*produkt.getCenaNetto() + (produkt.getCenaNetto()*50)/100, element.getWartoscNetto());
  }

  @Test
  void getWartoscNetto3() {
    Element element = new Element(produkt, "2.33", "szt.");
    assertEquals(2*produkt.getCenaNetto() + (produkt.getCenaNetto()*33)/100, element.getWartoscNetto());
  }

  @Test
  void getWartoscNetto4() {
    Element element = new Element(produkt, "0.1", "szt.");
    assertEquals(produkt.getCenaNetto()/10, element.getWartoscNetto());
  }


  @Test
  void getKowotaVAT() {
  }

  @Test
  void getWartoscBrutto() {
  }
}