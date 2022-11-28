import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.geometry.Rectangle2D;
import javafx.scene.Node;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.stage.Screen;
import javafx.stage.Stage;
import javafx.scene.control.Button;
import javafx.scene.control.TextField;
import javafx.scene.control.PasswordField;
import javafx.scene.control.Label;

import java.awt.*;
import java.io.IOException;

public class CreateAccountViewController {

    @FXML
    public TextField fnameTxtFld;
    @FXML
    public TextField lnameTxtFld;
    @FXML
    public TextField emailTxtFld;
    @FXML
    public PasswordField passTxtFld;
    @FXML
    public PasswordField confirmPassTxtFld;
    @FXML
    public Button submitButton;
    @FXML
    public Label passLbl;
    @FXML
    public Label emptyLbl;

    private String customerFname;
    private String customerLname;
    private String customerEmail;
    private String customerPass;
    private String customerPassConfirm;

    @FXML
    public void customerViewStart(Stage stage) throws IOException {
        Parent root = FXMLLoader.load(getClass().getResource("CreateAccount.fxml"));
        Scene scene = new Scene(root);
        stage.setScene(scene);
        stage.show();
    }

    /**
     * Save customer data to database and launch category page
     * */
    public void submitClicked(ActionEvent event) throws Exception {
        // get customer data
        customerFname = fnameTxtFld.getText();
        customerLname = lnameTxtFld.getText();
        customerEmail = emailTxtFld.getText();
        customerPass = passTxtFld.getText();
        customerPassConfirm = confirmPassTxtFld.getText();

        // check for fname, lname, email input
        if(customerFname.trim().isEmpty() || customerLname.trim().isEmpty() || customerEmail.trim().isEmpty() || customerPass.isEmpty()) {
            emptyLbl.setText("One or more fields cannot be empty.");
        } else {
            emptyLbl.setText("");
        }

        // check for password
        if(!customerPass.equals(customerPassConfirm)) {
            passLbl.setText("Confirmation password doesn't match. Please try again");
        } else {
            passLbl.setText("");
            System.out.println("Password match. Saving data."); // debug
            // TODO: store customer data in DB
            // TODO: go to category page
            
            DatabaseConnection dbConnection = new DatabaseConnection();
            dbConnection.getConnection();
            
            Parent root = FXMLLoader.load(getClass().getResource("Category.fxml"));
            Stage stage = (Stage)((Node)event.getSource()).getScene().getWindow();
            Scene scene = new Scene(root);
            stage.setScene(scene);
            stage.show();
        }
    }
}
