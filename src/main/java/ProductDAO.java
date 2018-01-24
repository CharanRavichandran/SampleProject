
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;
import javax.sql.DataSource;

public class ProductDAO {
    public String url = "jdbc:mysql://localhost:3306/JspDb";
    
        public List<Product> list() throws SQLException {
            List<Product> products = new ArrayList<Product>();
    
            try (
                Connection connection = DriverManager.getConnection(url, "root", "");
                // Connection connection = dataSource.getConnection();
                PreparedStatement statement = connection.prepareStatement("SELECT id, name, description, quantity FROM product");
                ResultSet resultSet = statement.executeQuery();
            ) {
                while (resultSet.next()) {
                    Product product = new Product();
                    product.setId(resultSet.getInt("id"));
                    product.setName(resultSet.getString("name"));
                    product.setDescription(resultSet.getString("description"));
                    product.setQuantity(resultSet.getInt("quantity"));
                    products.add(product);
                }
            }
    System.out.println(products);
            return products;
        }
    
    }
	