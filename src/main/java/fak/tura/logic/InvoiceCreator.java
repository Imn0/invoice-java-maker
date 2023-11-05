package fak.tura.logic;

import fak.tura.models.*;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;

public final class InvoiceCreator implements IInvoiceCreator {
    private final BufferedReader reader;

    public InvoiceCreator() {
        reader = new BufferedReader(new InputStreamReader(System.in));
    }

    public IInvoice generateInvoice() throws IOException {

        final IInvoice invoice = new Invoice();

        System.out.print("Podaj nazwę faktury: ");
        final String invoiceID = reader.readLine();
        invoice.setInvoiceID(invoiceID);

        System.out.print("Podaj datę wystawienia: ");
        final String invoiceDate = reader.readLine();
        invoice.setInvoiceDate(invoiceDate);

        System.out.print("Podaj datę sprzedarzy: ");
        final String saleDate = reader.readLine();
        invoice.setSaleDate(saleDate);

        System.out.println("Wprowadź sprzedającego");
        final IInvoiceParty seller = createInvoiceParty();
        System.out.println("Wprowadź kupującego");
        final IInvoiceParty buyer = createInvoiceParty();
        final IPaymentMethod paymentMethod = createPaymentMethod();

        boolean newProdukt = true;
        final ArrayList<IElement> elements = new ArrayList<>();

        while (newProdukt) {
            elements.add(createElement());
            String input;
            boolean gettingInput = true;
            while (gettingInput) {
                System.out.print("dodać kolejny produkt [y/n]");
                input = reader.readLine();
                char yesOption = 'y';
                char noOption = 'n';
                if (!input.isEmpty()) {
                    if (input.charAt(0) == yesOption) {
                        gettingInput = false;
                    } else if (input.charAt(0) == noOption) {
                        gettingInput = false;
                        newProdukt = false;
                    }
                }
            }
        }
        invoice.setBuyer(buyer);
        invoice.setSprzedajacy(seller);
        invoice.setElements(elements);
        invoice.setPaymentMethod(paymentMethod);
        return invoice;
    }

    private IPaymentMethod createPaymentMethod() throws IOException {
        IPaymentMethod paymentMethod;
        while (true) {
            try {
                System.out.println("Wybierz metodę płatności");
                System.out.println("gotówka - 1");
                char gotowkaOption = '1';
                System.out.println("przelew - 2");
                char przelewOption = '2';
                String input = reader.readLine();
                if (!input.isEmpty()) {
                    if (input.charAt(0) == gotowkaOption) {
                        paymentMethod = new CashPayment();
                        break;
                    } else if (input.charAt(0) == przelewOption) {
                        System.out.print("numer konta: ");
                        String accountNumber = reader.readLine();
                        System.out.print("bank: ");
                        String bankName = reader.readLine();
                        paymentMethod = new TransferPayment(bankName, accountNumber);
                        break;

                    }
                }
            } catch (NumberFormatException e) {
                System.out.println("Error dodaj produkt/usuługe jeszcze raz");
            }
        }
        return paymentMethod;
    }

    private IElement createElement() throws IOException {

        while (true) {
            try {
                System.out.println("Wprowadź produkt/uslugę");
                System.out.print("nazwa: ");
                final String nazwa = reader.readLine();

                System.out.print("jednostka miary: ");
                final String jednostkaMiary = reader.readLine();

                System.out.print("stawka vat: ");
                String svat = reader.readLine();
                svat = svat.replace('%', ' ');
                svat = svat.trim();

                final int vat = StringUtil.parseStringToValue(svat)[0];

                System.out.print("cenna netto: ");
                final String cenaNetto = reader.readLine();


                System.out.print("ilosc: ");
                final String ilosc = reader.readLine();
                return new Element(cenaNetto, vat, nazwa, jednostkaMiary, ilosc);
            } catch (NumberFormatException e) {
                System.out.println("Error dodaj produkt/usuługe jeszcze raz");
            }
        }

    }

    private IInvoiceParty createInvoiceParty() throws IOException {
        while (true) {
            boolean isCompany = true;
            boolean gettingInput = true;
            while (gettingInput) {
                System.out.println("Wybierz typ kontrahenta");
                System.out.println("firma - 1");
                char firmaOption = '1';
                System.out.println("osoba - 2");
                char osobaOption = '2';
                String input = reader.readLine();
                if (!input.isEmpty()) {
                    if (input.charAt(0) == firmaOption) {
                        gettingInput = false;
                    } else if (input.charAt(0) == osobaOption) {
                        gettingInput = false;
                        isCompany = false;
                    }
                }
            }
            String companyName = "";
            String name = "";
            String surname = "";

            if (isCompany) {
                System.out.print("nazwa: ");
                companyName = reader.readLine();
                if (companyName.isEmpty()) {
                    System.out.println("nazwa nie może być pusta");
                    continue;
                }
            } else {
                System.out.print("imię: ");
                name = reader.readLine();
                if (name.isEmpty()) {
                    System.out.println("imię nie może być puste");
                    continue;
                }
                System.out.print("nazwisko: ");
                surname = reader.readLine();
                if (surname.isEmpty()) {
                    System.out.println("nazwisko nie może być puste");
                    continue;
                }
            }

            System.out.print("adres: ");
            String adress = reader.readLine();

            System.out.print("nip: ");
            String taxIdentificationNumber = reader.readLine();
            String socialSecurityNumber = "";
            if (!isCompany) {
                System.out.print("Pesel: ");
                socialSecurityNumber = reader.readLine();
            }
            System.out.print("email: ");
            String email = reader.readLine();

            System.out.print("telefon: ");
            String phoneNumber = reader.readLine();

            IInvoiceParty party;
            if (isCompany) {
                party = new Company(companyName, adress, email, phoneNumber, taxIdentificationNumber);
            } else {
                Person osoba = new Person(name, surname, adress, email, phoneNumber);
                osoba.setTaxIdenificationNumber(taxIdentificationNumber);
                osoba.setPESEL(socialSecurityNumber);
                party = osoba;
            }
            return party;
        }
    }

}
