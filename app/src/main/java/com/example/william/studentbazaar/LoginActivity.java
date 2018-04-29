package com.example.william.studentbazaar;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.text.Editable;
import android.text.TextWatcher;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import com.example.william.studentbazaar.User.User;
import com.example.william.studentbazaar.User.UserLab;

public class LoginActivity extends AppCompatActivity {

    private EditText mStudentId;
    private EditText mPassword;

    private Button mSubmitButton;
    private Button mCancelButton;

    private String studentId;
    private String password;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_login);

        mStudentId = findViewById(R.id.studentId_login);
        mStudentId.addTextChangedListener(new TextWatcher() {
            @Override
            public void beforeTextChanged(CharSequence s, int start, int count, int after) {

            }

            @Override
            public void onTextChanged(CharSequence s, int start, int before, int count) {
                studentId = s.toString();
            }

            @Override
            public void afterTextChanged(Editable s) {

            }
        });

        mPassword = findViewById(R.id.password_login);
        mPassword.addTextChangedListener(new TextWatcher() {
            @Override
            public void beforeTextChanged(CharSequence s, int start, int count, int after) {

            }

            @Override
            public void onTextChanged(CharSequence s, int start, int before, int count) {
                password = s.toString();
            }

            @Override
            public void afterTextChanged(Editable s) {

            }
        });

        mSubmitButton = findViewById(R.id.submit_login);
        mSubmitButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if (mStudentId.getText().toString().equals("") || mPassword.getText().toString().equals("")) { //check error
                    Toast.makeText(LoginActivity.this, "Please enter a valid club name" ,Toast.LENGTH_SHORT).show();
                    return;
                }

                User user = UserLab.get(LoginActivity.this).getUser(studentId, password);
                if(user != null){
//                    Log.d("Login", "foundUser");
//                    Log.d("Login", user.getPassword());
                    Global.currentUser = user;
                    Toast.makeText(LoginActivity.this, "Signed in", Toast.LENGTH_SHORT).show();
                    startActivity(new Intent(LoginActivity.this, MainScreenActivity.class));
                }else{
//                    Log.d("Login", "no user");
                    Toast.makeText(LoginActivity.this, "Invalid ID/Password combination", Toast.LENGTH_SHORT).show();
                }

            }
        });

        mCancelButton = findViewById(R.id.cancel_login);
        mCancelButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                finish();
            }
        });
    }
}
