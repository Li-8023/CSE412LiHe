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
import javafx.scene.control.*;
import javafx.scene.control.cell.PropertyValueFactory;
import javafx.stage.Stage;
import javafx.scene.text.Text;

public class CategoryController implements Initializable{
	
	public CategoryController()
	{

	}
    //send data

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
    private int coat = 0;
    private int dress = 0;
    private int dungarees = 0;
    private int pajama = 0;
    private int suit = 0;
    private item item;
//    private LinkedList<item> itemList;
    private ObservableList<item> items;
    //int blouse = 0;
    public void setBlouseQuantity(ActionEvent event)
    {
        blouse = 0;
        blouse = Integer.parseInt(blouseNum.getText());
//       itemList.add(item);
//       System.out.print(blouse);

    }
    
    //int coat;
    public void setCoatQuantity(ActionEvent event)
    {
        coat = 0;
        coat = Integer.parseInt(coatNum.getText());
    }
    

    //int dress;
    public void setDressQuantity(ActionEvent event)
    {
    	dress = 0;
        dress = Integer.parseInt(dressNum.getText());
    }
    //int dungarees;
    public void setDungareesQuantity(ActionEvent event)
    {
    	dungarees = 0;
        dungarees = Integer.parseInt(dungareesNum.getText());
    }
    
    
    //int pajama;
    public void setPajamaQuantity(ActionEvent event)
    {
//        item item1 = new item();
//        item1.setItemDetails();
        pajama = 0;
    	pajama = Integer.parseInt(pajamaNum.getText());
    	
    }
    
    //int suit;
    public void setSuitQuantity(ActionEvent event)
    {
    	suit = 0;
        suit = Integer.valueOf(suitNum.getText());
    }
	
	public int getBlouseQuantity()
	{
//		System.out.print("Quantity:" + blouse);
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
        //table view
        //add one item
//        item item1 = new item();
//        item1.setItemDetails(blouseNum.getText());
//        item1.setQuantity(Integer.parseInt(blouseNum.getText()));
//        item1 = new item("Blouse", , 4.5);)
//        cartController.tableView.getItems().add(item1);

//        TableColumn<item, String> itemDetailsColumn = new TableColumn<>("itemDetails");
//        itemDetailsColumn.setCellValueFactory(new PropertyValueFactory<item, String>("itemDetails"));
//        TableColumn<item, Integer> quantityColumn = new TableColumn<>("quantity");
//        quantityColumn.setCellValueFactory(new PropertyValueFactory<item, Integer>("quantity"));
//        TableColumn<item, Double> totalPriceColumn = new TableColumn<>("totalPrice");
//        totalPriceColumn.setCellValueFactory(new PropertyValueFactory<item, Double>("totalPrice"));
//        TableColumn<item, String> itemDetailsColumn = new TableColumn<>("itemDetails");
//        itemDetailsColumn.setCellValueFactory(new PropertyValueFactory<item, String>("itemDetails"));
//        TableColumn<item, Integer> quantityColumn = new TableColumn<>("quantity");
//        quantityColumn.setCellValueFactory(new PropertyValueFactory<item, Integer>("quantity"));
//        TableColumn<item, Double> totalPriceColumn = new TableColumn<>("totalPrice");
//        totalPriceColumn.setCellValueFactory(new PropertyValueFactory<item, Double>("totalPrice"));
//        cartController.tableView.getColumns().addAll(itemDetailsColumn,quantityColumn,totalPriceColumn);
        cartController.tableView.setItems(getItem());

        //display quantity
        int finalQuantity =  blouseQuantity+coatQuantity+dressQuantity+dungareesQuantity+pajamaQuantity+suitQuantity;
        double blouseTotalPrice = blouseQuantity*15.0;
        double coatTotalPrice = coatQuantity*30.0;
        double dressTotalPrice = dressQuantity*25.0;
        double dungareesTotalPrice = dungareesQuantity*30.0;
        double pajamaTotalPrice = pajamaQuantity*20.0;
        double suitTotalPrice = suitQuantity*50.0;

        double finalPrice =  blouseQuantity*15.0+coatQuantity*30.0+dressQuantity*25.0+dungareesQuantity*30.0+pajamaQuantity*20.0+suitQuantity*50.0;
        cartController.displayQuantity(finalQuantity);
        cartController.displayPrice(finalPrice);
//        cartController.getItem();
		  Stage stage = (Stage)((Node)event.getSource()).getScene().getWindow();
		  Scene scene = new Scene(root);
		  stage.setScene(scene);
		  stage.show();
		
	}
    
	@Override
	public void initialize(URL arg0, ResourceBundle arg1) {
		// TODO Auto-generated method stub
		
	}

	public ObservableList<item> getItem()
	{
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
        double blouseTotalPrice = blouseQuantity*15.0;
        double coatTotalPrice = coatQuantity*30.0;
        double dressTotalPrice = dressQuantity*25.0;
        double dungareesTotalPrice = dungareesQuantity*30.0;
        double pajamaTotalPrice = pajamaQuantity*20.0;
        double suitTotalPrice = suitQuantity*50.0;
		items = FXCollections.observableArrayList();
		//CategoryController categoryCon = new CategoryController();
		items.add(new item("Blouse",  blouseQuantity , blouseTotalPrice));
		items.add(new item("Coat",  coatQuantity, coatTotalPrice));
		items.add(new item("Dress", dressQuantity, dressTotalPrice ));
		items.add(new item("Dungarees", dungareesQuantity, dungareesTotalPrice));
		items.add(new item("Pajama", pajamaQuantity, pajamaTotalPrice));
		items.add(new item("Suit", suitQuantity, suitTotalPrice ));
		return items;
	}
	
}
