package org.example;

public class User {
    private int id;
    private String name;
    private String surname;
    private boolean gender;
    private String address;
    private String email;
    private String phone;
    public User(){

    }

    public User(int id, String name, String surname, boolean gender,String address,String email,String phone) {
        this(name,surname,gender,address,email,phone);
        setStudentID(id);
    }

    public User(String name, String surname, boolean gender,String address,String email,String phone) {
        setName(name);
        setSurname(surname);
        setGender(gender);
        setAddress(address);
        setEmail(email);
        setPhone(phone);
    }

    public String getAddress() {
        return address;
    }

    public void setAddress(String address) {
        this.address = address;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getPhone() {
        return phone;
    }

    public void setPhone(String phone) {
        this.phone = phone;
    }

    public int getStudentID() {
        return id;
    }

    public void setStudentID(int studentID) {
        this.id = studentID;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getSurname() {
        return surname;
    }

    public void setSurname(String surname) {
        this.surname = surname;
    }

    public boolean isGender() {
        return gender;
    }

    public void setGender(boolean gender) {
        this.gender = gender;
    }

    @Override
    public String toString() {
        return "\n"+
                "ID: " + id +
                ", name: '" + name + '\'' +
                ", surname: '" + surname + '\'' +
                ", gender: " + gender +
                ", address: '" + address + '\'' +
                ", email: '" + email + '\'' +
                ", phone: '" + phone + '\'';
    }
}