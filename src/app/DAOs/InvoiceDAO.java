package app.DAOs;
import app.DatabaseAdapter;
import app.models.Invoice;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

public class InvoiceDAO {
    DatabaseAdapter data = DatabaseAdapter.getInstance();
    PreparedStatement prep2;

    /**
     * Fetches all invoices of the given user
     *
     * @param //customer to fetch for
     * @return All invoices from given user
     */
    public List<Invoice> getAllInvoicesByCustomer()
    {
        List<Invoice> result = new ArrayList<>();
        try {
            prep2 = data.theConnection().prepareStatement("SELECT * FROM invoice"); //JOIN customer ON invoice.customer=customer.customer_id");
            ResultSet res2 = prep2.executeQuery();
            while (res2.next()) {
                // fetch fields from result:
                String dato = res2.getString("dato");
                int customer = res2.getInt("customer");
                int invoiceId = res2.getInt("invoice_id");
                // create new address object:
                Invoice invoice = new Invoice();
                invoice.setInvoiceDate(dato);
                invoice.setInvoiceID(invoiceId);
                invoice.setCustomer(customer);

                result.add(invoice);
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return result;
    }

    public void deleteInvoice(Invoice invoice) {
        try {
            PreparedStatement delete = data.theConnection().prepareStatement("DELETE FROM invoice WHERE invoice_id=?");
            delete.setInt(1, invoice.getInvoiceID());
            delete.executeUpdate();
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    public void changeInvoice(Invoice invoice) {
        try {
            PreparedStatement change = data.theConnection().prepareStatement("UPDATE invoice SET customer=?, dato=? WHERE invoice_id= ?");
            change.setInt(1, invoice.getCustomer());
            change.setString(2, invoice.getInvoiceDate());
            change.setInt(3, invoice.getInvoiceID());
            change.executeUpdate();
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }


    public void addInvoice(Invoice invoice) {
        try {
            PreparedStatement change = data.theConnection().prepareStatement("INSERT INTO invoice(customer, dato)" +
                    "VALUES (?, ?)");
            change.setInt(1, invoice.getCustomer());
            change.setString(2, invoice.getInvoiceDate());
            change.executeUpdate();
        } catch (SQLException e) {
            e.printStackTrace();

        }
    }
    }
