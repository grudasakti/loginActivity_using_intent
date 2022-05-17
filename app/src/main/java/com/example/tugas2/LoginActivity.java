package com.example.tugas2;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.text.TextUtils;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

public class LoginActivity extends AppCompatActivity {

    EditText usernameLogin, passwordLogin;
    Button btnLogin;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_login);

        usernameLogin = findViewById(R.id.usernameLogin);
        passwordLogin = findViewById(R.id.passwordLogin);

        btnLogin = findViewById(R.id.btnLogin);
        btnLogin.setOnClickListener(view -> checkValidation());
    }

    boolean isEmpty(EditText text){
        CharSequence str = text.getText().toString();
        return TextUtils.isEmpty(str);
    }

    void checkValidation(){
        String intentUsername, intentFullname, intentPassword, username, password;
        Intent intent = getIntent();
        intentUsername = intent.getStringExtra("user");
        intentFullname = intent.getStringExtra("fullname");
        intentPassword = intent.getStringExtra("pass");

        username = usernameLogin.getText().toString();
        password = passwordLogin.getText().toString();

        if(isEmpty(usernameLogin)){
            usernameLogin.setError("Username is required");
        }else if(isEmpty(passwordLogin)){
            passwordLogin.setError("Password is required");
        }else if(!intentUsername.equals(username)){
            Toast t = Toast.makeText(this, "Username is incorrect", Toast.LENGTH_SHORT);
            t.show();
            usernameLogin.setError("Username is incorrect");
        } else if(!intentPassword.equals(password)){
            Toast t = Toast.makeText(this, "Password is incorrect", Toast.LENGTH_SHORT);
            t.show();
            passwordLogin.setError("Password is incorrect");
        }else{
            Intent intent2 = new Intent(this, HomeActivity.class);
            intent2.putExtra("fullname", intentFullname);
            startActivity(intent2);
        }
    }
}