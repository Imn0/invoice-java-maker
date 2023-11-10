package org.invoice.repository;

import org.invoice.models.Element;

public interface IElementRepository {
    long saveElement(Element element);

    Element getElement(String elementID);
}
