package Main;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.io.Serializable;
import java.util.logging.Level;
import java.util.logging.Logger;

public class ServiceCharge implements Serializable {

    private float price;
    private String ConnectionType;
    private float newConnectionCharge;

    public ServiceCharge(float price, String ConnectionType, float newConnectionCharge) {
        this.price = price;
        this.ConnectionType = ConnectionType;
        this.newConnectionCharge = newConnectionCharge;
    }

    public void addServiceCharge() {
        File f = null;
        FileOutputStream fos = null;
        ObjectOutputStream oos = null;

        try {
            f = new File("Service Charge.bin");
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

    public static ServiceCharge getServiceCharge() {
        File f = null;
        FileInputStream fis = null;
        ObjectInputStream ois = null;

        try {
            f = new File("Service Charge.bin");
            fis = new FileInputStream(f);
            ois = new ObjectInputStream(fis);
            ServiceCharge s = null;
            try {
                while (true) {
                    s = (ServiceCharge) ois.readObject();
                    return s;
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
        return null;
    }

    @Override
    public String toString() {
        return "Price: " + price + "\nConnectionType: " + ConnectionType + "\nNew Connection Charge: " + newConnectionCharge + "\n";
    }

}
