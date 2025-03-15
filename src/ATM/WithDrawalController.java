
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


public class WithDrawalController implements Initializable {

    @FXML
    private Label HEADING_WITHDRAWAL;
    @FXML
    private TextField AMOUNT_WITHDRAWAL;
    @FXML
    private Label LABEL_WITHDRAWAL;

    @Override
    public void initialize(URL url, ResourceBundle rb) {
        // TODO
    }    

    @FXML
    private void WITHDRAWAL(ActionEvent event) {
        
        QURIES qur = new QURIES();
        POJOS.Pojo po = new Pojo();
        
    
    if(Double.parseDouble(AMOUNT_WITHDRAWAL.getText())<=po.getAmt()){
 
    po.setAmt(qur.balAmt(po)-Double.parseDouble(AMOUNT_WITHDRAWAL.getText()));
   
   qur.amount(po); 
  po.setDebit(Double.parseDouble(AMOUNT_WITHDRAWAL.getText()));

 AMOUNT_WITHDRAWAL.clear();
         if(qur.Debit(po)!=0){  
              Dialog<String> dialog = new Dialog<>();
        dialog.setTitle("Withdrawal Successfully");
        VBox content = new VBox(10);
        content.getChildren().add(new Text("Dear, "+po.getName()));
        content.getChildren().add(new Text("Your Amount Withdrawal Successfully..."));
        content.getChildren().add(new Text("\"THANK YOU FOR YOUR TRANSACTION\""));
        dialog.getDialogPane().setContent(content);
        dialog.getDialogPane().getButtonTypes().add(ButtonType.OK);
        dialog.getDialogPane().setPrefSize(100, 100);
        dialog.getDialogPane().getStylesheets().add(getClass().getResource("Alert.css").toExternalForm());
        dialog.getDialogPane().getStyleClass().add("dialog-pane");
        dialog.setX(550);
        dialog.setY(285);
        dialog.showAndWait();
 
 }

     else{
 
          Dialog<String> dialog = new Dialog<>();
        dialog.setTitle("Failed...!");
        VBox content = new VBox(10);
        content.getChildren().add(new Text("Dear, "+po.getName()));
        content.getChildren().add(new Text("\"Your Transaction is Failed\""));
        content.getChildren().add(new Text("\"Please Try Again....!\""));
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
        dialog.setTitle("Failed...!");
        VBox content = new VBox(10);
        content.getChildren().add(new Text("Dear, "+"\""+po.getName()+"\""));
        content.getChildren().add(new Text("\"You have Insufficient Balance....!\""));
        dialog.getDialogPane().setContent(content);
        dialog.getDialogPane().getButtonTypes().add(ButtonType.OK);
        dialog.getDialogPane().setPrefSize(200, 100);
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
