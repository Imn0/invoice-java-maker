package fak.tura.models;

import org.antlr.v4.runtime.misc.Pair;

import java.util.List;


public interface IInvoiceParty {
    /**
     * @return List of pairs like ( ("name", "Jacob"), ("surname", "Smith") )
     */
    List<Pair<String, String>> getFields();
}
