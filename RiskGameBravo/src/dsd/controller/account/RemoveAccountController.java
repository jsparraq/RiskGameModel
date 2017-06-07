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

public class RemoveAccountController extends AnchorPane implements Initializable {

    private ClientController controller;

    public void setApp(Risk application) {
       controller=application.getContorller();

    }

    @Override
    public void initialize(URL location, ResourceBundle resources) {
    }

    public void remove(ActionEvent event) {
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
            controller.gotoLogin();
        } else {
            controller.gotoProfile();
        }

    }

    public void cancle(ActionEvent event) {
        controller.gotoProfile();
    }

}
