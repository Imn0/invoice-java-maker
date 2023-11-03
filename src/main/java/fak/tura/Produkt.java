package fak.tura;

public class Produkt implements IProdukt{
  private int cenaNetto;
  private int vat;
  private String nazwa;
  private String jednostkaMiary;
  public Produkt(String cenaNetto, int vat, String nazwa, String jednostkaMiary){
    int[] cena = StringUtil.parseStringToValue(cenaNetto);
    this.cenaNetto = cena[0]*100 + cena[1];
    this.vat = vat;
    this.nazwa = nazwa;
    this.jednostkaMiary = jednostkaMiary;
  }

  public int getCenaNetto() {
    return cenaNetto;
  }
  public int getVat() {
    return vat;
  }
  public String getNazwa(){
    return nazwa;
  }
  public String getJednostkaMiary(){
    return jednostkaMiary;
  }

}
