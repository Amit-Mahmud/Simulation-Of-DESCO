package Main;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.net.URL;
import java.util.ArrayList;
import java.util.ResourceBundle;
import java.util.logging.Level;
import java.util.logging.Logger;
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

public class FXMLFeedbackController implements Initializable {

    @FXML
    private TextField idField;
    @FXML
    private ComboBox rateCombo;
    @FXML
    private TextArea commentField;

    @Override
    public void initialize(URL url, ResourceBundle rb) {
        // TODO
        rateCombo.getItems().addAll("1", "2", "3", "4", "5");
    }

    @FXML
    private void onClickSubmitButton(ActionEvent event) throws IOException {
        Feedback s = new Feedback(
                Integer.parseInt(idField.getText()),
                Integer.parseInt(rateCombo.getValue().toString()),
                commentField.getText()
        );
        s.addFeedback();
        ArrayList<Feedback> nList = Feedback.getFeedback();
        for (Feedback i : nList) {
            System.out.println(i.toString());

        }
    }

    @FXML
    private void onClickBackToHomepageButton6(ActionEvent event) throws IOException {
        FXMLLoader loader1 = new FXMLLoader();
        loader1.setLocation(getClass().getResource("FXMLCustomerLogIn.fxml"));
        Parent personViewParent1 = loader1.load();
        Scene homepage1 = new Scene(personViewParent1);
        FXMLCustomerLogInController controller1 = loader1.getController();
        Stage window1 = (Stage) ((Node) event.getSource()).getScene().getWindow();
        window1.setScene(homepage1);
        window1.show();
    }

    public void addFeedback() {
        File f = null;
        FileOutputStream fos = null;
        ObjectOutputStream oos = null;

        try {
            f = new File("Feedback.bin");
            if (f.exists()) {
                fos = new FileOutputStream(f, true);
                oos = new AppendableObjectOutputStream(fos);
            } else {
                fos = new FileOutputStream(f);
                oos = new ObjectOutputStream(fos);
            }
            oos.writeObject(this);

        } catch (IOException ex) {
            Logger.getLogger(User.class.getName()).log(Level.SEVERE, null, ex);
        } finally {
            try {
                if (oos != null) {
                    oos.close();
                }
            } catch (IOException ex) {
                Logger.getLogger(User.class.getName()).log(Level.SEVERE, null, ex);
            }
        }
    }

    public static ArrayList<Feedback> getFeedbacksList() {
        ArrayList<Feedback> uList = new ArrayList<>();

        File f = null;
        FileInputStream fis = null;
        ObjectInputStream ois = null;

        try {
            f = new File("Feedback.bin");
            fis = new FileInputStream(f);
            ois = new ObjectInputStream(fis);
            Feedback u;
            try {
                while (true) {
                    u = (Feedback) ois.readObject();
                    uList.add(u);
                }
            }//end of nested try
            catch (Exception e) {
                //
            }//nested catch                 
        } catch (IOException ex) {
        } finally {
            try {
                if (ois != null) {
                    ois.close();
                }
            } catch (IOException ex) {
            }
        }
        return uList;
    }

    @Override
    public String toString() {
        return "\nID Field: " + idField + "\nRate Combo: " + rateCombo + "\nComment Field: " + commentField + "\n\n";
    }

}
