package Main;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.io.Serializable;
import java.util.ArrayList;
import java.util.logging.Level;
import java.util.logging.Logger;

public class NewConnection implements Serializable {

    private int customerID;
    private String address;
    private String connectionType;
    private String contactNumber;
    private boolean approveStatus;

    public NewConnection(int customerID, String address, String connectionType, String contactNumber, boolean approveStatus) {
        this.customerID = customerID;
        this.address = address;
        this.connectionType = connectionType;
        this.contactNumber = contactNumber;
        this.approveStatus = approveStatus;
    }

    @Override
    public String toString() {
        return "NewConnection{" + "customerID=" + customerID + ", address=" + address + ", connectionType=" + connectionType + ", contactNumber=" + contactNumber + ", approveStatus=" + approveStatus + '}';
    }

    public void addNewConnection() {
        File f = null;
        FileOutputStream fos = null;
        ObjectOutputStream oos = null;

        try {
            f = new File("New connection.bin");
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

    public static ArrayList<NewConnection> getNewConnection() {
        ArrayList<NewConnection> nList = new ArrayList<>();
        File f = null;
        FileInputStream fis = null;
        ObjectInputStream ois = null;

        try {
            f = new File("New connection.bin");
            fis = new FileInputStream(f);
            ois = new ObjectInputStream(fis);
            NewConnection s = null;
            try {
                while (true) {
                    s = (NewConnection) ois.readObject();
                    nList.add(s);
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
        return nList;
    }
}
