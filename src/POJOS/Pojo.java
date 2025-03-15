
package POJOS;

import java.sql.Date;
import java.sql.Timestamp;

public class Pojo {
    
    private static long acc_no;
    private short pin_no;
    private static double amt;
    private double credit;
    private double debit;
    private double bal;
    private static String name;
    private long cif;
    private String type;
    private String address;
    private long phonenumber;
    private String email;

    public double getBal() {
        return bal;
    }

    public void setBal(double bal) {
        this.bal = bal;
    }
    private Timestamp tran;

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public long getCif() {
        return cif;
    }

    public void setCif(long cif) {
        this.cif = cif;
    }

    public String getType() {
        return type;
    }

    public void setType(String type) {
        this.type = type;
    }

    public String getAddress() {
        return address;
    }

    public void setAddress(String address) {
        this.address = address;
    }

    public long getPhonenumber() {
        return phonenumber;
    }

    public void setPhonenumber(long phonenumber) {
        this.phonenumber = phonenumber;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }
 


    public Timestamp getTran() {
        return tran;
    }

    public void setTran(Timestamp tran) {
        this.tran = tran;
    }

    public double getCredit() {
        return credit;
    }

    public void setCredit(double credit) {
        this.credit = credit;
    }

    public double getDebit() {
        return debit;
    }

    public void setDebit(double debit) {
        this.debit = debit;
    }

    public long getAcc_no() {
        return acc_no;
    }

    public void setAcc_no(long acc_no) {
        this.acc_no = acc_no;
    }

    public short getPin_no() {
        return pin_no;
    }

    public void setPin_no(short pin_no) {
        this.pin_no = pin_no;
    }

    public double getAmt() {
        return amt;
    }

    public void setAmt(double amt) {
        this.amt = amt;
    }
    
    
}
