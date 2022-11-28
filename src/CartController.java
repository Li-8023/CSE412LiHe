import java.io.IOException;
import java.net.URL;
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
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import javafx.scene.control.cell.PropertyValueFactory;
import javafx.stage.Stage;

public class CartController implements Initializable{

	@FXML private TableView<item> tableView;
    @FXML private TableColumn<item, String> itemDetailsColumn;
    @FXML private TableColumn<item, Integer> quantityColumn;
    //@FXML private TableColumn<item, Double> itemPriceColumn;
    @FXML private TableColumn<item, Double> totalPriceColumn;
    
    private item itemInfo1;
    
    
	@Override
	public void initialize(URL arg0, ResourceBundle arg1) {
		// TODO Auto-generated method stub
		//CategoryController categoryCon = new CategoryController();
		//set up the columns in the table
		itemDetailsColumn.setCellValueFactory(new PropertyValueFactory<item, String>("itemDetails"));
		quantityColumn.setCellValueFactory(new PropertyValueFactory<item, Integer>("quantity"));
		//itemPriceColumn.setCellValueFactory(new PropertyValueFactory<item, Double>("itemPrice"));
		totalPriceColumn.setCellValueFactory(new PropertyValueFactory<item, Double>("totalPrice"));

		//load data
		tableView.setItems(getItem());
	}
	
	public ObservableList<item> getItem()
	{
		ObservableList<item> item = FXCollections.observableArrayList();
		
		CategoryController categoryCon = new CategoryController();
		item.add(new item("Blouse", categoryCon.getBlouseQuantity(),4.5));
		item.add(new item("Coat", categoryCon.getCoatQuantity(),  4.5));
		item.add(new item("Dress", categoryCon.getDressQuantity(),  4.5));
		item.add(new item("Dungarees", categoryCon.getDungareesQuantity(),  4.5));
		item.add(new item("Pajama", categoryCon.getPajamaQuantity(),  4.5));
		item.add(new item("Suit", categoryCon.getSuitQuantity(),  4.5));
		
		//System.out.print("I am here" + categoryCon.getBlouseQuantity());
		
		return item;	
	}
	public void switchToCategory(ActionEvent event) throws IOException
	{
		  Parent root = FXMLLoader.load(getClass().getResource("Category.fxml"));
		  Stage stage = (Stage)((Node)event.getSource()).getScene().getWindow();
		  Scene scene = new Scene(root);
		  stage.setScene(scene);
		  stage.show();
	}
	
	public void switchToCusAccount(ActionEvent event) throws IOException
	{
		  Parent root = FXMLLoader.load(getClass().getResource("CreateAccount.fxml"));
		  Stage stage = (Stage)((Node)event.getSource()).getScene().getWindow();
		  Scene scene = new Scene(root);
		  stage.setScene(scene);
		  stage.show();
	}
	
	public void switchToCompleteOrderView(ActionEvent event) throws IOException
	{
		  Parent root = FXMLLoader.load(getClass().getResource("CompleteOrderView.fxml"));
		  Stage stage = (Stage)((Node)event.getSource()).getScene().getWindow();
		  Scene scene = new Scene(root);
		  stage.setScene(scene);
		  stage.show();
	}
	
	public void switchToPayment(ActionEvent event) throws IOException
	{
		  Parent root = FXMLLoader.load(getClass().getResource("PaymentMethod.fxml"));
		  Stage stage = (Stage)((Node)event.getSource()).getScene().getWindow();
		  Scene scene = new Scene(root);
		  stage.setScene(scene);
		  stage.show();
	}
	
}
