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

public class Feedback implements Serializable {

    private int customerId;
    private int serviceRating;
    private String comment;

    public Feedback(int serviceRating, int customerId, String comment) {
        this.customerId = customerId;
        this.serviceRating = serviceRating;
        this.comment = comment;
    }

    @Override
    public String toString() {
        return "\ncustomerId= " + customerId + "\nserviceRating= " + serviceRating + "\ncomment " + comment + "\n";
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

    public static ArrayList<Feedback> getFeedback() {
        ArrayList<Feedback> nList = new ArrayList<>();
        File f = null;
        FileInputStream fis = null;
        ObjectInputStream ois = null;

        try {
            f = new File("Feedback.bin");
            fis = new FileInputStream(f);
            ois = new ObjectInputStream(fis);
            Feedback s = null;
            try {
                while (true) {
                    s = (Feedback) ois.readObject();
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
