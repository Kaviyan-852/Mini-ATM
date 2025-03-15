
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
import javafx.scene.control.PasswordField;
import javafx.scene.control.TextField;
import javafx.scene.layout.VBox;
import javafx.scene.text.Text;
import javafx.stage.Stage;

public class LoginController implements Initializable {

    @FXML
    private TextField ACC_NO;
    @FXML
    private PasswordField PIN_NO;

    @Override
    public void initialize(URL url, ResourceBundle rb) {

    }    
    @FXML
    private void LogIn(ActionEvent event) throws IOException {
       if(ACC_NO.getText().matches("\\d+")){
       if(ACC_NO.getText().length()<=10){
       if(PIN_NO.getText().matches("\\d+")){
       if(PIN_NO.getText().length()<=4&&PIN_NO.getText().length()>=4){    
       if(valid()){
        Stage stage = new Stage();
        Parent root = FXMLLoader.load(getClass().getResource("Welcome.fxml"));
        
        Scene scene = new Scene(root);
        stage.setResizable(false);
        stage.setScene(scene);
        stage.show();
       
           Stage currentStage = (Stage) ((javafx.scene.Node) event.getSource()).getScene().getWindow();
           currentStage.close();
        
       }
       else{
         Dialog<String> dialog = new Dialog<>();
        dialog.setTitle("ACCOUNT NOT FOUND...!");
        VBox content = new VBox(10);
        content.getChildren().add(new Text("\"Please Check Account Number (or) Pin number....!\""));
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
        dialog.setTitle("Warning...!");
        VBox content = new VBox(10);
        content.getChildren().add(new Text("Only Digits '4' in 'PIN'...!'"));
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
        dialog.setTitle("Warning...!");
        VBox content = new VBox(10);
        content.getChildren().add(new Text("Only Digits in \"PIN\" Number"));
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
        dialog.setTitle("Warning...!");
        VBox content = new VBox(10);
        content.getChildren().add(new Text("\"Account Number in '10' Digts Only...!\""));
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
       dialog.setTitle("Warning");
        VBox content = new VBox(10);
        content.getChildren().add(new Text("Only \"Numbers\" in Account Number....!"));
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
    
    public boolean valid(){
    
     POJOS.Pojo po = new Pojo();
        po.setAcc_no( Long.parseLong(ACC_NO.getText()));
        po.setPin_no(Short.parseShort(PIN_NO.getText()));
        
     if(po.getAcc_no() != 0 && po.getPin_no() !=0){
         QURIES obj = new QURIES();
         
         return obj.logInCheck(po);
     
     }
        
    return false;
    }
    @FXML
    private void Create(ActionEvent event) throws IOException {
 
        Stage stage = new Stage();
        Parent root = FXMLLoader.load(getClass().getResource("AccountCreate.fxml"));
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
        Parent root = FXMLLoader.load(getClass().getResource("Languages.fxml"));
        Scene scene = new Scene(root);
        stage.setResizable(false);
        stage.setScene(scene);
        stage.show();
        
Stage currentStage = (Stage) ((javafx.scene.Node) event.getSource()).getScene().getWindow();
currentStage.close();
        
    }

    
    
    
    
}
