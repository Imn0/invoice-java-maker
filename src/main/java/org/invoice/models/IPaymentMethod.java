package org.invoice.models;

import org.antlr.v4.runtime.misc.Pair;

import java.util.List;


public interface IPaymentMethod {
    List<Pair<String, String>> getFields();

}
