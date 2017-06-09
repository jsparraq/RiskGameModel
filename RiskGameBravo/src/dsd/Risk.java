package dsd;

import java.io.InputStream;
import javafx.application.Application;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.fxml.JavaFXBuilderFactory;
import javafx.scene.Scene;
import javafx.scene.layout.AnchorPane;
import javafx.stage.Stage;
import javafx.scene.image.Image;
import dsd.controller.ClientController;
import dsd.model.RiskConstanst;

public class Risk extends Application {

    private Stage stage;
    private double WINDOW_WIDTH = 520.0;
    private static final double WINDOW_HEIGHT = 700.0;
    private ClientController controller;

    public void setwidth(double width) {
        WINDOW_WIDTH = width;
    }

    public double getWidth() {
        return WINDOW_WIDTH;
    }

    public static void main(String[] args) {
        launch(Risk.class, (java.lang.String[]) null);

    }

    @Override
    public void start(Stage primaryStage) {
        try {
            stage = primaryStage;
            stage.setTitle(RiskConstanst.TITLE);
            stage.setMinWidth(RiskConstanst.MINIMUM_WINDOW_WIDTH);
            stage.setMinHeight(RiskConstanst.MINIMUM_WINDOW_HEIGHT);
            stage.getIcons().add(new Image("dsd/view/images/icon.png"));
            stage.setResizable(false);
            controller = new ClientController(this);
            controller.gotoLogin();

            primaryStage.show();
            
        } catch (Exception ex) {
        }
    }

    public ClientController getContorller() {
        if (controller == null) {
            controller = new ClientController(this);
        }

        return controller;
    }

    public Initializable replaceSceneContent(String fxml) throws Exception {

        FXMLLoader loader = new FXMLLoader();
        InputStream in = getClass().getResourceAsStream(fxml);
        loader.setBuilderFactory(new JavaFXBuilderFactory());
        loader.setLocation(Risk.class.getResource(fxml));
        AnchorPane page;

        try {
            page = (AnchorPane) loader.load(in);
        } finally {
            in.close();
        }
        Scene scene = new Scene(page, WINDOW_WIDTH, WINDOW_HEIGHT);
        stage.setScene(scene);
        stage.sizeToScene();
        
       
        return (Initializable) loader.getController();
    }
    public void showState(){
       
        stage.show();
    }
    
    public void hideState(){
        stage.hide();
    }

}
