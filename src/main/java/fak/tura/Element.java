package fak.tura;

public class Element {
  private Produkt produkt;
  private String ilosc;

  private String jedonstaMiary;

  public Element(Produkt produkt, String ilosc, String jedonstaMiary){
    this.ilosc = ilosc;
    this.produkt = produkt;
    this.jedonstaMiary = jedonstaMiary;
  }

  public String getJedonstaMiary() {
    return jedonstaMiary;
  }

  public int getWartoscNetto() {
    int[] c = StringUtil.parseStringToValue(ilosc);
    int iloscCalkowita = c[0];
    int iloscUlamkowa = c[1];

    int cena = produkt.getCenaNetto();

    return cena * iloscCalkowita + ( (cena*iloscUlamkowa) /100 );

  }

  public int getKowotaVAT(){
    return 1;
  }

  public int getWartoscBrutto(){
    return 1;
  }

}
