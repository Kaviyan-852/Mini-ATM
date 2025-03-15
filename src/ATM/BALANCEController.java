
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

public class BALANCEController implements Initializable {

    @FXML
    private Label Heading_deposite;
    @FXML
    private Label LABEL_BALANCE;
    @FXML
    private Label BALANE_AMOUNT;
    @FXML
    private Label BALANE_AMOUNT1;
    @FXML
    private Label Customer_name;

    @Override
    public void initialize(URL url, ResourceBundle rb) {
        
        QURIES obj = new QURIES();
        POJOS.Pojo po = new Pojo();
      String bal = Double.toString(obj.balAmt(po));
       BALANE_AMOUNT.setText(bal);
       Customer_name.setText(po.getName());
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
