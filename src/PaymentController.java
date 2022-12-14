import java.io.IOException;
import java.sql.Connection;

import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Node;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.CheckBox;
import javafx.scene.control.TextField;
import javafx.scene.text.Text;
import javafx.stage.Stage;

public class PaymentController {
	@FXML
    private TextField billingAddress;

    @FXML
    private TextField cardNumber;

    @FXML
    private CheckBox copyShipAddr;

    @FXML
    private CheckBox saveCardNum;

    @FXML
    private Button saveInfo;

    @FXML
    private Text prompt;
    
    @FXML
    private Text saveText;
    
    private String cardNum;
    private String addr;

	public void switchToCart(ActionEvent event) throws IOException
	{
		cardNum = cardNumber.getText();
		addr = billingAddress.getText();
		if(cardNum.trim().isEmpty() || addr.trim().isEmpty())
		{
			prompt.setText("One or more fields cannot be empty.");
		}
		else
		{
			// TODO: save the credit card number
			prompt.setText("");
			Parent root = FXMLLoader.load(getClass().getResource("ShoppingCart.fxml"));
			Stage stage = (Stage)((Node)event.getSource()).getScene().getWindow();
			Scene scene = new Scene(root);
			stage.setScene(scene);
			stage.show();
		}
		  
	}
	
	public void saveSuccess(ActionEvent event) throws IOException
	{
		saveText.setText("You have successfully save the information!!!");
	}
	
	public void copyShipAddr(ActionEvent event) throws IOException
	{
		if(copyShipAddr.isSelected())
		{
			//String query = "select address from customer where user_id = ?";
			DatabaseConnection dbConnection = new DatabaseConnection();
	        Connection conn = dbConnection.getConnection();
	        String address = dbConnection.copyShip(conn);
	        billingAddress.setText(address);
	        System.out.println("Controller Address:" + address);
	        System.out.println("Sucessfully copy the address");
		}
		else
		{
			System.out.println("No action");
		}
		
	}

}





