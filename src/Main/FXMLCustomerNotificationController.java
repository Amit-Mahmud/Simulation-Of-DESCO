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
import javafx.stage.Stage;

public class FXMLCustomerNotificationController implements Initializable {

    public FXMLCustomerNotificationController() {

    }

    /**
     * Initializes the controller class.
     */
    @Override
    public void initialize(URL url, ResourceBundle rb) {
        // TODO

    }

    @FXML
    private void onClickBackToHomepageButton4(ActionEvent event) throws IOException {
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
