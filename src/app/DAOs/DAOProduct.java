package app.DAOs;
import app.DatabaseAdapter;
import app.models.Product;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

public class DAOProduct {
    private DatabaseAdapter data = DatabaseAdapter.getInstance();

    public List<Product> findall() {

        List<Product> result = new ArrayList<>();
        try {
            PreparedStatement prep2 = data.theConnection().prepareStatement("SELECT * FROM product");
//             +       " JOIN invoice WHERE invoice.invoice_id = product.product_id");
            ResultSet res2 = prep2.executeQuery();

            while (res2.next()) {
                String name = res2.getString("product_name");
                String description = res2.getString("description");
                int price = res2.getInt("price");
                int category = res2.getInt("category");
                int id = res2.getInt("product_id");
                Product product = new Product();
                product.setpName(name);
                product.setDescription(description);
                product.setCategory(category);
                product.setPrice(price);
                product.setpID(id);
                result.add(product);
            }

        } catch (SQLException e) {
            e.printStackTrace();
        }
        return result;
    }

    public void deleteProduct(Product product) {

        try {
            PreparedStatement delete = data.theConnection().prepareStatement("DELETE FROM product WHERE product_id= ?");
            delete.setInt(1, product.getpID());
            delete.executeUpdate();
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    public void changeProduct(Product product) {
        try {
            PreparedStatement change = data.theConnection().prepareStatement("UPDATE product SET price=?, product_name=?, description=?, category=? WHERE product_id=?");
            change.setInt(1, product.getPrice());
            change.setString(2, product.getpName());
            change.setString(3, product.getDescription());
            change.setInt(4, product.getCategory());
            change.setInt(5, product.getpID());
            change.executeUpdate();
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    public void addProduct(Product product) {
        try {
            PreparedStatement change = data.theConnection().prepareStatement("INSERT INTO product (price, product_name,description, category)" +
                    "VALUES (?, ?, ?, ?)");
            change.setInt(1, product.getPrice());
//            change.setString(3,customer.getAddress());
            change.setString(2, product.getpName());
            change.setString(3, product.getDescription());
            change.setInt(4, product.getCategory());
            change.executeUpdate();

        } catch (SQLException e) {
            e.printStackTrace();
        }
    }
}
