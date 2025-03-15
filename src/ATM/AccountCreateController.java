
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
import javafx.scene.control.ScrollPane;
import javafx.scene.control.TextField;
import javafx.scene.layout.VBox;
import javafx.scene.text.Text;
import javafx.stage.Stage;

public class AccountCreateController implements Initializable {

    @FXML
    private Label HEADING_CREATE;
    @FXML
    private Label LABLE_ACC;
    @FXML
    private Label LABEL_PIN;
    @FXML
    private TextField ACCOUNT_NO;
    @FXML
    private TextField PIN_NO;
    @FXML
    private Label NAME_LABEL;
    @FXML
    private TextField NAME;
    @FXML
    private TextField ADDRESS;
    @FXML
    private TextField MOBILE;
    @FXML
    private TextField CIF;
    @FXML
    private TextField ACC_TYPE;
    @FXML
    private TextField EMAIL;
    @FXML
    private Label ADDRESS_LABEL;
    @FXML
    private Label CIF_lABEL;
    @FXML
    private Label LABLE_MOBILE;
    @FXML
    private Label LABLE_EMAIL;

    @Override
    public void initialize(URL url, ResourceBundle rb) {

    }    

    @FXML
    private void CREATE(ActionEvent event) {
        
            QURIES qur = new QURIES();
            POJOS.Pojo po = new Pojo();
            if(ACCOUNT_NO.getText().matches("\\d+")){
            if(ACCOUNT_NO.getText().length()<=10){    
            po.setAcc_no(Long.parseLong(ACCOUNT_NO.getText()));
            if(PIN_NO.getText().matches("\\d+")){
            if(PIN_NO.getText().length()<=4&&PIN_NO.getText().length()>=4){
                po.setPin_no(Short.parseShort(PIN_NO.getText()));
                po.setName(NAME.getText().toUpperCase());
           if(CIF.getText().matches("\\d+")){     
                po.setCif(Long.parseLong(CIF.getText()));
                po.setType(ACC_TYPE.getText());
           if(MOBILE.getText().matches("\\d+")){     
                po.setPhonenumber(Long.parseLong(MOBILE.getText()));
                po.setEmail(EMAIL.getText());
                po.setAddress(ADDRESS.getText().toUpperCase());
           if(qur.createAcc(po)){
           showCustomDialog("Successful", "\"Account Created Successfully...\"\n         Welcome \""+po.getName()+"\"");
           clearFields();
           }
else{
        showCustomDialog("Failed...!", "\"Account Cannot Be Created...!\"\n         \"Please Try Again...!\""); 
       }
           }  
else{  
        showCustomDialog("Warning", "\"Only Numbers in Moblie Number...!\"");      
        } 
        }
else{
           showCustomDialog("Warning", "\"Only Numbers in CIF...!\"");   
           }           
            }
else{
       showCustomDialog("Warning", "\"Set '4' Digits in PIN...!\"");    
       }            
            }
else{
       showCustomDialog("Warning", "\"Only Digits in PIN...!\"");        
       }
       }
else{
        showCustomDialog("Warning", "\"Account No. Limit 10 Digits...!\"");
       }
       }      
else{
       showCustomDialog("Warning", "\"Only Numbers in Account No...!\"");
       }
        
    }
    @FXML
    private void Back(ActionEvent event) throws IOException {
        Stage stage = new Stage();
        Parent root = FXMLLoader.load(getClass().getResource("Login.fxml"));
        Scene scene = new Scene(root);
        stage.setResizable(false);
        stage.setScene(scene);
        stage.show();
        ((Stage) ((javafx.scene.Node) event.getSource()).getScene().getWindow()).close();
    }

    @FXML
    private void CURRENT(ActionEvent event) {
        ACC_TYPE.setText("CURRENT ACCOUNT");
    }

    @FXML
    private void SAVING(ActionEvent event) {
        ACC_TYPE.setText("SAVINGS ACCOUNT");
    }
    
    
private void clearFields() {
        ACCOUNT_NO.clear();
        PIN_NO.clear();
        NAME.clear();
        ADDRESS.clear();
        MOBILE.clear();
        CIF.clear();
        ACC_TYPE.clear();
        EMAIL.clear();
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

    
    
}
