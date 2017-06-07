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
import javafx.scene.layout.AnchorPane;
import javafx.util.Callback;
import dsd.Risk;
import dsd.controller.ClientController;
import dsd.model.game.Account;
import dsd.model.game.Players;
import dsd.model.risk.Boundary;
import dsd.model.risk.Card;
import dsd.model.risk.Continent;
import dsd.model.risk.Map;
import dsd.model.risk.Player;
import dsd.model.risk.Session;
import dsd.model.risk.Territory;
import javafx.event.EventHandler;
import javafx.scene.control.Label;

public class CreateSessionController extends AnchorPane implements Initializable {

    @FXML
    private TableView<Players> contactTable;
    @FXML
    private TableColumn<Players, String> inviteColumn;
    @FXML
    private TableColumn<Players, String> contactColumn;
    @FXML
    private TableColumn<Players, String> playerColumn;
    @FXML
    private TableView<Players> playerTable;

    @FXML
    private TableColumn<Players, String> removeColumn;

    private final ObservableList<Players> contactData = FXCollections.observableArrayList();
    private final ObservableList<Players> playerData = FXCollections.observableArrayList();
    private ClientController controller;

    public void setApp(Risk application) {
        controller = application.getContorller();
    }

    @Override
    public void initialize(URL location, ResourceBundle resources) {
        setPlayerData();
        setContactData();

    }

    private void setContactData() {

        contactData.add(new Players(new Account(), "blue", true, true));
        contactData.add(new Players(new Account(), "green", false, true));
        contactData.add(new Players(new Account(), "blue", false, true));
        contactData.add(new Players(new Account(), "pink", false, true));
        contactData.add(new Players(new Account(), "red", false, true));
        contactData.add(new Players(new Account(), "brown", false, true));
        contactData.add(new Players(new Account(), "Purple", false, false));
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

                        setStyle("-fx-background-color: rgba(70, 255, 84, 0.2)");

                        setGraphic(contactName);

                    }

                }

            };
            return cell;
        };

        contactColumn.setCellFactory(cellFactory);

        cellFactory = (final TableColumn<Players, String> param) -> {
            final TableCell<Players, String> cell = new TableCell<Players, String>() {

                final Button btn = new Button("Invite");

                @Override
                public void updateItem(String item, boolean empty) {
                    super.updateItem(item, empty);
                    if (empty) {
                        setGraphic(null);
                        setText(null);

                    } else {
                        Players player = getTableView().getItems().get(getIndex());
                        btn.setOnAction((ActionEvent event)
                                -> {
                            Players person = getTableView().getItems().get(getIndex());

                            btn.setDisable(true);

                        });

                        setGraphic(btn);
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

        inviteColumn.setCellFactory(cellFactory);
    }

    private void setPlayerData() {

        playerData.add(new Players(new Account(), "yellow", true, true));
        playerData.add(new Players(new Account(), "red", false, true));
        playerData.add(new Players(new Account(), "green", false, true));
        playerData.add(new Players(new Account(), "blue",false, true));
        playerData.add(new Players(new Account(), "pink", false, true));
        playerData.add(new Players(new Account(), "gray", false, true));

        playerTable.setItems(playerData);

        Callback<TableColumn<Players, String>, TableCell<Players, String>> cellFactory;

        cellFactory = (final TableColumn<Players, String> param) -> {
            final TableCell<Players, String> cell = new TableCell<Players, String>() {
                private Label playerName;

                @Override
                public void updateItem(String item, boolean empty) {
                    super.updateItem(item, empty);
                    if (empty) {
                        setGraphic(null);
                        setText(null);
                        setStyle("");
                    } else {
                        Players player = getTableView().getItems().get(getIndex());
                        playerName = new Label(player.getAccount().getPlayerName());
                        setGraphic(playerName);
                        setStyle("-fx-background-color:" + player.getColor() + ";");
                    }

                }

            };
            return cell;
        };

        playerColumn.setCellFactory(cellFactory);

        cellFactory = new Callback<TableColumn<Players, String>, TableCell<Players, String>>() {
            @Override
            public TableCell call(final TableColumn<Players, String> param) {
                final TableCell<Players, String> cell = new TableCell<Players, String>() {

                    private Button btn ;

                    private Players player;

                    @Override
                    public void updateItem(String item, boolean empty) {
                        super.updateItem(item, empty);
                        if (empty) {
                            setGraphic(null);
                            setText(null);

                        } else {
                            btn = new Button("Remove");
                            btn.setOnAction(new EventHandler<ActionEvent>() {
                                @Override
                                public void handle(ActionEvent e) {

                                    int selectdIndex = getTableRow().getIndex();

                                    playerData.remove(selectdIndex);
                                }
                            });
                            player = getTableView().getItems().get(getIndex());
                            if (player.isHost()) {
                                btn.setVisible(false);
                            } else {
                                btn.setVisible(true);
                            }
                            setGraphic(btn);
                            btn.setStyle("-fx-background-color: \n"
                                    + "        rgba(0,0,0,0.08),\n"
                                    + "        linear-gradient(#9a9a9a, #909090),\n"
                                    + "        linear-gradient(white 0%, #f3f3f3 50%, #ececec 51%, #f2f2f2 100%);\n"
                                    + "    -fx-background-insets: 0 0 -1 0,0,1;\n"
                                    + "    -fx-background-radius: 5,5,4;\n"
                                    + "    -fx-padding: 3 30 3 30;\n"
                                    + "    -fx-text-fill: #242d35;\n"
                                    + "    -fx-font-size: 15px;");

                        }

                    }

                };
                return cell;
            }
        };

        removeColumn.setCellFactory(cellFactory);
    }

    public void backToProfile() {
        controller.gotoProfile();
    }

    public void startGame() {
         

        //controller.gotoRiskModel(session);
    }

}
