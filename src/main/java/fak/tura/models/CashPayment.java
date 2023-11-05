package fak.tura.models;

import org.antlr.v4.runtime.misc.Pair;

import java.util.ArrayList;
import java.util.List;

public class CashPayment implements IPaymentMethod {

    /**
     * Cash payment method.
     */
    private final String name;

    /**
     * Status of payment.
     */
    private String status;

    /**
     * Payment due date.
     */
    private String paymentDueDate;


    /**
     * Constructor.
     */
    public CashPayment() {
        name = "Gotówka";
    }

    public void setStatus(final String status) {
        this.status = status;
    }

    public void setPaymentDueDate(final String paymentDueDate) {
        this.paymentDueDate = paymentDueDate;
    }

    @Override
    public List<Pair<String, String>> getFields() {
        List<Pair<String, String>> fields = new ArrayList<>();
        Pair<String, String> field = new Pair<>("Płatność:", name);
        fields.add(field);
        if (status != null && !status.isEmpty()) {
            field = new Pair<>("Status:", status);
            fields.add(field);
        }
        if (paymentDueDate != null && !paymentDueDate.isEmpty()) {
            field = new Pair<>("Termin płatności:", paymentDueDate);
            fields.add(field);
        }
        return fields;
    }
}
