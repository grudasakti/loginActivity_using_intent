package com.example.tugas2;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.text.TextUtils;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity {

    EditText editTextUsername, editTextFullname, editTextPassword, editTextConfirm;
    Button btnRegistration;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        editTextUsername = findViewById(R.id.editTextUsername);
        editTextFullname = findViewById(R.id.editTextFullname);
        editTextPassword = findViewById(R.id.editTextPassword);
        editTextConfirm = findViewById(R.id.editTextConfirm);

        btnRegistration = findViewById(R.id.btnRegistration);
        btnRegistration.setOnClickListener(view -> checkValidation());
    }

    boolean isEmpty(EditText text){
        CharSequence str = text.getText().toString();
        return TextUtils.isEmpty(str);
    }

    void checkValidation(){
        String username, fullname, password, confirm;

        username = editTextUsername.getText().toString();
        fullname = editTextFullname.getText().toString();
        password = editTextPassword.getText().toString();
        confirm = editTextConfirm.getText().toString();

        if(isEmpty(editTextUsername)){
            editTextUsername.setError("Username is required");
        }else if (isEmpty(editTextFullname)){
            editTextFullname.setError("Fullname is required");
        }else if (isEmpty(editTextPassword)){
            editTextPassword.setError("Password is required");
        }else if (isEmpty(editTextConfirm)){
            editTextConfirm.setError("Confirm Password is required");
        }else if (!password.equals(confirm)){
            Toast t = Toast.makeText(this, "Password are not matching", Toast.LENGTH_SHORT);
            t.show();
            editTextConfirm.setError("Password are not matching");
        }else{
            Intent intent = new Intent(this, LoginActivity.class);
            intent.putExtra("user", username);
            intent.putExtra("fullname", fullname);
            intent.putExtra("pass", password);
            startActivity(intent);
        }
    }
}