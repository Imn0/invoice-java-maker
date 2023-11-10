package org.invoice.logic;

import org.invoice.models.*;
import org.springframework.stereotype.Component;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;



@Component
public final class InvoiceCreator implements IInvoiceCreator {
    private final BufferedReader reader;

    public InvoiceCreator() {
        reader = new BufferedReader(new InputStreamReader(System.in));
    }

    public Invoice generateInvoice() throws IOException {


        System.out.print("Invoice ID: ");
        final String invoiceID = reader.readLine();

        System.out.print("Invoice date: ");
        final String invoiceDate = reader.readLine();

        System.out.print("Sale date: ");
        final String saleDate = reader.readLine();

        System.out.println("Input seller");
        final IInvoiceParty seller = createInvoiceParty();
        System.out.println("Input buyer");
        final IInvoiceParty buyer = createInvoiceParty();
        final IPaymentMethod paymentMethod = createPaymentMethod();

        boolean newProdukt = true;
        final ArrayList<Element> elements = new ArrayList<>();

        while (newProdukt) {
            elements.add(createElement());
            String input;
            boolean gettingInput = true;
            while (gettingInput) {
                System.out.print("add another product? [y/n] ");
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

        return new Invoice(elements, seller, buyer, invoiceID, invoiceDate, saleDate, "",paymentMethod);
    }

    private IPaymentMethod createPaymentMethod() throws IOException {
        IPaymentMethod paymentMethod;
        while (true) {
            try {
                System.out.println("Select payment method");
                System.out.println("cash - 1");
                char gotowkaOption = '1';
                System.out.println("bank transfer - 2");
                char przelewOption = '2';
                String input = reader.readLine();
                if (!input.isEmpty()) {
                    if (input.charAt(0) == gotowkaOption) {
                        paymentMethod = new CashPayment();
                        break;
                    } else if (input.charAt(0) == przelewOption) {
                        System.out.print("account number: ");
                        String accountNumber = reader.readLine();
                        System.out.print("bank: ");
                        String bankName = reader.readLine();
                        paymentMethod = new TransferPayment(bankName, accountNumber);
                        break;

                    }
                }
            } catch (NumberFormatException e) {
                System.out.println("Error add payment method again");
            }
        }
        return paymentMethod;
    }

    private Element createElement() throws IOException {

        while (true) {
            try {
                System.out.println("Wprowadź produkt/uslugę");
                System.out.print("name: ");
                final String nazwa = reader.readLine();

                System.out.print("quantity unit: ");
                final String jednostkaMiary = reader.readLine();

                System.out.print("VAT rate: ");
                String svat = reader.readLine();
                svat = svat.replace('%', ' ');
                svat = svat.trim();

                final int vat = Integer.parseInt(svat);

                System.out.print("unit price before tax: ");
                final String cenaNetto = reader.readLine();


                System.out.print("amount: ");
                final String ilosc = reader.readLine();
                return new Element(cenaNetto, vat, nazwa, jednostkaMiary, ilosc);
            } catch (NumberFormatException e) {
                System.out.println("Error add element again");
            }
        }

    }

    private IInvoiceParty createInvoiceParty() throws IOException {
        while (true) {
            boolean isCompany = true;
            boolean gettingInput = true;
            while (gettingInput) {
                System.out.println("Choose type of party");
                System.out.println("company - 1");
                char firmaOption = '1';
                System.out.println("person - 2");
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
                System.out.print("name: ");
                companyName = reader.readLine();
                if (companyName.isEmpty()) {
                    System.out.println("name cannot be empty");
                    continue;
                }
            } else {
                System.out.print("name: ");
                name = reader.readLine();
                if (name.isEmpty()) {
                    System.out.println("name cannot be empty");
                    continue;
                }
                System.out.print("surname: ");
                surname = reader.readLine();
                if (surname.isEmpty()) {
                    System.out.println("surname cannot be empty");
                    continue;
                }
            }

            System.out.print("adress: ");
            String adress = reader.readLine();

            System.out.print("tax identification number: ");
            String taxIdentificationNumber = reader.readLine();
            String socialSecurityNumber = "";
            if (!isCompany) {
                System.out.print("social security: ");
                socialSecurityNumber = reader.readLine();
            }
            System.out.print("email: ");
            String email = reader.readLine();

            System.out.print("phone: ");
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