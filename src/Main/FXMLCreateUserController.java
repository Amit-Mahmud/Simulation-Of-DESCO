package Main;

import java.net.URL;
import java.util.ResourceBundle;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.ComboBox;
import javafx.scene.control.TextArea;
import javafx.scene.control.TextField;
import javafx.scene.input.MouseEvent;
import java.util.ArrayList;
import javafx.scene.input.ContextMenuEvent;

/**
 * FXML Controller class
 *
 * @author Mahmud Amit
 */
public class FXMLCreateUserController implements Initializable {

    @FXML
    private TextField nameField;
    @FXML
    private TextField idField;
    @FXML
    private TextField emailField;
    @FXML
    private TextField passwordField;
    @FXML
    private ComboBox comboField;
    @FXML
    private TextArea viewUserInfo;

    /**
     * Initializes the controller class.
     */
    @Override
    public void initialize(URL url, ResourceBundle rb) {
        // TODO
        comboField.getItems().addAll("Customer", "Staff", "Manager", "Administration", "IT Admin");
    }

    @FXML
    private void clickOnSubmitButton(ActionEvent event) {
        if (comboField.getValue().toString() == "Customer") {
            Customer c = new Customer(
                    nameField.getText(),
                    Integer.parseInt(idField.getText()),
                    comboField.getValue().toString(),
                    emailField.getText(),
                    passwordField.getText()
            );
            c.addUser();
        } else if (comboField.getValue().toString() == "Staff") {
            Staff c = new Staff(
                    nameField.getText(),
                    Integer.parseInt(idField.getText()),
                    comboField.getValue().toString(),
                    emailField.getText(),
                    passwordField.getText()
            );
            c.addUser();
        } else if (comboField.getValue().toString() == "Administration") {
            Administration c = new Administration(
                    nameField.getText(),
                    Integer.parseInt(idField.getText()),
                    comboField.getValue().toString(),
                    emailField.getText(),
                    passwordField.getText()
            );
            c.addUser();
        } else if (comboField.getValue().toString() == "Manager") {
            Manager c = new Manager(
                    nameField.getText(),
                    Integer.parseInt(idField.getText()),
                    comboField.getValue().toString(),
                    emailField.getText(),
                    passwordField.getText()
            );
            c.addUser();
        } else if (comboField.getValue().toString() == "IT Admin") {
            ITAdmin c = new ITAdmin(
                    nameField.getText(),
                    Integer.parseInt(idField.getText()),
                    comboField.getValue().toString(),
                    emailField.getText(),
                    passwordField.getText()
            );
            c.addUser();
        }
        nameField.setText("");
        idField.setText("");
        emailField.setText("");
        passwordField.setText("");
        comboField.setValue(null);
    }

    @FXML
    private void clickOnViewButton(ActionEvent event) {
        viewUserInfo.setText("");

        ArrayList<User> u = UserList.listOfUser();
        if (u != null) {
            for (User i : u) {
                System.out.println(u.toString());
                viewUserInfo.appendText(i.toString());
            }
        }
        viewUserInfo.appendText("All objects are loaded successfully...\n");
    }
}
