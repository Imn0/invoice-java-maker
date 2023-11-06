package fak.tura.logic;
import fak.tura.models.Invoice;
import java.io.IOException;

public interface IInvoiceCreator {
    Invoice generateInvoice() throws IOException;
}
