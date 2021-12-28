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
import javafx.scene.control.TextArea;
import javafx.scene.control.TextField;
import javafx.stage.Stage;

public class FXMLBillGenerationController implements Initializable {

    @FXML
    private TextField cusIDField;
    @FXML
    private TextField billnoField;
    @FXML
    private ComboBox paymentCombo;
    @FXML
    private ComboBox conectionTypeCombo;
    @FXML
    private TextField usedUnitField;
    @FXML
    private TextField totalAmountField;
    @FXML
    private TextArea informationField;
    @FXML
    private TextField costPerUnitfield;

    @Override
    public void initialize(URL url, ResourceBundle rb) {
        // TODO
        conectionTypeCombo.getItems().addAll("Home", "Office", "Factory");
        paymentCombo.getItems().addAll("Any");
    }

    @FXML
    private void onClickViewButton(ActionEvent event) {
        informationField.setText("");
        ArrayList<Bill> u = Bill.getBillList();
        for (Bill i : u) {
            if (i != null) {
                informationField.appendText(i.toString());
            }
        }

    }

    @FXML
    private void onClickSubmitButton(ActionEvent event) {
        Bill s = new Bill(
                Integer.parseInt(billnoField.getText()),
                Integer.parseInt(cusIDField.getText()),
                false,
                paymentCombo.getValue().toString(),
                "",
                conectionTypeCombo.getValue().toString(),
                Float.parseFloat(costPerUnitfield.getText()),
                Integer.parseInt(usedUnitField.getText()),
                Float.parseFloat(totalAmountField.getText())
        );
        s.addBill();
        ArrayList<Bill> b = Bill.getBillList();
        for (Bill i : b) {
            System.out.println(i.toString());
        }

    }

    @FXML
    private void onClickBacktoHomepageButton7(ActionEvent event) throws IOException {
        FXMLLoader loader1 = new FXMLLoader();
        loader1.setLocation(getClass().getResource("FXMLStaffLogIn.fxml"));
        Parent personViewParent1 = loader1.load();
        Scene homepage1 = new Scene(personViewParent1);
        FXMLStaffLogInController controller1 = loader1.getController();
        Stage window1 = (Stage) ((Node) event.getSource()).getScene().getWindow();
        window1.setScene(homepage1);
        window1.show();
    }
}
