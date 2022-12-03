import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.Statement;
import java.util.Set;

public class DatabaseConnection {
    public Connection conn;
    public String[] myarray = new String[10];//String array declaration with size
    public Connection getConnection() {
        String dbname = "CSE412";
        String user = "postgres";
        String password = "Hl011028";
        String url = "jdbc:postgresql://localhost:5432/";

        try {
            Class.forName("org.postgresql.Driver");
            conn = DriverManager.getConnection(url+dbname, user, password);
            if(conn!=null) {
                System.out.println("Connection successful");
            } else {
                System.out.println("Connection failed");
            }

        } catch (Exception e) {
            System.out.println(e);
        }

        return conn;
    }

    /**
     * Inputs the customer login information into the Customer database
     */
    private int customerId = 100;
    public void customerLogin(Connection conn, Customer customer) {
        String table_name = "customer";
        Statement statement;
        try {
            int hash = 7;
            for (int i = 0; i < customer.getFirstname().length(); i++) {
                hash = hash*31 + customer.getFirstname().charAt(i);
            }
            customerId += hash;
            String query = String.format("insert into %s(user_id, username, first_name, last_name, password, email, address) " +
                    "values('%d','%s','%s','%s','%s','%s','%s');",table_name, customerId, customer.getFirstname()+customer.getLastname(), customer.getFirstname(), customer.getLastname(),
                    customer.getPassword(), customer.getEmail(), customer.getAddress());
            statement = conn.createStatement();
            statement.executeUpdate(query);
            System.out.println("Customer added to database."); // logging
        } catch (Exception e) {
            System.out.println(e);
        }
    }

    /**
     * Add a cart item into the cart_item database
     */
    public void addItemToCart(Connection conn) {
        String table_name = "cart_item";
        Statement statement;
//        try
//        {
////        	String query = String format("insert into %d(cart_id, total_cost, product_id, quantity)" + 
////        			"values('%d', '%s', '%s', ")
//        }
    }

    public void checkLogin(Connection conn) {
        String table_name = "customer";
        Statement statement;
        try {
            String query = String.format("select email, password from %s", table_name);
            statement = conn.createStatement();
            ResultSet rs = statement.executeQuery(query);
            while (rs.next()) {
                String id  = rs.getString("user_id");
                String email = rs.getString("email");
                String password = rs.getString("password");
                myarray[0]= id;
                myarray[1]= email;
                myarray[2]= password;
                System.out.println(email + "," + password);
            }
            System.out.println("Information fetched");
        } catch (Exception e) {
            System.out.println(e);
        }
    }
}