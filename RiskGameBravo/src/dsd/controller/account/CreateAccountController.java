
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
        if(password.getText().equals(confirmpass.getText())){
            String confirm = dsd.controller.clientapi.Account.CreateAccount(username.getText(),email.getText(),password.getText());
            JOptionPane.showOptionDialog(null, confirm, "Message",
                        JOptionPane.INFORMATION_MESSAGE, JOptionPane.INFORMATION_MESSAGE,
                        null, new Object[]{"Accept"}, null);
            password.setText("");
            email.setText("");
            username.setText("");
            confirmpass.setText("");
        }else{
            JOptionPane.showMessageDialog(null,"The password and confirm password are diferent"); 
        }
    }
    public void back(ActionEvent event) {
        controller.gotoLogin();
    }
}
