package com.example.btl_thibanglaixe.Activities;

import android.annotation.SuppressLint;
import android.content.Intent;
import android.content.SharedPreferences;
import android.text.TextUtils;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import androidx.appcompat.app.AppCompatActivity;
import com.example.btl_thibanglaixe.Activities.GuiMaVeEmail;
import com.example.btl_thibanglaixe.Databases.User.User;
import com.example.btl_thibanglaixe.Databases.User.UserRepository;
import com.example.btl_thibanglaixe.R;

public class QuenMatKhauActivity extends AppCompatActivity {

    EditText edtEmail;
    Button btnGuiMa;
    private UserRepository urp;

    private EditText edtUserAccount;


    @SuppressLint("MissingInflatedId")
    protected void onCreate(android.os.Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(com.example.btl_thibanglaixe.R.layout.activity_quenmatkhau);

        edtUserAccount = findViewById(R.id.edtUserAccount);
        btnGuiMa = findViewById(com.example.btl_thibanglaixe.R.id.btnGuiMa);
        urp = new UserRepository(getApplication());
        btnGuiMa.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                String userAccount = edtUserAccount.getText().toString();

//                kiểm tra username và password đã được nhập chưa, nếu chưa thì yêu cầu
                if (TextUtils.isEmpty(userAccount)) {
                    Toast.makeText(QuenMatKhauActivity.this, "Vui lòng nhập đầy đủ thông tin", Toast.LENGTH_SHORT).show();
                    return;
                }

                User userCheck = urp.getUsername(userAccount);
                if (userCheck == null){
                    Toast.makeText(QuenMatKhauActivity.this,"Tên đăng nhập không tồn tại", Toast.LENGTH_SHORT).show();
                }else {
                    SharedPreferences preferences = getSharedPreferences("user_data", MODE_PRIVATE);
                    SharedPreferences.Editor editor = preferences.edit();


                    editor.putString("user_account",userAccount);
                    editor.apply();

                    String email = userCheck.getUserEmail().toString();
                    new GuiMaVeEmail(QuenMatKhauActivity.this).execute(email);
                }

            }
        });

    }
}
