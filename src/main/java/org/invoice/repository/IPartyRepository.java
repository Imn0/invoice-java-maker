package org.invoice.repository;

import org.invoice.models.IInvoiceParty;

public interface IPartyRepository {
    long saveInvoiceParty(IInvoiceParty invoiceParty);

    IInvoiceParty getInvoiceParty(String invoicePartyID);
}
