package fak.tura.logic;
import fak.tura.models.Element;
import org.springframework.stereotype.Component;

/**
 * High cohesion, low coupling, pure fabrication
 */
@Component
public class ElementCalculator implements IElementCalculator{

    public ElementCalculator() {
    }
    public FixedPointNumber calculateTotalPriceBeforeTax(Element element) {
        FixedPointNumber result = new FixedPointNumber(element.amount);
        result.mul(element.product.priceBeforeTax);
        return result;
    }
    public FixedPointNumber calculateTotalTaxAmount(Element element){
        FixedPointNumber result = new FixedPointNumber(element.amount);
        result.mul(element.product.priceBeforeTax);
        result.mul(element.product.vat);
        return result;
    }

    public FixedPointNumber calucateTotalPriceAfterTax(Element element){
        FixedPointNumber result = new FixedPointNumber(element.amount);
        result.mul(element.product.priceBeforeTax);
        result.mul(element.product.vat);
        result.add(calculateTotalPriceBeforeTax(element));
        return result;
    }

}
