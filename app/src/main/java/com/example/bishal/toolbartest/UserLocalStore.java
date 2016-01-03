package com.example.bishal.toolbartest;

import android.content.Context;
import android.content.SharedPreferences;

public class UserLocalStore {

    public static final String SP_NAME = "userDetails";
    SharedPreferences userLocalDatabase;

    public UserLocalStore(Context context) {
        userLocalDatabase = context.getSharedPreferences(SP_NAME, 0);
    }

    public void storeUserData(User user) {
        SharedPreferences.Editor spEditor = userLocalDatabase.edit();
        spEditor.putString("name", user.name);
        spEditor.putString("username", user.username);
        spEditor.putInt("age", user.age);
        spEditor.putString("password", user.password);
        spEditor.commit();
    }

    public User getLoggedInUser() {

        String name = userLocalDatabase.getString("name", "");
        String username = userLocalDatabase.getString("username", "");
        String password = userLocalDatabase.getString("password", "");
        int age = userLocalDatabase.getInt("age", -1);

        User storedUser = new User(name, age, username, password);
        return storedUser;
    }

    public void setUserLoggedIn(boolean LoggedIn) {
        SharedPreferences.Editor spEditor = userLocalDatabase.edit();
        spEditor.putBoolean("LoggedIn", LoggedIn);
        spEditor.commit();
    }

    public boolean getUserLoggedIn() {

        if (userLocalDatabase.getBoolean("LoggedIn", false) == true) {

            return true;
        } else {
            return false;
        }
    }

    public void clearUserData() {
        SharedPreferences.Editor spEditor = userLocalDatabase.edit();
        spEditor.clear();
        spEditor.commit();

    }


}
