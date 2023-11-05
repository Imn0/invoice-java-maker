package fak.tura;

import org.antlr.v4.runtime.misc.Pair;

import java.util.ArrayList;

public class Firma implements Ikontrahent{

    private String nazwa;
    private String adres;
    private String eMail;
    private String telefon;
    private String nip;

    public Firma(String nazwa, String adres, String eMail, String telefon, String nip)
    {
        this.adres = adres;
        this.nazwa = nazwa;
        this.eMail = eMail;
        this.telefon = telefon;
        this.nip = nip;
    }

    public String getName() {
        return nazwa;
    }

    public String getAdress() {
        return adres;
    }

    public String getContactInfo() {
        return telefon + " " + eMail;
    }

    public String getNIP() {
        return nip;
    }

    public ArrayList<Pair<String, String>> getFields() {
        return null;
    }
}
