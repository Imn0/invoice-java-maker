package fak.tura.logic;

import de.vandermeer.asciitable.AT_Row;
import de.vandermeer.asciitable.AsciiTable;
import de.vandermeer.skb.interfaces.transformers.textformat.TextAlignment;
import fak.tura.models.IInvoice;
import org.antlr.v4.runtime.misc.Pair;

import java.util.List;

public class Displayer implements IShowFakura {
    private final IInvoice invoice;

    public Displayer(final IInvoice invoice) {
        this.invoice = invoice;
    }
    @Override
    public void showFakura() {
        AT_Row row;
        try {
            AsciiTable headerTable = new AsciiTable();
            headerTable.addRule();
            row = headerTable.addRow("Faktura VAT");
            row.setTextAlignment(TextAlignment.CENTER);
            headerTable.addRule();
            row = headerTable.addRow("Nr: " + invoice.getInvoiceID());
            row.setTextAlignment(TextAlignment.CENTER);
            headerTable.addRule();
            row = headerTable.addRow("Data wystawienia: " + invoice.getInvoiceDate());
            row.setTextAlignment(TextAlignment.CENTER);
            headerTable.addRule();
            row = headerTable.addRow("Data sprzedaży: " + invoice.getSaleDate());
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
            List<Pair<String, String>> sellerFields = invoice.getSellerFields();
            List<Pair<String, String>> buyerFields = invoice.getBuyerFields();
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
            for (var element : invoice.getElements()) {
                row = elementsTable.addRow(element.getProduct(), element.getQuantityUnit(), element.getAmount(), StringUtil.getStringFromValue(element.getCenaNetto()), StringUtil.getStringFromValue(element.getPriceBeforeTAX()), element.getVat() + "%", StringUtil.getStringFromValue(element.getTaxAmount()), StringUtil.getStringFromValue(element.getPriceAfterTAX()));
                row.setTextAlignment(TextAlignment.RIGHT);
                elementsTable.addRule();
            }
            for (int vat : invoice.getAvailableVATs()) {
                row = elementsTable.addRow(null, null, "", "W tym", StringUtil.getStringFromValue(invoice.getWartoscNettoForVAT(vat)), vat + "%", StringUtil.getStringFromValue(invoice.getKwotaVATForVAT(vat)), StringUtil.getStringFromValue(invoice.getWartoscBruttoForVAT(vat)));
                row.setTextAlignment(TextAlignment.RIGHT);
            }
            elementsTable.addRule();
            row = elementsTable.addRow(null, null, "", "Razem", StringUtil.getStringFromValue(invoice.getTotalPriceBeforeTax()), "", StringUtil.getStringFromValue(invoice.getTotalVatAmount()), StringUtil.getStringFromValue(invoice.getTotalPriceAfterTax()));
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
            List<Pair<String, String>> paymentMethodFields = invoice.getPaymentMethodFields();
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

