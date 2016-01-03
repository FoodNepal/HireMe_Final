package com.example.bishal.toolbartest;

import android.app.AlertDialog;
import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.ActionBarActivity;
import android.support.v7.widget.Toolbar;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

public class Login extends ActionBarActivity implements View.OnClickListener {

    private Toolbar toolbar;
    Button bLogIn;
    EditText editUsername, editPassword;
    TextView register;
    UserLocalStore userLocalStore;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_login);

        toolbar = (Toolbar) findViewById(R.id.app_bar);
        setSupportActionBar(toolbar);
        getSupportActionBar().setDisplayShowHomeEnabled(true);

        editUsername = (EditText) findViewById(R.id.editUsername);
        editPassword = (EditText) findViewById(R.id.editPassword);
        register = (TextView) findViewById(R.id.register);
        bLogIn = (Button) findViewById(R.id.bLogIn);
        bLogIn.setOnClickListener(this);
        register.setOnClickListener(this);
        userLocalStore = new UserLocalStore(this);

    }

    @Override
    public void onClick(View v) {

        switch (v.getId()) {

            case R.id.bLogIn:

//                String username = editUsername.getText().toString();
//                String password = editPassword.getText().toString();
//                User user = new User(username, password);
//                authenticate(user);

                //new code

                Intent i = new Intent(Login.this,HireMeActivity.class);
                startActivity(i);

                break;

            case R.id.register:
                Intent i2 = new Intent(Login.this, SignUp.class);
                startActivity(i2);
                break;
        }
    }

    private void authenticate(User user) {

        ServerRequests serverRequests = new ServerRequests(this);
        serverRequests.fetchUserDataInBackground(user, new GetUserCallBack() {
            @Override
            public void done(User returnedUser) {

                if (returnedUser == null) {
                    showErrorMessage();
                } else {
                    logUserIn(returnedUser);

                }
            }
        });

    }

    private void logUserIn(User returnedUser) {

        userLocalStore.storeUserData(returnedUser);
        userLocalStore.setUserLoggedIn(true);

        startActivity(new Intent(this, HireMeActivity.class));

    }

    private void showErrorMessage() {

        AlertDialog.Builder dialogBuilder = new AlertDialog.Builder(Login.this);
        dialogBuilder.setMessage("Incorrect user details!");
        dialogBuilder.setPositiveButton("OK", null);
        dialogBuilder.show();
    }
}
