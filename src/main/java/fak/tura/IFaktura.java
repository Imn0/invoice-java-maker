package fak.tura;

import java.util.ArrayList;
import java.util.*;

public interface IFaktura {
  public ArrayList<IElement> getElements();
  public HashSet<Integer> getAvailableVATs();
  public int getTotalWartoscNetto();
  public int getTotalKwotaVAT();
  public int getTotalWartoscBrutto();
  public int getWartoscNettoForVAT(int vat);
  public int getKwotaVATForVAT(int vat);
  public int getWartoscBruttoForVAT(int vat);
}
