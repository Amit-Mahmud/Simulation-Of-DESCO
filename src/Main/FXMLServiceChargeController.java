package Main;

import java.net.URL;
import java.util.ResourceBundle;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.ComboBox;
import javafx.scene.control.TextArea;
import javafx.scene.control.TextField;

public class FXMLServiceChargeController implements Initializable {

    @FXML
    private TextField priceField;
    @FXML
    private TextField connectionChargeField;
    @FXML
    private ComboBox comboBox;
    @FXML
    private TextArea viewTextField;

    @Override
    public void initialize(URL url, ResourceBundle rb) {
        // TODO
        comboBox.getItems().addAll("Home", "Office", "Factory");
        connectionChargeField.setText("5000");
    }

    @FXML
    private void onClickViewButton(ActionEvent event) {
        viewTextField.setText("");

        ServiceCharge u = ServiceCharge.getServiceCharge();
        if (u != null) {
            viewTextField.appendText(u.toString());
        }
    }

    @FXML
    private void onClickSubmitButton(ActionEvent event) {
        ServiceCharge s = new ServiceCharge(
                Float.parseFloat(priceField.getText()),
                comboBox.getValue().toString(),
                Float.parseFloat(connectionChargeField.getText())
        );
        s.addServiceCharge();

    }

}
