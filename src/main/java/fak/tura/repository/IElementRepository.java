package fak.tura.repository;

import fak.tura.models.Element;

public interface IElementRepository {
    long saveElement(Element element);

    Element getElement(String elementID);
}
