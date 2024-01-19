package com.example.btl_thibanglaixe.Activities;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import androidx.appcompat.app.AppCompatActivity;

import com.example.btl_thibanglaixe.Databases.User.User;
import com.example.btl_thibanglaixe.Databases.User.UserRepository;
import com.example.btl_thibanglaixe.R;

public class DangKyActivity extends AppCompatActivity {

    private EditText edtHoTen, edtTenDangNhap, edtMatKhau, edtNhapLaiMatKhau, edtEmail;
    private Button btnDangKy, btnDangNhap;
    private UserRepository urp;


    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_dangky);

        edtHoTen = findViewById(R.id.edtHoTen);
        edtTenDangNhap = findViewById(R.id.edtTenDangNhap);
        edtMatKhau = findViewById(R.id.edtMatKhau);
        edtNhapLaiMatKhau = findViewById(R.id.edtNhapLaiMatKhau);
        edtEmail = findViewById(R.id.edtEmail);
        btnDangKy = findViewById(R.id.btnDangKy);
        btnDangNhap = findViewById(R.id.btnDangNhap);

        urp = new UserRepository((getApplication()));
        btnDangNhap.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent i = new Intent(DangKyActivity.this, DangNhapActivity.class);
                startActivity(i);
            }
        });

        btnDangKy.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                String hoTen = edtHoTen.getText().toString();
                String tenDangNhap = edtTenDangNhap.getText().toString();
                String matKhau = edtMatKhau.getText().toString();
                String nhapLaiMatKhau = edtNhapLaiMatKhau.getText().toString();
                String email = edtEmail.getText().toString();

                User userCheck = urp.getUsername(tenDangNhap);
                if(hoTen.equals("") || tenDangNhap.equals("") || matKhau.equals("") || nhapLaiMatKhau.equals("") || email.equals("")) {
                    Toast.makeText(DangKyActivity.this, "Vui lòng nhập đầy đủ thông tin", Toast.LENGTH_SHORT).show();
                    return;
                }
                if(!matKhau.equals(nhapLaiMatKhau)) {
                    Toast.makeText(DangKyActivity.this, "Mật khẩu không khớp", android.widget.Toast.LENGTH_SHORT).show();
                    return;
                }
                if (userCheck != null){
                    Toast.makeText(DangKyActivity.this,"Tài khoản đã tồn tại!",Toast.LENGTH_SHORT).show();
                }else {
                    User userinsert = new User(hoTen,tenDangNhap,matKhau,nhapLaiMatKhau,email);
                    System.out.println(userinsert);
                    urp.insert(userinsert);
                    Toast.makeText(DangKyActivity.this,"Tạo tài khoản thành công!",Toast.LENGTH_SHORT).show();
                    Intent i = new Intent(DangKyActivity.this, DangNhapActivity.class);
                    startActivity(i);
                }

            }
        });
    }
}
