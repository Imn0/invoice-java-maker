package fak.tura;

import java.io.IOException;

public class Main {
    public static void main(String[] args) {
        IInvoice faktura;
        try {
            IInvoiceCreator creator = new InvoiceCreator();
            faktura = creator.generateInvoice();

        } catch (IOException e) {
            System.out.println(e.getMessage());
            System.out.println("oops");
            return;
        }
        IShowFakura displayer = new Displayer(faktura);
        displayer.showFakura();


    }
}