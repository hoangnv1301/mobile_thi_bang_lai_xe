package com.example.btl_thibanglaixe.Activities;

import android.content.Intent;
import android.content.SharedPreferences;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import androidx.appcompat.app.AppCompatActivity;

import com.example.btl_thibanglaixe.Databases.User.UserRepository;
import com.example.btl_thibanglaixe.R;

public class DatLaiMatKhauActivity extends AppCompatActivity {

        EditText edtMatKhau, edtNhapLaiMatKhau, edtMaXacNhan;
        Button btnDatLai, btnHuy;

         private UserRepository urp;
    private SharedPreferences preferences;



    protected void onCreate(android.os.Bundle savedInstanceState) {
            super.onCreate(savedInstanceState);
            setContentView(com.example.btl_thibanglaixe.R.layout.activity_datlaimatkhau);

            edtMatKhau = findViewById(R.id.edtMatKhau);
            edtNhapLaiMatKhau = findViewById(R.id.edtNhapLaiMatKhau);
            btnDatLai = findViewById(R.id.btnXacnhan);
            btnHuy = findViewById(R.id.btnHuy);

            urp = new UserRepository(getApplication());
//            String maXacNhanMail = "colammoicoan";
//
            btnDatLai.setOnClickListener(new View.OnClickListener() {
                 @Override
                 public void onClick(android.view.View v) {
                     String matKhau = edtMatKhau.getText().toString();
                     String nhapLaiMatKhau = edtNhapLaiMatKhau.getText().toString();

                     preferences = getSharedPreferences("user_data", MODE_PRIVATE);
                     String userAccount = preferences.getString("user_account", null);

                     if (matKhau.equals("") || nhapLaiMatKhau.equals("")) {
                         Toast.makeText(DatLaiMatKhauActivity.this, "Vui lòng nhập đầy đủ thông tin", android.widget.Toast.LENGTH_SHORT).show();

                     }else {
                         if (!matKhau.equals(nhapLaiMatKhau)) {
                             Toast.makeText(DatLaiMatKhauActivity.this, "Mật khẩu không khớp", android.widget.Toast.LENGTH_SHORT).show();

                         }else {
                             boolean checkPass = urp.updatePass(matKhau, userAccount);
//                             System.out.println(matKhau);
//                             System.out.println(userAccount);
                             System.out.println(checkPass);
                             if (checkPass) {

                                 Toast.makeText(DatLaiMatKhauActivity.this, "Cập nhật thành công!", android.widget.Toast.LENGTH_SHORT).show();

                             }else {
                                 Toast.makeText(DatLaiMatKhauActivity.this, "Cập nhật thất bại!", android.widget.Toast.LENGTH_SHORT).show();

                             }
                         }
                     }




                 }
            });
//            btnHuy.setOnClickListener(new View.OnClickListener() {
//                @Override
//                public void onClick(android.view.View v) {
//                    Intent intent = new Intent(DatLaiMatKhauActivity.this, DangNhapActivity.class);
//                    startActivity(intent);
//                }
//            });
//
        }
}
