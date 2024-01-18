package com.example.btl_thibanglaixe.Databases.User;

import android.app.Application;

import androidx.lifecycle.LiveData;

import com.example.btl_thibanglaixe.Databases.dtb;

import java.util.List;

public class UserRepository {
    private UserDao mUserDao;
    private LiveData<List<User>> mAllUser;
    public UserRepository(Application application){
        dtb database = dtb.getDatabase(application);
        mUserDao = database.userDao();
        mAllUser = mUserDao.getAllUser();
    }

    public void insert(User user){
        dtb.databaseWriteExecutor.execute(() -> {
            mUserDao.insert(user);
        });
    }
    public User getUsername(String user){
        return mUserDao.getUsername(user);
    }
}
