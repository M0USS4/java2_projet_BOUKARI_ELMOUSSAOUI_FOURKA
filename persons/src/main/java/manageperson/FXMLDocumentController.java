/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package manageperson;

import com.jfoenix.controls.JFXListView;

import controller.CheckInputdata;
import controller.DatabaseController;
import java.net.URL;
import java.util.List;
import java.util.ResourceBundle;

import javax.swing.JOptionPane;

import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.Label;
import javafx.scene.control.TextField;
import javafx.scene.input.MouseEvent;

public class FXMLDocumentController implements Initializable {
    
    @FXML
    private Label label;
    @FXML 
            private TextField firstname;
    @FXML 
            private TextField lastname;
    @FXML 
            private TextField phonenumber;
    @FXML 
            private TextField email;
    @FXML 
            private TextField nickname;
    @FXML 
            private TextField address;
    @FXML 
            private TextField birthdate;
    @FXML 
            private TextField pid;
            
        
    
    @FXML
    private JFXListView<String> list;
    
  
    ObservableList<String> lists = FXCollections.observableArrayList(" PersonID , FirstName , LastName ,NickName , Email , Phone, Address , Birthdate ");
  
    @FXML 
    private void handleMouseClick(MouseEvent arg0) {
    
    String listItem = list.getSelectionModel().getSelectedItem();
    String items[] = listItem.split(",");
    String Id = items[0];
    String FirstName = items[1];
    String LastName = items[2];
    String NickName = items[3];
    String Email = items[4];
    String Phone = items[5];
    String Address = items[6];
    String BirthDate = items[7];
    
    pid.setText(Id);
    firstname.setText(FirstName);
    lastname.setText(LastName);
    email.setText(Email);
    phonenumber.setText(Phone);
    nickname.setText(NickName);
    address.setText(Address);
    birthdate.setText(BirthDate);
    
    
    
    
    
    
    
    }

    @FXML
    private void addButtonAction(ActionEvent event) {
    
    String FirstName = firstname.getText();
    String LastName = lastname.getText();
    String NickName = nickname.getText();
    String Email = email.getText();
    String Address = address.getText();
    String Birthday = birthdate.getText();
    String Phone = phonenumber.getText();
    
    CheckInputdata check = new CheckInputdata();
    boolean checkEmail = check.checkEmail(Email);
    boolean checkDateFormat = check.isValidDate(Birthday);
   
    if(check.checkNumberOrString(FirstName)== false && check.checkNumberOrString(LastName)== false && 
    		check.checkNumberOrString(NickName) == false && checkEmail == true 
    		&&  check.checkNumberOrString(Phone) == true && checkDateFormat == true  ) {
    	

    
    Person person = new Person(FirstName, LastName, NickName, Email, Phone, Address, Birthday);
    
    int added = new DatabaseController().addPerson(person);
    if(added>0){
    
        System.out.println("Person Added");
        
        List<Person> persons = new DatabaseController().getAllPersons();
           lists.clear();
           lists.add(" PersonID , FirstName , LastName ,NickName , Email , Phone, Address , Birthdate ");
        for(Person p : persons){
        
            lists.add(p.getPersonId()+", "+p.getFirstName()+", "+p.getLastName()+", "+p.getNickName()+", "+p.getEmail()+", "+p.getPhone()+", "+p.getAddress()+", "+p.getBirthdate());
            list.setItems(lists);
   
        }
        
    pid.setText("");
    firstname.setText("");
    lastname.setText("");
    email.setText("");
    phonenumber.setText("");
    nickname.setText("");
    address.setText("");
    birthdate.setText("");
   
        
    
    }else{
    
    	System.out.println("Something went wrong");
    
    }
   
    }else {
    	
    	JOptionPane.showMessageDialog(null, "Please input valid details");
    }
    
    
        
        
    }
     @FXML

