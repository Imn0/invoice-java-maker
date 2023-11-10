package fak.tura.models;

import org.antlr.v4.runtime.misc.Pair;

import java.util.ArrayList;
import java.util.List;

public class Company implements IInvoiceParty {

    private final String name;
    private final String adress;
    private final String email;
    private final String phoneNumber;
    private final String taxIdentificationNumber;

    public Company(final String name, final String adress, final String email, final String phoneNumber, final String taxIdentificationNumber) {
        this.adress = adress;
        this.name = name;
        this.email = email;
        this.phoneNumber = phoneNumber;
        this.taxIdentificationNumber = taxIdentificationNumber;
    }

    @Override
    public final List<Pair<String, String>> getFields() {
        List<Pair<String, String>> fields = new ArrayList<>();
        Pair<String, String> field = new Pair<>("Name:", name);
        fields.add(field);
        field = new Pair<>("Adress:", adress);
        fields.add(field);
        field = new Pair<>("Phone:", phoneNumber);
        fields.add(field);
        field = new Pair<>("email:", email);
        fields.add(field);
        field = new Pair<>("Tax identification:", taxIdentificationNumber);
        fields.add(field);

        return fields;
    }
}
