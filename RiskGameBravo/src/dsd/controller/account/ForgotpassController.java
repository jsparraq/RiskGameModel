
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
    
    public void sendmail(ActionEvent event) {
        
    }
    public void back(ActionEvent event) {
         controller.gotoLogin();
    }
    
    
    
}
