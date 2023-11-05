package fak.tura;

import java.util.ArrayList;
import java.util.*;

public interface IFaktura {
  public void setSprzedajacy(Ikontrahent sprzedajacy);
  public Ikontrahent getSprzedajacy();
  public void setKupujacy(Ikontrahent kupujacy);
  public Ikontrahent getKupujacy();
  public void setNumerFaktury(String numerFaktury);
  public void setDataWystawienia(String dataWystawienia);
  public void setDataUslugi(String dataUslugi);
  public void setUwagi(String uwagi);
  public String getNumerFaktury();
  public String getDataWystawienia();
  public String getDataUslugi();
  public String getUwagi() ;
  public void setElements(ArrayList<IElement> elements);
  public ArrayList<IElement> getElements();
  public HashSet<Integer> getAvailableVATs();
  public int getTotalWartoscNetto();
  public int getTotalKwotaVAT();
  public int getTotalWartoscBrutto();
  public int getWartoscNettoForVAT(int vat);
  public int getKwotaVATForVAT(int vat);
  public int getWartoscBruttoForVAT(int vat);
}
