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
import javafx.scene.control.Label;
import javafx.scene.control.TextField;
import javafx.scene.layout.VBox;
import javafx.scene.text.Text;
import javafx.stage.Stage;

public class WithdrawalTamilController implements Initializable {

    @FXML
    private Label HEADING_WITHDRAWAL;
    @FXML
    private TextField AMOUNT_WITHDRAWAL;
    @FXML
    private Label LABEL_WITHDRAWAL;

    @Override
    public void initialize(URL url, ResourceBundle rb) {

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
        dialog.setTitle("வெற்றிகரமாக முடிந்தது");
        VBox content = new VBox(10);
        content.getChildren().add(new Text("மதிப்புக்குரிய, "+po.getName()));
        content.getChildren().add(new Text("உங்கள் தொகை வெற்றிகரமாக எடுக்கப்பட்டது..."));
        content.getChildren().add(new Text("\"உங்கள் பரிவர்த்தனைக்கு நன்றி\""));
        dialog.getDialogPane().setContent(content);
        dialog.getDialogPane().getButtonTypes().add(ButtonType.OK);
        dialog.getDialogPane().setPrefSize(100, 100);
        dialog.getDialogPane().getStylesheets().add(getClass().getResource("Alert.css").toExternalForm());
        dialog.getDialogPane().getStyleClass().add("dialog-pane");
        dialog.setX(500);
        dialog.setY(285);
        dialog.showAndWait();
 
 }

     else{
 
          Dialog<String> dialog = new Dialog<>();
        dialog.setTitle("தோல்வியடைந்தது...!");
        VBox content = new VBox(10);
        content.getChildren().add(new Text("மதிப்புக்குரிய, "+po.getName()));
        content.getChildren().add(new Text("\"உங்கள் பரிவர்த்தனை தோல்வியடைந்தது\""));
        content.getChildren().add(new Text("\"தயவுசெய்து மீண்டும் முயற்சிக்கவும்....!\""));
        dialog.getDialogPane().setContent(content);
        dialog.getDialogPane().getButtonTypes().add(ButtonType.OK);
        dialog.getDialogPane().setPrefSize(100, 100);
        dialog.getDialogPane().getStylesheets().add(getClass().getResource("Alert.css").toExternalForm());
        dialog.getDialogPane().getStyleClass().add("dialog-pane");
        dialog.setX(500);
        dialog.setY(285);
        dialog.showAndWait();
 }
 }
 else{
         Dialog<String> dialog = new Dialog<>();
        dialog.setTitle("தோல்வியடைந்தது...!");
        VBox content = new VBox(10);
        content.getChildren().add(new Text("மதிப்புக்குரிய, "+"\""+po.getName()+"\""));
        content.getChildren().add(new Text("\"உங்கள் கணக்கில் போதுமான இருப்புத் தொகை இல்லை....!\""));
        dialog.getDialogPane().setContent(content);
        dialog.getDialogPane().getButtonTypes().add(ButtonType.OK);
        dialog.getDialogPane().setPrefSize(200, 100);
        dialog.getDialogPane().getStylesheets().add(getClass().getResource("Alert.css").toExternalForm());
        dialog.getDialogPane().getStyleClass().add("dialog-pane");
        dialog.setX(500);
        dialog.setY(285);
        dialog.showAndWait(); 
    }
        
    }

    @FXML
    private void Back(ActionEvent event) throws IOException {
        
       Stage stage = new Stage();
        Parent root = FXMLLoader.load(getClass().getResource("WelcomeTamil.fxml"));
        
        Scene scene = new Scene(root);
        stage.setResizable(false);
        stage.setScene(scene);
        stage.show();
        Stage currentStage = (Stage) ((javafx.scene.Node) event.getSource()).getScene().getWindow();
        currentStage.close();
        
    }
    
}
