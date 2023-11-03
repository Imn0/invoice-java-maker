package fak.tura;

public class Element implements IElement{
  private final IProdukt produkt;
  private final String ilosc;
  private int wartoscNetto;
  private int kowtaVat;
  private int wartoscBrutto;

  public Element(IProdukt produkt, String ilosc){
    this.ilosc = ilosc;
    this.produkt = produkt;

    setWartoscNetto();
    setKowtaVat();
    setWartoscBrutto();
  }

  private void setWartoscNetto() {
    int[] c = StringUtil.parseStringToValue(ilosc,3);

    int iloscCalkowita = c[0];
    int iloscUlamkowa = c[1];
    int cena = produkt.getCenaNetto();

    this.wartoscNetto = (cena * iloscCalkowita + ( (cena*iloscUlamkowa) /1000 ));
  }

  private void setKowtaVat() {
    this.kowtaVat =  wartoscNetto * produkt.getVat()/100;
  }

  private void setWartoscBrutto() {
    this.wartoscBrutto = kowtaVat + wartoscNetto;
  }

  public String getProdukt() {
    return produkt.getNazwa();
  }

  public String getJendostkaMiary() {
    return produkt.getJednostkaMiary();
  }

  public int getCenaNetto() {
    return produkt.getCenaNetto();
  }

  public int getVat() {
    return produkt.getVat();
  }

  public int getWartoscNetto() {
    return wartoscNetto;
  }

  public int getKowotaVAT(){
    return kowtaVat;
  }

  public int getWartoscBrutto(){
    return wartoscBrutto;
  }
  public String getIlosc(){return ilosc;}
}
