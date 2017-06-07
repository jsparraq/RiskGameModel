
package dsd.controller.account;

import java.net.URL;
import java.util.ResourceBundle;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.PasswordField;
import javafx.scene.control.TextField;
import javafx.scene.layout.AnchorPane;
import dsd.Risk;
import dsd.controller.ClientController;
import dsd.model.game.Account;
import dsd.security.Authenticator;


public class LoginController extends AnchorPane implements Initializable {
    @FXML
    TextField userId;
    @FXML
    PasswordField password;
    @FXML
    Button login;
    @FXML
    Label errorMessage;
    
    
    private Risk application;
    private Account loggedUser;
    private ClientController  controller;
   
    public void setApp(Risk application){
         this.application = application;
         controller=application.getContorller();
    }
    
    @Override
    public void initialize(URL location, ResourceBundle resources) {
        errorMessage.setText("");
        userId.setPromptText("demo");
        password.setPromptText("demo");
       
        
    }
    
    private Account getLoggedUser() {
        return loggedUser;
    }

   private boolean userLogging(String userId, String password) {
        if (Authenticator.validate(userId, password)) {
             controller.gotoProfile();
            return true;
        } else {
            return false;
        }
    }

    public void userLogout() {
        loggedUser = null;
        controller.gotoLogin();
    }
    
    public void forgotPassword(){
         controller.forgotPassword();
    }
    
    public void createAccount(ActionEvent event){
        controller.createAccount();
    }
    public void processLogin(ActionEvent event) {
        if (application == null){
            errorMessage.setText("Hello " + userId.getText());
        } else {
            if (!userLogging(userId.getText(), password.getText())){
                errorMessage.setText("Username/Password is incorrect");
            }
        }
    }
}
