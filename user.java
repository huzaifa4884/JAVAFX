package sample;

import javafx.beans.property.SimpleStringProperty;
import javafx.beans.property.StringProperty;

public class user
{
    public StringProperty rollNo;
    public StringProperty name;
    public StringProperty fName;
    public StringProperty gender;
    public StringProperty email;
    public StringProperty address;
//
//    public void setRoll_No(String roll_No) {
//        this.rollNo.set(roll_No);
//    }
//
//    public void setName(String name) {
//        this.name.set(name);
//    }
//
//    public void setF_Name(String f_Name) {
//        this.fName.set(f_Name);
//    }
//
//    public void setGender(String gender) {
//        this.gender.set(gender);
//    }
//
//    public void setEmail(String email) {
//        this.email.set(email);
//    }
//
//    public void setAddress(String address) {
//        this.address.set(address);
//    }

    user(String Roll_No , String Name , String F_Name , String Gender , String Email , String Address) {
        this.rollNo = new SimpleStringProperty(Roll_No);
        this.name = new SimpleStringProperty(Name);
        this.fName = new SimpleStringProperty(F_Name);
        this.gender = new SimpleStringProperty(Gender);
        this.email = new SimpleStringProperty(Email);
        this.address = new SimpleStringProperty(Address);
    }


    public String getRollNo() {
        return rollNo.get();
    }
    public String getName(){
        return name.get();
    }
    public String getFName(){
        return fName.get();
    }
    public String getGender(){
        return gender.get();
    }
    public String getEmail(){
        return email.get();
    }
    public String getAddress()
    {
        return address.get();

    }
    public StringProperty Roll_NoProperty(){return rollNo;}
    public StringProperty NameProperty(){return name;}
    public StringProperty FNameProperty(){return fName;}
    public StringProperty GenderProperty(){return gender;}
    public StringProperty EmailProperty(){return email;}
    public StringProperty AddressProperty(){return address;}

}
