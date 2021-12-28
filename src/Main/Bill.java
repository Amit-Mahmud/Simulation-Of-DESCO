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

public class Bill implements Serializable {

    private int billNo;
    private int customerID;
    private boolean billStatus;
    private String paymentMethod;
    private String cardOrbkashNum;
    private String connectionType;
    private float costPerUnit;
    private int usedUnit;
    private float totalAmount;

    public Bill(int billNo, int customerID, boolean billStatus, String paymentMethod, String cardOrbkashNum, String connectionType, float costPerUnit, int usedUnit, float totalAmount) {
        this.billNo = billNo;
        this.customerID = customerID;
        this.billStatus = billStatus;
        this.paymentMethod = paymentMethod;
        this.cardOrbkashNum = cardOrbkashNum;
        this.connectionType = connectionType;
        this.costPerUnit = costPerUnit;
        this.usedUnit = usedUnit;
        this.totalAmount = totalAmount;
    }

    public int getBillNo() {
        return billNo;
    }

    public void setBillNo(int billNo) {
        this.billNo = billNo;
    }

    public int getCustomerID() {
        return customerID;
    }

    public void setCustomerID(int customerID) {
        this.customerID = customerID;
    }

    public boolean isBillStatus() {
        return billStatus;
    }

    public void setBillStatus(boolean billStatus) {
        this.billStatus = billStatus;
    }

    public String getPaymentMethod() {
        return paymentMethod;
    }

    public void setPaymentMethod(String paymentMethod) {
        this.paymentMethod = paymentMethod;
    }

    public String getCardOrbkashNum() {
        return cardOrbkashNum;
    }

    public void setCardOrbkashNum(String cardOrbkashNum) {
        this.cardOrbkashNum = cardOrbkashNum;
    }

    public String getConnectionType() {
        return connectionType;
    }

    public void setConnectionType(String connectionType) {
        this.connectionType = connectionType;
    }

    public float getCostPerUnit() {
        return costPerUnit;
    }

    public void setCostPerUnit(float costPerUnit) {
        this.costPerUnit = costPerUnit;
    }

    public int getUsedUnit() {
        return usedUnit;
    }

    public void setUsedUnit(int usedUnit) {
        this.usedUnit = usedUnit;
    }

    public float getTotalAmount() {
        return totalAmount;
    }

    public void setTotalAmount(float totalAmount) {
        this.totalAmount = totalAmount;
    }

    public void addBill() {
        File f = null;
        FileOutputStream fos = null;
        ObjectOutputStream oos = null;

        try {
            f = new File("Bill.bin");
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

    public static ArrayList<Bill> getBillList() {
        ArrayList<Bill> uList = new ArrayList<>();

        File f = null;
        FileInputStream fis = null;
        ObjectInputStream ois = null;

        try {
            f = new File("Bill.bin");
            fis = new FileInputStream(f);
            ois = new ObjectInputStream(fis);
            Bill u;
            try {
                while (true) {
                    u = (Bill) ois.readObject();
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
        return "BillNo: " + billNo + "\nCustomerID: " + customerID + "\nBillStatus: " + billStatus + "\nPaymentMethod= " + paymentMethod + "\nCardOrbkashNum= " + cardOrbkashNum + "\nConnectionType= " + connectionType + "\nCostPerUnit= " + costPerUnit + "\nUsedUnit= " + usedUnit + "\nTotalAmount=" + totalAmount + "\n";
    }

}
