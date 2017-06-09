
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
import java.util.Optional;
import javafx.scene.control.Alert;
import javafx.scene.control.ButtonType;
import javafx.scene.control.DialogPane;
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
        String confirm = dsd.controller.clientapi.AccountController.forgotPassword(email.getText());
        Alert alert = new Alert(Alert.AlertType.INFORMATION);
        alert.setTitle("Forgot password");
        alert.setContentText(confirm + " to " + email.getText());
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
    }
    public void back(ActionEvent event) {
         controller.gotoLogin();
    }
    
    
    
}
