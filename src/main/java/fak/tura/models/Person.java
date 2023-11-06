package fak.tura.models;

import org.antlr.v4.runtime.misc.Pair;

import java.util.ArrayList;
import java.util.List;


public class Person implements IInvoiceParty {
    private final String name;
    private final String surname;
    private final String adress;
    private final String email;
    private final String phoneNumber;
    private String taxIdenificationNumber;
    private String socialSecurityNumber;

    public Person(final String imie, final String surname, final String adres, final String email, String phoneNumber) {
        this.adress = adres;
        this.name = imie;
        this.surname = surname;
        this.email = email;
        this.phoneNumber = phoneNumber;

    }

    public void setTaxIdenificationNumber(final String taxIdenificationNumber) {
        this.taxIdenificationNumber = taxIdenificationNumber;
    }

    public void setPESEL(final String socialSecurityNumber) {
        this.socialSecurityNumber = socialSecurityNumber;
    }

    public List<Pair<String, String>> getFields() {
        List<Pair<String, String>> fields = new ArrayList<>();
        Pair<String, String> field = new Pair<>("Nazwa:", name + " " + surname);
        fields.add(field);
        field = new Pair<>("Adres:", adress);
        fields.add(field);
        field = new Pair<>("Telefon:", phoneNumber);
        fields.add(field);
        field = new Pair<>("email:", email);
        fields.add(field);
        if (taxIdenificationNumber != null && !taxIdenificationNumber.isEmpty()) {
            field = new Pair<>("NIP:", taxIdenificationNumber);
            fields.add(field);
        }
        if (socialSecurityNumber != null && !socialSecurityNumber.isEmpty()) {
            field = new Pair<>("PESEL:", socialSecurityNumber);
            fields.add(field);
        }
        return fields;
    }
}
