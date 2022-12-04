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
import javafx.scene.layout.VBox;
import javafx.stage.Stage;
import javafx.scene.control.Label;
import javafx.scene.text.*;

public class CartController implements Initializable{
	public CartController() {
//		this.tableView = tableView;
	}

	@FXML
	public TableView<item> tableView;
	@FXML private ObservableList<item> item = FXCollections.observableArrayList();
    @FXML private TableColumn<item, String> itemDetailsColumn;
    @FXML private TableColumn<item, Integer> quantityColumn;
    //@FXML private TableColumn<item, Double> itemPriceColumn;
    @FXML private TableColumn<item, Double> totalPriceColumn;

	@FXML
	private Label FinalQuantity;
	public void displayQuantity(int finalQuantity)
	{
		String output = Integer.toString(finalQuantity);
		this.FinalQuantity.setText(output +" Items");
	}
	@FXML
	private Label FinalPrice;
	public void displayPrice(double finalPrice)
	{
		String output = Double.toString(finalPrice);
		this.FinalPrice.setText("Total："+ output);
	}

    //parsing information

	@Override
	public void initialize(URL arg0, ResourceBundle arg1) {
		// TODO Auto-generated method stub

		//CategoryController categoryCon = new CategoryController();
		//set up the columns in the table
//		TableColumn<item, String> itemDetailsColumn = new TableColumn<>("itemDetails");
		itemDetailsColumn.setCellValueFactory(new PropertyValueFactory<item, String>("itemDetails"));
//		TableColumn<item, Integer> quantityColumn = new TableColumn<>("quantity");
		quantityColumn.setCellValueFactory(new PropertyValueFactory<item, Integer>("quantity"));
//		TableColumn<item, Double> totalPriceColumn = new TableColumn<>("totalPrice");
		totalPriceColumn.setCellValueFactory(new PropertyValueFactory<item, Double>("totalPrice"));
		tableView.getColumns().addAll(itemDetailsColumn,quantityColumn,totalPriceColumn);
//
	}
	
//	public ObservableList<item> getItem()
//	{
////		ObservableList<item> item = FXCollections.observableArrayList();
////		item = FXCollections.observableArrayList();
////		CategoryController categoryCon = new CategoryController();
//		item.add(new item("Blouse", 0,4.5));
//		item.add(new item("Coat", 0,  4.5));
//		item.add(new item("Dress", 0,  4.5));
//		item.add(new item("Dungarees",0,  4.5));
//		item.add(new item("Pajama", 0,  4.5));
//		item.add(new item("Suit", 0,  4.5));
//
//		item = FXCollections.observableArrayList();
//		//CategoryController categoryCon = new CategoryController();
//
////		item.add(new item("Blouse",  blouseQuantity , blouseTotalPrice));
////		item.add(new item("Coat",  coatQuantity, coatTotalPrice));
////		item.add(new item("Dress", dressQuantity, dressTotalPrice ));
////		item.add(new item("Dungarees", dungareesQuantity, dungareesTotalPrice));
////		item.add(new item("Pajama", pajamaQuantity, pajamaTotalPrice));
////		item.add(new item("Suit", suitQuantity, suitTotalPrice ));
//		//System.out.print("I am here" + categoryCon.getBlouseQuantity());
//		return item;
//	}
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
