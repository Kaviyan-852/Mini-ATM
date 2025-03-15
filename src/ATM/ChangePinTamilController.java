
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

public class ChangePinTamilController implements Initializable {

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
        dialog.setTitle("வெற்றிகரமாக முடிந்தது");
        VBox content = new VBox(10);
        content.getChildren().add(new Text("மதிப்புக்குரிய, "+po.getName()));
        content.getChildren().add(new Text("\"உங்கள் கடவுச்சொல் வெற்றிகரமாக மாற்றப்பட்டது...!\""));
        dialog.getDialogPane().setContent(content);
        dialog.getDialogPane().getButtonTypes().add(ButtonType.OK);
        dialog.getDialogPane().setPrefSize(100, 100);
        dialog.getDialogPane().getStylesheets().add(getClass().getResource("Alert.css").toExternalForm());
        dialog.getDialogPane().getStyleClass().add("dialog-pane");
        dialog.setX(500);
        dialog.setY(285);
        dialog.showAndWait();
        NEWPIN.clear();
        CONFIRMPIN.clear();
          }
          else{
           Dialog<String> dialog = new Dialog<>();
        dialog.setTitle("தோல்வியடைந்தது");
        VBox content = new VBox(10);
        content.getChildren().add(new Text("\"உங்கள் கடவுச்சொல் மாற்றப்படவில்லை\""));
        content.getChildren().add(new Text("\"தயவுசெய்து மீண்டும் முயற்சிக்கவும்...!\""));
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
        dialog.setTitle("எச்சரிக்கை");
        VBox content = new VBox(10);
        content.getChildren().add(new Text("\"கடவுச்சொல்லில் '4' இலக்கங்களை மட்டும் அமைக்கவும்...!\""));
        content.getChildren().add(new Text("\"தயவுசெய்து மீண்டும் முயற்சிக்கவும்...!\""));
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
        dialog.setTitle("எச்சரிக்கை");
        VBox content = new VBox(10);
        content.getChildren().add(new Text("\"கடவுச்சொல் ஒரே மாதிரி இல்லை\""));
        content.getChildren().add(new Text("\"தயவுசெய்து மீண்டும் முயற்சிக்கவும்...!\""));
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
        dialog.setTitle("எச்சரிக்கை");
        VBox content = new VBox(10);
        content.getChildren().add(new Text("\"கடவுச்சொல்லில் எண்களை மட்டும் அமைக்கவும்...!\""));
        content.getChildren().add(new Text("\"தயவுசெய்து மீண்டும் முயற்சிக்கவும்...!\""));
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

    @FXML
    private void BACK(ActionEvent event) throws IOException {
        
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
