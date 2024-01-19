package com.example.btl_thibanglaixe.Model;

public class UserModel {
    private static int id;
    private static String userName;
    private String userAccount;
    private String userPass;
    private String userPassAgain;
    private String userEmail;


    public UserModel(int id, String userName, String userAccount, String userPass, String userPassAgain, String userEmail) {
        this.id = id;
        this.userName = userName;
        this.userAccount = userAccount;
        this.userPass = userPass;
        this.userPassAgain = userPassAgain;
        this.userEmail = userEmail;
    }

    public static int getId() {
        return id;
    }

    public static void setId(int id) {
        UserModel.id = id;
    }

    public static String getUserName() {
        return userName;
    }

    public static void setUserName(String userName) {
        UserModel.userName = userName;
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
