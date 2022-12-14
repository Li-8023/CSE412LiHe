import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.Statement;
import java.util.Set;

public class DatabaseConnection {
    public Connection conn;
    boolean checkUsernameAndPassword;
    public static int CUSTOMER_ID;
    String COMP_USER; // use this to specify who is the user, only for testing purposes
    public Connection getConnection() {
        //COMP_USER = "adeline";
        String dbname = "CSE412";
        String user = "postgres";
        String password = "Hl011028";

        if(COMP_USER.equals("adeline")) {
            System.out.println("user: " +user);
            dbname = "CSE412Project";
            password = "cse412db";
        }
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
            CUSTOMER_ID = customerId; // set the global variable CUSTOMER_ID to the customerId that we just created
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
    public void addItemToCart(Connection conn, item mItem)
    {
        String table_name = "cart_item";
        Statement statement;
        // HINT: CART_ID IS EQUAL TO CUSTOMER_ID
        try {
            // add item to cart_item table
            String query = String.format("insert to cart_item(cart_id, total_cost, product_id, quantity) " +
                    "values('%d','%f','%d','%d');", CUSTOMER_ID, mItem.getTotalPrice(), mItem.getProductId(), mItem.getQuantity());
            statement = conn.createStatement();
            statement.executeUpdate(query);
            System.out.println("Item(s) added to cart"); // logging
        } catch (Exception e) {
            System.out.println(e);
        }
    }

    public boolean checkLogin(Connection conn,String a, String b) {
        String table_name = "customer";
        Statement statement;
        try {
            String query = String.format("select user_id, email, password from %s", table_name);
            statement = conn.createStatement();
            ResultSet rs = statement.executeQuery(query);
            while (rs.next()) {
            	CUSTOMER_ID  = rs.getInt("user_id");
                String email = rs.getString("email");
                String password = rs.getString("password");
                
                System.out.println(email + "," + password);
                System.out.println("a" + a);
                System.out.println("b" + b);
                System.out.println("email" + email);
                System.out.println("password"+ password);
                System.out.println("Database login ID: " + CUSTOMER_ID);
                if(email.equals(a) && password.equals(b)){
                	System.out.println("match");
                    return true;
                }else{
                	System.out.println("NO match");
                    return false;
                }
            }
            System.out.println("Information fetched");
        } catch (Exception e) {
            System.out.println(e);
        }
        
        return false;
    }
    
  public String copyShip(Connection conn)
  {
  	String table_name = "customer";
  	Statement statement;
  	String address = "";
  	try
  	{
  		System.out.println("copy address user id: " + CUSTOMER_ID);
  		String query = String.format("select address from %s where user_id = %d", table_name, CUSTOMER_ID);
  		statement = conn.createStatement();
        ResultSet rs = statement.executeQuery(query);
        
        while (rs.next()) {
            address = rs.getString("address");
            System.out.println("Database Address:" + address);
            return address;
        }
  		System.out.println("Successful copy shipping address to billing address");
  		System.out.println("Database id:" + CUSTOMER_ID);
  		
  	}catch(Exception e)
  	{
  		System.out.println(e);
  	}
  	return address;
  }
}

   
//}
