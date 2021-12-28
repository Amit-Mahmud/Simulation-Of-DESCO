/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Main;

import java.io.IOException;
import java.net.URL;
import java.util.ArrayList;
import java.util.ResourceBundle;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.scene.Node;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.ComboBox;
import javafx.scene.control.Label;
import javafx.scene.control.TextField;
import javafx.stage.Stage;

/**
 * FXML Controller class
 *
 * @author Mahmud Amit
 */
public class FXMLPayBillsController implements Initializable {

    @FXML
    private TextField customerIdField;
    @FXML
    private ComboBox paymentCombo;
    @FXML
    private TextField cardOrBkashNumberField;
    @FXML
    private Label label;

    /**
     * Initializes the controller class.
     */
    @Override
    public void initialize(URL url, ResourceBundle rb) {
        paymentCombo.getItems().addAll("Bkash", "Credit Card");
        label.setText("There Are Due Bills.");
    }

    @FXML
    private void onClickPayNowButton(ActionEvent event) {
        int cus = Integer.parseInt(customerIdField.getText());
        label.setText("Payment Successful !");

        ArrayList<Bill> b = Bill.getBillList();
        for (Bill i : b) {
            if (i.getCustomerID() == cus) {
                i.setBillStatus(true);
            }
        }

    }

    @FXML
    private void onClickBackToHomepageButton3(ActionEvent event) throws IOException {
        FXMLLoader loader1 = new FXMLLoader();
        loader1.setLocation(getClass().getResource("FXMLCustomerLogIn.fxml"));
        Parent personViewParent1 = loader1.load();
        Scene homepage1 = new Scene(personViewParent1);
        FXMLCustomerLogInController controller1 = loader1.getController();
        Stage window1 = (Stage) ((Node) event.getSource()).getScene().getWindow();
        window1.setScene(homepage1);
        window1.show();
    }

}
