package org.invoice.logic;
import org.invoice.models.Invoice;
import java.io.IOException;

public interface IInvoiceCreator {
    Invoice generateInvoice() throws IOException;
}
