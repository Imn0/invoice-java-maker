package fak.tura;

import de.vandermeer.asciitable.AT_Row;
import de.vandermeer.asciitable.AsciiTable;
import de.vandermeer.skb.interfaces.transformers.textformat.TextAlignment;

import java.util.ArrayList;

public class Displayer implements IShowFakura{
  IFaktura faktura;

  public Displayer(IFaktura faktura){
    this.faktura = faktura;
  }

  public void showFakura() {
    ArrayList<IElement> elements = faktura.getElements();
    AsciiTable at = new AsciiTable();

    AT_Row row;
    at.addRule();
    row = at.addRow("nazwa", "Jm.", "ilość", "Cena netto", "Wartość netto", "Stawka VAT", "Kwota VAT", "Wartość brutto");
    row.setTextAlignment(TextAlignment.RIGHT);
    at.addRule();
    for (var element : elements) {
      row = at.addRow(element.getProdukt(), element.getJendostkaMiary(),element.getIlosc(), StringUtil.getStringFromValue(element.getCenaNetto()), StringUtil.getStringFromValue(element.getWartoscNetto()), element.getVat() + "%", StringUtil.getStringFromValue(element.getKowotaVAT()), StringUtil.getStringFromValue(element.getWartoscBrutto()));
      row.setTextAlignment(TextAlignment.RIGHT);
      at.addRule();
    }
    for(int vat: faktura.getAvailableVATs()){
      row = at.addRow(null, null, "", "W tym", StringUtil.getStringFromValue(faktura.getWartoscNettoForVAT(vat)), vat+"%", StringUtil.getStringFromValue(faktura.getKwotaVATForVAT(vat)), StringUtil.getStringFromValue(faktura.getWartoscBruttoForVAT(vat)));
      row.setTextAlignment(TextAlignment.RIGHT);
    }
    at.addRule();
    row = at.addRow(null, null, "", "Razem", StringUtil.getStringFromValue(faktura.getTotalWartoscNetto()), "", StringUtil.getStringFromValue(faktura.getTotalKwotaVAT()), StringUtil.getStringFromValue(faktura.getTotalWartoscBrutto()));
    row.setTextAlignment(TextAlignment.RIGHT);
    at.addRule();
    String rend = at.render();
    System.out.println(rend);
  }
}

