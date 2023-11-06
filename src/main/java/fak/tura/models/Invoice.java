package fak.tura.models;

import fak.tura.logic.FixedPointNumber;

import java.util.HashSet;
import java.util.List;
import java.util.Set;


/**
 * Information expert
 */
public class Invoice {

    public Set<FixedPointNumber> getAvailableVATs() {
        return availableVATs;
    }
    private final Set<FixedPointNumber> availableVATs = new HashSet<>();
    public final IInvoiceParty seller;
    public final IInvoiceParty buyer;
    public final IPaymentMethod paymentMethod;
    public final String invoiceID;
    public final String invoiceDate;
    public final String saleDate;
    public String additionalInfo = "";
    public final List<Element> elements;



    public Invoice(final List<Element> elements, final IInvoiceParty seller, final IInvoiceParty buyer, final String invoiceID, final String invoiceDate, final String saleDate, final String additionalInfo, final IPaymentMethod paymentMethod) {
        this.elements = elements;
        this.seller = seller;
        this.buyer = buyer;
        this.invoiceID = invoiceID;
        this.invoiceDate = invoiceDate;
        this.saleDate = saleDate;
        this.additionalInfo = additionalInfo;
        this.paymentMethod = paymentMethod;
        setAvaiableVats();
    }

    private void setAvaiableVats(){
        for(Element element : elements){
            availableVATs.add(element.product.vat);
        }
        System.out.println(availableVATs);
    }

}
