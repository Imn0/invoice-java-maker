package fak.tura;


import fak.tura.models.Element;
import fak.tura.models.IInvoiceParty;
import fak.tura.models.Invoice;
import fak.tura.models.Product;

public interface IRepository {
     void saveInvoice(Invoice invoice);
     Invoice getInvoice(String invoiceID);

     void saveElement(Element element);
     Element getElement(String elementID);

     void saveInvoiceParty(IInvoiceParty invoiceParty);
     IInvoiceParty getInvoiceParty(String invoicePartyID);
}
