package com.example.btl_thibanglaixe.Activities;

import android.annotation.SuppressLint;
import android.content.Intent;
import android.os.Bundle;
import android.text.TextUtils;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import androidx.appcompat.app.AppCompatActivity;

import com.example.btl_thibanglaixe.Databases.User.User;
import com.example.btl_thibanglaixe.Databases.User.UserRepository;
import com.example.btl_thibanglaixe.Model.UserModel;
import com.example.btl_thibanglaixe.R;

public class DangNhapActivity extends AppCompatActivity{

    private EditText mEditTextUserAccount;
    private EditText mEditTextPassword;
    private Button mButtonLogin;
    private Button mButtonRegister;

    private UserRepository urp;

    private Button btnQuenMatKhau;
//    NguoiDungDao nguoiDungDao;

    @SuppressLint("MissingInflatedId")
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_dangnhap);

        mEditTextUserAccount = findViewById(R.id.userAccountEditText);
        mEditTextPassword = findViewById(R.id.passwordEditText);
        mButtonLogin = findViewById(R.id.loginButton);
        mButtonRegister = findViewById(R.id.registerButton);
        btnQuenMatKhau = findViewById(R.id.forgotPasswordButton);

        urp = new UserRepository(getApplication());
        mButtonLogin.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                String userAccount = mEditTextUserAccount.getText().toString();
                String password = mEditTextPassword.getText().toString();
//                kiểm tra username và password đã được nhập chưa, nếu chưa thì yêu cầu
                if (TextUtils.isEmpty(userAccount) || TextUtils.isEmpty(password)) {
                    Toast.makeText(DangNhapActivity.this, "Vui lòng nhập đầy đủ thông tin", Toast.LENGTH_SHORT).show();
                    return;
                }
                User userCheck = urp.getUsername(userAccount);
                if (userCheck == null){
                    Toast.makeText(DangNhapActivity.this,"Tài khoản hoặc mật khẩu không đúng", Toast.LENGTH_SHORT).show();
                }else {
                    if (userCheck.getUserPass().equals(password)){
                        Toast.makeText(DangNhapActivity.this,"Đăng nhập thành công", Toast.LENGTH_SHORT).show();
                        Intent i = new Intent(DangNhapActivity.this, MainActivity.class);
                        startActivity(i);

                        UserModel.setUserName(userCheck.getUserName());

                    }else {
                        Toast.makeText(DangNhapActivity.this,"Tài khoản hoặc mật khẩu không đúng", Toast.LENGTH_SHORT).show();
                    }
                }

            }
        });

        mButtonRegister.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(DangNhapActivity.this, DangKyActivity.class);
                startActivity(intent);
            }
        });

        btnQuenMatKhau.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(DangNhapActivity.this, QuenMatKhauActivity.class);
                startActivity(intent);
            }
        });
    }

}