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

public class FXMLNewConnectionController implements Initializable {

    @FXML
    private TextField customerIDField;
    @FXML
    private TextField addressField;
    @FXML
    private TextField contactField;
    @FXML
    private ComboBox connectionType;
    @FXML
    private Label label;

    /**
     * Initializes the controller class.
     */
    @Override
    public void initialize(URL url, ResourceBundle rb) {
        // TODO
        connectionType.getItems().addAll("Home", "Office", "Factory");
    }

    @FXML
    private void clickOnSubmitButton(ActionEvent event) {
        NewConnection s = new NewConnection(
                Integer.parseInt(customerIDField.getText()),
                addressField.getText(),
                connectionType.getValue().toString(),
                contactField.getText(),
                false
        );
        label.setText("Successful !");
        s.addNewConnection();
        ArrayList<NewConnection> nList = NewConnection.getNewConnection();
        for (NewConnection i : nList) {
            System.out.println(i.toString());
        }
        /*
            ArrayList<NewConnection>nList = NewConnection.getNewConnection();
            for(NewConnection i: nList){
                System.out.println(i.toString());
            }
         */
    }

    @FXML
    private void onClickBackToHomepageButton1(ActionEvent event) throws IOException {
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
