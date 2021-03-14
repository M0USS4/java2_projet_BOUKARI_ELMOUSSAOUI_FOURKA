/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package manageperson;

public class Person {

    private int personId;
    private String FirstName;
    private String LastName;
    private String NickName;
    private String Email;
    private String Phone;
    private String Address;
    private String Birthdate;

    public Person() {
    }

    public Person(String FirstName, String LastName, String NickName, String Email, String Phone, String Address, String Birthdate) {
        this.FirstName = FirstName;
        this.LastName = LastName;
        this.NickName = NickName;
        this.Email = Email;
        this.Phone = Phone;
        this.Address = Address;
        this.Birthdate = Birthdate;
    }

    public int getPersonId() {
        return personId;
    }

    public void setPersonId(int personId) {
        this.personId = personId;
    }

    public String getFirstName() {
        return FirstName;
    }

    public void setFirstName(String FirstName) {
        this.FirstName = FirstName;
    }

    public String getLastName() {
        return LastName;
    }

    public void setLastName(String LastName) {
        this.LastName = LastName;
    }

    public String getNickName() {
        return NickName;
    }

    public void setNickName(String NickName) {
        this.NickName = NickName;
    }

    public String getEmail() {
        return Email;
    }

    public void setEmail(String Email) {
        this.Email = Email;
    }

    public String getPhone() {
        return Phone;
    }

    public void setPhone(String Phone) {
        this.Phone = Phone;
    }

    public String getAddress() {
        return Address;
    }

    public void setAddress(String Address) {
        this.Address = Address;
    }

    public String getBirthdate() {
        return Birthdate;
    }

    public void setBirthdate(String Birthdate) {
        this.Birthdate = Birthdate;
    }

    
    
    
    
    
}
