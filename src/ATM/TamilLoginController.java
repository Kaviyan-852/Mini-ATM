
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
import javafx.scene.control.PasswordField;
import javafx.scene.control.ProgressIndicator;
import javafx.scene.control.TextField;
import javafx.scene.input.TouchEvent;
import javafx.scene.layout.VBox;
import javafx.scene.text.Text;
import javafx.stage.Stage;


public class TamilLoginController implements Initializable {

    @FXML
    private TextField Acc_no;
    @FXML
    private PasswordField PIn_No;
 

    @Override
    public void initialize(URL url, ResourceBundle rb) {

    }    

    @FXML
    private void login(ActionEvent event) throws IOException {
         if(Acc_no.getText().matches("\\d+")){
       if(Acc_no.getText().length()<=10){
       if(PIn_No.getText().matches("\\d+")){
       if(PIn_No.getText().length()<=4&&PIn_No.getText().length()>=4){    
       if(valid()){
        Stage stage = new Stage();
        Parent root = FXMLLoader.load(getClass().getResource("WelcomeTamil.fxml"));
        Scene scene = new Scene(root);
        stage.setResizable(false);
        stage.setScene(scene);
        stage.show();
       
           Stage currentStage = (Stage) ((javafx.scene.Node) event.getSource()).getScene().getWindow();
           currentStage.close();
        
       }
       else{
         Dialog<String> dialog = new Dialog<>();
        dialog.setTitle("கணக்கு கிடைக்கவில்லை...!");
        VBox content = new VBox(10);
        content.getChildren().add(new Text("\"கணக்கு எண் (அல்லது) கடவுச்சொல் எண்ணை சரிபார்க்கவும்....!\""));
        dialog.getDialogPane().setContent(content);
        dialog.getDialogPane().getButtonTypes().add(ButtonType.OK);
        dialog.getDialogPane().setPrefSize(100, 100);
        dialog.getDialogPane().getStylesheets().add(getClass().getResource("Alert.css").toExternalForm());
        dialog.getDialogPane().getStyleClass().add("dialog-pane");
        dialog.setX(480);
        dialog.setY(285);
        dialog.showAndWait();
       }
       }
              else{
                Dialog<String> dialog = new Dialog<>();
        dialog.setTitle("எச்சரிக்கை...!");
        VBox content = new VBox(10);
        content.getChildren().add(new Text("கடவுச்சொல்லில் '4' இலக்கங்களை மட்டும் அமைக்கவும்...!'"));
        dialog.getDialogPane().setContent(content);
        dialog.getDialogPane().getButtonTypes().add(ButtonType.OK);
        dialog.getDialogPane().setPrefSize(100, 100);
        dialog.getDialogPane().getStylesheets().add(getClass().getResource("Alert.css").toExternalForm());
        dialog.getDialogPane().getStyleClass().add("dialog-pane");
        dialog.setX(480);
        dialog.setY(285);
        dialog.showAndWait();
       
       }
       }
       else{
                Dialog<String> dialog = new Dialog<>();
        dialog.setTitle("எச்சரிக்கை...!");
        VBox content = new VBox(10);
        content.getChildren().add(new Text("கடவுச்சொல்லில் எண்களை மட்டும் அமைக்கவும்"));
        dialog.getDialogPane().setContent(content);
        dialog.getDialogPane().getButtonTypes().add(ButtonType.OK);
        dialog.getDialogPane().setPrefSize(100, 100);
        dialog.getDialogPane().getStylesheets().add(getClass().getResource("Alert.css").toExternalForm());
        dialog.getDialogPane().getStyleClass().add("dialog-pane");
        dialog.setX(480);
        dialog.setY(285);
        dialog.showAndWait();
       
       }
       }
       else{ 
           Dialog<String> dialog = new Dialog<>();
        dialog.setTitle("எச்சரிக்கை...!");
        VBox content = new VBox(10);
        content.getChildren().add(new Text("\"கணக்கு எண் '10' எண்கள் மட்டுமே...!\""));
        dialog.getDialogPane().setContent(content);
        dialog.getDialogPane().getButtonTypes().add(ButtonType.OK);
        dialog.getDialogPane().setPrefSize(100, 100);
        dialog.getDialogPane().getStylesheets().add(getClass().getResource("Alert.css").toExternalForm());
        dialog.getDialogPane().getStyleClass().add("dialog-pane");
        dialog.setX(480);
        dialog.setY(285);
        dialog.showAndWait();
       }
    }
       else{
        Dialog<String> dialog = new Dialog<>();
       dialog.setTitle("எச்சரிக்கை...!");
        VBox content = new VBox(10);
        content.getChildren().add(new Text("கணக்கு எண்கள் எண்களில் மட்டுமே இருக்க வேண்டும்....!"));
        dialog.getDialogPane().setContent(content);
        dialog.getDialogPane().getButtonTypes().add(ButtonType.OK);
        dialog.getDialogPane().setPrefSize(100, 100);
        dialog.getDialogPane().getStylesheets().add(getClass().getResource("Alert.css").toExternalForm());
        dialog.getDialogPane().getStyleClass().add("dialog-pane");
        dialog.setX(480);
        dialog.setY(285);
        dialog.showAndWait();
       }
    }
    
    public boolean valid(){
    
     POJOS.Pojo po = new Pojo();
        po.setAcc_no( Long.parseLong(Acc_no.getText()));
        po.setPin_no(Short.parseShort(PIn_No.getText()));
        
     if(po.getAcc_no() != 0 && po.getPin_no() !=0){
         QURIES obj = new QURIES();
         
         return obj.logInCheck(po);
     
     }
        
    return false;
    }
        

    @FXML
    private void create(ActionEvent event) throws IOException {
        
         Stage stage = new Stage();
        Parent root = FXMLLoader.load(getClass().getResource("AccountCreateTamil.fxml"));
        Scene scene = new Scene(root);
        stage.setResizable(false);
        stage.setScene(scene);
        stage.show();
        
Stage currentStage = (Stage) ((javafx.scene.Node) event.getSource()).getScene().getWindow();
currentStage.close();
        
    }

    @FXML
    private void back(ActionEvent event) throws IOException {
        
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
