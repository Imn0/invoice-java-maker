package fak.tura;


import fak.tura.models.IInvoice;

public interface IRepository {
     void saveInvoice(IInvoice invoice);
     IInvoice getInvoice(String invoiceID);
}
