package fak.tura.repository;

import fak.tura.models.Element;
import fak.tura.models.Invoice;
import fak.tura.models.Product;
import org.springframework.stereotype.Component;

import java.math.BigDecimal;
import java.sql.*;
import java.util.List;


@Component("SQLrepository")
public class SQLrepository implements IRepository, IElementRepository {

    private final Connection connection;
    public SQLrepository() {
        String url = "jdbc:mysql://hostname:port/databasename";
        String username = "username";
        String password = "password";

        System.out.println("Connecting database...");

        try {
            connection = DriverManager.getConnection(url, username, password);
            System.out.println("Database connected!");
        } catch (SQLException e) {
            throw new IllegalStateException("Cannot connect the database!", e);
        }
    }

    private static long execute(PreparedStatement pstmt) {
        long id = 0;
        try {
            int affectedRows = pstmt.executeUpdate();
            // check the affected rows
            if (affectedRows > 0) {
                // get the ID back
                try (ResultSet rs = pstmt.getGeneratedKeys()) {
                    if (rs.next()) {
                        id = rs.getLong(1);
                    }
                } catch (SQLException ex) {
                    System.out.println(ex.getMessage());
                }
            }
        } catch (SQLException ex) {
            System.out.println(ex.getMessage());
        }
        return id;
    }

    @Override
    public long saveInvoice(final Invoice invoice) {
        String SQL = "INSERT INTO invoice(invoice_name,invoice_date, sale_date, seller_id, buyer_id, payment_id, basket_id) "
                + "VALUES(?, ?, ?, ?, ?, ?, ?)";

        long id = 0;
        long basketID = saveBasket(invoice.elements);

        try (PreparedStatement pstmt = connection.prepareStatement(SQL,
                     Statement.RETURN_GENERATED_KEYS)) {

            pstmt.setString(1, invoice.invoiceName);
            pstmt.setString(2, invoice.invoiceDate);
            pstmt.setString(3, invoice.saleDate);
            id = execute(pstmt);
        } catch (SQLException ex) {
            System.out.println(ex.getMessage());
        }

        return id;
    }

    private long saveBasket(List<Element> elements){
        String SQL = "INSERT INTO basket(element_id) "
                + "VALUES(?)";

        long id = 0;
        try (PreparedStatement pstmt = connection.prepareStatement(SQL,
                Statement.RETURN_GENERATED_KEYS)) {
            for(var element : elements){
                id = saveElement(element);
                pstmt.setLong(1, id);

                id = execute(pstmt);
            }

        } catch (SQLException ex) {
            System.out.println(ex.getMessage());
        }

        return id;
    }

    @Override
    public Invoice getInvoice(final String invoiceID) {
        return null;
    }

    @Override
    public long saveElement(Element element) {
        String SQL = "INSERT INTO element(product_id, amount) "
                + "VALUES(?, ?)";

        long id = 0;

        try (PreparedStatement pstmt = connection.prepareStatement(SQL,
                Statement.RETURN_GENERATED_KEYS)) {

            pstmt.setLong(1, saveProduct(element.product));
            pstmt.setObject(2, new BigDecimal(String.valueOf(element.amount)));
            id = execute(pstmt);
        } catch (SQLException ex) {
            System.out.println(ex.getMessage());
        }

        return id;
    }

    @Override
    public Element getElement(String elementID) {
        return null;
    }

    private long saveProduct(Product product){
        String SQL = "INSERT INTO product(product_name, quantity_unit, vat, unit_price) "
                + "VALUES(?, ?, ?, ?)";
        long id = 0;

        try (PreparedStatement pstmt = connection.prepareStatement(SQL,
                Statement.RETURN_GENERATED_KEYS)) {

            pstmt.setString(1, product.name);
            pstmt.setString(2, product.quantityUnit);
            pstmt.setObject(3, new BigDecimal(String.valueOf(product.vat)));
            pstmt.setObject(4, new BigDecimal(String.valueOf(product.priceBeforeTax)));
            id = execute(pstmt);
        } catch (SQLException ex) {
            System.out.println(ex.getMessage());
        }

        return id;
    }

}
