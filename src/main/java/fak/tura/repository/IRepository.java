package fak.tura.repository;



import fak.tura.models.Invoice;


public interface IRepository {
     long saveInvoice(Invoice invoice);
     Invoice getInvoice(String invoiceID);

}
