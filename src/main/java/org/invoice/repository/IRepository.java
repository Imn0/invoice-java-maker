package org.invoice.repository;



import org.invoice.models.Invoice;


public interface IRepository {
     long saveInvoice(Invoice invoice);
     Invoice getInvoice(String invoiceID);

}
