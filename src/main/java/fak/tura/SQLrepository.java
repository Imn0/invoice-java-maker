package fak.tura;

import fak.tura.models.Element;
import fak.tura.models.IInvoiceParty;
import fak.tura.models.Invoice;
import org.springframework.stereotype.Component;



@Component("SQLrepository")
public class SQLrepository implements IRepository{
    @Override
    public void saveInvoice(final Invoice invoice) { }
    @Override
    public Invoice getInvoice(final String invoiceID) {
        return new Invoice(null,null, null, null, null, null, null, null);
    }

    @Override
    public void saveElement(Element element) {
    }

    @Override
    public Element getElement(String elementID) {
        return null;
    }

    @Override
    public void saveInvoiceParty(IInvoiceParty invoiceParty) {

    }

    @Override
    public IInvoiceParty getInvoiceParty(String invoicePartyID) {
        return null;
    }
}
