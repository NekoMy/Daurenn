package com.javarush.art;


import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
// Class is called Userr, with double "r", because postgre does not allow entity "user"
@Entity // This tells Hibernate to make a table out of this class
public class Userr {
    @Id
    @GeneratedValue(strategy=GenerationType.AUTO) // This says id will be generated automatically
    private int id;
    private String login;
    private String surname;
    private String name;
    private String lastname;
    private String phonenumber;
    private String email;
    private String country;
    private String city;
    private String password;

    // When working with entities, we have to create an empty constructor
    public Userr(){

    }
    // Here comes the real constructor
    public Userr(int id, String name, String surname, String password, String lastname, String login,  String phonenumber, String email, String country, String city){
        this.login = login;
        this.surname = surname;
        this.name = name;
        this.password = password;
        this.id = id;
        this.lastname = lastname;
        this.phonenumber = phonenumber;
        this.email = email;
        this.country = country;
        this.city = city;
    }

    //Multiple setters and getter

    public Integer getId() {
        return id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getLogin() {
        return login;
    }

    public void setLogin(String login) {
        this.login = login;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public String getSurname() {
        return surname;
    }

    public void setSurname(String surname) {
        this.surname = surname;
    }

    public String getLastname() {
        return lastname;
    }

    public void setLastname(String lastname) {
        this.lastname = lastname;
    }

    public String getPhonenumber() {
        return phonenumber;
    }

    public void setPhonenumber(String phonenumber) {
        this.phonenumber = phonenumber;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getCountry() {
        return country;
    }

    public void setCountry(String country) {
        this.country = country;
    }

    public String getCity() {
        return city;
    }

    public void setCity(String city) {
        this.city = city;
    }
}