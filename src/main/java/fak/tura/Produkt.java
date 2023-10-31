package fak.tura;

public class Produkt {
  private int cenaNetto;
  private int vat;
  private String nazwa;
  public Produkt(String cenaNetto, int vat, String nazwa){
    int[] cena = StringUtil.parseStringToValue(cenaNetto);
    this.cenaNetto = cena[0]*100 + cena[1];
    this.vat = vat;
    this.nazwa = nazwa;
  }

  public int getCenaNetto() {
    return cenaNetto;
  }
  public int getVat() {
    return vat;
  }
  public void setVat(int vat) {
    this.vat = vat;
  }

  public String getNazwa() {
    return nazwa;
  }
}
