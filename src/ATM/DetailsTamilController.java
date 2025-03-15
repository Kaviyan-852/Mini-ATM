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
import javafx.scene.control.Label;
import javafx.stage.Stage;

/**
 * FXML Controller class
 *
 * @author Admin
 */
public class DetailsTamilController implements Initializable {

    @FXML
    private Label ACCOUNT_NO;
    @FXML
    private Label NAME;
    @FXML
    private Label CIF;
    @FXML
    private Label ACCTYPE;
    @FXML
    private Label ADDRESS;
    @FXML
    private Label PHONE_NUMBER;
    @FXML
    private Label E_MAIL;


    @Override
    public void initialize(URL url, ResourceBundle rb) {
      
        QURIES obj = new QURIES();
        POJOS.Pojo po = new Pojo();
        obj.details(po);
        ACCOUNT_NO.setText(Long.toString(po.getAcc_no()));
        NAME.setText(po.getName());
        CIF.setText(Long.toString(po.getCif()));
        ACCTYPE.setText(po.getType());
        ADDRESS.setText(po.getAddress());
        PHONE_NUMBER.setText(Long.toString(po.getPhonenumber()));
        E_MAIL.setText(po.getEmail());
        
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
