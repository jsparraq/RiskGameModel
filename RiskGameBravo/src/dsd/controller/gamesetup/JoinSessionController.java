package dsd.controller.gamesetup;

import java.net.URL;
import java.util.ResourceBundle;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.TableView;
import javafx.scene.layout.BorderPane;
import dsd.Risk;
import dsd.controller.ClientController;
import dsd.model.game.Players;
import javafx.scene.control.Label;
import javafx.scene.control.TableCell;
import javafx.scene.control.TableColumn;
import javafx.util.Callback;

public class JoinSessionController extends BorderPane implements Initializable {

    @FXML
    private TableView<Players> playerTable;
    @FXML
    private TableColumn<Players, String> playerColumn;

    private final ObservableList<Players> playerData = FXCollections.observableArrayList();
    private ClientController controller;

    public void setApp(Risk application) {
        controller = application.getContorller();
        setGameSession();
    }

    @Override
    public void initialize(URL url, ResourceBundle rb) {

    }

    private void setGameSession() {

        if (controller.getGames() != null) {
            for (int i = 0; i < controller.getGames().getPlayers().size(); i++) {
                playerData.add(controller.getGames().getPlayers().get(i));
            }
        }
        playerTable.setItems(playerData);

        Callback<TableColumn<Players, String>, TableCell<Players, String>> cellFactory;

        cellFactory = (final TableColumn<Players, String> param) -> {
            final TableCell<Players, String> cell = new TableCell<Players, String>() {

                private Players player;
                Label playerName = new Label();

                @Override
                public void updateItem(String item, boolean empty) {
                    super.updateItem(item, empty);
                    if (empty) {
                        setGraphic(null);
                        setText(null);
                        setStyle("-fx-font-size: 17px;");

                    } else {
                        player = getTableView().getItems().get(getIndex());
                        playerName.setText(player.getAccount().getPlayerName());
                        setStyle("-fx-background-color:" + player.getColor() + ";");
                        setGraphic(playerName);
                    }

                }

            };
            return cell;
        };

        playerColumn.setCellFactory(cellFactory);
    }

    public void backToProfile() {
        controller.gotoProfile();
    }

    public void join() {

    }
}
