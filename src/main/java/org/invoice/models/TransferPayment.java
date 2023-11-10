package org.invoice.models;

import org.antlr.v4.runtime.misc.Pair;

import java.util.ArrayList;
import java.util.List;

public class TransferPayment implements IPaymentMethod {

    private final String accountNumber;
    private final String name;
    private final String bankName;

    public TransferPayment(final String bankName, final String accountNumber) {
        this.accountNumber = accountNumber;
        this.name = "bank transfer";
        this.bankName = bankName;
    }

    public List<Pair<String, String>> getFields() {
        List<Pair<String, String>> fields = new ArrayList<>();
        Pair<String, String> field = new Pair<>("Method:", name);
        fields.add(field);
        field = new Pair<>("Account number:", accountNumber);
        fields.add(field);
        field = new Pair<>("Bank", bankName);
        fields.add(field);
        return fields;
    }
}
