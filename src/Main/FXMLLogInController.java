package Main;

import java.io.IOException;
import java.net.URL;
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

public class FXMLLogInController implements Initializable {

    @FXML
    private TextField idField;
    @FXML
    private TextField passField;
    @FXML
    private ComboBox<String> typeCombo;

    @FXML
    private Label label;

    @Override
    public void initialize(URL url, ResourceBundle rb) {
        // TODO
        typeCombo.getItems().addAll("Customer", "Staff", "Manager", "Administration", "IT Admin");
    }

    @FXML
    private void onClickLogOut1(ActionEvent event) throws IOException {
        FXMLLoader loader1 = new FXMLLoader();
        loader1.setLocation(getClass().getResource("CustomerLogInController.fxml"));
        Parent personViewParent1 = loader1.load();
        Scene homepage1 = new Scene(personViewParent1);
        FXMLCustomerLogInController controller1 = loader1.getController();
        Stage window1 = (Stage) ((Node) event.getSource()).getScene().getWindow();
        window1.setScene(homepage1);
        window1.show();

    }

    @FXML
    private void clickOnLogInButton(ActionEvent event) throws IOException {
        User u = User.login(
                Integer.parseInt(idField.getText()),
                passField.getText(),
                typeCombo.getValue()
        );
        if (u == null) {
            label.setText("User-Id and Password combination failed!!");
        } else {

            if (u instanceof Customer) {
                FXMLLoader loader1 = new FXMLLoader();
                loader1.setLocation(getClass().getResource("FXMLCustomerLogIn.fxml"));
                Parent personViewParent1 = loader1.load();
                Scene homepage1 = new Scene(personViewParent1);
                FXMLCustomerLogInController controller1 = loader1.getController();
                controller1.initData1(u);
                Stage window1 = (Stage) ((Node) event.getSource()).getScene().getWindow();
                window1.setScene(homepage1);
                window1.show();
            } else if (u instanceof Staff) {
                FXMLLoader loader2 = new FXMLLoader();
                loader2.setLocation(getClass().getResource("FXMLStaffLogIn.fxml"));
                Parent personViewParent2 = loader2.load();
                Scene homepage2 = new Scene(personViewParent2);
                FXMLStaffLogInController controller2 = loader2.getController();
                controller2.initData2(u);
                Stage window2 = (Stage) ((Node) event.getSource()).getScene().getWindow();
                window2.setScene(homepage2);
                window2.show();
            } else if (u instanceof Administration) {
                FXMLLoader loader3 = new FXMLLoader();
                loader3.setLocation(getClass().getResource("FXMLAdministrationLogIn.fxml"));
                Parent personViewParent3 = loader3.load();
                Scene homepage3 = new Scene(personViewParent3);
                FXMLAdministrationLogInController controller3 = loader3.getController();
                controller3.initData3(u);
                Stage window3 = (Stage) ((Node) event.getSource()).getScene().getWindow();
                window3.setScene(homepage3);
                window3.show();
            } else if (u instanceof ITAdmin) {
                FXMLLoader loader4 = new FXMLLoader();
                loader4.setLocation(getClass().getResource("FXMLITAdminLogIn.fxml"));
                Parent personViewParent4 = loader4.load();
                Scene homepage4 = new Scene(personViewParent4);
                FXMLITAdminLogInController controller4 = loader4.getController();
                controller4.initData4(u);
                Stage window4 = (Stage) ((Node) event.getSource()).getScene().getWindow();
                window4.setScene(homepage4);
                window4.show();
            } else if (u instanceof Manager) {
                FXMLLoader loader5 = new FXMLLoader();
                loader5.setLocation(getClass().getResource("FXMLManagerLogIn.fxml"));
                Parent personViewParent5 = loader5.load();
                Scene homepage5 = new Scene(personViewParent5);
                FXMLManagerLogInController controller5 = loader5.getController();
                controller5.initData5(u);
                Stage window5 = (Stage) ((Node) event.getSource()).getScene().getWindow();
                window5.setScene(homepage5);
                window5.show();
            }

        }
    }

}
