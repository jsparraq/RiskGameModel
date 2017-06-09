package dsd.controller.gamesetup;

import java.net.URL;
import java.util.ArrayList;
import java.util.List;
import java.util.ResourceBundle;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.TableCell;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import javafx.scene.layout.BorderPane;
import javafx.util.Callback;
import dsd.Risk;
import dsd.controller.ClientController;
import dsd.model.game.Account;
import dsd.model.game.GameSetup;
import dsd.model.game.Players;

public class SessionController extends BorderPane implements Initializable {
    
    @FXML
    private TableView<GameSetup> sessiontable;
    @FXML
    private TableColumn<GameSetup, String> joinColumn;
    @FXML
    private TableColumn<GameSetup, String> hostColumn;
    @FXML
    private TableColumn<GameSetup, String> numberColumn;
    
    private ClientController controller;
   
    public void setApp(Risk application) {
       controller=application.getContorller();
    }
    private final ObservableList<GameSetup> sessionData = FXCollections.observableArrayList();

    @Override
    public void initialize(URL location, ResourceBundle resources) {
        setSessionData();
    }
   
    private void setSessionData() {
        
        GameSetup session1 = new GameSetup();
        session1.setMaxPlayers(5);
        session1.setSessionId(55555);
        session1.setGameType("game1");
        List<Players> playerList = new ArrayList<>();
        playerList.add(new Players(new Account(),  "blue", true, true));
        playerList.add(new Players(new Account(),  "pink", false, true));
        playerList.add(new Players(new Account(),  "Purple", false, true));
        session1.setPlayers(playerList);
        
        GameSetup session2 = new GameSetup();
        session2.setMaxPlayers(6);
        session2.setSessionId(55555);
        session2.setGameType("game2");
        List<Players> playerList2 = new ArrayList<>();
        playerList2.add(new Players(new Account(),  "green", true, true));
        playerList2.add(new Players(new Account(), "pink", false, true));
        playerList2.add(new Players(new Account(),  "blue", false, true));
        playerList2.add(new Players(new Account(),  "brown", false, true));
        playerList2.add(new Players(new Account(), "yellow", false, true));
        session2.setPlayers(playerList2);
        
        sessionData.add(session1);
        sessionData.add(session2);
        sessiontable.setItems(sessionData);
        
        Callback<TableColumn<GameSetup, String>, TableCell<GameSetup, String>> cellFactory;
        
        cellFactory = (final TableColumn<GameSetup, String> param) -> {
            final TableCell<GameSetup, String> cell = new TableCell<GameSetup, String>() {
                
                private Players player;
              
                
                @Override
                public void updateItem(String item, boolean empty) {
                    super.updateItem(item, empty);
                    if (empty) {
                        setGraphic(null);
                        setText(null);
                        
                    } else {
                        player = getTableView().getItems().get(getIndex()).getPlayers().get(0);
                        Label hst = new Label(player.getAccount().getPlayerName());
                        
                        setGraphic(hst);
                        setText(null);
                        
                    }
                    
                }
                
            };
            return cell;
        };
        
        hostColumn.setCellFactory(cellFactory);
        
        cellFactory = (final TableColumn<GameSetup, String> param) -> {
            final TableCell<GameSetup, String> cell = new TableCell<GameSetup, String>() {
                
                @Override
                public void updateItem(String item, boolean empty) {
                    super.updateItem(item, empty);
                    if (empty) {
                        setGraphic(null);
                        setText(null);
                        
                    } else {
                        GameSetup session = getTableView().getItems().get(getIndex());
                        Label hst = new Label(session.getPlayers().size()+ "/" + session.getMaxPlayers());
                        
                        setGraphic(hst);
                        setText(null);
                        
                    }
                    
                    
                }
                
            };
            return cell;
        };
        
        numberColumn.setCellFactory(cellFactory);
        
        cellFactory = (final TableColumn<GameSetup, String> param) -> {
            final TableCell<GameSetup, String> cell = new TableCell<GameSetup, String>() {
                
                final Button btn = new Button("Join Session");
                   private GameSetup session;
                
                
                @Override
                public void updateItem(String item, boolean empty) {
                    super.updateItem(item, empty);
                    if (empty) {
                        setGraphic(null);
                        setText(null);
                        
                    } else {
                        session = getTableView().getItems().get(getIndex());
                        
                        btn.setOnAction((ActionEvent event) -> {
                            
                            controller.setGames(session);
                            joinSession(event);
                            
                            
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
                            + "    -fx-font-size: 17px;");
                }
                
            };
            return cell;
        };

        joinColumn.setCellFactory(cellFactory);
       
    }
    private void joinSession(ActionEvent event) {
        controller.joinSession();
    }
    public void createSession(ActionEvent event) {
        controller.createSession();
    }
    public void logout(ActionEvent event) {
        controller.gotoLogin();
       
    }
    public void manageContact(ActionEvent event) {
       controller.gotoManageContact();
    }

    public void manageAccount(ActionEvent event) {
        controller.gotoManageAcount();
        
    }
    
}
