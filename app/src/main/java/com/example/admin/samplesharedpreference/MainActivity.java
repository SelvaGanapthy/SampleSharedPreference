package com.example.admin.samplesharedpreference;

import android.content.Context;
import android.content.SharedPreferences;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity {
    public static final String mypreference = "mypreference";
    EditText username, password;
    SharedPreferences sharedPreferences;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        sharedPreferences = getSharedPreferences(mypreference, Context.MODE_PRIVATE);
        username = (EditText) findViewById(R.id.username);
        password = (EditText) findViewById(R.id.password);
    }

    public void save(View v) {
        SharedPreferences.Editor editor = sharedPreferences.edit();
        editor.putString("username", username.getText().toString());
        editor.putString("password", password.getText().toString());
        editor.commit();

//        String name=sharedPreferences.getString("password","");
//        Toast.makeText(getApplicationContext()," username: "+name,Toast.LENGTH_SHORT).show();

        username.setText("");
        password.setText("");
    }

    public void retreive(View v) {
        if (sharedPreferences.contains("username"))
            username.setText(sharedPreferences.getString("username", ""));
        else
            username.setError("Empty field");

        if (sharedPreferences.contains("password"))
            password.setText(sharedPreferences.getString("password", ""));
        else
            password.setError("Empty field");
    }
}

