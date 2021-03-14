/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package controller;

import java.io.File;
import java.sql.Connection;
import java.sql.DatabaseMetaData;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;
import manageperson.Person;

public class DatabaseController {
    
    public static String DatabaseUse = "personsmanagement.db";
            
    public  void CreateDatabase(String fileName) {  
   
        String url = "jdbc:sqlite:C:/sqlite/" + fileName;  
        
        File f = new File("C://sqlite//" + fileName);
        if(!f.exists()){
   
        try {  
            Connection conn = DriverManager.getConnection(url);  
            
            if (conn != null) {  
             
                DatabaseMetaData meta = conn.getMetaData();  
                System.out.println("--Database "+ fileName+ " Created."); 
                DatabaseUse = fileName;
    
            }  
   
        } catch (SQLException e) {  
            System.out.println(e.getMessage());  
        }
        
        }else{
        
            System.out.println("-- !Failed to create database db_1 because it already exists.");
        }
    }
     public  void createNewTable( String Query) {
        // SQLite connection string
        if(DatabaseUse != null){
        String url = "jdbc:sqlite:C:/sqlite/"+DatabaseUse;
        
        
        try {
        	
        Connection conn = DriverManager.getConnection(url);
                Statement stmt = conn.createStatement();
                 stmt.execute(Query);
                 System.out.println("-- Table  created.");
        } catch (SQLException e) {
            System.out.println(e.getMessage());
        }
        }else{
        
            System.out.println("Please Select a database");
        }
    }
     
     public List<Person> getAllPersons(){
    
        List<Person> persons = new ArrayList<Person>();
        
        try{
       
              String url = "jdbc:sqlite:C:/sqlite/"+DatabaseUse;
              Connection conn = DriverManager.getConnection(url);
       
            String query = "Select * from person";
        PreparedStatement preparedStatement = conn.prepareStatement(query);
    
        ResultSet rs = preparedStatement.executeQuery();
            while(rs.next()){
          
                   Person person = new Person(rs.getString("firstname"), rs.getString("lastname"), rs.getString("nickname"), rs.getString("email_address"), rs.getString("phone_number"), rs.getString("address"), rs.getString("birth_date"));
                   person.setPersonId(rs.getInt("idperson"));
                   persons.add(person);
            }
        }catch(Exception e){
        
            e.printStackTrace();
        }
        
        return persons;
    }
    
    public int deletePerson(int id){
    
        int deleted = 0;
        
        try{
        
            if(DatabaseUse != null){
                String url = "jdbc:sqlite:C:/sqlite/"+DatabaseUse;
              Connection conn = DriverManager.getConnection(url);
          
            String query = "Delete from person where idperson =?";
        PreparedStatement preparedStatement = conn.prepareStatement(query);
        preparedStatement.setInt(1, id);
        
           deleted = preparedStatement.executeUpdate();
            
            }
        }catch(Exception e){
        
            e.printStackTrace();
        }
        
        return deleted;
    }
     public int addPerson(Person person){
        
        int added = 0;
        
           String sql = "insert into person (firstname , lastname , nickname , phone_number , "
                   + "address , email_address , birth_date ) values(?,?,?,?,?,?,?)";
                
           try{
            
                 if(DatabaseUse != null){
                String url = "jdbc:sqlite:C:/sqlite/"+DatabaseUse;
        
        
                Connection conn = DriverManager.getConnection(url);
               PreparedStatement stmt = conn.prepareStatement(sql); 
     
               stmt.setString(1, person.getFirstName());
               stmt.setString(2, person.getLastName());
               stmt.setString(3, person.getNickName());
               stmt.setString(4, person.getPhone());
               stmt.setString(5, person.getAddress());
               stmt.setString(6, person.getEmail());
               stmt.setString(7, person.getBirthdate());
               
               added = stmt.executeUpdate();
                 }
           }catch(Exception e){
           
               e.printStackTrace();
           }
            
        return added;
    }
     
     public int updatePerson(Person person){
        
        int added = 0;
        
           String sql = "update  person set firstname =? , lastname=? , nickname=? , phone_number=? , "
                   + "address =? , email_address=? , birth_date=? where idperson =?";
                
           try{
            
                 if(DatabaseUse != null){
                String url = "jdbc:sqlite:C:/sqlite/"+DatabaseUse;
        
        
                Connection conn = DriverManager.getConnection(url);
               PreparedStatement stmt = conn.prepareStatement(sql); 
     
               stmt.setString(1, person.getFirstName());
               stmt.setString(2, person.getLastName());
               stmt.setString(3, person.getNickName());
               stmt.setString(4, person.getPhone());
               stmt.setString(5, person.getAddress());
               stmt.setString(6, person.getEmail());
               stmt.setString(7, person.getBirthdate());
               stmt.setInt(8, person.getPersonId());
               
               
               added = stmt.executeUpdate();
                 }
           }catch(Exception e){
           
               e.printStackTrace();
           }
            
        return added;
    }
   
}
