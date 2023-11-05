package fak.tura;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;

public class Creator implements ICreator{
    public static IFaktura generateFaktura() throws IOException {
        System.out.println("Witamy w kreatorze faktur 2000");
        BufferedReader reader = new BufferedReader(
                new InputStreamReader(System.in));

        IFaktura faktura = new Faktura();

        System.out.print("Podaj nazwę faktury: ");
        String numerFaktury = reader.readLine();
        faktura.setNumerFaktury(numerFaktury);

        System.out.print("Podaj datę wystawienia: ");
        String dataWystawienia = reader.readLine();
        faktura.setDataWystawienia(dataWystawienia);

        System.out.print("Podaj datę sprzedarzy: ");
        String dataSprzedazy = reader.readLine();
        faktura.setDataUslugi(dataSprzedazy);

        Ikontrahent sprzedajacy = Creator.createKontrahent();
        Ikontrahent kupujacy = Creator.createKontrahent();


        boolean newProdukt = true;
        ArrayList<IElement> elements = new ArrayList<>();

        while (newProdukt) {
            elements.add(Creator.createElement());
            String input;
            boolean gettingInput = true;
            while (gettingInput) {
                System.out.print("dodać kolejny produkt [y/n]");
                input = reader.readLine();
                if (!input.isEmpty()) {
                    if (input.charAt(0) == 'y') {
                        gettingInput = false;
                    } else if (input.charAt(0) == 'n'){
                        gettingInput = false;
                        newProdukt = false;
                    }
                }
            }
        }
        faktura.setKupujacy(kupujacy);
        faktura.setSprzedajacy(sprzedajacy);
        faktura.setElements(elements);
        return faktura;
    }

    private static IElement createElement() throws IOException{
        BufferedReader reader = new BufferedReader(
                new InputStreamReader(System.in));

        while (true){
            try {
                System.out.println("Wprowadź produkt/uslugę");
                System.out.print("nazwa: ");
                String nazwa = reader.readLine();

                System.out.print("jednostka miary: ");
                String Jm = reader.readLine();

                System.out.print("stawka vat: ");
                String svat = reader.readLine();
                svat = svat.replace('%', ' ');
                svat = svat.trim();

                int vat = StringUtil.parseStringToValue(svat)[0];

                System.out.print("cenna netto: ");
                String cenaNetto = reader.readLine();

                IProdukt produkt = new Produkt(cenaNetto, vat, nazwa, Jm);

                System.out.print("ilosc: ");
                String ilosc = reader.readLine();
                return new Element(produkt, ilosc);
            } catch (NumberFormatException e){
                System.out.println("Error dodaj produkt/usuługe jeszcze raz");
            }
        }

    }

    private static Ikontrahent createKontrahent() throws IOException{
        BufferedReader reader = new BufferedReader(
                new InputStreamReader(System.in));
        while (true){
            boolean isFirma = true;
            boolean gettingInput = true;
            while (gettingInput) {
                System.out.println("Wybierz typ kontrahenta");
                System.out.println("firma - 1");
                System.out.println("osoba - 2");
                String input = reader.readLine();
                if (!input.isEmpty()) {
                    if (input.charAt(0) == '1') {
                        gettingInput = false;
                        isFirma = true;
                    } else if (input.charAt(0) == '2'){
                        gettingInput = false;
                        isFirma = false;
                    }
                }
            }
            String nazwa = "";
            String imie = "";
            String nazwisko = "";

            if(isFirma)
            {
                System.out.print("nazwa: ");
                nazwa = reader.readLine();
            }
            else{
                System.out.print("imię: ");
                imie = reader.readLine();

                System.out.print("nazwisko: ");
                nazwisko = reader.readLine();
            }

            System.out.print("adres: ");
            String adres = reader.readLine();

            System.out.print("nip: ");
            String nip = reader.readLine();
            String pesel = "";
            if(!isFirma)
            {
                System.out.print("Pesel: ");
                pesel = reader.readLine();
            }
            System.out.print("email: ");
            String email = reader.readLine();

            System.out.print("telefon: ");
            String telefom = reader.readLine();


            if (isFirma)
                return new Firma(nazwa, adres, email, telefom, nip);
            else{
                Osoba osoba = new Osoba(imie, nazwisko, adres, email, telefom);
                osoba.setNip(nip);
                osoba.setPESEL(pesel);
                return osoba;
            }

        }
    }

}
