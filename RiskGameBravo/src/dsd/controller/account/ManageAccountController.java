
package dsd.controller.account;

import java.net.URL;
import java.util.ResourceBundle;
import javafx.event.ActionEvent;
import javafx.fxml.Initializable;
import javafx.scene.layout.AnchorPane;
import dsd.Risk;
import dsd.controller.ClientController;



public class ManageAccountController extends AnchorPane implements Initializable {

    private ClientController controller;
    
    public void setApp(Risk application){
         controller=application.getContorller();
    }

    @Override
    public void initialize(URL location, ResourceBundle resources) {
    }
    
    
    public void removeAccount(ActionEvent event) {
        controller.removeAccount();
    }
    
    public void changePassword(ActionEvent event){
        controller.changePassword();
    }
    public void backtoProfile(ActionEvent event){
       controller.gotoProfile();
        
    }
    public void editAccount(ActionEvent event){
        
    }
}
