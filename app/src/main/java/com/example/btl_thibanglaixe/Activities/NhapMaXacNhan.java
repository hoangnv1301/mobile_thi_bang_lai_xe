package com.example.btl_thibanglaixe.Activities;

import androidx.appcompat.app.AppCompatActivity;

import android.annotation.SuppressLint;
import android.content.Intent;
import android.content.SharedPreferences;
import android.os.Bundle;
import android.text.TextUtils;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import com.example.btl_thibanglaixe.Databases.User.User;
import com.example.btl_thibanglaixe.R;

public class NhapMaXacNhan extends AppCompatActivity {

    private Button mButtonAccept;
    private Button mButtonCancel;
    private EditText mMaXN;


    @SuppressLint("MissingInflatedId")
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_nhap_ma_xac_nhan);
        Intent intent = getIntent();

        int randomNumber = intent.getIntExtra("RANDOM_NUMBER", 0);

        // Now, you can use the randomNumber in your layout
        System.out.println(randomNumber);

        mMaXN= findViewById(R.id.edtMaXacNhan);
        mButtonAccept = findViewById(R.id.btnXacnhan);
        mButtonCancel = findViewById(R.id.btnHuy);
        mButtonAccept.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                String maXN = mMaXN.getText().toString();

//                kiểm tra username và password đã được nhập chưa, nếu chưa thì yêu cầu
                if (TextUtils.isEmpty(maXN) ) {
                    Toast.makeText(NhapMaXacNhan.this, "Vui lòng nhập đầy đủ thông tin", Toast.LENGTH_SHORT).show();
                    return;
                }
                else {
                    if (maXN.equals(Integer.toString(randomNumber))){
                        Intent intent = new Intent(NhapMaXacNhan.this, DatLaiMatKhauActivity.class);
                        startActivity(intent);                    }
                    else
                        Toast.makeText(NhapMaXacNhan.this,"Mã xác nhận không đúng, vui lòng nhập lại!", Toast.LENGTH_SHORT).show();
                }

            }
        });

        mButtonCancel.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(android.view.View v) {
                Intent intent = new Intent(NhapMaXacNhan.this, QuenMatKhauActivity.class);
                startActivity(intent);
            }
        });
    }
}