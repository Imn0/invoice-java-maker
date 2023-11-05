package fak.tura;

import fak.tura.models.*;
import org.junit.Test;
import java.util.ArrayList;

import static org.junit.Assert.assertEquals;


public class InvoiceTest {


  void setUp() {

  }

  @Test
  public void getTotalWartoscNetto() {

    IProduct produkt1 = new Product("10", 23, "baton", "szt.");
    IElement element1 = new Element(produkt1, "10");

    IProduct produkt2 = new Product("11", 23, "cukierek", "szt.");
    IElement element2 = new Element(produkt2, "8");

    IProduct produkt3 = new Product("12.123", 8, "uran", "tony");
    IElement element3 = new Element(produkt3, "2137.420");

    ArrayList<IElement> elements = new ArrayList<>();
    elements.add(element1);
    elements.add(element2);
    elements.add(element3);

    IInvoice faktura = new Invoice(elements);
    assertEquals(faktura.getTotalPriceAfterTax(), 2820921);
  }

  @Test
  public void getTotalKwotaVAT() {

    IProduct produkt1 = new Product("10", 23, "baton", "szt.");
    IElement element1 = new Element(produkt1, "10");

    IProduct produkt2 = new Product("11", 23, "cukierek", "szt.");
    IElement element2 = new Element(produkt2, "8");

    IProduct produkt3 = new Product("12.123", 8, "uran", "tony");
    IElement element3 = new Element(produkt3, "2137.420");

    ArrayList<IElement> elements = new ArrayList<>();
    elements.add(element1);
    elements.add(element2);
    elements.add(element3);

    IInvoice faktura = new Invoice(elements);
    assertEquals(faktura.getTotalVatAmount(), 211568);
  }

  @Test
  public void getTotalWartoscBrutto() {

    IProduct produkt1 = new Product("10", 23, "baton", "szt.");
    IElement element1 = new Element(produkt1, "10");

    IProduct produkt2 = new Product("11", 23, "cukierek", "szt.");
    IElement element2 = new Element(produkt2, "8");

    IProduct produkt3 = new Product("12.123", 8, "uran", "tony");
    IElement element3 = new Element(produkt3, "2137.420");

    ArrayList<IElement> elements = new ArrayList<>();
    elements.add(element1);
    elements.add(element2);
    elements.add(element3);

    IInvoice faktura = new Invoice(elements);
    assertEquals(faktura.getTotalPriceBeforeTax(), 2609353);
  }

  @Test
  public void getWartoscNettoForVAT1() {

    IProduct produkt1 = new Product("10", 23, "baton", "szt.");
    IElement element1 = new Element(produkt1, "10");

    IProduct produkt2 = new Product("11", 23, "cukierek", "szt.");
    IElement element2 = new Element(produkt2, "8");

    IProduct produkt3 = new Product("12.123", 8, "uran", "tony");
    IElement element3 = new Element(produkt3, "2137.420");

    ArrayList<IElement> elements = new ArrayList<>();
    elements.add(element1);
    elements.add(element2);
    elements.add(element3);

    IInvoice faktura = new Invoice(elements);
    assertEquals(faktura.getWartoscNettoForVAT(23), 18800);
  }
  @Test
  public void getWartoscNettoForVAT2() {
    IProduct produkt1 = new Product("10", 23, "baton", "szt.");
    IElement element1 = new Element(produkt1, "10");

    IProduct produkt2 = new Product("11", 23, "cukierek", "szt.");
    IElement element2 = new Element(produkt2, "8");

    IProduct produkt3 = new Product("12.123", 8, "uran", "tony");
    IElement element3 = new Element(produkt3, "2137.420");

    ArrayList<IElement> elements = new ArrayList<>();
    elements.add(element1);
    elements.add(element2);
    elements.add(element3);

    IInvoice faktura = new Invoice(elements);
    assertEquals(faktura.getWartoscNettoForVAT(8), 2590553);
  }

  @Test
  public void getKwotaVATForVAT1() {
    IProduct produkt1 = new Product("10", 23, "baton", "szt.");
    IElement element1 = new Element(produkt1, "10");

    IProduct produkt2 = new Product("11", 23, "cukierek", "szt.");
    IElement element2 = new Element(produkt2, "8");

    IProduct produkt3 = new Product("12.123", 8, "uran", "tony");
    IElement element3 = new Element(produkt3, "2137.420");

    ArrayList<IElement> elements = new ArrayList<>();
    elements.add(element1);
    elements.add(element2);
    elements.add(element3);

    IInvoice faktura = new Invoice(elements);
    assertEquals(faktura.getKwotaVATForVAT(23), 4324);
  }
  @Test
  public void getKwotaVATForVAT2() {
    IProduct produkt1 = new Product("10", 23, "baton", "szt.");
    IElement element1 = new Element(produkt1, "10");

    IProduct produkt2 = new Product("11", 23, "cukierek", "szt.");
    IElement element2 = new Element(produkt2, "8");

    IProduct produkt3 = new Product("12.123", 8, "uran", "tony");
    IElement element3 = new Element(produkt3, "2137.420");

    ArrayList<IElement> elements = new ArrayList<>();
    elements.add(element1);
    elements.add(element2);
    elements.add(element3);

    IInvoice faktura = new Invoice(elements);
    assertEquals(faktura.getKwotaVATForVAT(8), 207244);
  }

  @Test
  public void getWartoscBruttoForVAT1() {
    IProduct produkt1 = new Product("10", 23, "baton", "szt.");
    IElement element1 = new Element(produkt1, "10");

    IProduct produkt2 = new Product("11", 23, "cukierek", "szt.");
    IElement element2 = new Element(produkt2, "8");

    IProduct produkt3 = new Product("12.123", 8, "uran", "tony");
    IElement element3 = new Element(produkt3, "2137.420");

    ArrayList<IElement> elements = new ArrayList<>();
    elements.add(element1);
    elements.add(element2);
    elements.add(element3);

    IInvoice faktura = new Invoice(elements);
    assertEquals(faktura.getWartoscBruttoForVAT(23), 23124);
  }
  @Test
  public void getWartoscBruttoForVAT2() {
    IProduct produkt1 = new Product("10", 23, "baton", "szt.");
    IElement element1 = new Element(produkt1, "10");

    IProduct produkt2 = new Product("11", 23, "cukierek", "szt.");
    IElement element2 = new Element(produkt2, "8");

    IProduct produkt3 = new Product("12.123", 8, "uran", "tony");
    IElement element3 = new Element(produkt3, "2137.420");

    ArrayList<IElement> elements = new ArrayList<>();
    elements.add(element1);
    elements.add(element2);
    elements.add(element3);

    IInvoice faktura = new Invoice(elements);
    assertEquals(faktura.getWartoscBruttoForVAT(8), 2797797);
  }
}