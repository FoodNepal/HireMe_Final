package com.example.bishal.toolbartest;

import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.ActionBarActivity;
import android.support.v7.widget.Toolbar;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;

public class SignUp extends ActionBarActivity implements View.OnClickListener {

    private Toolbar toolbar;
    Button bRegister;
    EditText editUsername, editPassword, editName, editAge;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_sign_up);

        toolbar = (Toolbar) findViewById(R.id.app_bar);
        setSupportActionBar(toolbar);
        getSupportActionBar().setDisplayShowHomeEnabled(true);

        editUsername = (EditText) findViewById(R.id.editUsername);
        editPassword = (EditText) findViewById(R.id.editPassword);
        editAge = (EditText) findViewById(R.id.editAge);
        editName = (EditText) findViewById(R.id.editName);
        bRegister = (Button) findViewById(R.id.bRegister);
        bRegister.setOnClickListener(this);
    }

    @Override
    public void onClick(View v) {
        switch (v.getId()) {

            case R.id.bRegister:

                String name = editName.getText().toString();
                String username = editUsername.getText().toString();
                String password = editPassword.getText().toString();
                int age = Integer.parseInt(editAge.getText().toString());

                User user = new User(name, age, username, password);

                registerUser(user);

                break;
        }
    }

    private void registerUser(User user) {

        ServerRequests serverRequests = new ServerRequests(this);
        serverRequests.storeUserDataInBackground(user, new GetUserCallBack() {
            @Override
            public void done(User returnedUser) {

                startActivity(new Intent(SignUp.this, Login.class));

            }
        });

    }
}
