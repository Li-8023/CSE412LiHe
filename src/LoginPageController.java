import javafx.fxml.FXML;
import java.io.*;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.PasswordField;
import javafx.scene.control.TextField;
import javafx.stage.Stage;
import javafx.event.ActionEvent;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;


public class LoginPageController{
    public LoginPageController() {
    }
    Connection con;
    PreparedStatement pst;
    public void Connect(){
        try{
            Class.forName("org.postgresql.Driver");
            con = DriverManager.getConnection("jdbc:porstgresql://localhost:5434", "postgres", "Hl011028");
        }catch(ClassNotFoundException ex){
            ex.printStackTrace();
        }catch(SQLException ex){
            ex.printStackTrace();
        }
    }
    @FXML
    private TextField username;

    @FXML
    private PasswordField password;

    @FXML
    private Button logInButton;

    @FXML
    private Button signupButton;

    @FXML
    private Label errorMsg;

    @FXML
    public void userLogIn(ActionEvent event) throws IOException 
    {
        String typeUsername = "Username: ";
        String typePassword = "Password: ";
        String name = username.getText().toString();
        String inputPassword = password.getText().toString();
        try{
            pst = con.prepareStatement("SELECT * FROM Customer where username = ? password = ?");
            pst.setString(1,name);
            pst.setString(2,inputPassword);
            ResultSet rs = pst.excuteQuery();
            //boolean checkLogin = false;
            if(rs.next()){
                errorMsg.setText("Succsessful!");
                Parent root = FXMLLoader.load(getClass().getResource("Category.fxml"));
                Stage window = (Stage) logInButton.getScene().getWindow();
                window.setScene(new Scene(root, 600, 400));
            }else if(username.getText().isEmpty() && password.getText().isEmpty()){
                errorMsg.setText("Please enter your data.");
            }else{
                errorMsg.setText("Wrong username or password!");
            }

        }catch(SQLException ex){
            System.out.println(e);
        }
        

        Parent root = FXMLLoader.load(getClass().getResource("Category.fxml"));
        Stage window = (Stage) logInButton.getScene().getWindow();
        window.setScene(new Scene(root, 600, 400));


    }
    @FXML
    public void userSignUp(ActionEvent event) throws IOException{
        Parent root = FXMLLoader.load(getClass().getResource("CreateAccount.fxml"));
        Stage window = (Stage) signupButton.getScene().getWindow();
        window.setScene(new Scene(root, 600, 400));
    }

//    private boolean checkLogin() throws IOException {
//    	
//        //Main m = new Main();
//		String typeUsername = "Username: ";
//		String typePassword = "Password: ";
//		String name = username.getText().toString();
//		String inputPassword;
//		name = (new StringBuilder()).append(typeUsername).append(name).toString();
//		System.out.println(name);
//
//		inputPassword = password.getText().toString().trim();
//		inputPassword = (new StringBuilder()).append(typePassword).append(inputPassword).toString();
//        
//        //check if name and password are correct, if correct return 
//		//CheckUP check = new CheckUP(name, inputPassword, "Ci.txt");
//        boolean loginValid = true;
//        // = check.checkUsernameAndPassword();
//        //boolean passwordMatch;
//        if (loginValid){
//            errorMsg.setText("Success!");
//            return true;
//            //m.changeScene("HomePage.fxml"); 	        	
//        }else if(username.getText().isEmpty() && password.getText().isEmpty()) {
//            errorMsg.setText("Please enter your data.");
//            return false;
//        }else {
//            errorMsg.setText("Wrong username or password!");
//            return false;
//        } 
//    }
}