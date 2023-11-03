package fak.tura;
import java.util.ArrayList;
import java.lang.reflect.Method;
import java.util.HashSet;


public class Faktura implements IFaktura{
  private final ArrayList<IElement> elements;
  private int totalWartoscNetto;
  private int totalKwotaVAT;
  private int totalWartoscBrutto;
  private final HashSet<Integer> availableVATs = new HashSet<>();

  public Faktura(ArrayList<IElement> elements){
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
