package fak.tura.logic;

import fak.tura.models.IInvoice;

import java.io.IOException;

public interface IInvoiceCreator {
    IInvoice generateInvoice() throws IOException;
}
