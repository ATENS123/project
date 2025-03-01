package Model;

import java.io.Serializable;
import java.util.Date;

public class Customer implements Serializable {
    private static final long serialVersionUID = 1L;  // Thêm serialVersionUID cho Serializable
    
    private int id;
    private String Fname;
    private String Lname;
    private String email;
    private String pass;
    private String address;
    private String phone;
    private Date Rdate;

    // Constructor không tham số (No-arg constructor)
    public Customer() {
    }

    // Constructor có tham số
    public Customer(int id, String Fname, String Lname, String email, String pass, String address, String phone, Date Rdate) {
        this.id = id;
        this.Fname = Fname;
        this.Lname = Lname;
        this.email = email;
        this.pass = pass;
        this.address = address;
        this.phone = phone;
        this.Rdate = Rdate;
    }

    // Getter và Setter cho các thuộc tính
    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getFname() {
        return Fname;
    }

    public void setFname(String Fname) {
        this.Fname = Fname;
    }

    public String getLname() {
        return Lname;
    }

    public void setLname(String Lname) {
        this.Lname = Lname;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getPass() {
        return pass;
    }

    public void setPass(String pass) {
        this.pass = pass;
    }

    public String getAddress() {
        return address;
    }

    public void setAddress(String address) {
        this.address = address;
    }

    public String getPhone() {
        return phone;
    }

    public void setPhone(String phone) {
        this.phone = phone;
    }

    public Date getRdate() {
        return Rdate;
    }

    public void setRdate(Date Rdate) {
        this.Rdate = Rdate;
    }

    // Phương thức toString() để dễ dàng in đối tượng Customer ra dạng chuỗi
    @Override
    public String toString() {
        return "Customer{" + "id=" + id + ", Fname=" + Fname + ", Lname=" + Lname + ", email=" + email + ", pass=" + pass + ", address=" + address + ", phone=" + phone + ", Rdate=" + Rdate + '}';
    }

    // Constructor sao chép
    public Customer(Customer c) {
        this(c.id, c.Fname, c.Lname, c.email, c.pass, c.address, c.phone, c.Rdate);
    }
}

