/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package ATM;

import BACKEND.QURIES;
import POJOS.Pojo;
import java.io.IOException;
import java.net.URL;
import java.util.ResourceBundle;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Alert;
import javafx.scene.control.ButtonType;
import javafx.scene.control.Dialog;
import javafx.scene.control.Label;
import javafx.scene.control.TextField;
import javafx.scene.layout.VBox;
import javafx.scene.text.Text;
import javafx.stage.Stage;

/**
 * FXML Controller class
 *
 * @author Admin
 */
public class DepositeController implements Initializable {

    @FXML
    private Label Heading_deposite;
    @FXML
    private TextField DepositeAmount;
    @FXML
    private Label Label_Enter_Deposite;

    /**
     * Initializes the controller class.
     */
    @Override
    public void initialize(URL url, ResourceBundle rb) {
        // TODO
    }    

    @FXML
    private void Deposite(ActionEvent event) {
        QURIES qur = new QURIES();
        POJOS.Pojo po = new Pojo();
        
   po.setAmt(Double.parseDouble(DepositeAmount.getText())+qur.balAmt(po));
  qur.amount(po); 
  po.setCredit(Double.parseDouble(DepositeAmount.getText()));
if(qur.Credit(po)!=0){
 
         Dialog<String> dialog = new Dialog<>();
        dialog.setTitle("Deposited Successfully");
        VBox content = new VBox(10);
        content.getChildren().add(new Text("Dear, \""+po.getName()+"\""));
        content.getChildren().add(new Text("\"Your Amount Deposited Sucessfully...\""));
        content.getChildren().add(new Text("\"THANK YOU FOR YOUR TRANSACTION\""));
        dialog.getDialogPane().setContent(content);
        dialog.getDialogPane().getButtonTypes().add(ButtonType.OK);
        dialog.getDialogPane().setPrefSize(100, 100);
        dialog.getDialogPane().getStylesheets().add(getClass().getResource("Alert.css").toExternalForm());
        dialog.getDialogPane().getStyleClass().add("dialog-pane");
        dialog.setX(550);
        dialog.setY(285);
        dialog.showAndWait();
        DepositeAmount.clear();
    }
else{
         Dialog<String> dialog = new Dialog<>();
        dialog.setTitle("Deposited Failed...!");
        VBox content = new VBox(10);
        content.getChildren().add(new Text("Dear, \""+po.getName()+"\""));
        content.getChildren().add(new Text("\"Your Transaction is Failed\""));
        content.getChildren().add(new Text("\"Please Try Again...!\""));
        dialog.getDialogPane().setContent(content);
        dialog.getDialogPane().getButtonTypes().add(ButtonType.OK);
        dialog.getDialogPane().setPrefSize(100, 100);
        dialog.getDialogPane().getStylesheets().add(getClass().getResource("Alert.css").toExternalForm());
        dialog.getDialogPane().getStyleClass().add("dialog-pane");
        dialog.setX(550);
        dialog.setY(285);
        dialog.showAndWait();

}

    }

    @FXML
    private void Back(ActionEvent event) throws IOException {
  
         Stage stage = new Stage();
        Parent root = FXMLLoader.load(getClass().getResource("Welcome.fxml"));
        
        Scene scene = new Scene(root);
        stage.setResizable(false);
        stage.setScene(scene);
        stage.show();
       Stage currentStage = (Stage) ((javafx.scene.Node) event.getSource()).getScene().getWindow();
       currentStage.close();
        
    }
    
}
