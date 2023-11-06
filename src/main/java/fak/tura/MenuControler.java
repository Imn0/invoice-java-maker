package fak.tura;

import fak.tura.logic.IInvoiceCreator;
import fak.tura.logic.IShowInvoice;
import fak.tura.models.Invoice;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.List;

/**
 * Controler
 * */
@Controller
public class MenuControler implements IMenu {

    private final IRepository repository;
    private final IShowInvoice displayer;
    private final BufferedReader reader;
    private final IInvoiceCreator creator;
    private final List<Invoice> invoices;
    @Autowired
    public MenuControler(IRepository repository, IShowInvoice displayer, IInvoiceCreator creator) {
        this.repository = repository;
        this.displayer = displayer;
        this.creator = creator;
        invoices = new ArrayList<>();
        reader = new BufferedReader(new InputStreamReader(System.in));
    }

    public void Loop() throws IOException {
        if (repository == null) {
            System.out.println("repository is null");
            return;
        }
        Invoice invoice = null;

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
                System.out.println("Wybrano fakturę: " + invoice.invoiceID);
            }
            System.out.print("Wybór: ");
            input = reader.readLine();
            if (input.isEmpty()) {
                continue;
            }
            switch (input.charAt(0)){
                case '1':
                    invoice = creator.generateInvoice();
                    invoices.add(invoice);
                    System.out.println("Dodano oraz wybrano fakturę");
                    break;
                case '2':
                    if (invoice == null){
                        System.out.println("Nie wybrano faktury");
                    } else {
                        displayer.showInvoice(invoice);
                    }
                    break;
                case '3':
                    for (int i = 0; i < invoices.size(); i++) {
                        System.out.println(i + ". " + invoices.get(i).invoiceID);
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