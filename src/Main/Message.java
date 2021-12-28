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

public class Message implements Serializable {

    private int receiverID;
    private int senderID;
    private String content;

    public Message(int receiverID, int senderID, String content) {
        this.receiverID = receiverID;
        this.senderID = senderID;
        this.content = content;
    }

    public void addMessage() {
        File f = null;
        FileOutputStream fos = null;
        ObjectOutputStream oos = null;

        try {
            f = new File("Message.bin");
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

    public static ArrayList<Message> getMessageList() {
        ArrayList<Message> uList = new ArrayList<>();

        File f = null;
        FileInputStream fis = null;
        ObjectInputStream ois = null;

        try {
            f = new File("Message.bin");
            fis = new FileInputStream(f);
            ois = new ObjectInputStream(fis);
            Message u;
            try {
                while (true) {
                    u = (Message) ois.readObject();
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
        return "ReceiverID= " + receiverID + "\nSenderID= " + senderID + "\nContent= " + content + "\n";
    }

}
