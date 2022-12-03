import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.Statement;
import java.util.Set;

public class DatabaseConnection {
    public Connection conn;
    private Customer mCustomer;
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
    public void customerLogin(Connection conn, Customer customer) {
        mCustomer = customer;
        String table_name = "customer";
        Statement statement;
        try {
            String query = String.format("insert into %s(user_id, username, first_name, last_name, password, email, address) " +
                    "values('%d','%s','%s','%s','%s','%s','%s');",table_name, customer.getId(), customer.getFirstname()+customer.getLastname(), customer.getFirstname(), customer.getLastname(),
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
            System.out.println("Information fetched");
        } catch (Exception e) {
            System.out.println(e);
        }

    }

    /**
     * This function saves customer's credit card number into the PAYMENT table
     * A hash function will delegate its payment_id and map it with the customer's id on CUSPAY table
     * @param conn
     * @param customer that owns the credit card
     */
    public void saveCreditCard(Connection conn, Customer customer, String cardNumber) {
        Statement statement;
        try {
            // hash function for generating payment_id
            int pay_id = 150;
            int hash = 7;
            for (int i = 0; i < customer.getFirstname().length(); i++) {
                hash = hash*31 + customer.getFirstname().charAt(i);
            }
            pay_id += hash;
            String query1 = String.format("insert to payment(payment_id, amount, acctNumber) values('%d','%f','%s');",pay_id, 0, cardNumber);
            statement = conn.createStatement();
            statement.executeUpdate(query1);
            System.out.println("Saved in PAYMENT table"); // logging

            // map the customer id and payment id in CUSPAY
            String query2 = String.format("insert to cuspay(user_id, payment_id) values('%d','%d');", pay_id, mCustomer.getId());
            statement = conn.createStatement();
            statement.executeUpdate(query1);
            System.out.println("Saved in CUSPAY table"); // logging

        } catch (Exception e) {
            System.out.println(e);
        }

    }
}
