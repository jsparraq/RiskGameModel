package dsd.controller.gamesetup;

import java.net.URL;
import java.util.ResourceBundle;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.Button;
import javafx.scene.control.TableCell;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import javafx.util.Callback;
import dsd.Risk;
import dsd.controller.ClientController;
import dsd.model.game.Account;
import dsd.model.game.Players;
import javafx.scene.control.Label;

public class ManageContactController implements Initializable {

    @FXML
    private TableView<Players> contactTable;
    @FXML
    private TableColumn<Players, String> deleteColumn;
    @FXML
    private TableColumn<Players, String> contactColumn;
    private ClientController controller;
    private final ObservableList<Players> contactData = FXCollections.observableArrayList();

    public void setApp(Risk application) {
        controller = application.getContorller();
    }

    @Override
    public void initialize(URL url, ResourceBundle rb) {
        setContactData();
    }

    private void setContactData() {

        contactData.add(new Players(new Account(), "blue", true, true));
        contactData.add(new Players(new Account(), "green", false, true));
        contactData.add(new Players(new Account(), "blue", false, true));
        contactData.add(new Players(new Account(), "pink", false, true));
        contactData.add(new Players(new Account(), "red", false, true));
        contactData.add(new Players(new Account(), "brown", false, true));
        contactData.add(new Players(new Account(), "oragne", false, false));
        contactData.add(new Players(new Account(), "black", false, false));

        contactTable.setItems(contactData);

        Callback<TableColumn<Players, String>, TableCell<Players, String>> cellFactory;

        cellFactory = (final TableColumn<Players, String> param) -> {
            final TableCell<Players, String> cell = new TableCell<Players, String>() {

                private Players player;

                @Override
                public void updateItem(String item, boolean empty) {
                    super.updateItem(item, empty);
                    if (empty) {
                        setGraphic(null);
                        setText(null);

                    } else {
                        player = getTableView().getItems().get(getIndex());
                        Label contactName = new Label(player.getAccount().getPlayerName());
                        setGraphic(contactName);
                    }

                }

            };
            return cell;
        };
        contactColumn.setCellFactory(cellFactory);

        cellFactory = (final TableColumn<Players, String> param) -> {
            final TableCell<Players, String> cell = new TableCell<Players, String>() {

                final Button btn = new Button("Delete");

                @Override
                public void updateItem(String item, boolean empty) {
                    super.updateItem(item, empty);
                    if (empty) {
                        setGraphic(null);
                        setText(null);

                    } else {
                        
                        btn.setOnAction((ActionEvent event)-> {
                            Players person = getTableView().getItems().get(getIndex());
                            contactData.remove(person);
                        });

                        setGraphic(btn);
                        setText(null);

                    }
                    btn.setStyle("-fx-background-color: \n"
                            + "        rgba(0,0,0,0.08),\n"
                            + "        linear-gradient(#9a9a9a, #909090),\n"
                            + "        linear-gradient(white 0%, #f3f3f3 50%, #ececec 51%, #f2f2f2 100%);\n"
                            + "    -fx-background-insets: 0 0 -1 0,0,1;\n"
                            + "    -fx-background-radius: 5,5,4;\n"
                            + "    -fx-padding: 3 30 3 30;\n"
                            + "    -fx-text-fill: #242d35;\n"
                            + "    -fx-font-size: 18px;");
                }

            };
            return cell;
        };

        deleteColumn.setCellFactory(cellFactory);
    }

    public void backToProfile() {
        controller.gotoProfile();
    }

    public void addContact() {

    }

}