    private void updateButtonAction(ActionEvent event) {
    
    String FirstName = firstname.getText();
    String LastName = lastname.getText();
    String NickName = nickname.getText();
    String Email = email.getText();
    String Address = address.getText();
    String Birthday = birthdate.getText();
    String Phone = phonenumber.getText();
    int ID = Integer.parseInt(pid.getText());
   
    CheckInputdata check = new CheckInputdata();
    boolean checkEmail = check.checkEmail(Email);
    boolean checkDateFormat = check.isValidDate(Birthday);
   
    if(check.checkNumberOrString(FirstName)== false && check.checkNumberOrString(LastName)== false && 
    		check.checkNumberOrString(NickName) == false && checkEmail == true 
    		&&  check.checkNumberOrString(Phone) == true && checkDateFormat == true  ) {
    
    
    
    Person person = new Person(FirstName, LastName, NickName, Email, Phone, Address, Birthday);
    person.setPersonId(ID);
    int updated = new DatabaseController().updatePerson(person);
    if(updated>0){
    
        System.out.println("Person Updated");
        
        List<Person> persons = new DatabaseController().getAllPersons();
           lists.clear();
           lists.add(" PersonID , FirstName , LastName ,NickName , Email , Phone, Address , Birthdate ");
        for(Person p : persons){
        
            lists.add(p.getPersonId()+",    "+p.getFirstName()+",    "+p.getLastName()+",   "+p.getNickName()+",    "+p.getEmail()+", "+p.getPhone()+", "+p.getAddress()+", "+p.getBirthdate());
            list.setItems(lists);
   
        }
        
        pid.setText("");
    firstname.setText("");
    lastname.setText("");
    email.setText("");
    phonenumber.setText("");
    nickname.setText("");
    address.setText("");
    birthdate.setText("");
   
        
    
    
    }else{
        System.out.println("Something went wrong");
    
    }
        

    }else {
    	
    	JOptionPane.showMessageDialog(null, "Please input valid details");
    }
    
    }
     @FXML

    private void deleteButtonAction(ActionEvent event) {

    int ID = Integer.parseInt(pid.getText());
    
    int deleted = new DatabaseController().deletePerson(ID);
    if(deleted>0){
    
        System.out.println("Person Deleted");
        
        List<Person> persons = new DatabaseController().getAllPersons();
           lists.clear();
           lists.add(" PersonID , FirstName , LastName ,NickName , Email , Phone, Address , Birthdate ");
        for(Person p : persons){
        
            lists.add(p.getPersonId()+",    "+p.getFirstName()+",    "+p.getLastName()+",   "+p.getNickName()+",    "+p.getEmail()+", "+p.getPhone()+", "+p.getAddress()+", "+p.getBirthdate());
            list.setItems(lists);
   
        }
        
        pid.setText("");
    firstname.setText("");
    lastname.setText("");
    email.setText("");
    phonenumber.setText("");
    nickname.setText("");
    address.setText("");
    birthdate.setText("");
   
        
    
        
    
    }else{
        System.out.println("Something went wrong");
    
    }
   
    }
     
    
    public void initialize(URL url, ResourceBundle rb) {
       
        DatabaseController controller = new DatabaseController();
        controller.CreateDatabase("personsmanagement.db");
        String PersonTable = "CREATE TABLE IF NOT EXISTS person ( " +
                            "idperson INTEGER NOT NULL PRIMARY KEY AUTOINCREMENT, " +
                            "lastname VARCHAR(45) NOT NULL, " +
                            "firstname VARCHAR(45) NOT NULL, " +
                            "nickname VARCHAR(45) NOT NULL, " +
                            "phone_number VARCHAR(15) NULL, " +
                            "address VARCHAR(200) NULL, " +
                            "email_address VARCHAR(150) NULL, " +
                            "birth_date DATE NULL);";
        controller.createNewTable(PersonTable);
        
        List<Person> persons = new DatabaseController().getAllPersons();

        for(Person p : persons){
        
            lists.add(p.getPersonId()+",    "+p.getFirstName()+",    "+p.getLastName()+",    "+p.getNickName()+",    "+p.getEmail()+", "+p.getPhone()+", "+p.getAddress()+", "+p.getBirthdate());
            list.setItems(lists);
   
        }
        
       
   
    }    
    
}
