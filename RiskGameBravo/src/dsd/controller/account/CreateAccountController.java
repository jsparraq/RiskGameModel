
package dsd.controller.account;

import java.net.URL;
import java.util.ResourceBundle;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.TextField;
import javafx.scene.layout.AnchorPane;
import dsd.Risk;
import dsd.controller.ClientController;
import java.io.IOException;
import java.util.Optional;
import javafx.scene.control.Alert;
import javafx.scene.control.ButtonType;
import javafx.scene.control.DialogPane;
import javafx.scene.control.PasswordField;
import javax.swing.JOptionPane;
import org.json.simple.parser.ParseException;


public class CreateAccountController extends AnchorPane implements Initializable {

    @FXML
    private TextField username;
    @FXML
    private PasswordField password;
    @FXML
    private TextField email;
    @FXML
    private PasswordField confirmpass;
   
    
    private ClientController controller;
    public void setApp(Risk application){
        controller=application.getContorller();
    }

    @Override
    public void initialize(URL location, ResourceBundle resources) {
         
    }
    
    public void create(ActionEvent event) throws ParseException, IOException {
        String confirm;
        if(password.getText().equals(confirmpass.getText())){
            confirm = dsd.controller.clientapi.AccountController.CreateAccount(username.getText(),email.getText(),password.getText());
        }else{
            confirm = "The password and confirm password are diferent"; 
        }
        Alert alert = new Alert(Alert.AlertType.INFORMATION);
        alert.setTitle("Create account");
        alert.setContentText(confirm);
        alert.setHeaderText("");
        DialogPane dialogPane = alert.getDialogPane();
        dialogPane.setStyle("-fx-background-color: white;");
        dialogPane.setStyle("");

        dialogPane.lookup(".content.label").setStyle("\n"
                + "  -fx-padding: 20;\n"
                + "  -fx-spacing: 10;\n"
                + "  -fx-alignment: center;\n"
                + "  -fx-font-size: 20;\n"
                + "  -fx-border-width: 5;\n"
                + "  -fx-background-insets: 12;\n"
                + "  -fx-border-insets: 10;\n"
                + "  -fx-border-radius: 6;\n"
                + "-fx-background-radius: 6;");
        alert.show();
        password.setText("");
        email.setText("");
        username.setText("");
        confirmpass.setText("");
    }
    public void back(ActionEvent event) {
        controller.gotoLogin();
    }
}
