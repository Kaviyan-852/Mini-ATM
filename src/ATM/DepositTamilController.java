
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

/**
 * FXML Controller class
 *
 * @author Admin
 */
public class DepositTamilController implements Initializable {

    @FXML
    private Label Heading_deposite;
    @FXML
    private TextField DepositeAmount;
    @FXML
    private Label Label_Enter_Deposite;

    @Override
    public void initialize(URL url, ResourceBundle rb) {

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
        dialog.setTitle("வெற்றிகரமாக முடிந்தது");
        VBox content = new VBox(10);
        content.getChildren().add(new Text("மதிப்புக்குரிய, \""+po.getName()+"\""));
        content.getChildren().add(new Text("\"உங்கள் தொகை வெற்றிகரமாக செலுத்தப்பட்டது....\""));
        content.getChildren().add(new Text("\"உங்கள் பரிவர்த்தனைக்கு நன்றி\""));
        dialog.getDialogPane().setContent(content);
        dialog.getDialogPane().getButtonTypes().add(ButtonType.OK);
        dialog.getDialogPane().setPrefSize(100, 100);
        dialog.getDialogPane().getStylesheets().add(getClass().getResource("Alert.css").toExternalForm());
        dialog.getDialogPane().getStyleClass().add("dialog-pane");
        dialog.setX(500);
        dialog.setY(285);
        dialog.showAndWait();
        DepositeAmount.clear();
    }
else{
         Dialog<String> dialog = new Dialog<>();
        dialog.setTitle("தோல்வியடைந்தது...!");
        VBox content = new VBox(10);
        content.getChildren().add(new Text("மதிப்புக்குரிய, \""+po.getName()+"\""));
        content.getChildren().add(new Text("\"உங்கள் பரிவர்த்தனை தோல்வியடைந்தது\""));
        content.getChildren().add(new Text("\"தயவுசெய்து மீண்டும் முயற்சிக்கவும்...!\""));
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
        Parent root = FXMLLoader.load(getClass().getResource("WelcomeTamil.fxml"));
        Scene scene = new Scene(root);
        stage.setResizable(false);
        stage.setScene(scene);
        stage.show();
        
       Stage currentStage = (Stage) ((javafx.scene.Node) event.getSource()).getScene().getWindow();
       currentStage.close();
        
    }
    
}
