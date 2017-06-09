
package dsd.controller;

import java.net.URL;
import java.util.ResourceBundle;
import javafx.fxml.Initializable;
import dsd.Risk;
import dsd.controller.account.ChangePassController;
import dsd.controller.account.CreateAccountController;
import dsd.controller.account.ForgotpassController;
import dsd.controller.account.LoginController;
import dsd.controller.account.ManageAccountController;
import dsd.controller.account.RemoveAccountController;
import dsd.controller.gamesetup.CreateSessionController;
import dsd.controller.gamesetup.JoinSessionController;
import dsd.controller.gamesetup.ManageContactController;
import dsd.controller.gamesetup.SessionController;
import dsd.model.RiskConstanst;
import dsd.model.game.GameSetup;
import dsd.model.risk.Session;
import dsd.view.risk.Accepts_Turn_Interface;
import java.io.FileNotFoundException;
import java.io.IOException;
import javax.swing.ImageIcon;
import javax.swing.JFrame;


public class ClientController implements Initializable {

    private double WINDOW_WIDTH = 520.0;
    private double WINDOW_HEIGHT = 700.0;
    private GameSetup games;

    public GameSetup getGames() {
        return games;
    }

    public void setGames(GameSetup games) {
        this.games = games;
    }

    
   

    public double getWINDOW_WIDTH() {
        return WINDOW_WIDTH;
    }

    public void setWINDOW_WIDTH(double WINDOW_WIDTH) {
        this.WINDOW_WIDTH = WINDOW_WIDTH;
    }

    public double getWINDOW_HEIGHT() {
        return WINDOW_HEIGHT;
    }

    public void setWINDOW_HEIGHT(double WINDOW_HEIGHT) {
        this.WINDOW_HEIGHT = WINDOW_HEIGHT;
    }
    private final Risk application;

    public ClientController(Risk application) {
        this.application = application;

    }
    
    public void gotoLogin() {
        application.setwidth(RiskConstanst.MINIMUM_WINDOW_WIDTH);
        try {
            LoginController controller = (LoginController) application.replaceSceneContent("view/account/login.fxml");
            controller.setApp(application);
        } catch (Exception ex) {
        }
    }

    public void forgotPassword() {
        application.setwidth(RiskConstanst.MINIMUM_WINDOW_WIDTH);
        try {
            ForgotpassController controller = (ForgotpassController) application.replaceSceneContent("view/account/forgotpass.fxml");
            controller.setApp(application);
        } catch (Exception ex) {
        }
    }

    public void createAccount() {
        application.setwidth(RiskConstanst.MINIMUM_WINDOW_WIDTH);
        try {
            CreateAccountController controller = (CreateAccountController) application.replaceSceneContent("view/account/createaccount.fxml");
            controller.setApp(application);
        } catch (Exception ex) {
            
        }
    }

    public void removeAccount() {
        application.setwidth(RiskConstanst.MINIMUM_WINDOW_WIDTH);
        try {
            RemoveAccountController controller = (RemoveAccountController) application.replaceSceneContent("view/account/removeaccount.fxml");
            controller.setApp(application);
        } catch (Exception ex) {
            
        }
    }

    public void changePassword() {
        application.setwidth(RiskConstanst.MINIMUM_WINDOW_WIDTH);
        try {
            ChangePassController controller = (ChangePassController) application.replaceSceneContent("view/account/changepass.fxml");
            controller.setApp(application);
        } catch (Exception ex) {
        }
    }

    public void gotoProfile() {
        application.setwidth(700);
        try {
            SessionController controller = (SessionController) application.replaceSceneContent("view/gamesetup/sessions.fxml");
            controller.setApp(application);
        } catch (Exception ex) {
        }
    }

    public void gotoManageAcount() {
        application.setwidth(RiskConstanst.MINIMUM_WINDOW_WIDTH);
        try {
            ManageAccountController controller = (ManageAccountController) application.replaceSceneContent("view/account/manageaccount.fxml");
            controller.setApp(application);
        } catch (Exception ex) {
        }
    }

    public void gotoManageContact() {
        application.setwidth(RiskConstanst.MINIMUM_WINDOW_WIDTH);
        try {
            ManageContactController controller = (ManageContactController) application.replaceSceneContent("view/gamesetup/managecontact.fxml");
            controller.setApp(application);
        } catch (Exception ex) {
        }
    }

    public void createSession() {
        application.setwidth(700);
        try {
            CreateSessionController controller = (CreateSessionController) application.replaceSceneContent("view/gamesetup/createsession.fxml");
            controller.setApp(application);
        } catch (Exception ex) {
        }
    }

    public void joinSession() {
        application.setwidth(RiskConstanst.MINIMUM_WINDOW_WIDTH);
       
        try {
            JoinSessionController controller = (JoinSessionController) application.replaceSceneContent("view/gamesetup/joinsession.fxml");
           
            controller.setApp(application);
          
        } catch (Exception ex) {
        }
    }
    
    public void gotoRiskModel() throws FileNotFoundException, IOException{
        ImageIcon img = new ImageIcon(getClass().getResource("/dsd/view/images/icon.png"));
        Session sessionstart = dsd.controller.clientapi.GameModelController.createSession(dsd.controller.clientapi.GameModelController.initialSession());
        JFrame frame = new Accepts_Turn_Interface(sessionstart);
        frame.setTitle(RiskConstanst.TITLE);
        frame.setIconImage(img.getImage());
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.setLocationRelativeTo(null);
        frame.setVisible(true);
        application.hideState();
        
    }

    @Override
    public void initialize(URL location, ResourceBundle resources) {

    }

}
