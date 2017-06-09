package dsd.controller.account;

import java.net.URL;
import java.util.Optional;
import java.util.ResourceBundle;
import javafx.event.ActionEvent;
import javafx.fxml.Initializable;
import javafx.scene.control.Alert;
import javafx.scene.control.Alert.AlertType;
import javafx.scene.control.ButtonType;
import javafx.scene.control.DialogPane;
import javafx.scene.layout.AnchorPane;
import dsd.Risk;
import dsd.controller.ClientController;
import java.io.FileNotFoundException;
import java.io.IOException;
import javafx.fxml.FXML;
import javafx.scene.control.TextField;
import org.json.simple.parser.ParseException;

public class RemoveAccountController extends AnchorPane implements Initializable {

    @FXML
    TextField username;
    @FXML
    TextField password;
    
    
    private ClientController controller;

    public void setApp(Risk application) {
       controller=application.getContorller();

    }

    @Override
    public void initialize(URL location, ResourceBundle resources) {
    }

    public void remove(ActionEvent event) throws IOException, FileNotFoundException, ParseException {
        Alert alert = new Alert(AlertType.CONFIRMATION);
        alert.setTitle("Comfirm remove account");
        alert.setContentText("Do you want to remove account?");
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

        Optional<ButtonType> result = alert.showAndWait();
        if (result.get() == ButtonType.OK) {
            String responds = dsd.controller.clientapi.AccountController.removeAccount(username.getText(),password.getText());
            
            if(responds.equals("Account remove")){
                Alert alert1 = new Alert(AlertType.INFORMATION);
                alert1.setTitle("Remove account");
                alert1.setContentText("Do you want to remove account?");
                alert1.setHeaderText("");
                DialogPane dialogPane1 = alert1.getDialogPane();
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
            alert1.show();
            controller.gotoLogin();
            }else{
                
            }
                        
        } else {
            controller.gotoProfile();
        }

    }

    public void cancle(ActionEvent event) {
        controller.gotoProfile();
    }

}
