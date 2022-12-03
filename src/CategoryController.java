import java.io.IOException;
import java.net.URL;
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
import javafx.scene.text.Text;

public class CategoryController implements Initializable{
	
//	public CategoryController(int blouse, int coat, int dress, int dungarees, int pajama, int suit) 
//	{
//		
//	}
    //send data

    @FXML
//    private void sendData(MouseEvent event) {
//        // Step 1
//        Order order1 = new Order();
//        // Step 2
//        Node node = (Node) event.getSource();
//        // Step 3
//        Stage stage = (Stage) node.getScene().getWindow();
//        stage.close();
//        try {
//            // Step 4
//            Parent root = FXMLLoader.load(getClass().getClassLoader().getResource("ShoppingCart.fxml"));
//            // Step 5
//            stage.setUserData(order1);// data java.class
//            // Step 6
//            Scene scene = new Scene(root);
//            stage.setScene(scene);
//            // Step 7
//            stage.show();
//        } catch (IOException e) {
//            System.err.println(String.format("Error: %s", e.getMessage()));
//        }
//    }
//	@FXML
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
    private ObservableList<item> data;
    //int blouse = 0;
    public void setBlouseQuantity(ActionEvent event)
    {
       blouse = Integer.parseInt(blouseNum.getText());
//       item = new item("Blouse", blouse, 15.0, 4.5);
//       itemList.add(item);
       System.out.print(blouse);

    }
    
    //int coat;
    public void setCoatQuantity(ActionEvent event)
    {
    	coat = Integer.parseInt(coatNum.getText());
    }
    

    //int dress;
    public void setDressQuantity(ActionEvent event)
    {
    	dress = Integer.parseInt(dressNum.getText());
    }
    //int dungarees;
    public void setDungareesQuantity(ActionEvent event)
    {
    	dungarees = Integer.parseInt(dungareesNum.getText());
    }
    
    
    //int pajama;
    public void setPajamaQuantity(ActionEvent event)
    {
    	pajama = Integer.parseInt(pajamaNum.getText());
    	
    }
    
    //int suit;
    public void setSuitQuantity(ActionEvent event)
    {
    	suit = Integer.parseInt(suitNum.getText());
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
		//parsing info
        String blouseNumText = blouseNum.getText();
        String coatNumText = coatNum.getText();
        String dressNumText = dressNum.getText();
        String dungareesNumText = dungareesNum.getText();
        String pajamaNumText = pajamaNum.getText(); //test for pajama
        String suitNumText = suitNum.getText();
        int blouseQuantity = Integer.valueOf(blouseNumText);
        int coatQuantity = Integer.valueOf(coatNumText);
        int dressQuantity = Integer.valueOf(dressNumText);
        int dungareesQuantity = Integer.valueOf(dungareesNumText);
        int pajamaQuantity = Integer.valueOf(pajamaNumText);
        int suitQuantity = Integer.valueOf(suitNumText);

        Parent root;
        FXMLLoader loader = new FXMLLoader(getClass().getResource("ShoppingCart.fxml"));
        root = loader.load();
        CartController cartController = loader.getController();
        //display quantity
        int finalQuantity =  blouseQuantity+coatQuantity+dressQuantity+dungareesQuantity+pajamaQuantity+suitQuantity;
        double blouseTotalPrice = blouseQuantity*15.0;


        double finalPrice =  blouseQuantity*15.0+coatQuantity*30.0+dressQuantity*25.0+dungareesQuantity*30.0+pajamaQuantity*20.0+suitQuantity*50.0;
        cartController.displayQuantity(finalQuantity);
        cartController.displayPrice(finalPrice);
//        cartController.getItem(cartController);

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
