package fak.tura;

import java.io.IOException;
import java.util.ArrayList;

public class Main {

  public static void test1(){
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

    IFaktura faktura = new Faktura(elements);
    Displayer displayer = new Displayer(faktura);
    displayer.showFakura();
  }
  public static void main(String[] args)  {
//    test1();
    IFaktura faktura = new Faktura();
    try {
      faktura = Creator.generateFaktura();

    } catch (IOException e) {
      System.out.println("oops");
    }
    IShowFakura displayer = new Displayer(faktura);
    displayer.showFakura();


  }
}