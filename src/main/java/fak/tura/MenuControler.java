package fak.tura;

import fak.tura.logic.IInvoiceCreator;
import fak.tura.logic.IShowInvoice;
import fak.tura.models.Invoice;
import fak.tura.repository.IRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.List;

/**
 * Controler for menu loop
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
//        if (repository == null) {
//            System.out.println("Error initializing repository");
//            return;
//        }
        Invoice invoice = null;

        boolean exit = false;
        String input;
        while (!exit)
        {
            System.out.println("Choose option:\n" +
                    "1. Create an invoice\n" +
                    "2. Show selected invoice\n" +
                    "3. Show invloice list\n" +
                    "4. Save invoice\n" +
                    "5. Choose an invoice\n" +
                    "q. Exit");
            if (invoice == null){
                System.out.println("No invoice selected");
            } else {
                System.out.println("Selected invoice: " + invoice.invoiceName);
            }
            System.out.print("Option: ");
            input = reader.readLine();
            if (input.isEmpty()) {
                continue;
            }
            switch (input.charAt(0)){
                case '1':
                    invoice = creator.generateInvoice();
                    invoices.add(invoice);
                    System.out.println("Added an invoice");
                    break;
                case '2':
                    if (invoice == null){
                        System.out.println("No invloice chosen");
                    } else {
                        displayer.showInvoice(invoice);
                    }
                    break;
                case '3':
                    for (int i = 0; i < invoices.size(); i++) {
                        System.out.println(i + ". " + invoices.get(i).invoiceName);
                    }
                    break;
                case '4':
                    if(invoice == null){
                        System.out.println("No invoice chosen");
                    } else {
                        repository.saveInvoice(invoice);
                    }
                    break;
                case '5':
                    System.out.println("Select invoice: ");
                    int index = Integer.parseInt(reader.readLine());
                    if (index >= invoices.size()){
                        System.out.println("Invalid invoice index");
                    } else {
                        invoice = invoices.get(index);
                    }
                    break;
                case 'q':
                    exit = true;
                    break;
                default:
                    System.out.println("Unknown option");
            }
        }
    }
}
