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
public class AccountCreateTamilController implements Initializable {
    @FXML
    private Label HEADING_CREATE;
    @FXML
    private Label LABLE_ACC;
    @FXML
    private TextField Acc_no;
    @FXML
    private Label LABEL_PIN;
    @FXML
    private TextField Pin_no;
    @FXML
    private Label NAME_LABEL;
    @FXML
    private Label ADDRESS_LABEL;
    @FXML
    private TextField NAME;
    @FXML
    private TextField ADDRESS;
    @FXML
    private Label CIF_lABEL;
    @FXML
    private TextField CIF;
    @FXML
    private Label LABLE_MOBILE;
    @FXML
    private TextField MOBILE;
    @FXML
    private TextField ACC_TYPE;
    @FXML
    private Label LABLE_EMAIL;
    @FXML
    private TextField EMAIL;
    @Override
    public void initialize(URL url, ResourceBundle rb) {

    }    

    @FXML
    private void Back(ActionEvent event) throws IOException {
        
        Stage stage = new Stage();
        Parent root = FXMLLoader.load(getClass().getResource("TamilLogin.fxml"));
        Scene scene = new Scene(root);
        stage.setResizable(false);
        stage.setScene(scene);
        stage.show();
        Stage currentStage = (Stage) ((javafx.scene.Node) event.getSource()).getScene().getWindow();
        currentStage.close();
        
        
    }

    @FXML
    private void CURRENT(ActionEvent event) {
         ACC_TYPE.setText("CURRENT ACCOUNT");
    }

    @FXML
    private void SAVING(ActionEvent event) {
         ACC_TYPE.setText("SAVINGS ACCOUNT");
    }

    @FXML
    private void CREATE(ActionEvent event) throws IOException {
        
 
                QURIES qur = new QURIES();
                POJOS.Pojo po = new Pojo();

            if(Acc_no.getText().matches("\\d+")){
            if(Acc_no.getText().length()<=10){    
            po.setAcc_no(Long.parseLong(Acc_no.getText()));
            if(Pin_no.getText().matches("\\d+")){
            if(Pin_no.getText().length()<=4&&Pin_no.getText().length()>=4){
                po.setPin_no(Short.parseShort(Pin_no.getText()));
                po.setName(NAME.getText().toUpperCase());
           if(CIF.getText().matches("\\d+")){     
                po.setCif(Long.parseLong(CIF.getText()));
                po.setType(ACC_TYPE.getText());
           if(MOBILE.getText().matches("\\d+")){     
                po.setPhonenumber(Long.parseLong(MOBILE.getText()));
                po.setEmail(EMAIL.getText());
                po.setAddress(ADDRESS.getText().toUpperCase());
           if(qur.createAcc(po)){
           showCustomDialog("வெற்றிகரமாக முடிந்தது", "\"உங்கள் கணக்கு வெற்றிகரமாக உருவாக்கப்பட்டது....\"\n                                வணக்கம் \""+po.getName()+"\"");
           clearFields();
           }
else{
       showCustomDialog("தோல்வியடைந்தது...!", "\"உங்கள் கணக்கு உருவாக்க படவில்லை\"\n          \"மீண்டும் முயற்சிக்கவும்...!\"");
       }
       }  
else{
       showCustomDialog("எச்சரிக்கை", "\"மொபைல் எண்ணில் எண்கள் மட்டுமே இருக்க வேண்டும்...!\"");
       } 
       }
else{ 
       showCustomDialog("எச்சரிக்கை", "\"எண்கள் மட்டுமே \"CIF\" இல் இருக்க வேண்டும்...!\"");
       }           
       }
else{
       showCustomDialog("எச்சரிக்கை", "\"கடவுச்சொல்லில் '4' இலக்கங்களை மட்டும் அமைக்கவும்\"");
       }            
       }
else{
       showCustomDialog("எச்சரிக்கை", "\"கடவுச்சொல்லில் எண்களை மட்டும் அமைக்கவும்\"");
       }
       }
else{
      showCustomDialog("எச்சரிக்கை", "\"கணக்கு எண் பத்து எண்கள் மட்டுமே...!\"");
      }
      }      
  else{
         showCustomDialog("எச்சரிக்கை", "\"கணக்கு எண் எண்கள் மட்டுமே...!\"");
        }
        
    }
    
    
    private void showCustomDialog(String title, String message) {
    Dialog<String> dialog = new Dialog<>();
    dialog.setTitle(title);

    VBox content = new VBox(10);
    content.getChildren().add(new Text(message));

    dialog.getDialogPane().setContent(content);
    dialog.getDialogPane().getButtonTypes().add(ButtonType.OK);
    
    dialog.getDialogPane().setPrefSize(100, 100); 
    try {
        dialog.getDialogPane().getStylesheets().add(getClass().getResource("Alert.css").toExternalForm());
        dialog.getDialogPane().getStyleClass().add("dialog-pane");
    } 
    catch (Exception e) {
        System.out.println("Stylesheet not found: " + e.getMessage());
    }

    dialog.showAndWait();
}
   
    private void clearFields() {
        Acc_no.clear();
        Pin_no.clear();
        NAME.clear();
        ADDRESS.clear();
        MOBILE.clear();
        CIF.clear();
        ACC_TYPE.clear();
        EMAIL.clear();
}
     
    
    
}
