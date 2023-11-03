package fak.tura;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import java.util.ArrayList;

import static org.junit.jupiter.api.Assertions.*;

class FakturaTest {
  IFaktura faktura;
  @BeforeEach
  void setUp() {
    IProdukt produkt1 = new Produkt("10", 23, "baton", "szt.");
    IElement element1 = new Element(produkt1, "10");

    IProdukt produkt2 = new Produkt("11", 23, "cukierek", "szt.");
    IElement element2 = new Element(produkt2, "8");

    IProdukt produkt3 = new Produkt("12.123", 8, "uran", "tony");
    IElement element3 = new Element(produkt3, "2137.420");

    ArrayList<IElement> elements = new ArrayList<>();
    elements.add(element1);
    elements.add(element2);
    elements.add(element3);

    faktura = new Faktura(elements);
  }

  @Test
  void getTotalWartoscNetto() {
    assertEquals(faktura.getTotalWartoscBrutto(), 2820921);
  }

  @Test
  void getTotalKwotaVAT() {
    assertEquals(faktura.getTotalKwotaVAT(), 211568);
  }

  @Test
  void getTotalWartoscBrutto() {
    assertEquals(faktura.getTotalWartoscNetto(), 2609353);
  }

  @Test
  void getWartoscNettoForVAT1() {
    assertEquals(faktura.getWartoscNettoForVAT(23), 18800);
  }
  @Test
  void getWartoscNettoForVAT2() {
    assertEquals(faktura.getWartoscNettoForVAT(23), 2590553);
  }

  @Test
  void getKwotaVATForVAT1() {
    assertEquals(faktura.getKwotaVATForVAT(23), 4324);
  }
  @Test
  void getKwotaVATForVAT2() {
    assertEquals(faktura.getKwotaVATForVAT(8), 207244);
  }

  @Test
  void getWartoscBruttoForVAT1() {
    assertEquals(faktura.getWartoscBruttoForVAT(23), 23124);
  }
  @Test
  void getWartoscBruttoForVAT2() {
    assertEquals(faktura.getWartoscBruttoForVAT(8), 2797797);
  }
}