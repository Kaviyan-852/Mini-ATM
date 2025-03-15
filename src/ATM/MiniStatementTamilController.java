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
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Label;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import javafx.scene.control.cell.PropertyValueFactory;
import javafx.stage.Stage;

/**
 * FXML Controller class
 *
 * @author Admin
 */
public class MiniStatementTamilController implements Initializable {

    @FXML
    private Label Heading_deposite;
    @FXML
    private TableView<POJOS.Pojo> FULL_TABLE;
    @FXML
    private TableColumn<POJOS.Pojo, Double> debit;
    @FXML
    private TableColumn<POJOS.Pojo, Double> credit;
    @FXML
    private TableColumn<POJOS.Pojo, Double> balance;
    @FXML
    private TableColumn<POJOS.Pojo, String> Transaction;

    /**
     * Initializes the controller class.
     */
    @Override
    public void initialize(URL url, ResourceBundle rb) {
        // TODO
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
        Parent root = FXMLLoader.load(getClass().getResource("WelcomeTamil.fxml"));
        
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
