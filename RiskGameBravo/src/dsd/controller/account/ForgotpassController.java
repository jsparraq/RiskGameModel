
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
import java.io.FileNotFoundException;
import java.io.IOException;
import javax.swing.JOptionPane;
import org.json.simple.parser.ParseException;

public class ForgotpassController extends AnchorPane implements Initializable {

    @FXML
    private TextField email;
    
   
    private ClientController controller;
    public void setApp(Risk application){
        controller=application.getContorller();
        
    }

    @Override
    public void initialize(URL location, ResourceBundle resources) {
         
       
    }
    
    public void sendmail(ActionEvent event) throws IOException, FileNotFoundException, ParseException {
        String confirm = dsd.controller.clientapi.Account.forgotPassword(email.getText());
        JOptionPane.showOptionDialog(null, confirm + " to " + email.getText(), "Message",
                        JOptionPane.INFORMATION_MESSAGE, JOptionPane.INFORMATION_MESSAGE,
                        null, new Object[]{"Accept"}, null);
    }
    public void back(ActionEvent event) {
         controller.gotoLogin();
    }
    
    
    
}
