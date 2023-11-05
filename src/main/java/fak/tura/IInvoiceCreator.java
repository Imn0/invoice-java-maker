package fak.tura;

import java.io.IOException;

public interface IInvoiceCreator {
    IInvoice generateInvoice() throws IOException;
}
