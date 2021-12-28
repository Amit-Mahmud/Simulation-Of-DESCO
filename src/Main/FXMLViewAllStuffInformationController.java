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
import javafx.scene.control.TextArea;
import javafx.stage.Stage;

/**
 * FXML Controller class
 *
 * @author Mahmud Amit
 */
public class FXMLViewAllStuffInformationController implements Initializable {

    @FXML
    private TextArea infoField;

    @Override
    public void initialize(URL url, ResourceBundle rb) {
        infoField.setText("");
        ArrayList<User> f = UserList.listOfUser();
        for (User i : f) {
            infoField.appendText(i.toString());
        }
    }

    @FXML
    private void onClickBackToHomepageButton8(ActionEvent event) throws IOException {
        FXMLLoader loader1 = new FXMLLoader();
        loader1.setLocation(getClass().getResource("FXMLlogIn.fxml"));
        Parent personViewParent1 = loader1.load();
        Scene homepage1 = new Scene(personViewParent1);
        FXMLLogInController controller1 = loader1.getController();
        Stage window1 = (Stage) ((Node) event.getSource()).getScene().getWindow();
        window1.setScene(homepage1);
        window1.show();
    }

}
