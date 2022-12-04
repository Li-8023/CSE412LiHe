import java.io.IOException;
import java.net.URL;
import java.sql.Connection;
import java.util.LinkedList;
import java.util.ResourceBundle;

import javafx.application.Application;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.scene.Node;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.ChoiceBox;
import javafx.scene.control.Label;
import javafx.scene.control.TextField;
import javafx.stage.Stage;

public class CategoryController implements Initializable{
	
//	public CategoryController(int blouse, int coat, int dress, int dungarees, int pajama, int suit) 
//	{
//		
//	}
	@FXML
    private Label blousePrice;
    @FXML
    private TextField blouseNum;
    @FXML
    private Label coatPrice;
    @FXML
    private TextField coatNum;
    @FXML
    private Label dressPrice;
    @FXML
    private TextField dressNum;
    @FXML
    private Label dungareesPrice;
    @FXML
    private TextField dungareesNum;

    @FXML
    private Label pajamaPrice;
    @FXML
    private TextField pajamaNum;

    @FXML
    private Label suitPrice;

    @FXML
    private TextField suitNum;
    
    private int blouse;
    private int coat;
    private int dress;
    private int dungarees;
    private int pajama;
    private int suit;
    private item item;
    private LinkedList<item> itemList;
    //int blouse = 0;

    /**
     * This is the actually the event handler for ADD TO CART button.
     * but i'm too tired to change the name :)
     * @param event
     */
    public void setBlouseQuantity(ActionEvent event)
    {
        DatabaseConnection dbConenction = new DatabaseConnection();
        Connection conn = dbConenction.getConnection();

        if(!blouseNum.getText().isEmpty()) {
            blouse = Integer.parseInt(blouseNum.getText());
            item blouse_item = new item("Blouse",blouse,blouse*15.0);
            dbConenction.addItemToCart(conn, blouse_item);

        }
        if(!coatNum.getText().isEmpty()) {
            coat = Integer.parseInt(coatNum.getText());
            item coat_item = new item("Coat",coat,coat*30.0);
            dbConenction.addItemToCart(conn, coat_item);
        }
        if(!dressNum.getText().isEmpty()) {
            dress = Integer.parseInt(dressNum.getText());
            item dress_item = new item("Dress",dress,dress*25.0);
            dbConenction.addItemToCart(conn, dress_item);
        }
        if(!pajamaNum.getText().isEmpty()) {
            pajama = Integer.parseInt(pajamaNum.getText());
            item pajama_item = new item("Pajama",pajama,pajama*20.0);
            dbConenction.addItemToCart(conn, pajama_item);
        }
        if(!suitNum.getText().isEmpty()) {
            suit = Integer.parseInt(suitNum.getText());
            item suit_item = new item("Suit",suit,suit*50.0);
            dbConenction.addItemToCart(conn, suit_item);
        }
        if(!dungareesNum.getText().isEmpty()) {
            dungarees = Integer.parseInt(dungareesNum.getText());
            item dung_item = new item("Dungarees",dungarees,dungarees*30.0);
            dbConenction.addItemToCart(conn, dung_item);
        }

       
    }

	public int getBlouseQuantity()
	{
		System.out.print("Quantity:" + blouse);
		return blouse;
	}
	public int getCoatQuantity()
	{
		return coat;
	}
	public int getDressQuantity()
	{
		return dress;
	}
	public int getDungareesQuantity()
	{
		return dungarees;
	}
	public int getPajamaQuantity()
	{
		return pajama;
	}
	public int getSuitQuantity()
	{
		return suit;
	}
	
	//When this function is called, it will change the scene
	//to the shopping cart view
	public void changeSceneToCart(ActionEvent event) throws IOException
	{
//		Parent tableViewParent = FXMLLoader.load(getClass().getResource("ShoppingCart.fxml"));
//		Scene tableViewScene = new Scene(tableViewParent);
//		
//		//This lines gets the stage information
//		Stage window = (Stage)((Node)event.getSource()).getScene().getWindow();
//		window.setScene(tableViewScene);
//		window.show();
		
		//CartController controller = FXMLLoader.getController();
		
//		//原本代码
//		FXMLLoader loader = new FXMLLoader();
//		loader.setLocation(getClass().getResource("ShoppingCart.fxml"));
//		Parent tableViewParent = loader.load();
//		Scene tableViewScene = new Scene(tableViewParent);
//		
//		CartController controller = loader.getController();
//		controller.getItem();
//		
//		Stage window = (Stage)((Node)event.getSource()).getScene().getWindow();
//		window.setScene(tableViewScene);
//		window.show();
//		//原本代码
		
		  Parent root = FXMLLoader.load(getClass().getResource("ShoppingCart.fxml"));
		  Stage stage = (Stage)((Node)event.getSource()).getScene().getWindow();
		  Scene scene = new Scene(root);
		  stage.setScene(scene);
		  stage.show();
		
	}
    
	@Override
	public void initialize(URL arg0, ResourceBundle arg1) {
		// TODO Auto-generated method stub
		
	}
//	
//	public ObservableList<item> getItem()
//	{
//		ObservableList<item> item = FXCollections.observableArrayList();
//		//CategoryController categoryCon = new CategoryController();
//		item.add(new item("Blouse", blouse, 15.00, 4.3));
//		item.add(new item("Coat", coat, 30.00, 4.5));
//		item.add(new item("Dress", dress, 25.00, 4.5));
//		item.add(new item("Dungarees", dungarees, 30.00, 4.5));
//		item.add(new item("Pajama", pajama, 20.00, 4.5));
//		item.add(new item("Suit", suit, 50.00, 4.5));
//		
//		return item;	
//	}
	
}
