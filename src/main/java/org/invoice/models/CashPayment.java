package org.invoice.models;

import org.antlr.v4.runtime.misc.Pair;

import java.util.ArrayList;
import java.util.List;

public class CashPayment implements IPaymentMethod {

    /**
     * Cash payment method.
     */
    private final String name;

    /**
     * Constructor.
     */
    public CashPayment() {
        name = "Cash";
    }


    @Override
    public List<Pair<String, String>> getFields() {
        List<Pair<String, String>> fields = new ArrayList<>();
        Pair<String, String> field = new Pair<>("Payment:", name);
        fields.add(field);

        return fields;
    }
}
