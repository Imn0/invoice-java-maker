package fak.tura.repository;

import fak.tura.models.IInvoiceParty;

public interface IPartyRepository {
    long saveInvoiceParty(IInvoiceParty invoiceParty);

    IInvoiceParty getInvoiceParty(String invoicePartyID);
}
