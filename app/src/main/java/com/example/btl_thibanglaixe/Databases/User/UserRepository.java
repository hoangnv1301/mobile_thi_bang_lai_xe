package com.example.btl_thibanglaixe.Databases.User;

import android.app.Application;

import androidx.lifecycle.LiveData;

import com.example.btl_thibanglaixe.Databases.dtb;

import java.util.List;
import java.util.concurrent.CountDownLatch;

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

    public boolean updatePass(String pass, String account){
        final boolean[] success = {false};
        CountDownLatch latch = new CountDownLatch(1);

        dtb.databaseWriteExecutor.execute(() -> {
            int rowsUpdated = mUserDao.updatePass(pass, account);
            success[0] = rowsUpdated > 0;
            latch.countDown();
        });

        try {
            latch.await();
        } catch (InterruptedException e) {
            e.printStackTrace();
        }

        return success[0];
    }
}
