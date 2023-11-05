package fak.tura;

import fak.tura.models.IInvoice;
import fak.tura.models.Invoice;
import org.springframework.stereotype.Component;



@Component("SQLrepository")
public class SQLrepository implements IRepository{
    public void saveInvoice(final IInvoice invoice) { }
    public IInvoice getInvoice(final String invoiceID) {
        return new Invoice();
    }
}
