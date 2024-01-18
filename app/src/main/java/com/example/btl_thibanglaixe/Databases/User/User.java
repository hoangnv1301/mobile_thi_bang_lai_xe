package com.example.btl_thibanglaixe.Databases.User;

import androidx.room.Entity;
import androidx.room.PrimaryKey;

@Entity(tableName = "User_table")
public class User {
    @PrimaryKey(autoGenerate = true)
    private int id;
    private String userName;
    private String userAccount;
    private String userPass;
    private String userPassAgain;
    private String userEmail;

    public User(String userName, String userAccount, String userPass, String userPassAgain, String userEmail) {
        this.userName = userName;
        this.userAccount = userAccount;
        this.userPass = userPass;
        this.userPassAgain = userPassAgain;
        this.userEmail = userEmail;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getUserName() {
        return userName;
    }

    public void setUserName(String userName) {
        this.userName = userName;
    }

    public String getUserAccount() {
        return userAccount;
    }

    public void setUserAccount(String userAccount) {
        this.userAccount = userAccount;
    }

    public String getUserPass() {
        return userPass;
    }

    public void setUserPass(String userPass) {
        this.userPass = userPass;
    }

    public String getUserPassAgain() {
        return userPassAgain;
    }

    public void setUserPassAgain(String userPassAgain) {
        this.userPassAgain = userPassAgain;
    }

    public String getUserEmail() {
        return userEmail;
    }

    public void setUserEmail(String userEmail) {
        this.userEmail = userEmail;
    }
}
