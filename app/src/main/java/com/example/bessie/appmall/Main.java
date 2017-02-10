package com.example.bessie.appmall;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;

public class Main extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.main);


    }
    public void sales (View v)
    {
        Intent intent = new Intent(getBaseContext(),MainActivity.class);
        startActivity(intent);
    }

}
