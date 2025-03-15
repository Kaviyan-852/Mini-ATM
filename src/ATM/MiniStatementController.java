
package ATM;

import BACKEND.QURIES;
import POJOS.Pojo;
import java.io.IOException;
import java.net.URL;
import java.time.LocalDate;
import java.util.ResourceBundle;
import javafx.beans.property.Property;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.DatePicker;
import javafx.scene.control.Label;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import javafx.scene.control.cell.PropertyValueFactory;
import javafx.stage.Stage;


public class MiniStatementController implements Initializable {

    @FXML
    private Label Heading_deposite;
    @FXML
    private TableView<POJOS.Pojo> FULL_TABLE;
    @FXML
    private TableColumn<POJOS.Pojo, String> Transaction;
    @FXML
    private TableColumn<POJOS.Pojo, Double> debit;
    @FXML
    private TableColumn<POJOS.Pojo, Double> credit;
    @FXML
    private TableColumn<POJOS.Pojo, Double> balance;


    @Override
    public void initialize(URL url, ResourceBundle rb) {

        
        
    }    

    @FXML
    private void Display(ActionEvent event) {
        
     Show();
     
    }

    public void Show(){
    
        QURIES obj = new QURIES();
        POJOS.Pojo po = new Pojo();
        ObservableList ob = FXCollections.observableArrayList();
        FULL_TABLE.setItems(ob);
        ob.addAll(obj.showStatement(po));
        Transaction.setCellValueFactory(new PropertyValueFactory<>("tran"));
        debit.setCellValueFactory(new PropertyValueFactory<>("debit"));
        credit.setCellValueFactory(new PropertyValueFactory<>("credit"));
        balance.setCellValueFactory(new PropertyValueFactory<>("bal"));
        
   
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

    @FXML
    private void clear(ActionEvent event) {
        Pojo po = new Pojo();
       QURIES qur = new QURIES();
       qur.clear(po);
        Show();
        
        
    }

    
    
}
