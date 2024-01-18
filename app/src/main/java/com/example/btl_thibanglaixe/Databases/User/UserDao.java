package com.example.btl_thibanglaixe.Databases.User;

import androidx.lifecycle.LiveData;
import androidx.room.Dao;
import androidx.room.Insert;
import androidx.room.Query;

import java.util.List;

@Dao
public interface UserDao {
    @Insert
    void insert(User user);

    @Query("DELETE FROM User_table")
    void delete();

    @Query("SELECT * FROM User_table ORDER BY userName ASC")
    LiveData<List<User>> getAllUser();

    @Query("SELECT * FROM user_table WHERE userAccount = :username")
    User getUsername(String username);
}
