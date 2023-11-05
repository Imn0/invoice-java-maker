package fak.tura.models;

import org.antlr.v4.runtime.misc.Pair;

import java.util.List;
import java.util.Set;

public interface IInvoice {
    void setSprzedajacy(IInvoiceParty sprzedajacy);

    void setBuyer(IInvoiceParty buyer);

    String getInvoiceID();

    void setInvoiceID(String invoiceID);

    String getInvoiceDate();

    void setInvoiceDate(String invoiceDate);

    String getSaleDate();

    void setSaleDate(String saleDate);

    String getAdditionalInfo();

    void setAdditionalInfo(String additionalInfo);

    List<Pair<String, String>> getSellerFields();

    List<Pair<String, String>> getBuyerFields();

    List<Pair<String, String>> getPaymentMethodFields();

    void setPaymentMethod(IPaymentMethod paymentMethod);

    List<IElement> getElements();

    void setElements(List<IElement> elements);

    Set<Integer> getAvailableVATs();

    int getTotalPriceBeforeTax();

    int getTotalVatAmount();

    int getTotalPriceAfterTax();

    int getWartoscNettoForVAT(int vat);

    int getKwotaVATForVAT(int vat);

    int getWartoscBruttoForVAT(int vat);
}
