package fak.tura;

import fak.tura.logic.Displayer;
import fak.tura.logic.IInvoiceCreator;
import fak.tura.logic.IShowFakura;
import fak.tura.logic.InvoiceCreator;
import fak.tura.models.IInvoice;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

import javax.annotation.PostConstruct;
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;

@SpringBootApplication
public class Main {

    @Autowired
    private IRepository repository;

    public static void main(final String[] args) {
        SpringApplication.run(Main.class, args);
    }

    @PostConstruct
    public void execute() throws IOException {
        if (repository == null) {
            System.out.println("repository is null");
            return;
        }
        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
        ArrayList<IInvoice> invoices = new ArrayList<>();
        IInvoice invoice = null;

        System.out.println("Witamy w kreatorze faktur 2000");
        boolean exit = false;
        String input;
        while (!exit)
        {
            System.out.println("Wybierz opcję:\n" +
                    "1. Dodaj fakturę\n" +
                    "2. Wyświetl fakturę\n" +
                    "3. Pokaż faktury\n" +
                    "4. Zapisz fakurę\n" +
                    "5. Wybierz fakturę\n" +
                    "q. Wyjdź");
            if (invoice == null){
                System.out.println("Obecnie nie wybrano faktury");
            } else {
                System.out.println("Wybrano fakturę: " + invoice.getInvoiceID());
            }
            System.out.print("Wybór: ");
            input = reader.readLine();
            if (input.isEmpty()) {
                continue;
            }
            switch (input.charAt(0)){
                case '1':
                    IInvoiceCreator creator = new InvoiceCreator();
                    invoices.add(creator.generateInvoice());
                    break;
                case '2':
                    if (invoice == null){
                        System.out.println("Nie wybrano faktury");
                    } else {
                        IShowFakura displayer = new Displayer(invoice);
                        displayer.showFakura();
                    }
                    break;
                case '3':
                    for (int i = 0; i < invoices.size(); i++) {
                        System.out.println(i + ". " + invoices.get(i).getInvoiceID());
                    }
                    break;
                case '4':
                    if(invoice == null){
                        System.out.println("Nie wybrano faktury");
                    } else {
                        repository.saveInvoice(invoice);
                    }
                    break;
                case '5':
                    System.out.println("Podaj numer faktury: ");
                    int index = Integer.parseInt(reader.readLine());
                    if (index >= invoices.size()){
                        System.out.println("Nie ma takiej faktury");
                    } else {
                        invoice = invoices.get(index);
                    }
                    break;
                case 'q':
                    exit = true;
                    break;
                default:
                    System.out.println("Nieznana opcja");
            }
        }
    }
}

