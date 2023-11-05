package fak.tura;
import java.util.ArrayList;
import java.util.HashSet;


public class Faktura implements IFaktura{

  private Ikontrahent sprzedajacy;
  private Ikontrahent kupujacy;

  public void setSprzedajacy(Ikontrahent sprzedajacy){
    this.sprzedajacy = sprzedajacy;
  }
  public Ikontrahent getSprzedajacy(){
    return sprzedajacy;
  }

  public void setKupujacy(Ikontrahent kupujacy){
    this.kupujacy = kupujacy;
  }
  public Ikontrahent getKupujacy(){
    return kupujacy;
  }



  private String numerFaktury = "";
  public void setNumerFaktury(String numerFaktury) {
    this.numerFaktury = numerFaktury;
  }
  public String getNumerFaktury() {
    return numerFaktury;
  }

  private String dataWystawienia = "";
  public void setDataWystawienia(String dataWystawienia) {
    this.dataWystawienia = dataWystawienia;
  }
  public String getDataWystawienia() {
    return dataWystawienia;
  }

  private String dataUslugi = "";
  public void setDataUslugi(String dataUslugi) {
    this.dataUslugi = dataUslugi;
  }

  public String getDataUslugi() {
    return dataUslugi;
  }

  private String uwagi ="";
  public void setUwagi(String uwagi) {
    this.uwagi = uwagi;
  }
  public String getUwagi() {
    return uwagi;
  }

  private ArrayList<IElement> elements = new ArrayList<>();
  private int totalWartoscNetto;
  private int totalKwotaVAT;
  private int totalWartoscBrutto;
  private final HashSet<Integer> availableVATs = new HashSet<>();

  public Faktura() {}

  public Faktura(ArrayList<IElement> elements){
    this.elements = elements;

    setTotalWartoscNetto();
    setTotalKwotaVAT();
    setTotalWartoscBrutto();
    setAvailableVATs();
  }

  public void setElements(ArrayList<IElement> elements){
    this.elements = elements;

    setTotalWartoscNetto();
    setTotalKwotaVAT();
    setTotalWartoscBrutto();
    setAvailableVATs();
  }

  private void setAvailableVATs(){
    for(var element:elements){
      availableVATs.add(element.getVat());
    }
  }

  private void setTotalWartoscNetto() {
    int total = 0;
    for(var element:elements){
      total += element.getWartoscNetto();
    }
    this.totalWartoscNetto = total;
  }

  private void setTotalKwotaVAT() {
    int total = 0;
    for(var element:elements){
      total += element.getKowotaVAT();
    }
    this.totalKwotaVAT = total;
  }

  private void setTotalWartoscBrutto() {
    int total = 0;
    for(var element:elements){
      total += element.getWartoscBrutto();
    }
    this.totalWartoscBrutto = total;
  }

  public int getTotalWartoscNetto() {
    return totalWartoscNetto;
  }

  public int getTotalKwotaVAT() {
    return totalKwotaVAT;
  }

  public int getTotalWartoscBrutto() {
    return totalWartoscBrutto;
  }

  public ArrayList<IElement> getElements(){
    return elements;
  }

  public HashSet<Integer> getAvailableVATs() {
    return availableVATs;
  }
  public int getWartoscNettoForVAT(int vat) {
    int total = 0;
    for(var element: elements){
      if (element.getVat() == vat){
        total += element.getWartoscNetto();
      }
    }
    return total;
  }

  public int getKwotaVATForVAT(int vat) {
    int total = 0;
    for(var element: elements){
      if (element.getVat() == vat){
        total += element.getKowotaVAT();
      }
    }
    return total;
  }

  public int getWartoscBruttoForVAT(int vat) {
    int total = 0;
    for(var element: elements){
      if (element.getVat() == vat){
        total += element.getWartoscBrutto();
      }
    }
    return total;
  }
}
