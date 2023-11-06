package fak.tura.models;

import org.antlr.v4.runtime.misc.Pair;

import java.util.List;

/**
 * Protected variations
 */
public interface IPaymentMethod {
    List<Pair<String, String>> getFields();

}
