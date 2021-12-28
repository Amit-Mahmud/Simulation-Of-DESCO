package Main;

import java.io.File;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.ObjectOutputStream;
import java.io.Serializable;
import java.util.logging.Level;
import java.util.logging.Logger;

public class Staff extends User implements Serializable {

    public Staff(String name, int id, String user_type, String email, String password) {
        super(name, id, user_type, email, password);
    }

    public void addStaff(String name, int id, String email, String password, String user_type) {

    }

    public void calcAndGenerateBills(int customerID, int usedUnit) {

    }

    public String viewCustomerMsg() {
        return "";
    }

    public void communicateWithCustomer(int customerID, String msg, String subject, String details) {

    }

    public void provideNewConnections(int cusID) {

    }

    public void surveyOnCustomers() {

    }

    public void ommWithITAdminAboutCustomerComplain(int adminID, String msg, String subject, String details) {

    }

    public String viewAdminMsg() {
        return "";
    }

    public int countStaff() {
        return 0;
    }

    @Override
    public String toString() {
        return "Name: " + name + "\nID: " + id + "\nUser type: " + user_type + "\nPassword=" + password
                + "\nEmail: " + email + "\n";
    }

    @Override
    public void addUser() {
        File f = null;
        FileOutputStream fos = null;
        ObjectOutputStream oos = null;

        try {
            f = new File("User.bin");
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
}
