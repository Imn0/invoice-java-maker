package fak.tura.models;

import org.antlr.v4.runtime.misc.Pair;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;


public class Invoice implements IInvoice {

    private final Set<Integer> availableVATs = new HashSet<>();
    private IInvoiceParty seller;
    private IInvoiceParty buyer;
    private IPaymentMethod paymentMethod;
    private String invoiceID = "";
    private String invoiceDate = "";
    private String saleDate = "";
    private String additionalInfo = "";
    private List<IElement> elements = new ArrayList<>();
    private int totalPriceBeforeTax;
    private int totalVatAmount;
    private int totalPriceAfterTax;

    public Invoice() {
    }

    public Invoice(final List<IElement> elements) {
        this.elements = elements;

        setTotalWartoscNetto();
        setTotalKwotaVAT();
        setTotalWartoscBrutto();
        setAvailableVATs();
    }

    public void setSprzedajacy(final IInvoiceParty sprzedajacy) {
        this.seller = sprzedajacy;
    }
    @Override
    public void setBuyer(final IInvoiceParty buyer) {
        this.buyer = buyer;
    }
    @Override
    public String getInvoiceID() {
        return invoiceID;
    }
    @Override
    public void setInvoiceID(final String invoiceID) {
        this.invoiceID = invoiceID;
    }
    @Override
    public String getInvoiceDate() {
        return invoiceDate;
    }
    @Override
    public void setInvoiceDate(final String invoiceDate) {
        this.invoiceDate = invoiceDate;
    }
    @Override
    public String getSaleDate() {
        return saleDate;
    }
    @Override
    public void setSaleDate(final String saleDate) {
        this.saleDate = saleDate;
    }
    @Override
    public String getAdditionalInfo() {
        return additionalInfo;
    }
    @Override
    public void setAdditionalInfo(final String additionalInfo) {
        this.additionalInfo = additionalInfo;
    }
    @Override
    public List<Pair<String, String>> getSellerFields() {
        return seller.getFields();
    }
    @Override
    public List<Pair<String, String>> getBuyerFields() {
        return buyer.getFields();
    }
    @Override
    public List<Pair<String, String>> getPaymentMethodFields() {
        return paymentMethod.getFields();
    }
    @Override
    public void setPaymentMethod(final IPaymentMethod paymentMethod) {
        this.paymentMethod = paymentMethod;
    }

    private void setAvailableVATs() {
        for (var element : elements) {
            availableVATs.add(element.getVat());
        }
    }

    private void setTotalWartoscNetto() {
        int total = 0;
        for (var element : elements) {
            total += element.getPriceBeforeTAX();
        }
        this.totalPriceBeforeTax = total;
    }

    private void setTotalKwotaVAT() {
        int total = 0;
        for (var element : elements) {
            total += element.getTaxAmount();
        }
        this.totalVatAmount = total;
    }

    private void setTotalWartoscBrutto() {
        int total = 0;
        for (var element : elements) {
            total += element.getPriceAfterTAX();
        }
        this.totalPriceAfterTax = total;
    }

    public int getTotalPriceBeforeTax() {
        return totalPriceBeforeTax;
    }

    public int getTotalVatAmount() {
        return totalVatAmount;
    }

    public int getTotalPriceAfterTax() {
        return totalPriceAfterTax;
    }

    public List<IElement> getElements() {
        return elements;
    }

    public void setElements(final List<IElement> elements) {
        this.elements = elements;

        setTotalWartoscNetto();
        setTotalKwotaVAT();
        setTotalWartoscBrutto();
        setAvailableVATs();
    }

    public Set<Integer> getAvailableVATs() {
        return availableVATs;
    }

    public int getWartoscNettoForVAT(final int vat) {
        int total = 0;
        for (var element : elements) {
            if (element.getVat() == vat) {
                total += element.getPriceBeforeTAX();
            }
        }
        return total;
    }

    public int getKwotaVATForVAT(final int vat) {
        int total = 0;
        for (var element : elements) {
            if (element.getVat() == vat) {
                total += element.getTaxAmount();
            }
        }
        return total;
    }

    public int getWartoscBruttoForVAT(final int vat) {
        int total = 0;
        for (var element : elements) {
            if (element.getVat() == vat) {
                total += element.getPriceAfterTAX();
            }
        }
        return total;
    }
}