/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package ATM;

import java.io.IOException;
import java.net.URL;
import java.util.ResourceBundle;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Label;
import javafx.stage.Stage;

/**
 * FXML Controller class
 *
 * @author Admin
 */
public class WelcomeController implements Initializable {

    @FXML
    private Label HEADING_WELCOME;

    /**
     * Initializes the controller class.
     */
    @Override
    public void initialize(URL url, ResourceBundle rb) {
        // TODO
    }    

    @FXML
    private void STATEMENT(ActionEvent event) throws IOException {

                       Stage stage = new Stage();
        Parent root = FXMLLoader.load(getClass().getResource("MiniStatement.fxml"));
        
        Scene scene = new Scene(root);
        stage.setResizable(false);
        stage.setScene(scene);
        stage.show();
                Stage currentStage = (Stage) ((javafx.scene.Node) event.getSource()).getScene().getWindow();
currentStage.close();
        
    }

    @FXML
    private void DEPOSITE(ActionEvent event) throws IOException {

        
                Stage stage = new Stage();
        Parent root = FXMLLoader.load(getClass().getResource("Deposite.fxml"));
        
        Scene scene = new Scene(root);
        stage.setResizable(false);
        stage.setScene(scene);
        stage.show();
       
                Stage currentStage = (Stage) ((javafx.scene.Node) event.getSource()).getScene().getWindow();
currentStage.close();
        
    }

    @FXML
    private void WITHDRAWAL(ActionEvent event) throws IOException {

                Stage stage = new Stage();
        Parent root = FXMLLoader.load(getClass().getResource("WithDrawal.fxml"));
        
        Scene scene = new Scene(root);
        stage.setResizable(false);
        stage.setScene(scene);
        stage.show();
       
                Stage currentStage = (Stage) ((javafx.scene.Node) event.getSource()).getScene().getWindow();
currentStage.close();
        
    }

    @FXML
    private void BALANCE(ActionEvent event) throws IOException {
       
         Stage stage = new Stage();
        Parent root = FXMLLoader.load(getClass().getResource("BALANCE.fxml"));
        
        Scene scene = new Scene(root);
        stage.setResizable(false);
        stage.setScene(scene);
        stage.show();
       
                Stage currentStage = (Stage) ((javafx.scene.Node) event.getSource()).getScene().getWindow();
currentStage.close();
    }

    @FXML
    private void Back(ActionEvent event) throws IOException {
        
        Stage stage = new Stage();
        Parent root = FXMLLoader.load(getClass().getResource("Login.fxml"));
        
        Scene scene = new Scene(root);
        stage.setResizable(false);
        stage.setScene(scene);
        stage.show();
        
Stage currentStage = (Stage) ((javafx.scene.Node) event.getSource()).getScene().getWindow();
currentStage.close();
        
    }

    @FXML
    private void CHANGE_PIN(ActionEvent event) throws IOException {
        
                Stage stage = new Stage();
        Parent root = FXMLLoader.load(getClass().getResource("ChangePin.fxml"));
        
        Scene scene = new Scene(root);
        stage.setResizable(false);
        stage.setScene(scene);
        stage.show();
        
Stage currentStage = (Stage) ((javafx.scene.Node) event.getSource()).getScene().getWindow();
currentStage.close();
        
    }

    @FXML
    private void VEIW_DETAILS(ActionEvent event) throws IOException {
        
                Stage stage = new Stage();
        Parent root = FXMLLoader.load(getClass().getResource("Details.fxml"));
        
        Scene scene = new Scene(root);
        stage.setResizable(false);
        stage.setScene(scene);
        stage.show();
        
Stage currentStage = (Stage) ((javafx.scene.Node) event.getSource()).getScene().getWindow();
currentStage.close();
        
    }


    
}
