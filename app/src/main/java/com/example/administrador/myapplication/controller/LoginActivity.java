package com.example.administrador.myapplication.controller;

import android.app.AlertDialog;
import android.content.DialogInterface;
import android.content.Intent;
import android.net.Uri;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.AdapterView;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ListView;

import com.example.administrador.myapplication.R;
import com.example.administrador.myapplication.model.entities.Client;
import com.example.administrador.myapplication.model.entities.User;

import java.util.List;

public class LoginActivity extends AppCompatActivity {

    User user;
    EditText editTextUserName;
    EditText editTextPassword;
    Button buttonLogin;

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_login);
        bindUser();
        bindLoginButton();
    }

    private void bindLoginButton() {
        buttonLogin = (Button) findViewById(R.id.buttonLogin);
        editTextUserName = (EditText) findViewById(R.id.editTextUserName);
        editTextPassword = (EditText) findViewById(R.id.editTextPassword);
        buttonLogin.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if(validadeUser(user)){
                    Intent goToMainActivity = new Intent(LoginActivity.this, ClientListActivity.class);
                    startActivity(goToMainActivity);
                } else {
                    new AlertDialog.Builder(LoginActivity.this)
                            .setMessage(R.string.validate_error)
                            .setTitle(R.string.message)
                            .setPositiveButton(R.string.ok, new DialogInterface.OnClickListener() {
                                public void onClick(DialogInterface dialog, int id) {
                                    editTextUserName.setText("");
                                    editTextPassword.setText("");
                                }
                            })
                            .create()
                            .show();
                }

            }
        });
    }

    private void bindUser() {
        user = User.get();
    }

    private boolean validadeUser(User user) {
        return (user.getUser().equals(editTextUserName.getText().toString()) && user.getPassword().equals(editTextPassword.getText().toString()));
    }
}
