package fak.tura.logic;

import de.vandermeer.asciitable.AT_Row;
import de.vandermeer.asciitable.AsciiTable;
import de.vandermeer.skb.interfaces.transformers.textformat.TextAlignment;
import fak.tura.models.Invoice;
import org.antlr.v4.runtime.misc.Pair;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import java.util.List;

/**
 * Pure fabrication
 */
@Component
public class Displayer implements IShowInvoice {
    private final IElementCalculator ElementCalculator;
    private final IInvoiceCalculator InvoiceCalculator;
    @Autowired
    public Displayer(IElementCalculator elementCalculator, IInvoiceCalculator invoiceCalculator){
        ElementCalculator = elementCalculator;
        InvoiceCalculator = invoiceCalculator;
    }
    @Override
    public void showInvoice(Invoice invoice){
        AT_Row row;
        try {
            AsciiTable headerTable = new AsciiTable();
            headerTable.addRule();
            row = headerTable.addRow("Faktura VAT");
            row.setTextAlignment(TextAlignment.CENTER);
            headerTable.addRule();
            row = headerTable.addRow("Nr: " + invoice.invoiceID);
            row.setTextAlignment(TextAlignment.CENTER);
            headerTable.addRule();
            row = headerTable.addRow("Data wystawienia: " + invoice.invoiceDate);
            row.setTextAlignment(TextAlignment.CENTER);
            headerTable.addRule();
            row = headerTable.addRow("Data sprzedaży: " + invoice.saleDate);
            row.setTextAlignment(TextAlignment.CENTER);
            headerTable.addRule();
            String header = headerTable.render();
            System.out.println(header);
        } catch (Exception e) {
            System.out.println("Błąd wyświetlania nagłówka");
            System.out.println(e.getMessage());
        }
        try {
            AsciiTable partiesTable = new AsciiTable();
            partiesTable.addRule();
            row = partiesTable.addRow(null, "Sprzedawca", null, "Nabywca");
            row.setTextAlignment(TextAlignment.CENTER);
            partiesTable.addRule();
            List<Pair<String, String>> sellerFields = invoice.seller.getFields();
            List<Pair<String, String>> buyerFields = invoice.buyer.getFields();
            int firstLoopLimit = Math.min(sellerFields.size(), buyerFields.size());
            int loopCounter;
            for (loopCounter = 0; loopCounter < firstLoopLimit; loopCounter++) {
                partiesTable.addRow(sellerFields.get(loopCounter).a, sellerFields.get(loopCounter).b, buyerFields.get(loopCounter).a, buyerFields.get(loopCounter).b);
                partiesTable.addRule();
            }
            if (sellerFields.size() > buyerFields.size()) {
                for (; loopCounter < sellerFields.size(); loopCounter++) {
                    partiesTable.addRow(sellerFields.get(loopCounter).a, sellerFields.get(loopCounter).b, "", "");
                    partiesTable.addRule();
                }
            } else {
                for (; loopCounter < buyerFields.size(); loopCounter++) {
                    partiesTable.addRow("", "", buyerFields.get(loopCounter).a, buyerFields.get(loopCounter).b);
                    partiesTable.addRule();
                }
            }

            String parties = partiesTable.render();
            System.out.println(parties);
        } catch (Exception e) {
            System.out.println("Błąd wyświetlania tabeli z danymi sprzedawcy i nabywcy");
        }

        try {
            AsciiTable elementsTable = new AsciiTable();

            elementsTable.addRule();
            row = elementsTable.addRow("nazwa", "Jm.", "ilość", "Cena netto", "Wartość netto", "Stawka VAT", "Kwota VAT", "Wartość brutto");
            row.setTextAlignment(TextAlignment.RIGHT);
            elementsTable.addRule();
            for (var element : invoice.elements) {
                row = elementsTable.addRow(element.product.name, element.product.quantityUnit, element.amount, element.product.priceBeforeTax, ElementCalculator.calculateTotalPriceBeforeTax(element), element.product.vat, ElementCalculator.calculateTotalTaxAmount(element), ElementCalculator.calucateTotalPriceAfterTax(element));
                row.setTextAlignment(TextAlignment.RIGHT);
                elementsTable.addRule();
            }
            for (var vat : invoice.getAvailableVATs()) {
                row = elementsTable.addRow(null, null, "", "W tym", InvoiceCalculator.totalBeforeTax(invoice, vat), vat, InvoiceCalculator.totalTax(invoice, vat), InvoiceCalculator.totalAfetTax(invoice, vat));
                row.setTextAlignment(TextAlignment.RIGHT);
            }
            elementsTable.addRule();
            row = elementsTable.addRow(null, null, "", "Razem", InvoiceCalculator.totalBeforeTax(invoice), "", InvoiceCalculator.totalTax(invoice), InvoiceCalculator.totalAfetTax(invoice));
            row.setTextAlignment(TextAlignment.RIGHT);
            elementsTable.addRule();
            String rend = elementsTable.render();
            System.out.println(rend);

        } catch (Exception e) {
            System.out.println("Błąd wyświetlania tabeli z danymi elementów");
        }

        try {
            AsciiTable paymentMethodTable = new AsciiTable();
            paymentMethodTable.addRule();
            List<Pair<String, String>> paymentMethodFields = invoice.paymentMethod.getFields();
            for (Pair<String, String> paymentMethodField : paymentMethodFields) {
                paymentMethodTable.addRow(paymentMethodField.a, paymentMethodField.b);
                paymentMethodTable.addRule();
            }
            String rend = paymentMethodTable.render();
            System.out.println(rend);
        } catch (Exception e) {
            System.out.println("Błąd wyświetlania tabeli z danymi płatności");
            System.out.println(e.getMessage());
        }


    }
}

