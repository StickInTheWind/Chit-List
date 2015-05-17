package com.parsons.iou;

/**
 * Created by Larry Parsons on 5/16/2015.
 */
public class User {
    public String firstName;
    public String lastName;
    public String userName;
    public String password;
    public double total;
    public double specialID;

    public User(String firstName, String lastName, String userName, String password, double total, double specialID){
        this.firstName = firstName;
        this.lastName = lastName;
        this.userName = userName;
        this.password = password;
        this.total = total;
        this. specialID = specialID;
    }

}
