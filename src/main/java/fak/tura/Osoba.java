package fak.tura;

import org.antlr.v4.runtime.misc.Pair;

import java.util.ArrayList;

public class Osoba implements Ikontrahent{
    private String imie;
    private String nazwisko;
    private String adres;
    private String eMail;
    private String telefon;

    public void setNip(String nip) {
        this.nip = nip;
    }

    public void setPESEL(String PESEL) {
        this.PESEL = PESEL;
    }

    private String nip;
    private String PESEL;


    public Osoba(String imie, String nazwisko, String adres, String eMail, String telefon)
    {
        this.adres = adres;
        this.imie = imie;
        this.nazwisko = nazwisko;
        this.eMail = eMail;
        this.telefon = telefon;

    }

    public ArrayList<Pair<String, String>> getFields() {
        ArrayList<Pair<String,String>> fields = new ArrayList<Pair<String,String>>();
        Pair<String, String> field = new Pair<>("Nazwa:", imie + " " + nazwisko);
        fields.add(field);
        field = new Pair<>("Adres:", adres);
        fields.add(field);
        field = new Pair<>("Kontakt:", telefon + " " + eMail);
        fields.add(field);
        field = new Pair<>("NIP:", nip);
        fields.add(field);
        field = new Pair<>("PESEL:", PESEL);
        fields.add(field);

        return fields;
    }
}
