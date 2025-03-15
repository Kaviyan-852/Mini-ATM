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
import javafx.scene.control.ButtonType;
import javafx.scene.control.Dialog;
import javafx.scene.control.TextField;
import javafx.scene.layout.VBox;
import javafx.scene.text.Text;
import javafx.stage.Stage;

public class ChangePinController implements Initializable {

    @FXML
    private TextField NEWPIN;
    @FXML
    private TextField CONFIRMPIN;

    @Override
    public void initialize(URL url, ResourceBundle rb) {

    }    

    @FXML
    private void ENTER(ActionEvent event) {
        QURIES obj = new QURIES();
        POJOS.Pojo po = new Pojo();
        
        if(NEWPIN.getText().matches("\\d+")){
        if(NEWPIN.getText().equals(CONFIRMPIN.getText())){
        if(NEWPIN.getText().length()<=4&&NEWPIN.getText().length()>=4){
           po.setPin_no(Short.parseShort(NEWPIN.getText()));
          if(obj.changePin(po)){
           Dialog<String> dialog = new Dialog<>();
        dialog.setTitle("SUCCESSFUL");
        VBox content = new VBox(10);
        content.getChildren().add(new Text("Dear, "+po.getName()));
        content.getChildren().add(new Text("\"PIN Changed Successfully...!\""));
        dialog.getDialogPane().setContent(content);
        dialog.getDialogPane().getButtonTypes().add(ButtonType.OK);
        dialog.getDialogPane().setPrefSize(100, 100);
        dialog.getDialogPane().getStylesheets().add(getClass().getResource("Alert.css").toExternalForm());
        dialog.getDialogPane().getStyleClass().add("dialog-pane");
        dialog.setX(550);
        dialog.setY(285);
        dialog.showAndWait();
        NEWPIN.clear();
        CONFIRMPIN.clear();
          }
          else{
           Dialog<String> dialog = new Dialog<>();
        dialog.setTitle("FAILED");
        VBox content = new VBox(10);
        content.getChildren().add(new Text("\"Cannot Be Changed\""));
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
        else{
          Dialog<String> dialog = new Dialog<>();
        dialog.setTitle("FAILED");
        VBox content = new VBox(10);
        content.getChildren().add(new Text("\"4 DIGITS ONLY...!\""));
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
        else{
         Dialog<String> dialog = new Dialog<>();
        dialog.setTitle("FAILED");
        VBox content = new VBox(10);
        content.getChildren().add(new Text("\"CONFIRM PIN IS NOT SAME\""));
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
        else{
         Dialog<String> dialog = new Dialog<>();
        dialog.setTitle("FAILED");
        VBox content = new VBox(10);
        content.getChildren().add(new Text("\"DIGITS ONLY...!\""));
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
    private void BACK(ActionEvent event) throws IOException {
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
