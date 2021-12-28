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
import javafx.scene.control.TextArea;
import javafx.scene.control.TextField;
import javafx.stage.Stage;

/**
 * FXML Controller class
 *
 * @author Mahmud Amit
 */
public class FXMLCommunicationController implements Initializable {

    @FXML
    private ComboBox communicateCombo;
    @FXML
    private TextField receiverIDField;
    @FXML
    private TextField senderIdField;
    @FXML
    private TextArea messageField;
    @FXML
    private Label label;

    /**
     * Initializes the controller class.
     */
    @Override
    public void initialize(URL url, ResourceBundle rb) {
        communicateCombo.getItems().addAll("Customer", "Staff", "Manager", "Administration", "IT Admin");
    }

    @FXML
    private void onClickSendMessageButton(ActionEvent event) {
        Message c = new Message(Integer.parseInt(receiverIDField.getText()),
                Integer.parseInt(senderIdField.getText()), messageField.getText());
        c.addMessage();

        ArrayList<Message> a = Message.getMessageList();
        for (Message i : a) {
            System.out.println(i.toString());
        }

        label.setText("Successful !");
    }

    @FXML
    private void onClickBackToHomePageButton9(ActionEvent event) throws IOException {
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
